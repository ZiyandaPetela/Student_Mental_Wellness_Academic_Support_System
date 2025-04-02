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

## 2. PHQ-9/GAD-7 Assessment Flow  
**Swimlanes**: Student, System, Counselor  
```mermaid
flowchart TD
    start([Start]) --> A[Display Questions] --> B[Student Answers]
    B --> C{{"All questions answered?"}}
    C -->|No| D[Save Progress] --> B
    C -->|Yes| E[Calculate Scores] --> F[Generate Recommendations]
    F --> G[Display Dashboard] --> end([End])
    E -->|Score ≥8| H[Alert Counselor] --> I[High-Risk Protocol]
```
**Stakeholder Value**:  
- Real-time processing (<2s) for immediate feedback (**FR4, NRF9**).  
- Auto-escalation for high-risk cases (**FR4, FR12**).  

---

## 3. Academic-Mental Health Correlation  
**Swimlanes**: System, Database  
```mermaid
flowchart TD
    start([Start]) --> A[Pull Grades] --> B[Fetch Assessment Data]
    B --> C[Identify Patterns] --> D{{"Significant correlation?"}}
    D -->|Yes| E[Suggest Academic Adjustments] --> F[Update Student Dashboard]
    D -->|No| G[Log Baseline Data] --> end([End])
```
**Stakeholder Value**:  
- Links mental health to academic performance (**FR6**).  
- Supports data-driven interventions (**FR8**).  

---

## 4. Crisis Resource Delivery  
**Swimlanes**: System, Student  
```mermaid
flowchart TD
    start([Start]) --> A[Check Risk Level] --> B{{"High risk?"}}
    B -->|Yes| C[Show Crisis Hotline] --> D[Trigger Counselor Alert]
    B -->|No| E[Recommend Self-Help Articles] --> end([End])
    D --> F[Log Intervention] --> end
```
**Stakeholder Value**:  
- Prioritizes life-saving resources (**FR7**).  
- HIPAA-compliant logging (**NRF7**).  

---

## 5. Progress Tracking & Goal Updates  
**Swimlanes**: Student, System  
```mermaid
flowchart TD
    start([Start]) --> A[View Dashboard] --> B{{"New data?"}}
    B -->|Yes| C[Update Trends Graph] --> D[Check Milestones]
    B -->|No| end([End])
    D --> E{{"Goal achieved?"}} -->|Yes| F[Send Congratulation] --> end
    E -->|No| G[Adjust Recommendations] --> end
```
**Stakeholder Value**:  
- Visualizes progress for motivation (**FR11**).  
- Accessible UI (**NRF1**).  

---

## 6. Counselor High-Risk Case Handling  
**Swimlanes**: Counselor, System, Campus Safety  
```mermaid
flowchart TD
    start([Start]) --> A[Receive Alert] --> B[Review Assessment]
    B --> C{{"Immediate threat?"}}
    C -->|Yes| D[Contact Student] --> E[Escalate if No Response]
    C -->|No| F[Schedule Follow-Up] --> end([End])
    E --> G[Notify Campus Safety] --> end
```
**Stakeholder Value**:  
- Ensures rapid response to crises (**FR4, NRF14**).  
- Clear escalation paths (**FR12**).  

---

## 7. Study Guide Generation  
**Swimlanes**: System, Database  
```mermaid
flowchart TD
    start([Start]) --> A[Select Topic] --> B[Fetch Content]
    B --> C[Inject Wellness Tips] --> D{{"Exam in <1 week?"}}
    D -->|Yes| E[Prioritize Stress Relief] --> F[Generate PDF]
    D -->|No| F --> end([End])
```
**Stakeholder Value**:  
- Integrates academic and mental health support (**FR10**).  
- Modular content updates (**NRF13**).  

---

## 8. Automated Backup & Compliance  
**Swimlanes**: System, Admin  
```mermaid
flowchart TD
    start([Start]) --> A[Trigger Daily Backup] --> B[Encrypt Data]
    B --> C[Upload to Offsite] --> D[Generate Compliance Report]
    D --> E{{"Anomalies detected?"}}
    E -->|Yes| F[Alert Admin] --> end([End])
    E -->|No| end
```
**Stakeholder Value**:  
- Meets legal data retention rules (**NRF7, NRF15**).  
- Supports audit trails (**NRF12**).  
