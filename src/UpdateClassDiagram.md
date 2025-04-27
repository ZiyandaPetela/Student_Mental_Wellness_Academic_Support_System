# Class Diagrams

## 1. Domain Model Class Diagram

```plaintext
Student
---------
- studentId: String
- name: String
- email: String
- major: String
- academicYear: String
---------
+ register()
+ login()
+ completeAssessment()
+ scheduleAppointment()

MentalHealthAssessment
---------
- type: String
- score: int
- timestamp: LocalDateTime
---------
+ calculateScore()
+ generateRecommendations()
+ triggerAlerts()

Counselor
---------
- counselorId: String
- specialization: String
---------
+ viewTrends()
+ confirmAppointment()

Appointment
---------
- appointmentId: String
- datetime: LocalDateTime
- status: String
---------
+ schedule()
+ cancel()

WellnessResource
---------
- resourceId: String
- type: String
- title: String
---------
+ filterByTopic()

EmergencyAlert
---------
- alertId: String
- severity: String
---------
+ escalate()
(Relationships:

Student "1 to many" MentalHealthAssessment

Student "1 to 3" Appointment

MentalHealthAssessment "1 to many" WellnessResource

MentalHealthAssessment "0 or 1" EmergencyAlert)



# Repository Layer Class Diagram (Mermaid)

```mermaid
classDiagram
    class Repository~T, ID~ {
        +save(T entity)
        +findById(ID id) Optional~T~
        +findAll() List~T~
        +delete(ID id)
    }

    Repository~T, ID~ <|-- StudentRepository
    Repository~T, ID~ <|-- CounselorRepository
    Repository~T, ID~ <|-- AppointmentRepository
    Repository~T, ID~ <|-- MentalHealthAssessmentRepository
    Repository~T, ID~ <|-- EmergencyAlertRepository
    Repository~T, ID~ <|-- WellnessResourceRepository

    StudentRepository <|-- InMemoryStudentRepository
    CounselorRepository <|-- InMemoryCounselorRepository
    AppointmentRepository <|-- InMemoryAppointmentRepository
    MentalHealthAssessmentRepository <|-- InMemoryMentalHealthAssessmentRepository
    EmergencyAlertRepository <|-- InMemoryEmergencyAlertRepository
    WellnessResourceRepository <|-- InMemoryWellnessResourceRepository

    class RepositoryFactory {
        +getStudentRepository(storageType: String) StudentRepository
        +getCounselorRepository(storageType: String) CounselorRepository
        +getAppointmentRepository(storageType: String) AppointmentRepository
        +getRepository(storageType: String, entityClass: Class~T~) Repository~T, ID~
    }
