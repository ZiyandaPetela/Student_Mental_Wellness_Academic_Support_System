# Workflow Explanations
# State Diagram Explanations
# need to replace UC/FR with the correct ones from assignment 4/5
## 1. Wellness Assessment
### Key States and Transitions
- **Unstarted → InProgress**: Student begins assessment (triggered by "Complete Wellness Assessment" use case).
- **InProgress → Submitted**: Student completes all questions (FR4: "System shall implement PHQ-9 and GAD-7 assessments with real-time feedback").
- **Analyzed → HighRisk/ModerateRisk/LowRisk**: Scores categorized based on clinical thresholds (PHQ-9 ≥ 15 or GAD-7 ≥ 10 for high risk).
- **HighRisk → Resolved**: Counselor intervention required for severe cases (supports US-005 Resources recommendation).
- **Resolved → Archived**: Case closed after intervention or self-help completion (supports monitoring in FR11).
---

## 2. Counseling Appointment
### Key States and Transitions
- **Unrequested → Pending**: Student requests appointment (implements "Schedule Counselling Appointment" use case).
- **Pending → Confirmed/Rescheduled/Canceled**: Multiple outcome paths based on availability (supports US-010 scheduling).
- **Confirmed → NoShow**: Student misses session (triggers follow-up protocol).
- **Completed → FeedbackPending**: System requests session feedback for service improvement.
- **FollowUp**: Ensures no student issues are overlooked (supporting comprehensive care).
---

## 3. Student Wellness Profile
### Key States and Transitions
- **New → Active**: Student completes registration (FR-21: "Require profile completion").
- **Active → HighPriority**: System detects high-risk symptoms (FR-09: "Prioritize high-risk profiles").
- **Monitoring → Archived**: Inactive for 90 days (FR-24: "Auto-archive inactive profiles").

---

## 4. Counselor Case File
### Key States and Transitions
- **Unassigned → Open**: Counselor accepts case (supports counselor role in use case diagram).
- **InProgress → OnHold/Resolved/Reopened**: Multiple progression paths based on student response.
- **Reopened → InProgress**: Tracks recurring issues or academic decline (FR6: "Assess how mental health issues affect academic activities").
- **Resolved → Archived**: Documentation complete after follow-up period (supports US-016 Correlation).
---

## 5. Emergency Alert
### Key States and Transitions
- **Inactive → Triggered**: System detects crisis indicators like suicide ideation or severe depression.
- **Acknowledged → Escalated/Managed**: Decision point for severity level (supports "Generate Risk Assessment Reports" use case).
- **External → Resolved**: Campus security or emergency services involved for severe cases.
- **Logged**: Creates comprehensive audit trail (supports US-012 Reporting).
---

## 6. Wellness Resource
### Key States and Transitions
- **Unreviewed → InReview → Approved**: Quality control workflow (FR9: "Categorize content by topic").
- **Published → Featured**: Highlights highly effective resources based on user feedback.
- **Archived → InReview**: Allows content refresh cycle (supports US-006 Filtering Resources).
- **Featured → Published**: Rotation of featured resources keeps content fresh.

## 7. Progress Report
### Key States and Transitions
- **Unprepared → Draft**: Counselor initiates report creation.
-  **PendingAcademicData → Finalized**: Integration of wellness and academic metrics (FR11: "Track and visualize mental wellness trends").
- **Reviewed → Updated**: Iterative improvement process with student feedback.
- **Finalized → Archived**: Semester-end documentation (supports US-009 Trends and US-007 Dashboard).

## 8. User Account
### Key States and Transitions
- **Created → PendingEmailVerification**: Institutional email validation (FR1: "Registration with institutional email").
- **PendingMFASetup → Active**: Security setup complete (FR2: "Multi-factor authentication").
- **Active → Locked**: Security protection for failed attempts (supports NRF6: "Data encryption").
- **Inactive → Archived**: Lifecycle management for unused accounts (supports US-001 Registration and US-002 MFA).
---


# Activity Diagram Explanations
## 1. Student Registration & Authentication
### Key Steps
1. **Email Validation**: Verifies institutional email domains (FR1)
2. **OTP Verification**: Enforces multi-factor authentication (FR2)
3. **Profile Completion**: Mandates academic/wellness data (FR3)

### Stakeholder Benefits
- **Students**: Secure onboarding (NRF6 encryption)
- **Admins**: Compliant with FERPA (NRF7)
- **System**: Blocks non-institutional emails (FR1 acceptance criteria)

---

## 2. PHQ-9/GAD-7 Assessment Flow
### Key Steps
1. **Question Processing**: Validated depression/anxiety tools (FR4)
2. **Real-Time Scoring**: <2s processing (NRF9)
3. **High-Risk Escalation**: Auto-alerts counselors (FR12)

### Stakeholder Benefits
- **Students**: Immediate feedback (FR4)
- **Counselors**: Prioritized cases (FR12)
- **System**: Handles 1,000 concurrent users (NRF10)

---

## 3. Academic-Mental Health Correlation
### Key Steps
1. **Data Aggregation**: Links grades to assessment scores (FR6)
2. **Pattern Analysis**: Identifies academic impacts
3. **Intervention Suggestions**: Custom study plans (FR8)

### Stakeholder Benefits
- **Faculty**: Early warning system
- **Students**: Targeted academic support (FR8)
- **System**: Modular updates (NRF13)

---

## 4. Crisis Resource Delivery
### Key Steps
1. **Risk Triage**: Score-based routing (FR7)
2. **Emergency Protocol**: Instant hotline display
3. **Logging**: Encrypted audit trail (NRF6)

### Stakeholder Benefits
- **Students**: Life-saving resources
- **Counselors**: Clear escalation path
- **Compliance**: HIPAA-ready (NRF7)

---

## 5. Progress Tracking & Goal Updates
### Key Steps
1. **Dashboard Updates**: Real-time graphs (FR11)
2. **Milestone Checks**: Automated notifications (FR12)
3. **Plan Adjustment**: Dynamic recommendations

### Stakeholder Benefits
- **Students**: Motivational tracking
- **Admins**: WCAG 2.1 AA compliant (NRF1)
- **System**: 99.5% uptime (NRF14)

---

## 6. Counselor High-Risk Case Handling
### Key Steps
1. **Alert Reception**: <5 min response (FR12)
2. **Threat Assessment**: Counselor judgment
3. **Escalation**: Campus safety integration

### Stakeholder Benefits
- **Counselors**: Streamlined workflow
- **Students**: Rapid intervention
- **Security**: AES-256 encrypted comms (NRF6)

---

## 7. Study Guide Generation
### Key Steps
1. **Content Fetching**: Topic-filtered (FR9)
2. **Wellness Integration**: Stress-management tips (FR10)
3. **PDF Output**: Accessible format (NRF1)

### Stakeholder Benefits
- **Students**: Unified academic/wellness support
- **System**: Linux/Windows compatible (NRF3)

---

## 8. Automated Backup & Compliance
### Key Steps
1. **Daily Backup**: Offsite encrypted storage (NRF15)
2. **Report Generation**: Compliance documentation (NRF7)
3. **Anomaly Detection**: Admin alerts

### Stakeholder Benefits
- **Admins**: Automated legal compliance
- **System**: Docker-ready (NRF4)
- **Data**: 50% faster deployments (NRF5)

# Activity Diagram Explanations

## 1. Student Registration & Authentication
### Key Steps
1. **Email Validation**: Verifies institutional email domains (FR1)
2. **OTP Verification**: Enforces multi-factor authentication (FR2)
3. **Profile Completion**: Mandates academic/wellness data (FR3)

### Stakeholder Benefits
- **Students**: Secure onboarding with protection of sensitive mental health data (NRF6: "AES-256 encryption")
- **Admins**: Compliant with educational data privacy regulations (NRF7)
- **System**: Robust validation prevents unauthorized access (supports US-001 Registration)

## 2. PHQ-9/GAD-7 Assessment Flow
### Key Steps
1. **Question Presentation**: Validated depression/anxiety screening tools (FR4)
2. **Real-Time Scoring**: Fast processing within 2 seconds (NRF9)
3. **High-Risk Escalation**: Automated alerts to counselors for critical cases

### Stakeholder Benefits
- **Students**: Immediate feedback with personalized recommendations (FR7) 
- **Counselors**: Prioritized case management for efficient intervention
- **System**: Handles 1,000 concurrent assessments during peak periods (NRF10)

## 3. Academic-Mental Health Correlation
### Key Steps
1. **Data Aggregation**: Links academic performance with mental health metrics (FR6)
2. **Pattern Analysis**: Identifies impact on specific activities like attendance and grades
3. **Intervention Suggestions**: Customized study techniques aligned with mental health needs (FR8)

### Stakeholder Benefits
- **Faculty**: Early warning system for academic performance issues
- **Students**: Targeted support addressing both academic and wellness concerns
- **System**: Supports modular updates without requiring full system restart (NRF13)

## 4. Crisis Resource Delivery
### Key Steps
1. **Risk Triage**: Score-based routing to appropriate resources (FR7)
2. **Emergency Protocol**: Immediate display of crisis resources for high-risk cases
3. **Secure Tracking**: Encrypted audit trail of resource delivery (NRF6)

### Stakeholder Benefits
- **Students**: Life-saving resources delivered when most needed
- **Counselors**: Clear escalation path with defined protocols
- **Compliance**: Maintains privacy while enabling necessary interventions (NRF7)

## 5. Progress Tracking & Goal Setting
### Key Steps
1. **Dashboard Visualization**: Real-time graphs and trends (FR11)
2. **Goal Definition**: Student-defined wellness objectives (FR12)
3. **Milestone Notifications**: Automated recognition of achievements

### Stakeholder Benefits
- **Students**: Motivational tracking with visual progress indicators (supports US-008 Goals)
- **System**: Accessible interface compliant with WCAG 2.1 AA standards (NRF1)
- **Data Integrity**: 99.5% uptime ensures consistent access to progress data (NRF14)

## 6. Counselor High-Risk Case Management
### Key Steps
1. **Alert Reception**: Rapid notification of high-risk assessments
2. **Case Evaluation**: Counselor assessment of severity and urgency
3. **Intervention Planning**: Structured approach based on risk level
4. **Referral Options**: Integration with external services when needed

### Stakeholder Benefits
- **Counselors**: Streamlined workflow prioritizing most urgent cases
- **Students**: Timely intervention for critical mental health needs
- **Security**: Encrypted communications protect sensitive discussions (NRF6)

## 7. Personalized Study Resource Generation
### Key Steps
1. **Content Filtering**: Topic-specific educational resources (FR9)
2. **Mental Wellness Integration**: Study guides with stress management components (FR10)
3. **Personalization**: Adapting recommendations to individual assessment results (FR7)

### Stakeholder Benefits
- **Students**: Unified approach connecting academic needs with mental wellness strategies
- **Faculty**: Supplementary resources that support classroom learning
- **System**: Cross-platform compatibility with Windows and Linux (NRF3)

## 8. System Security & Compliance Management
### Key Steps
1. **Automated Backups**: Daily secure data protection (NRF15)
2. **Compliance Monitoring**: Regular checks against privacy regulations (NRF7)
3. **Containerized Deployment**: Docker-based implementation for consistency (NRF4)

### Stakeholder Benefits
- **Administrators**: Streamlined compliance documentation
- **IT Staff**: Simplified deployment and maintenance (NRF5: "50% faster deployments")
- **Data Protection**: Multi-layered security approach protecting sensitive mental health data
