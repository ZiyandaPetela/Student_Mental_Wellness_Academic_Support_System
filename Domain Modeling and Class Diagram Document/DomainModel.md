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
