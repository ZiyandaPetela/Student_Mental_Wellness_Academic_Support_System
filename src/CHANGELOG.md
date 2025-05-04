# Changelog

All notable changes to the Student Mental Health System project will be documented in this file.

## [1.0.0] 
### Added
- Initial implementation of core domain classes
  - Student
  - Counselor
  - Appointment
  - MentalHealthAssessment
  - EmergencyAlert
  - WellnessResource
- Implemented all six creational design patterns:
  - Simple Factory: WellnessResourceFactory for creating different resource types
  - Factory Method: AssessmentCreator hierarchy for specialized assessment creation
  - Abstract Factory: NotificationFactory hierarchy for email and SMS notifications
  - Builder: AppointmentBuilder for flexible appointment construction
  - Prototype: ResourcePrototype for cloning pre-configured wellness resources
  - Singleton: EmergencyResponseSystem for centralized emergency handling
- Comprehensive unit tests for all patterns
  - Thread safety test for Singleton pattern
  - Edge case testing for Builder pattern
  - Validation testing for all factories

### Fixed
- Added thread-safe implementation to EmergencyResponseSystem using double-checked locking
- Fixed potential null pointer exception in AppointmentBuilder
- Resolved issue with invalid status values in Appointment class

# Service Layer and REST API Implementation


## [v1.1.0]

### Added

**Service Layer:**
- Created `StudentService` to handle student management and validation (#11)
- Created `CounselorService` to handle counselor management (#12)
- Created `AppointmentService` to handle appointment scheduling with business rules (#13)
- Implemented student appointment limit (maximum 3 appointments per student)
- Added validation for appointment scheduling dates (no past dates)
- Created appointment status management workflow

**REST API Endpoints:**

*Student Management:*
- `GET /api/students` - List all students (#21)
- `GET /api/students/{id}` - Get student details (#22)
- `GET /api/students/year/{academicYear}` - Get students by academic year (#23)
- `GET /api/students/major/{major}` - Get students by major (#24)
- `POST /api/students` - Create new student (#25)
- `PUT /api/students/{id}` - Update student information (#26)
- `DELETE /api/students/{id}` - Remove student record (#27)

*Counselor Management:*
- `GET /api/counselors` - List all counselors (#31)
- `GET /api/counselors/{id}` - Get counselor details (#32)
- `GET /api/counselors/specialization/{specialization}` - Get counselors by specialization (#35)
- `POST /api/counselors` - Register new counselor (#33)
- `PUT /api/counselors/{id}` - Update counselor information (#34)
- `DELETE /api/counselors/{id}` - Remove counselor (#36)

*Appointment Management:*
- `GET /api/appointments` - List all appointments (#41)
- `GET /api/appointments/{id}` - Get appointment details (#42)
- `GET /api/appointments/student/{studentId}` - Get appointments by student (#43)
- `GET /api/appointments/counselor/{counselorId}` - Get appointments by counselor (#44)
- `GET /api/appointments/status/{status}` - Get appointments by status (#45)
- `GET /api/appointments/date-range` - Get appointments within date range (#46)
- `POST /api/appointments` - Create new appointment (#47)
- `PUT /api/appointments/{id}/status` - Update appointment status (#48)
- `PUT /api/appointments/{id}/reschedule` - Reschedule appointment (#49)
- `DELETE /api/appointments/{id}` - Cancel appointment (#50)

**Documentation:**
- Integrated OpenAPI/Swagger using `springdoc-openapi-ui` (#60)
- Configured `OpenApiConfig` for custom API metadata
- Added comprehensive `@Operation`, `@ApiResponse`, and parameter annotations
- Included schemas and error response documentation
- Captured Swagger UI screenshots for submission

**Testing:**
- Created unit tests for `AppointmentService`, `CounselorService`, and `StudentService` with:
  - Appointment creation, rescheduling, cancellation, validation
  - Student appointment limits
  - Error handling for invalid inputs
- Created integration tests for REST controllers (#62)

### Fixed
- Resolved issue with appointment scheduling validation logic (#70)
- Fixed race condition during concurrent appointment creation (#71)
- Corrected error handling for appointment status updates (#72)
- Added proper email format validation for students (#73)

### Technical
- Used Spring Boot framework v2.7.0
- Applied layered architecture with dependency injection
- Configured JaCoCo for code coverage reporting
- Added in-memory repositories for development/testing
- Applied centralized exception handling with meaningful error responses
