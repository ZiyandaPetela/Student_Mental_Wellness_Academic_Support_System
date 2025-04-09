# Student Mental Wellness System - Domain Model

## Core Entities

| Entity               | Attributes                              | Methods                          | Relationships                     | Business Rules                          |
|----------------------|-----------------------------------------|----------------------------------|-----------------------------------|-----------------------------------------|
| **Student**         | `studentId`, `email`, `academicYear`, `major`, `status` | `register()`, `login()`, `completeAssessment()` | Initiates Assessments, Sets Goals, Books Appointments | Must use institutional email (FR1), Max 3 active appointments |
| **MentalHealthAssessment** | `assessmentId`, `type`, `score`, `timestamp`, `status` | `calculateScore()`, `generateRiskReport()` | Generates Recommendations, Triggers Alerts | PHQ-9 ≥15 triggers high-risk alert, Mandatory every 30 days |
| **Counselor**       | `counselorId`, `specialization`, `availabilitySlots` | `viewStudentTrends()`, `confirmAppointment()` | Conducts Appointments, Reviews Resources | 15-min response to high-risk alerts |
| **Appointment**     | `appointmentId`, `datetime`, `duration`, `status` | `schedule()`, `cancel()`, `sendReminder()` | Links Student and Counselor | 24h cancellation notice, Max 60min duration |
| **WellnessResource** | `resourceId`, `title`, `type`, `topic`, `approvalStatus` | `filterByTopic()`, `rateHelpfulness()` | Recommended via Assessments | Counselor approval required before publish |
| **EmergencyAlert**  | `alertId`, `severity`, `triggerTime`, `responseTime` | `escalate()`, `markResolved()` | Triggered by HighRisk Assessments | Must acknowledge within 5 minutes |
| **ProgressTracker** | `trackerId`, `wellnessScoreTrend`, `goalCompletionRate` | `generateTrendReport()`, `sendMilestoneNotifications()` | Monitors Student and Goals | Weekly notifications if progress <50% |

## Key Relationships

```mermaid
graph TD
    Student -->|completes| MentalHealthAssessment
    MentalHealthAssessment -->|generates| Recommendation
    Student -->|books| Appointment
    Appointment -->|with| Counselor
    MentalHealthAssessment -->|triggers| EmergencyAlert
    Counselor -->|reviews| WellnessResource
```
Business Rules Summary
Authentication:

Institutional email validation (FR1)

Multi-factor authentication (FR2)

Assessments:

PHQ-9 ≥15 → High-risk flag (FR4)

Mandatory reassessment every 30 days (FR5)

Appointments:

Max 3 active appointments per student

24-hour cancellation policy

Emergency Protocol:

5-minute alert acknowledgment (FR20)

Counselor escalation paths

Data Privacy:

Anonymized trend analysis (NRF7)

AES-256 encryption (NRF6)

Traceability
Entity	Related Requirements	Linked Use Cases
Student	FR1, FR2, FR15	Register, Track Goals
Assessment	FR4, FR5, FR6	Complete Assessment
Appointment	FR10, FR15	Schedule Counseling
EmergencyAlert	FR20	Generate Risk Reports

# Domain Model: Student Mental Wellness Academic Support System

| Entity | Attributes | Methods | Relationships |
|--------|------------|---------|----------------|
| **Student** | studentId, name, email, academicYear, major, preferences | register(), login(), completeAssessment() | Has many **Assessments**, has one **Profile**, schedules **CounsellingAppointments** |
| **Assessment** | assessmentId, type (PHQ-9/GAD-7), dateTaken, score, feedback | generateFeedback(), correlateWithAcademic() | Belongs to **Student**, generates **Report**, recommends **Resources** |
| **Profile** | profileId, wellnessPreferences, goals | updatePreferences(), setGoals() | Belongs to **Student** |
| **Resource** | resourceId, title, topic, type, url | filterByTopic(), recommend() | Recommended by **Assessment** |
| **Counsellor** | counsellorId, name, availabilitySchedule | viewAppointments(), analyzeTrends() | Has many **CounsellingAppointments**, views **Reports** |
| **CounsellingAppointment** | appointmentId, dateTime, status | schedule(), cancel() | Belongs to **Student** and **Counsellor** |
| **Report** | reportId, summary, riskLevel, academicCorrelation | downloadPDF(), anonymizeData() | Generated from **Assessment**, viewed by **Counsellor** and **Admin** |

## Business Rules
- A student can schedule **one counselling appointment per day**.
- Each student can complete **only one assessment per type (PHQ-9/GAD-7) per week**.
- An assessment must generate **real-time feedback within 2 seconds**.
- Each student can have **only one active wellness goal** at a time.
- Resources must be **filterable by topic** (e.g., stress, anxiety, depression).
- Counselors only access **anonymized data** unless explicitly authorized.
- **High-risk assessments** must trigger an alert to a counselor within 5 minutes.
- Reports must be **downloadable in PDF format** for sharing with counselors or academic advisors.

# Student Mental Wellness Academic Support System - Domain Model

## Key Domain Entities

| Entity | Attributes | Methods | Relationships |
|--------|------------|---------|---------------|
| Student | - studentId: String<br>- email: String<br>- password: String<br>- academicYear: String<br>- major: String<br>- authenticationStatus: Boolean | - register()<br>- login()<br>- completeAssessment()<br>- viewRecommendations()<br>- scheduleAppointment()<br>- trackProgress()<br>- setWellnessGoals() | - Completes Assessments<br>- Receives Recommendations<br>- Schedules Appointments with Counselors<br>- Sets WellnessGoals<br>- Tracks WellnessTrends |
| Assessment | - assessmentId: String<br>- type: String (PHQ-9/GAD-7)<br>- date: DateTime<br>- score: Integer<br>- feedback: String<br>- frequency: String | - calculateScore()<br>- provideFeedback()<br>- correlateWithAcademics()<br>- setFrequency() | - Completed by Student<br>- Generates Recommendations<br>- Associated with WellnessTrend |
| Recommendation | - recommendationId: String<br>- type: String<br>- priority: Integer<br>- dateGenerated: DateTime | - generateForStudent()<br>- matchToAssessment()<br>- linkToResources() | - Generated from Assessment<br>- Includes Resources<br>- Provided to Student |
| Resource | - resourceId: String<br>- title: String<br>- type: String<br>- category: String<br>- content: String | - categorize()<br>- filter() | - Included in Recommendations<br>- Categorized by topic |
| Counselor | - counselorId: String<br>- email: String<br>- password: String<br>- specialization: String<br>- availability: DateTime[] | - login()<br>- updateAvailability()<br>- viewAnonymizedTrends()<br>- generateRiskReports() | - Has Appointments with Students<br>- Creates RiskAssessments |
| Appointment | - appointmentId: String<br>- date: DateTime<br>- status: String<br>- notes: String | - schedule()<br>- cancel()<br>- reschedule()<br>- syncCalendar() | - Between Student and Counselor |
| WellnessGoal | - goalId: String<br>- description: String<br>- targetDate: DateTime<br>- progress: Float<br>- isAchieved: Boolean | - updateProgress()<br>- notifyMilestone() | - Set by Student |

## Business Rules

1. Registration requires an institutional email address (validated by domain)
2. All user logins require two-factor authentication (password + OTP)
3. Assessments generate personalized recommendations within 2 seconds of completion
4. Students can customize the frequency of their assessments (daily/weekly/monthly)
5. Resources are categorized by topic (stress, anxiety, depression) with 100% filtering accuracy
6. Students can set and track mental wellness goals, receiving notifications upon reaching milestones
7. Counselors can view anonymized wellness trends but no personally identifiable information
8. The system correlates mental health metrics with academic performance indicators
9. All user data is encrypted using AES-256
10. The system must handle 1,000 concurrent users during peak hours
11. System availability must be maintained at 99.5% during academic terms
