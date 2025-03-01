# Architecture Documentation

## Project Title
Student Mental Wellness & Academic Support System

## Domain
**Education**

This system operates at the intersection of educational technology and mental health support, focused specifically on the academic environment. It targets higher education institutions, including universities and colleges, where academic pressure and stress are particularly high.

## Problem Statement
Students face significant mental health challenges, especially during examination periods, which directly impact their academic performance. Current educational systems often fail to adequately address the connection between mental wellbeing and academic success. Students experiencing stress, anxiety, and emotional difficulties struggle with concentration, experience burnout, and ultimately achieve lower grades than their potential would suggest.

The **Student Mental Wellness & Academic Support System** aims to bridge this gap by providing timely intervention, personalized support, and practical strategies to help students manage their mental health while improving their academic outcomes.

## Individual Scope
This project is feasible for individual implementation due to its modular architecture and focused scope:

1. **Core Functionality**: The system will focus on three key components:
   - Mental health self-assessment tools
   - Personalized study technique recommendations
   - Stress management resources

2. **Technical Implementation**:
   - Web-based application with responsive design
   - Backend database for user profiles and assessment data
   - Algorithm for personalized recommendations based on assessment results

## C4 Model Architectural Documentation

### Context Diagram
The context diagram shows the overall system and its interactions with external actors and systems:
- **Primary Users**: Students seeking mental health support and academic guidance
- **Secondary Users**: Mental health professionals who provide content and review anonymized data
- **System Administrators**: Technical staff who maintain the system
- **External Systems**: Email notification system and external resource databases

### Container Diagram
The container diagram breaks down the system into its major components:
- **Web Application**: Primary interface for students and administrators
- **Mobile Application**: Alternative access point optimized for mobile devices
- **API Gateway**: Central access point for all services
- **Authentication Service**: Handles user registration, login, and security
- **Assessment Service**: Manages and processes mental health self-assessments
- **Recommendation Engine**: Generates personalized suggestions based on assessment results
- **User Database**: Stores user profiles and assessment history
- **Content Database**: Stores educational resources and recommendation content
- **Analytics Service**: Processes anonymized data for system improvement

### Component Diagrams
The component diagrams detail the internal workings of key containers:

#### Web Application Components
- **User Interface**: Main presentation layer
- **Authentication Component**: Handles login/registration
- **Assessment Component**: Delivers self-assessment tools
- **Dashboard Component**: Visualizes progress and recommendations
- **Resource Component**: Provides access to educational and mental health content
- **Notification Component**: Manages user alerts and reminders
- **Scheduler Component**: Helps students create balanced study schedules
- **API Client**: Communicates with backend services

#### API Gateway Components
- **Router Component**: Directs requests to appropriate controllers
- **Authentication Middleware**: Validates user tokens
- **User Controller**: Handles user-related operations
- **Assessment Controller**: Manages assessment data
- **Recommendation Controller**: Retrieves personalized recommendations
- **Resource Controller**: Accesses educational content
- **Notification Controller**: Sends alerts and reminders
- **Scheduler Controller**: Manages study schedule creation and updates
- **Logging Middleware**: Records system activity

## End-to-End Components
The system implements a complete end-to-end architecture covering all aspects of the student mental wellness journey:

### 1. User Onboarding Flow
- Registration and profile creation
- Initial mental health assessment
- Preference setting for study habits and notification frequency

### 2. Assessment Process
- Regular self-assessment prompts
- Standardized mental health measurement tools
- Real-time feedback on assessment results

### 3. Recommendation Pipeline
- Data analysis of assessment results
- Pattern recognition for effective interventions
- Personalized recommendation generation

### 4. Resource Delivery Mechanism
- Context-aware content presentation
- Categorized mental health and study resources
- Bookmarking and saving functionality

### 5. Progress Tracking System
- Longitudinal data visualization
- Trend analysis of mental health metrics
- Academic performance correlation insights

### 6. Study Schedule Management
- Calendar integration
- Balanced study session planning
- Break and self-care activity scheduling

### 7. Notification Framework
- Timely reminders for assessments
- Study schedule alerts
- Positive reinforcement messages

## Technical Stack

### Frontend
- **Framework**: React (Web), React Native (Mobile)
- **State Management**: Redux
- **UI Components**: Material-UI
- **Data Visualization**: D3.js

### Backend
- **API Framework**: Node.js with Express
- **Authentication**: JWT with Passport.js
- **Assessment Processing**: Python with Flask
- **Recommendation Engine**: Python with TensorFlow

### Databases
- **User Data**: MongoDB (NoSQL for flexible user profiles)
- **Content Data**: PostgreSQL (Relational for structured content)

### DevOps
- **Containerization**: Docker
- **CI/CD**: GitHub Actions
- **Monitoring**: Prometheus and Grafana

## Data Flow

1. **User Assessment**:
   - Student logs in and completes mental health assessment
   - Data is securely stored in user database
   - Assessment service processes results

2. **Recommendation Generation**:
   - Recommendation engine analyzes assessment results
   - System matches user needs with appropriate resources
   - Personalized recommendations are presented to the student

3. **Progress Tracking**:
   - System records student interactions and follow-up assessments
   - Analytics service identifies trends and effectiveness
   - Dashboard displays progress visually to the student

4. **Schedule Management**:
   - Student inputs academic commitments and availability
   - System generates balanced study schedule with breaks
   - Notifications remind students of scheduled activities

## Security Considerations

- **Data Encryption**: All personal health data encrypted at rest and in transit
- **Authentication**: Multi-factor authentication available for sensitive operations
- **Authorization**: Role-based access control limiting data visibility
- **Compliance**: Design aligned with relevant health data protection regulations
- **Anonymization**: Personal identifiers removed from analytics data

## Scalability Considerations

- **Microservices Architecture**: Allows independent scaling of components
- **Database Sharding**: Prepared for growth in user base
- **Caching Layer**: Redis implementation for frequently accessed resources
- **Content Delivery Network**: For efficient delivery of static resources
- **Horizontal Scaling**: Ability to add server instances during peak periods
```mermaid
graph TD
    title[C4 Model: Context Diagram]
    Student["Student [Person]"]
    MentalHealthProfessional["Mental Health Professional [Person]"]
    Administrator["System Administrator [Person]"]
    SMWASS["Student Mental Wellness & Academic Support System [Software System]"]
    EmailSystem["Email Notification System [Software System]"]
    ResourceDB["External Resource Database [Software System]"]
    
    Student -->|Uses for self-assessment, receives recommendations| SMWASS
    MentalHealthProfessional -->|Provides content, reviews anonymized data| SMWASS
    Administrator -->|Manages and maintains| SMWASS
    SMWASS -->|Sends notifications| EmailSystem
    SMWASS -->|Retrieves resources| ResourceDB
    
    subgraph "Enterprise Boundary"
        SMWASS
    end

```
```mermaid
graph TD
    title[C4 Model: Container Diagram]
    Student["Student\n[Person]"]
    MentalHealthProfessional["Mental Health Professional\n[Person]"]
    Administrator["System Administrator\n[Person]"]
    
    subgraph "Student Mental Wellness & Academic Support System"
        WebApp["Web Application\n[Container: JavaScript/React]"]
        MobileApp["Mobile Application\n[Container: React Native]"]
        APIGateway["API Gateway\n[Container: Node.js/Express]"]
        AuthService["Authentication Service\n[Container: Node.js/Passport]"]
        AssessmentService["Assessment Service\n[Container: Python/Flask]"]
        RecommendationEngine["Recommendation Engine\n[Container: Python/TensorFlow]"]
        UserDatabase["User Database\n[Container: MongoDB]"]
        ContentDatabase["Content Database\n[Container: PostgreSQL]"]
        AnalyticsService["Analytics Service\n[Container: Python/Pandas]"]
    end
    
    EmailSystem["Email Notification System\n[Software System]"]
    ResourceDB["External Resource Database\n[Software System]"]
    
    Student -->|Uses| WebApp
    Student -->|Uses| MobileApp
    MentalHealthProfessional -->|Manages content via| WebApp
    Administrator -->|Administers| WebApp
    
    WebApp -->|API calls| APIGateway
    MobileApp -->|API calls| APIGateway
    
    APIGateway -->|Authenticates| AuthService
    APIGateway -->|Requests assessments| AssessmentService
    APIGateway -->|Gets recommendations| RecommendationEngine
    APIGateway -->|Analyzes data| AnalyticsService
    
    AuthService -->|Stores user data| UserDatabase
    AssessmentService -->|Reads/writes assessment data| UserDatabase
    RecommendationEngine -->|Reads user history| UserDatabase
    RecommendationEngine -->|Reads content| ContentDatabase
    AnalyticsService -->|Reads anonymized data| UserDatabase
    
    APIGateway -->|Sends emails| EmailSystem
    RecommendationEngine -->|Retrieves resources| ResourceDB
```
```mermaid
graph TD
    title[C4 Model: Component Diagram - Web Application]
    
    Student["Student\n[Person]"]
    
    subgraph "Web Application Container"
        UserInterface["User Interface\n[Component: React]"]
        AuthComponent["Authentication Component\n[Component: React/Auth0]"]
        AssessmentComponent["Assessment Component\n[Component: React]"]
        DashboardComponent["Dashboard Component\n[Component: React/D3.js]"]
        ResourceComponent["Resource Component\n[Component: React]"]
        NotificationComponent["Notification Component\n[Component: React]"]
        SchedulerComponent["Scheduler Component\n[Component: React]"]
        APIClient["API Client\n[Component: Axios]"]
    end
    
    APIGateway["API Gateway\n[Container]"]
    
    Student -->|Views and interacts with| UserInterface
    
    UserInterface -->|User login/registration| AuthComponent
    UserInterface -->|Take assessments| AssessmentComponent
    UserInterface -->|View progress| DashboardComponent
    UserInterface -->|Access resources| ResourceComponent
    UserInterface -->|Manage notifications| NotificationComponent
    UserInterface -->|Create study schedules| SchedulerComponent
    
    AuthComponent -->|API calls| APIClient
    AssessmentComponent -->|API calls| APIClient
    DashboardComponent -->|API calls| APIClient
    ResourceComponent -->|API calls| APIClient
    NotificationComponent -->|API calls| APIClient
    SchedulerComponent -->|API calls| APIClient
    
    APIClient -->|HTTP requests| APIGateway
```
```mermaid
graph TD
    title[C4 Model: Component Diagram - API Gateway]
    
    WebApp["Web Application\n[Container]"]
    MobileApp["Mobile Application\n[Container]"]
    
    subgraph "API Gateway Container"
        RouterComponent["Router Component\n[Component: Express.js]"]
        AuthMiddleware["Authentication Middleware\n[Component: JWT]"]
        UserController["User Controller\n[Component: Node.js]"]
        AssessmentController["Assessment Controller\n[Component: Node.js]"]
        RecommendationController["Recommendation Controller\n[Component: Node.js]"]
        ResourceController["Resource Controller\n[Component: Node.js]"]
        NotificationController["Notification Controller\n[Component: Node.js]"]
        SchedulerController["Scheduler Controller\n[Component: Node.js]"]
        LoggingMiddleware["Logging Middleware\n[Component: Winston]"]
    end
    
    AuthService["Authentication Service\n[Container]"]
    AssessmentService["Assessment Service\n[Container]"]
    RecommendationEngine["Recommendation Engine\n[Container]"]
    ContentDatabase["Content Database\n[Container]"]
    EmailSystem["Email Notification System\n[Software System]"]
    
    WebApp -->|HTTP requests| RouterComponent
    MobileApp -->|HTTP requests| RouterComponent
    
    RouterComponent -->|Validates tokens| AuthMiddleware
    RouterComponent -->|Routes user requests| UserController
    RouterComponent -->|Routes assessment requests| AssessmentController
    RouterComponent -->|Routes recommendation requests| RecommendationController
    RouterComponent -->|Routes resource requests| ResourceController
    RouterComponent -->|Routes notification requests| NotificationController
    RouterComponent -->|Routes scheduler requests| SchedulerController
    RouterComponent -->|Logs all requests| LoggingMiddleware
    
    UserController -->|Authenticates users| AuthService
    AssessmentController -->|Processes assessments| AssessmentService
    RecommendationController -->|Gets recommendations| RecommendationEngine
    ResourceController -->|Retrieves content| ContentDatabase
    NotificationController -->|Sends notifications| EmailSystem
    SchedulerController -->|Manages schedules| ContentDatabase
   ``` 
