# Student Mental Wellness & Academic Support System

```mermaid
---
title: Student Mental Wellness & Academic Support System
---
flowchart TB
    %% Actors
    Student(["Student"])
    Counselor(["Counselor/Support Staff"])
    Admin(["University Administrator"])
    IT(["IT Staff"])
    Faculty(["Faculty/Lecturer"])
    Parent(["Parent/Guardian"])

    %% Use Cases
    UC1["Register/Login"]
    UC2["Complete Wellness Assessment"]
    UC3["View Personalized Recommendations"]
    UC4["Schedule Counseling Appointment"]
    UC5["Track Mental Wellness Goals"]
    UC6["Access Resource Library"]
    UC7["View Academic Support Tools"]
    UC8["Monitor Student Wellness Trends"]
    UC9["Generate Risk Assessment Reports"]
    UC10["Configure System Settings"]
    UC11["Check Counselor Availability"]
    UC12["Analyze Assessment Data"]

    %% Actor-Use Case Relationships
    Student --- UC1
    Student --- UC2
    Student --- UC3
    Student --- UC4
    Student --- UC5
    Student --- UC6
    Student --- UC7
    
    Counselor --- UC4
    Counselor --- UC6
    Counselor --- UC8
    Counselor --- UC9
    
    Admin --- UC10
    Admin --- UC9
    Admin --- UC8
    
    IT --- UC10
    IT --- UC1
    
    Faculty --- UC7
    Faculty --- UC8
    
    Parent --- UC5
    
    %% Include/Extend Relationships
    UC4 -.-> |<<include>>| UC11
    UC3 -.-> |<<include>>| UC12
    UC8 -.-> |<<extend>>| UC9
    
    %% Use Case Generalization
    Faculty -.-> |<<communicate>>| Counselor
    
    %% Styling to make it look more like UML
    classDef actor fill:#f9f,stroke:#333,stroke-width:2px
    classDef usecase fill:#ccf,stroke:#333,stroke-width:1px,rx:10px,ry:10px
    
    class Student,Counselor,Admin,IT,Faculty,Parent actor
    class UC1,UC2,UC3,UC4,UC5,UC6,UC7,UC8,UC9,UC10,UC11,UC12 usecase
```
