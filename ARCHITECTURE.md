

```mermaid
C4Context
    title Student Mental Wellness & Academic Support System
    Person(student, "Student", "Uses the system to assess mental health and receive support")
    System(webApp, "Mental Wellness System", "Provides self-assessments and personalized tips")
    student -> webApp : "Completes self-assessment quiz"



