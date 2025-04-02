# Activity Workflow Diagrams
# 1. Student Registration & Authentication  
**Swimlanes**: Student, System, Database  
```mermaid
flowchart TD
    start([Start]) --> A[Enter Email]
    A --> B{"Valid institutional email?"}
    B -->|Yes| C[Send OTP]
    B -->|No| E[Show Error] --> end1([End])
    C --> D[Input Profile Data]
    D --> F{"All mandatory fields complete?"}
    F -->|Yes| G[Encrypt & Save Profile] --> H[Confirm Registration] --> end2([End])
    F -->|No| I[Prompt Completion] --> D
```
## 1. Student Registration & Authentication  
**Swimlanes**: Student, System, Database  

```mermaid
flowchart TD
    start([Start]) --> A[Enter Email] --> B{{"Valid institutional email?"}}
    B -->|Yes| C[Send OTP] --> D[Input Profile Data]
    B -->|No| E[Show Error] --> end([End])
    D --> F{{"All mandatory fields complete?"}}
    F -->|Yes| G[Encrypt & Save Profile] --> H[Confirm Registration]
    F -->|No| I[Prompt Completion] --> D
    H --> end
```
**Stakeholder Value**:  
- Ensures only verified students access the system (**FR1, NRF7**).  
- MFA and encryption meet security standards (**FR2, NRF6**).  

---
# Activity Workflow Diagrams

## 1. Student Registration & Authentication  
**Swimlanes**: Student, System, Database  
```mermaid
flowchart TD
    start([Start]) --> A[Enter Email]
    A --> B{"Valid institutional email?"}
    B -->|Yes| C[Send OTP]
    B -->|No| E[Show Error] --> end1([End])
    C --> D[Input Profile Data]
    D --> F{"All mandatory fields complete?"}
    F -->|Yes| G[Encrypt & Save Profile] --> H[Confirm Registration] --> end2([End])
    F -->|No| I[Prompt Completion] --> D
```

## 2. PHQ-9/GAD-7 Assessment Flow  
**Swimlanes**: Student, System, Counselor  
```mermaid
flowchart TD
    start([Start]) --> A[Display Questions]
    A --> B[Student Answers]
    B --> C{"All questions answered?"}
    C -->|No| D[Save Progress] --> B
    C -->|Yes| E[Calculate Scores]
    E --> F[Generate Recommendations]
    F --> G[Display Dashboard] --> end1([End])
    E -->|Score ≥8| H[Alert Counselor] --> I[High-Risk Protocol] --> end2([End])
```

## 3. Academic-Mental Health Correlation  
**Swimlanes**: System, Database  
```mermaid
flowchart TD
    start([Start]) --> A[Pull Grades]
    A --> B[Fetch Assessment Data]
    B --> C[Identify Patterns]
    C --> D{"Significant correlation?"}
    D -->|Yes| E[Suggest Adjustments] --> F[Update Dashboard] --> end1([End])
    D -->|No| G[Log Baseline Data] --> end2([End])
```

## 4. Crisis Resource Delivery  
**Swimlanes**: System, Student  
```mermaid
flowchart TD
    start([Start]) --> A[Check Risk Level]
    A --> B{"High risk?"}
    B -->|Yes| C[Show Crisis Hotline] --> D[Trigger Alert] --> end1([End])
    B -->|No| E[Recommend Articles] --> end2([End])
```

## 5. Progress Tracking & Goal Updates  
**Swimlanes**: Student, System  
```mermaid
flowchart TD
    start([Start]) --> A[View Dashboard]
    A --> B{"New data?"}
    B -->|Yes| C[Update Trends] --> D[Check Milestones]
    D --> E{"Goal achieved?"}
    E -->|Yes| F[Send Notification] --> end1([End])
    E -->|No| G[Adjust Plan] --> end2([End])
    B -->|No| end3([End])
```

## 6. Counselor High-Risk Case Handling  
**Swimlanes**: Counselor, System, Campus Safety  
```mermaid
flowchart TD
    start([Start]) --> A[Receive Alert]
    A --> B[Review Assessment]
    B --> C{"Immediate threat?"}
    C -->|Yes| D[Contact Student] --> E{"Responded?"}
    E -->|No| F[Escalate] --> end1([End])
    E -->|Yes| end2([End])
    C -->|No| G[Schedule Follow-Up] --> end3([End])
```

## 7. Study Guide Generation  
**Swimlanes**: System, Database  
```mermaid
flowchart TD
    start([Start]) --> A[Select Topic]
    A --> B[Fetch Content]
    B --> C[Add Wellness Tips]
    C --> D{"Exam in <1 week?"}
    D -->|Yes| E[Prioritize Stress Relief] --> F[Generate PDF] --> end1([End])
    D -->|No| F --> end2([End])
```

## 8. Automated Backup & Compliance  
**Swimlanes**: System, Admin  
```mermaid
flowchart TD
    start([Start]) --> A[Trigger Backup]
    A --> B[Encrypt Data]
    B --> C[Upload Offsite]
    C --> D[Generate Report]
    D --> E{"Anomalies?"}
    E -->|Yes| F[Alert Admin] --> end1([End])
    E -->|No| end2([End])
```
