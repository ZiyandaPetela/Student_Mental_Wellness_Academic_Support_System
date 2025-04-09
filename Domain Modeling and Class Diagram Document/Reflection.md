# Reflection on Domain Modeling and Class Diagram Design

## Challenges Faced

### Abstraction Challenges
- **Assessment System Design**: Struggled with whether to create separate classes for PHQ-9 and GAD-7 assessments or use a single class with type discrimination
- **Privacy Requirements**: Difficulty representing counselor access to student data without creating privacy-compromising direct links
- **Emergency Alert Placement**: Debated whether alert handling belonged in Student, Counselor, or a separate system class

### Relationship Complexities
- Counselor-student relationships required indirect access patterns
- Determining appropriate multiplicities for appointment booking
- Balancing association clarity with privacy protections

### Method Definition Issues
- Properly scoping assessment scoring logic
- Determining where notification triggers should reside
- Allocating responsibility for report generation

## Alignment with Previous Artifacts

### Use Case Implementation
| Class | Supported Use Cases |
|-------|---------------------|
| Student | Register/Login, Track Goals |
| MentalHealthAssessment | Complete Wellness Assessment |
| Appointment | Schedule Counseling Appointment |
| EmergencyAlert | Generate Risk Assessment Reports |

### State Diagram Mapping
- All status fields directly correspond to state diagram states:
  - `AssessmentStatus` → Assessment State Diagram
  - `AppointmentStatus` → Appointment State Diagram
  - `StudentStatus` → Student Profile State Diagram

### Requirement Coverage
- **FR4 (PHQ-9/GAD-7)**: Implemented in `MentalHealthAssessment`
- **FR20 (5-min response)**: Enforced in `EmergencyAlert`
- **NRF6 (Encryption)**: Noted in authentication methods
- **NRF1 (Accessibility)**: Considered in UI-related methods

## Design Trade-offs

| Decision Point | Chosen Approach | Alternative Considered | Rationale |
|---------------|----------------|-----------------------|-----------|
| Counselor Relationship | Composition | Inheritance | Better reflects real-world roles |
| State Management | Embedded Status | State Pattern | Simpler diagram for current needs |
| Alert System | Separate Class | Integrated in Assessment | Clearer responsibility separation |
| Data Access | Indirect Patterns | Direct Links | Privacy compliance priority |

## Object-Oriented Design Lessons

1. **Single Responsibility Principle**
   - Learned to resist putting too much functionality in single classes
   - Example: Separated alert handling from assessment scoring

2. **Encapsulation Value**
   - Strict access control proved essential for sensitive data
   - Used carefully designed interfaces for protected operations

3. **Domain-Driven Alignment**
   - State diagrams should directly inform class status fields
   - Business rules manifest in method constraints

4. **Evolutionary Design**
   - Made extension points explicit (e.g., resource types)
   - Avoided over-engineering while preserving flexibility

5. **Constraint Visualization**
   - Learned to represent rules through:
     - Multiplicities (e.g., 0..3 appointments)
     - Method preconditions
     - Enumeration values

> **Key Insight**: The iterative design process - with multiple diagram revisions - was crucial for achieving a model that satisfies both technical requirements and real-world wellness system needs.
Reflection

Designing the domain model and class diagram for the Student Mental Wellness Academic Support System was both rewarding and challenging. One of the first challenges was abstracting real-world psychological processes into formal software entities and methods. Terms like "wellness," "anxiety," or "counseling" are complex and sensitive, so converting them into usable and logical software components took a great deal of critical thinking and iteration.

1. Challenges

A major challenge was defining the right level of abstraction. Initially, we debated whether entities like Report and Assessment should be merged. However, keeping them separate allowed for clearer system responsibilities: Assessment collects data while Report interprets it. Similarly, determining how to model the relationship between Student, Counsellor, and Appointment required balancing usability with privacy, especially considering that counselors should only access anonymized data in some cases.

Another challenge was selecting appropriate methods for each class. It was tempting to overload entities with functionality. For instance, giving the Student class access to report generation or analytics seemed logical at first, but upon reflection, these responsibilities were more appropriate for the Assessment or Report classes. This separation of concerns improved cohesion.

2. Alignment with Prior Work

The class diagram aligns well with previous artifacts. For example:

The Student registering, completing assessments, and receiving feedback is directly tied to Use Case 1.

The Counsellor class is involved in scheduling and reviewing appointments, aligning with Use Case 4.

The state diagrams also shaped how we defined transitions and relationships—especially between Assessment, Report, and Counsellor.

Requirements around privacy, performance, and mental health customization helped shape class methods like generateFeedback(), recommend(), and anonymizeData().

3. Trade-offs

We opted for composition over inheritance. Rather than abstracting users into a superclass like Person, we modeled Student and Counsellor separately. This made it easier to reflect their different responsibilities and relationships. While this might result in some repetition, it enhances readability and reduces coupling in the short term.

Another trade-off was not modeling roles like Admin and ITStaff. While they exist in the use case diagram, they are currently focused on system maintenance and infrastructure. We chose to leave them out of the core domain model for simplicity.

4. Lessons Learned

This exercise provided a deeper appreciation for object-oriented design principles:

Encapsulation makes systems more maintainable.

Modular design improves scalability and future updates.

Defining precise relationships helps eliminate ambiguity in behavior.

The combination of UML class diagrams and state diagrams offers a complete view of both structure and behavior.

Overall, this task enhanced our ability to translate user needs and business logic into a well-structured and visually clear software design. It laid a solid foundation for development, testing, and system scalability moving forward.

