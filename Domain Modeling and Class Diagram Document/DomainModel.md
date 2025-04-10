# Student Mental Wellness System - Domain Model

## Core Domain Entities

| Entity               | Attributes                              | Methods                          | Relationships                     | Business Rules                          |
|----------------------|-----------------------------------------|----------------------------------|-----------------------------------|-----------------------------------------|
| **Student**         | `studentId: String`<br>`email: String`<br>`academicYear: String`<br>`major: String`<br>`status: Enum[Active, Inactive]`<br>`preferences: String[]`<br>`authenticationStatus: Boolean` | `register()`<br>`login()`<br>`completeAssessment()`<br>`scheduleAppointment()`<br>`trackProgress()`<br>`setWellnessGoals()` | Completes Assessments<br>Books Appointments<br>Sets Goals<br>Receives Recommendations | 1. Institutional email required (FR1)<br>2. Max 3 active appointments<br>3. One assessment per type per week |
| **MentalHealthAssessment** | `assessmentId: String`<br>`type: Enum[PHQ-9, GAD-7]`<br>`score: Integer`<br>`timestamp: DateTime`<br>`status: Enum[Pending, Completed]`<br>`feedback: String`<br>`frequency: String` | `calculateScore()`<br>`generateRiskReport()`<br>`provideFeedback()`<br>`correlateWithAcademics()` | Generates Recommendations<br>Triggers Alerts<br>Links to WellnessTrend | 1. PHQ-9 ≥15 = High risk (FR4)<br>2. Mandatory every 30 days<br>3. Real-time feedback within 2s |
| **Counselor**       | `counselorId: String`<br>`specialization: String[]`<br>`availabilitySlots: TimeSlot[]`<br>`email: String` | `viewStudentTrends()`<br>`confirmAppointment()`<br>`updateAvailability()`<br>`generateRiskReports()` | Manages Appointments<br>Reviews Resources<br>Handles Alerts | 1. 15-min response to high-risk alerts<br>2. Only anonymized data access |
| **Appointment**     | `appointmentId: String`<br>`datetime: DateTime`<br>`duration: Integer`<br>`status: Enum[Pending, Confirmed, Completed]`<br>`notes: String` | `schedule()`<br>`cancel()`<br>`sendReminder()`<br>`syncCalendar()` | Links Student and Counselor | 1. 24h cancellation notice<br>2. Max 1 per day<br>3. 60min duration limit |
| **WellnessResource** | `resourceId: String`<br>`title: String`<br>`type: Enum[Article, Video]`<br>`topic: Enum[Stress, Anxiety, Depression]`<br>`content: String`<br>`approvalStatus: Enum[Pending, Approved]` | `filterByTopic()`<br>`rateHelpfulness()`<br>`categorize()` | Recommended via Assessments | 1. Counselor approval required<br>2. Filterable by topic with 100% accuracy |
| **EmergencyAlert**  | `alertId: String`<br>`severity: Enum[Low, Medium, High]`<br>`triggerTime: DateTime`<br>`responseTime: DateTime` | `escalate()`<br>`markResolved()` | Triggered by HighRisk Assessments | 1. Must acknowledge within 5min (FR20)<br>2. Auto-escalate if unacknowledged |
| **ProgressTracker** | `trackerId: String`<br>`wellnessScoreTrend: DataPoint[]`<br>`goalCompletionRate: Float`<br>`currentGoals: Goal[]` | `generateTrendReport()`<br>`sendMilestoneNotifications()`<br>`updateProgress()` | Monitors Student and Goals | 1. Weekly notifications if progress <50%<br>2. PDF report generation |

## Key Relationships with Multiplicity

```mermaid
classDiagram
    Student "1" -- "0..*" MentalHealthAssessment : completes
    Student "1" -- "0..3" Appointment : books
    Counselor "1" -- "0..*" Appointment : manages
    MentalHealthAssessment "1" -- "1..*" Recommendation : generates
    MentalHealthAssessment "1" -- "0..1" EmergencyAlert : triggers
    Counselor "1" -- "0..*" EmergencyAlert : handles
    Counselor "1" -- "1..*" WellnessResource : reviews
    ProgressTracker "1" -- "1" Student : monitors
