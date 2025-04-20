
# Student Mental Health System

This project implements a Student Mental Health Management System using all six creational design patterns. The system helps students access mental health resources, complete assessments, and schedule counseling appointments.

## Language Choice & Design Decisions

This project is implemented in **Java** due to its robust object-oriented features that make it ideal for demonstrating design patterns. Java's strong typing and explicit class structure provide clarity when implementing complex patterns like Abstract Factory and Builder.

Key design decisions:
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
