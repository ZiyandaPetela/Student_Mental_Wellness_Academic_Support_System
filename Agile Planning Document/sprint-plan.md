# Sprint Plan Document  

## Sprint Goal
Implement secure student registration, mental health assessments, personalized resource delivery, and appointment scheduling to establish the MVP foundation.

---

## Sprint Goal Contribution to MVP
This sprint delivers the core MVP functionality by enabling:
- **Secure access**: Student registration and multi-factor authentication (MFA).
- **Mental health assessments**: PHQ-9/GAD-7 assessments with real-time feedback.
- **Personalized resources**: Recommendations based on assessment results.
- **Appointment scheduling**: Counseling session scheduling with calendar integration.

---

## Selected User Stories (6 Must-Have)
| **Story ID** | **User Story**                                                                 | **GitHub Issue Link** |
|--------------|--------------------------------------------------------------------------------|-----------------------|
| US-001       | Student registration with institutional email.                                 | [Issue #1](#)        |
| US-002       | Multi-factor authentication (MFA).                                            | [Issue #2](#)        |
| US-003       | PHQ-9/GAD-7 assessments with real-time feedback.                              | [Issue #3](#)        |
| US-005       | Personalized mental health resources.                                         | [Issue #5](#)        |
| US-006       | Filter resources by topic.                                                    | [Issue #6](#)        |
| US-010       | Schedule counseling appointments.                                             | [Issue #10](#)       |

---

## Sprint Backlog
| **Task ID** | **Task Description**                          | **Assigned To**   | **Estimated Hours** | **Status**   | 
|-------------|-----------------------------------------------|-------------------|----------------------|--------------|
| T-001       | Develop registration API with email validation. | Backend Team      | 10                   | In Progress|
| T-002       | Design student registration UI.               | Frontend Team     | 8                    | To Do        | 
| T-003       | Integrate OTP service for MFA.                | Security Team     | 12                   | In Progress  | 
| T-004       | Build PHQ-9/GAD-7 scoring algorithm.          | Data Team         | 14                   | To Do        | 
| T-005       | Create assessment feedback interface.         | UX Team           | 8                    | To Do        | 
| T-006       | Develop recommendation engine for resources.  | AI Team           | 16                   | To Do        | 
| T-007       | Implement topic-based filtering UI.           | Frontend Team     | 6                    | To Do        | 
| T-008       | Design appointment scheduling calendar.       | Full-Stack Team   | 10                   | To Do        | 
| T-009       | Sync appointments with calendar API.          | Backend Team      | 8                    | To Do        | 

---

## Dependencies
-  **US-002 (MFA)** requires **US-001 (Registration)**.
-  **US-005/US-006 (Resources)** depend on **US-003 (Assessments)**.
-  **US-010 (Appointments)** depends on **US-001 (Registration)**.

---

## Workflow Strategy
### Parallel Development:
- **Backend**: Registration API (T-001) + OTP (T-003).
- **Frontend/UX**: Registration UI (T-002) + Feedback UI (T-005).

### Critical Path:
- Focus on **T-004 (Scoring Algorithm)** to unblock resource recommendations.

### Daily Standups:
- Track blockers (e.g., OTP delays).

---

## Time Estimates & Milestones
- **Total Hours**: 92 hours (≈2 weeks for a 4-person team).
- **Key Milestones**:
  - **Day 3**: Complete registration API (T-001) and OTP setup (T-003).
  - **Day 7**: Finish scoring algorithm (T-004) and recommendation engine (T-006).
  - **Day 10**: Finalize appointment scheduling (T-008/T-009).

---




