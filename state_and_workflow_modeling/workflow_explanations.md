# Workflow Explanations
# State Diagram Explanations
# replace UC/FR with the correct ones from assignment 4/5
## 1. Wellness Assessment
### Key States and Transitions
- **Unstarted → InProgress**: Student begins assessment (triggered by UC-01: "Complete Wellness Assessment").
- **InProgress → Submitted**: Student completes all questions (FR-04: "System shall auto-submit after completion").
- **Analyzed → HighRisk**: Score exceeds threshold (FR-07: "Flag high-risk assessments for counselors").
- **Resolved → Archived**: Case closed after counselor intervention (FR-12: "Archive resolved cases after 30 days").

---

## 2. Counseling Appointment
### Key States and Transitions
- **Unrequested → Pending**: Student requests appointment (UC-03: "Schedule Counseling Session").
- **Pending → Canceled**: Student cancels (FR-15: "Allow cancellations up to 24h before").
- **Confirmed → NoShow**: Student misses session (FR-18: "Track no-shows for follow-up").
- **FollowUp**: Counselor reviews no-shows (UC-07: "Handle missed appointments").

---

## 3. Student Wellness Profile
### Key States and Transitions
- **New → Active**: Student completes registration (FR-21: "Require profile completion").
- **Active → HighPriority**: System detects high-risk symptoms (FR-09: "Prioritize high-risk profiles").
- **Monitoring → Archived**: Inactive for 90 days (FR-24: "Auto-archive inactive profiles").

---

## 4. Counselor Case File
### Key States and Transitions
- **Unassigned → Open**: Counselor accepts case (UC-05: "Assign cases to counselors").
- **InProgress → Reopened**: New symptoms reported (FR-27: "Allow case reopening").
- **Resolved → Archived**: Counselor confirms resolution (FR-30: "Close cases after 14 days").

---

## 5. Emergency Alert
### Key States and Transitions
- **Inactive → Triggered**: System detects crisis (FR-20: "Immediate alerts for suicidal ideation").
- **Escalated → Resolved**: Counselor intervenes (UC-09: "Emergency protocol").
- **Logged**: Audit trail created (FR-33: "Log all emergency actions").

---

## 6. Wellness Resource
### Key States and Transitions
- **Unreviewed → Approved**: Counselor verifies content (FR-25: "Counselor approval for resources").
- **Published → Archived**: Resource outdated (FR-36: "Archive unused resources after 1 year").

---

## 7. Progress Report
### Key States and Transitions
- **Unprepared → Draft**: Counselor starts report (UC-11: "Generate Progress Reports").
- **Finalized → Reviewed**: Student views report (FR-39: "Share reports with students").
- **Updated**: New assessment data added (FR-42: "Allow report updates").

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
