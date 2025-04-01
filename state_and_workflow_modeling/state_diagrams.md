```mermaid
stateDiagram-v2
    [*] --> Draft
    Draft --> Submitted: student_submits
    Submitted --> Analyzed: system_scores
    Analyzed --> HighRisk: score >= threshold
    Analyzed --> LowRisk: score < threshold
    HighRisk --> Resolved: counselor_intervention
    LowRisk --> Archived: after_30_days
    Resolved --> Archived: case_closed
```
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
