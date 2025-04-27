
# Student Mental Health System

This project implements a Student Mental Health Management System using all six creational design patterns. The system helps students access mental health resources, complete assessments, and schedule counseling appointments.

## Language Choice & Design Decisions

This project is implemented in **Java** due to its robust object-oriented features that make it ideal for demonstrating design patterns. Java's strong typing and explicit class structure provide clarity when implementing complex patterns like Abstract Factory and Builder.
- **Strong Typing**: Ensures data integrity (e.g., valid email format).
- **OOP Principles**: Encapsulation, composition, and polymorphism align with the class diagram.
- **Maven Support**: Simplifies dependency management and testing.


Key design decisions:
1. **Relationships**:
   - **Composition**: `MentalHealthAssessment` creates/owns `EmergencyAlert`.
   - **Associations**: `Student` ↔ `Appointment` (enforced via collection limits).
2. **Validation**:
   - Appointment limits (`Student` can’t book >3 appointments).
   - Score thresholds for triggering alerts.
3. **Encapsulation**:
   - Private fields with getters/setters.
   - Defensive copying of collections.
- **Core domain model** focused on Student, Counselor, Appointment, and MentalHealthAssessment classes
- **Clear separation** between core classes and pattern implementations
- **Thread-safe Singleton** implementation for the EmergencyResponseSystem
- **Comprehensive testing** for each pattern with JUnit

## Creational Patterns Implementation

### 1. Simple Factory
**Implementation**: `WellnessResourceFactory`  
**Justification**: Centralizes creation of different types of wellness resources (articles, videos, podcasts) with specific default configurations.

### 2. Factory Method
**Implementation**: `AssessmentCreator` hierarchy  
**Justification**: Allows for specialized creation of different assessment types (PHQ-9 for depression, GAD-7 for anxiety) while sharing common post-creation processing.

### 3. Abstract Factory
**Implementation**: `NotificationFactory` hierarchy  
**Justification**: Creates families of related notification components (email notifications and SMS notifications) that work together to deliver both emergency alerts and appointment reminders.

### 4. Builder Pattern
**Implementation**: `AppointmentBuilder`  
**Justification**: Simplifies the creation of Appointment objects which have multiple optional attributes (student, counselor, status) and enforces required attributes (id, datetime).

### 5. Prototype Pattern
**Implementation**: `ResourcePrototype`  
**Justification**: Enables cloning of pre-configured wellness resources to avoid repetitive configuration of common resources like anxiety articles or depression videos.

### 6. Singleton Pattern
**Implementation**: `EmergencyResponseSystem`  
**Justification**: Ensures a single global access point for the emergency response system which must coordinate all high-severity alerts campus-wide.

## Project Structure

```
student-mental-health-system/
├── src/
│   ├── core/                           # Core domain models
│   │   ├── Appointment.java
│   │   ├── Counselor.java
│   │   ├── EmergencyAlert.java
│   │   ├── MentalHealthAssessment.java
│   │   ├── Student.java
│   │   └── WellnessResource.java
│   └── creational_patterns/            # Pattern implementations
│       ├── simple_factory/
│       │   └── WellnessResourceFactory.java
│       ├── factory_method/
│       │   ├── AssessmentCreator.java
│       │   ├── DepressionAssessmentCreator.java
│       │   └── AnxietyAssessmentCreator.java
│       ├── abstract_factory/
│       │   ├── NotificationFactory.java
│       │   ├── EmailNotificationFactory.java
│       │   ├── SMSNotificationFactory.java
│       │   └── ...
│       ├── builder/
│       │   └── AppointmentBuilder.java
│       ├── prototype/
│       │   └── ResourcePrototype.java
│       └── singleton/
│           └── EmergencyResponseSystem.java
├── tests/                              # Unit tests
│   └── creational_patterns/
│       ├── SimpleFactoryTest.java
│       ├── FactoryMethodTest.java
│       ├── AbstractFactoryTest.java
│       ├── BuilderTest.java
│       ├── PrototypeTest.java
│       └── SingletonTest.java
└── CHANGELOG.md                        # Project progress tracking
```

## Running the Tests

To run the tests, ensure you have JUnit 5 in your classpath and execute:

```bash
# If using Maven
mvn test

# If using Gradle
gradle test
```

## Coverage Report

Test coverage breakdown:
- Simple Factory: 100%
- Factory Method: 92%
- Abstract Factory: 95%
- Builder: 100%
- Prototype: 98%
- Singleton: 100%

Overall code coverage: 97%

# Repository Interface Design Justification

## Generic Repository Pattern
- Used generics to avoid duplication across entity repositories
- Type parameters `<T, ID>` ensure type safety while maintaining reusability
- Common CRUD operations defined once following DRY principle

## Entity-Specific Repositories
- Created specialized interfaces for each domain entity (Student, Counselor, etc.)
- Each repository extends the generic interface with domain-specific query methods
- Examples: `findByDateRange()` for appointments, `findBySpecialization()` for counselors

## Method Naming Convention
- Consistent "findBy[Property]" pattern for all query methods
- Improves readability and makes method behavior obvious
- Follows industry standard naming conventions

## Standard CRUD Operations
- Implemented essential persistence operations: Create/Update (save), Read (findById, findAll), Delete
- Used `Optional<T>` for findById to properly handle non-existent entities

## Separation of Concerns
- Repository interfaces focus solely on data access operations
- Keeps persistence logic separate from business rules
- Enables easier testing and future storage implementation swapping

# Student Wellness Management System - Repository Layer

## Overview
This project implements a repository layer for a Student Wellness Management System following clean architecture principles. The system manages student wellness resources, counseling appointments, mental health assessments, and emergency alerts.

## Architecture

The repository layer abstracts data storage from domain logic using the Repository pattern and Factory pattern:

- **Repository Interface**: Defines CRUD operations for domain entities
- **In-Memory Implementation**: HashMap-based storage for development and testing
- **Factory Pattern**: Allows easy switching between storage implementations
- **Future Storage Options**: Stubs for file-based and database repositories

## Project Structure

```
src/
├── core/                               # Domain model classes
│   ├── Student.java
│   ├── Counselor.java
│   ├── Appointment.java
│   ├── MentalHealthAssessment.java
│   ├── EmergencyAlert.java
│   └── WellnessResource.java
│
├── repositories/                       # Repository interfaces
│   ├── Repository.java                 # Generic repository interface
│   ├── StudentRepository.java
│   ├── CounselorRepository.java
│   ├── AppointmentRepository.java
│   ├── MentalHealthAssessmentRepository.java
│   ├── EmergencyAlertRepository.java
│   └── WellnessResourceRepository.java
│   │
│   ├── inmemory/                       # In-memory implementations
│   │   ├── InMemoryRepository.java     # Abstract base implementation
│   │   ├── InMemoryStudentRepository.java
│   │   ├── InMemoryCounselorRepository.java
│   │   ├── InMemoryAppointmentRepository.java
│   │   ├── InMemoryMentalHealthAssessmentRepository.java
│   │   ├── InMemoryEmergencyAlertRepository.java
│   │   └── InMemoryWellnessResourceRepository.java
│   │
│   └── filesystem/                     # File-based implementations (stub)
│       └── FileSystemStudentRepository.java
│
├── factories/                          # Factory pattern implementation
│   └── RepositoryFactory.java
│
└── services/                           # Service layer using repositories
    ├── StudentService.java
    ├── CounselorService.java
    └── AppointmentService.java
    
test/
└── tests/                              # Test classes
    ├── InMemoryStudentRepositoryTest.java
    ├── InMemoryCounselorRepositoryTest.java
    └── RepositoryFactoryTest.java
```

## Design Choices

### Repository Interface Design
- **Generic Repository Interface**: Used generics (`Repository<T, ID>`) to avoid duplication across entity repositories
- **Entity-Specific Extensions**: Created specialized interfaces for each domain entity with domain-specific query methods
- **CRUD Operations**: Each repository supports create, read, update, and delete operations

### In-Memory Implementation
- **Abstract Base Class**: Created `InMemoryRepository<T, ID>` to handle common storage operations
- **HashMap-Based Storage**: Used Java's HashMap for efficient in-memory data access
- **Stream-Based Queries**: Leveraged Java streams for specialized query methods

### Storage Abstraction Mechanism
- **Factory Pattern**: Implemented `RepositoryFactory` to abstract storage details
- **Easy Switching**: The factory makes it simple to switch between storage implementations
- **Generic and Specific Methods**: Provides both generic and entity-specific factory methods

### Future-Proofing
- **Stub Implementations**: Created stub for file-based repository implementation
- **Extension Points**: Clear structure for adding database repositories in the future
- **Client Independence**: Client code relies only on repository interfaces, not implementations

## Domain Entities

- **Student**: Manages student information (ID, name, email, major, academic year)
- **Counselor**: Stores counselor information (ID, name, specialization)
- **Appointment**: Tracks student-counselor appointments
- **MentalHealthAssessment**: Records assessment results
- **EmergencyAlert**: Handles critical student wellness situations
- **WellnessResource**: Manages available wellness resources

## Usage Examples

### Using the Repository Factory

```java
// Get a repository using the factory
StudentRepository studentRepo = RepositoryFactory.getStudentRepository("MEMORY");
CounselorRepository counselorRepo = RepositoryFactory.getCounselorRepository("MEMORY");

// Generic approach
Repository<Student, String> genericRepo = RepositoryFactory.getRepository("MEMORY", Student.class);
```

### Creating and Accessing Data

```java
// Create a new student
Student student = new Student("S123", "John Doe", "john@example.com", "Computer Science", "Junior");
studentRepo.save(student);

// Read a student
Optional<Student> found = studentRepo.findById("S123");

// Find students by criteria
List<Student> csStudents = studentRepo.findByMajor("Computer Science");
List<Student> juniors = studentRepo.findByAcademicYear("Junior");

// Update a student
student.setEmail("john.doe@university.edu");
studentRepo.save(student);

// Delete a student
studentRepo.delete("S123");
```

### Using Services with Repositories

```java
// Create a service with in-memory storage
StudentService service = new StudentService("MEMORY");

// Service uses repository internally
service.registerStudent(student);
Student foundStudent = service.findStudent("S123");
```

## Testing

Run tests using JUnit:
```
mvn test
```

The test suite verifies:
- CRUD operations for in-memory repositories
- Custom query methods
- Factory pattern functionality
- Error handling for invalid inputs

## Future Enhancements

1. **Database Integration**: Implement repositories for MySQL, MongoDB
2. **File-Based Storage**: Complete the filesystem repository implementations
3. **Caching Layer**: Add caching support for frequently accessed entities
4. **Transaction Support**: Implement transaction management for repository operations

## Justification of Design Decisions

- **Repository Pattern**: Used to abstract storage details from domain logic
- **Factory Pattern**: Chosen over DI for simplicity and direct control over repository creation
- **Generics**: Used to promote code reuse and type safety
- **Interface-Based Design**: Promotes loose coupling and makes testing easier
- **Domain-Specific Methods**: Added specialized methods to repositories to support domain-specific queries
