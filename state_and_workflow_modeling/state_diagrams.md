# 1. Wellness Assessment
```mermaid
stateDiagram-v2
    [*] --> WellnessAssessment
    WellnessAssessment --> Submitted: student_completes
    Submitted --> Analyzed: system_processes
    Analyzed --> HighRisk: score >= threshold
    Analyzed --> LowRisk: score < threshold
    HighRisk --> Resolved: counselor_intervenes
    LowRisk --> Archived: after_30_days
    Resolved --> Archived: case_closed
```
# 2. Wellness Appointment
```mermaid
stateDiagram-v2
    [*] --> Pending
    Pending --> Confirmed: counselor_approves
    Pending --> Canceled: student_cancels
    
    state "Confirmed" as conf <<blue>>
    state "NoShow" as ns <<orange>>
    
    conf --> Completed: session_ends
    conf --> ns: student_misses
    ns --> Archived: after_review
    Completed --> Archived
    Canceled --> Archived
```
# State Transition Diagrams

## 1. Wellness Assessment
```mermaid
stateDiagram-v2
    [*] --> WellnessDraft
    WellnessDraft --> Submitted: student_completes
    Submitted --> Analyzed: system_scores
    Analyzed --> HighRisk: score >= threshold
    Analyzed --> LowRisk: score < threshold
    HighRisk --> Resolved: counselor_intervention
    LowRisk --> Archived: after_30_days
    Resolved --> Archived: case_closed
```

**Explanation**:  
- **Key States**: `HighRisk` (requires counselor action), `LowRisk` (auto-archived after 30 days).  
- **Links to**: FR-04 (Automated scoring), UC-01 (Complete Assessment).  

---

## 2. Wellness Appointment
```mermaid
stateDiagram-v2
    [*] --> Pending
    Pending --> Confirmed: counselor_approves
    Pending --> Canceled: student_cancels
    Confirmed --> Completed: session_ends
    Confirmed --> NoShow: student_misses
    NoShow --> Archived: after_review
    Completed --> Archived
```

**Explanation**:  
- **Critical Transition**: `NoShow` state triggers follow-up (FR-30).  

---

## 3. Student Wellness Profile
```mermaid
stateDiagram-v2
    [*] --> New
    New --> Active: completes_registration
    Active --> Monitoring: low_risk
    Active --> HighPriority: high_risk
    Monitoring --> Archived: inactive_30_days
    HighPriority --> Archived: case_closed
```

---

## 4. Counselor Wellness Case
```mermaid
stateDiagram-v2
    [*] --> Open
    Open --> Assigned: counselor_accepts
    Assigned --> InProgress: contact_initiated
    InProgress --> Resolved: student_confirmed
    InProgress --> Reopened: new_symptoms
```

---

## 5. Wellness Emergency Alert
```mermaid
stateDiagram-v2
    [*] --> Triggered
    Triggered --> Escalated: notify_counselor
    Escalated --> Resolved: intervention_complete
    Resolved --> Logged: report_filed
```

---

## 6. Wellness Resource
```mermaid
stateDiagram-v2
    [*] --> Draft
    Draft --> Reviewed: counselor_approves
    Reviewed --> Published: admin_approves
    Published --> Archived: outdated
```

---

## 7. Wellness Progress Report
```mermaid
stateDiagram-v2
    [*] --> Draft
    Draft --> Shared: counselor_submits
    Shared --> Reviewed: student_views
    Reviewed --> Updated: new_data_added
    Updated --> Archived: semester_end
```











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
    InProgress --> Resolved: student_confirmed
    InProgress --> Reopened: new_symptoms
    Resolved --> Archived
```
**Workflow**:  
- `Reopened` state handles recurring issues (UC-07)  

---

## 5. Emergency Alert
```mermaid
stateDiagram-v2
    [*] --> Inactive
    Inactive --> Triggered: risk_detected
    Triggered --> Escalated: notify_counselor
    Escalated --> Resolved: intervention_complete
    Resolved --> Logged: report_filed
```
**Protocol**:  
- `Triggered` within 5 minutes of detection (FR-20)  

---

## 6. Wellness Resource
```mermaid
stateDiagram-v2
    [*] --> Unreviewed
    Unreviewed --> Approved: counselor_verifies
    Approved --> Published: admin_releases
    Published --> Archived: outdated
```
**Control**:  
- Dual approval process (FR-25)  

---

## 7. Progress Report
```mermaid
stateDiagram-v2
    [*] --> Unprepared
    Unprepared --> Draft: counselor_starts
    Draft --> Finalized: counselor_submits
    Finalized --> Reviewed: student_views
    Reviewed --> Updated: new_data_added
    Updated --> Archived: semester_end
```
**Lifecycle**:  
- `Updated` allows iterative improvements (FR-33)  
