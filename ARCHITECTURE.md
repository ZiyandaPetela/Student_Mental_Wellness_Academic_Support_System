
# System Architecture

## C4 Model - Context Diagram
```mermaid
C4Context
    title Student Mental Wellness & Academic Support System
    Person(student, "Student", "Uses the system to assess mental health and receive support")
    System(webApp, "Mental Wellness System", "Provides self-assessments and personalized tips")
    student -> webApp : "Completes self-assessment quiz"


graph TD
    title[C4 Model: Context Diagram]
    Student["Student\n[Person]"]
    MentalHealthProfessional["Mental Health Professional\n[Person]"]
    Administrator["System Administrator\n[Person]"]
    SMWASS["Student Mental Wellness &\nAcademic Support System\n[Software System]"]
    EmailSystem["Email Notification System\n[Software System]"]
    ResourceDB["External Resource Database\n[Software System]"]
    
    Student -->|Uses for self-assessment, receives recommendations| SMWASS
    MentalHealthProfessional -->|Provides content, reviews anonymized data| SMWASS
    Administrator -->|Manages and maintains| SMWASS
    SMWASS -->|Sends notifications| EmailSystem
    SMWASS -->|Retrieves resources| ResourceDB
    
    subgraph "Enterprise Boundary"
        SMWASS
    end













