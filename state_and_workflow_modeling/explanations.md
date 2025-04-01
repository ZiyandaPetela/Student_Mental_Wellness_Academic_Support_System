# State Diagram Explanations

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
