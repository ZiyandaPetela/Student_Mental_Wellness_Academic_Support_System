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
