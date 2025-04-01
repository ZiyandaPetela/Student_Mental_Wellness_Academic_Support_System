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
