# Reflection on Domain Modeling and Class Diagram Design

## Challenges Faced

### Abstraction Challenges
- **Assessment System Design**  
  Struggled with whether to create separate classes for PHQ-9 and GAD-7 assessments or use a single class with type discrimination. Ultimately chose a unified `MentalHealthAssessment` class with a type field to maintain cohesion while accommodating both assessment types.

- **Privacy Requirements**  
  Difficulty representing counselor access to student data without creating privacy-compromising direct links. Solved through indirect relationships via Appointment records and anonymized trend reports.

- **Emergency Alert Placement**  
  Debated whether alert handling belonged in Student, Counselor, or a separate system class. Created a dedicated `EmergencyAlert` class for clear responsibility separation and crisis workflow management.

### Relationship Complexities
- **Counselor-Student Relationships**  
  Required designing indirect access patterns through Appointment records to maintain privacy while enabling necessary functionality.

- **Multiplicity Decisions**  
  Determining appropriate multiplicities for appointment booking (settled on 0..3 per student) and resource recommendations required multiple iterations.

- **Privacy vs Clarity**  
  Balanced explicit associations with privacy protections by limiting counselor access to aggregated data.

### Method Definition Issues
- **Assessment Scoring**  
  Initially combined score calculation and feedback generation, later separated into `calculateScore()` and `generateRecommendations()` for better single responsibility.

- **Notification Triggers**  
  Decided to place progress notifications in `ProgressTracker` rather than `Student` for better cohesion.

- **Report Generation**  
  Allocated report creation to `MentalHealthAssessment` rather than `Student` to maintain proper responsibility boundaries.

## Alignment with Previous Artifacts

### Use Case Implementation
| Use Case                   | Implementing Classes               | Key Methods                     |
|----------------------------|------------------------------------|---------------------------------|
| Register/Login             | `Student`                          | register(), login()             |
| Complete Assessment        | `MentalHealthAssessment`           | calculateScore(), triggerAlerts() |
| Schedule Appointment       | `Appointment`, `Counselor`         | schedule(), confirmAppointment() |
| Generate Risk Reports      | `EmergencyAlert`                   | escalate(), resolve()           |

### State Diagram Mapping
- **Assessment States**:  
  `UNSTARTED` → `IN_PROGRESS` → `COMPLETED` matches assessment workflow
- **Appointment States**:  
  `REQUESTED` → `CONFIRMED` → `COMPLETED` aligns with scheduling process
- **Alert States**:  
  `TRIGGERED` → `ACKNOWLEDGED` → `RESOLVED` implements emergency protocol

### Requirement Coverage
- **FR4 (PHQ-9/GAD-7)**: Implemented via `MentalHealthAssessment.type` and score thresholds
- **FR20 (5-min response)**: Enforced through `EmergencyAlert.responseDeadline`
- **NRF6 (Encryption)**: Implied in authentication methods
- **NRF7 (Privacy)**: Achieved through anonymized counselor access

## Design Trade-offs

| Decision Point          | Chosen Approach           | Alternative Considered      | Rationale                          |
|-------------------------|---------------------------|-----------------------------|------------------------------------|
| User Hierarchy          | No inheritance            | `User` superclass           | Simpler for current scope          |
| Alert System            | Separate `EmergencyAlert` | Embedded in `Assessment`    | Cleaner crisis isolation           |
| Counselor Data Access   | Indirect via `Appointment`| Direct links                | Privacy compliance (NRF7)          |
| Status Tracking         | Enum fields               | State Pattern               | Lower complexity for current needs |

## Lessons Learned

### Object-Oriented Principles
1. **Single Responsibility**  
   Keeping classes focused (e.g., separating `Assessment` from `Alert`) improved maintainability.

2. **Encapsulation**  
   Strict access control (- private fields, + public methods) proved essential for sensitive data.

3. **Domain-Driven Design**  
   State diagrams directly informed status fields and transitions in classes.

4. **Iterative Design**  
   Multiple revisions were needed to balance completeness with simplicity.

5. **Constraint Modeling**  
   Learned to represent business rules through:
   - Multiplicities (e.g., 0..3 appointments)
   - Method preconditions
   - Enumeration values

### Practical Insights
- Mental health domains require special attention to data sensitivity
- Clear relationship labeling is crucial for team understanding
- Mermaid.js limitations influenced some notation choices
- Trade-off documentation helps justify design decisions

> **Key Insight**: The iterative design process - with multiple diagram revisions - was crucial for achieving a model that satisfies both technical requirements and real-world wellness system needs while maintaining student privacy and system usability.

## Conclusion
This task significantly enhanced my ability to:
- Translate complex domain requirements into clean class structures
- Balance theoretical OOP principles with practical implementation needs
- Maintain traceability between requirements, use cases, and implementation
- Make and document thoughtful design trade-offs

The final design provides a solid foundation for development while remaining adaptable to future enhancements.
