# Student Wellness System - State Transition Diagrams

## 1. Wellness Assessment
```mermaid
stateDiagram-v2
    [*] --> Unstarted
    Unstarted --> InProgress: student_begins
    InProgress --> Submitted: student_completes
    Submitted --> Analyzed: system_scores
    Analyzed --> HighRisk: score >= threshold
    Analyzed --> LowRisk: score < threshold
    HighRisk --> Resolved: counselor_intervention
    LowRisk --> Archived: after_30_days
    Resolved --> Archived: case_closed
```
```mermaid
stateDiagram-v2
    [*] --> Unstarted
    Unstarted --> InProgress: student_begins
    InProgress --> Submitted: student_completes
    Submitted --> Analyzed: system_scores
    Analyzed --> HighRisk: score >= 15 [PHQ-9] || score >= 10 [GAD-7]
    Analyzed --> ModerateRisk: score >= 10 [PHQ-9] || score >= 5 [GAD-7]
    Analyzed --> LowRisk: score < 10 [PHQ-9] && score < 5 [GAD-7]
    HighRisk --> Resolved: counselor_intervention
    ModerateRisk --> Resolved: self_help_completed
    LowRisk --> Archived: after_30_days
    Resolved --> Archived: case_closed
```
**Key States**:  
- `Unstarted` → `InProgress`: Tracks active assessment (FR-04)  
- `HighRisk`: Triggers counselor alerts (UC-03)  

---

## 2. Counseling Appointment
```mermaid
stateDiagram-v2
    [*] --> Unrequested
    Unrequested --> Pending: student_requests
    Pending --> Confirmed: counselor_approves
    Pending --> Canceled: student_cancels
    Confirmed --> Completed: session_ends
    Confirmed --> NoShow: student_misses
    NoShow --> FollowUp: counselor_reviews
    Completed --> Archived
```
```mermaid
stateDiagram-v2
    [*] --> Unrequested
    Unrequested --> Pending: student_requests
    Pending --> Confirmed: counselor_approves
    Pending --> Rescheduled: time_conflict
    Pending --> Canceled: student_cancels || counselor_unavailable
    Confirmed --> Completed: session_ends
    Confirmed --> NoShow: student_misses
    NoShow --> FollowUp: counselor_reviews
    Completed --> FeedbackPending: system_requests_feedback
    FeedbackPending --> Archived: feedback_provided || 7_days_elapsed
    FollowUp --> Pending: reschedule
```
**Critical Flow**:  
- `NoShow` → `FollowUp`: Addresses missed sessions (FR-15)  

---

## 3. Student Wellness Profile
```mermaid
stateDiagram-v2
    [*] --> New
    New --> Active: completes_registration
    Active --> Monitoring: low_risk
    Active --> HighPriority: high_risk
    HighPriority --> Archived: case_closed
    Monitoring --> Archived: inactive_90_days
```

**Note**:  
- `HighPriority` requires counselor attention (FR-09)  

---

## 4. Counselor Case File

```mermaid
    stateDiagram-v2
    [*] --> Unassigned
    Unassigned --> Open: counselor_accepts
    Open --> InProgress: contact_initiated
    InProgress --> OnHold: awaiting_student_response
    OnHold --> InProgress: student_responds
    InProgress --> Resolved: intervention_complete && student_confirmed
    InProgress --> Reopened: new_symptoms || academic_decline
    Reopened --> InProgress: intervention_updated
    Resolved --> Archived: 30_days_no_issues
```
**Workflow**:  
- `Reopened` state handles recurring issues (UC-07)  

---

## 5. Emergency Alert

```mermaid
  stateDiagram-v2
    [*] --> Inactive
    Inactive --> Triggered: risk_detected && (suicide_ideation || severe_depression)
    Triggered --> Acknowledged: system_notifies_counselor
    Acknowledged --> Escalated: escalation_required
    Acknowledged --> Managed: counselor_handling
    Escalated --> External: campus_security_notified || emergency_services_called
    Managed --> Resolved: intervention_complete
    External --> Resolved: external_intervention_complete
    Resolved --> Logged: report_filed && case_documented
    Logged --> [*]
```
**Protocol**:  
- `Triggered` within 5 minutes of detection (FR-20)  

---

## 6. Wellness Resource
```mermaid
stateDiagram-v2
    [*] --> Unreviewed
    Unreviewed --> InReview: counselor_assigned
    InReview --> Approved: content_verified
    InReview --> Rejected: content_unsuitable
    Approved --> Published: admin_releases
    Published --> Featured: high_effectiveness_rating
    Featured --> Published: newer_resources_available
    Published --> Archived: outdated || low_usage_90_days
    Archived --> InReview: content_refresh_requested
```
**Control**:  
- Dual approval process (FR-25)  

---

## 7. Progress Report

```mermaid
  stateDiagram-v2
    [*] --> Unprepared
    Unprepared --> Draft: counselor_starts
    Draft --> PendingAcademicData: wellness_data_added
    PendingAcademicData --> Finalized: academic_data_integrated && counselor_submits
    Finalized --> Reviewed: student_views
    Reviewed --> Updated: new_data_added || student_feedback_received
    Updated --> Finalized: counselor_approves_changes
    Finalized --> Archived: semester_end
```
**Lifecycle**:  
- `Updated` allows iterative improvements (FR-33)
# 8. User Account 
```mermaid
stateDiagram-v2
    [*] --> Created
    Created --> PendingEmailVerification: registration_submitted
    PendingEmailVerification --> PendingMFASetup: email_verified
    PendingMFASetup --> Active: mfa_setup_complete
    Active --> Locked: failed_login_attempts >= 3
    Locked --> Active: password_reset || 24_hours_elapsed
    Active --> Suspended: institutional_policy_violation
    Suspended --> Active: admin_approval
    Active --> Inactive: 60_days_no_login
    Inactive --> Active: user_returns
    Inactive --> Archived: 180_days_no_login
    Archived --> [*]
```
## State Diagrams Explanation  
[See explanation](https://github.com/ZiyandaPetela/Student_Mental_Wellness_Academic_Support_System/blob/main/state_and_workflow_modeling/workflow_explanations.md)  
