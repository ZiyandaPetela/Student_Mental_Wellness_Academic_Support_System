# Functional Requirements

## 1 User Management
- **FR1:**-The system shall allow students to register using their institutional email addresses.
     - **Acceptance Criteria**: Registration must include validation of institutional email domains and fails for non-institutional emails..
- **FR2:**- The system shall support multi-factor authentication (password + OTP).
     - **Acceptance Criteria**: 100% of logins require two-factor verification.
- **FR3:** -The system shall store user profiles with academic year, major, and mental health preferences.
     - **Acceptance Criteria**:Profiles include mandatory fields for academic and wellness data.
## 2 Self-Assessment Module
- **FR4:** -The system shall implement PHQ-9 for depression ans GAD-7 for anxiety assessments with real-time feedback. 
   - **Acceptance Criteria**: Assessments must include validated tools and provide real-time feedback.
- **FR5:** -The system shall allow students to customize the frequency of assessments based on their needs.
   - **Acceptance Criteria**: Users can set reminders (daily/weekly/monthly).
- **FR6:** -The system shall assess how mental health issues are affecting specific academic activities (e.g., attendance, grades).
    - **Acceptance Criteria**: The system must correlate mental health metrics with academic performance indicators.

## 3 Personalized Recommendation Engine
- **FR7:** - The system shall provide personalized mental health resources based on assessment results.
   - **Acceptance Criteria**: Recommendations must be generated within 2 seconds of completing an assessment.
- **FR8:** - The system shall offer customized study techniques aligned with the student’s mental health needs(e.g., time maganagement).
   - **Acceptance Criteria**: Study techniques must include stress management tips and time management strategies.
## 4 Resource Library
- **FR9:** - The system shall categorize content by topic (stress, anxiety, depression).
    - **Acceptance Criteria**:Users can filter resources by topic with 100% accuracy..
- **FR10:** - The system shall provide study guides and exam preparation strategies with mental wellness components.
     - Acceptance Criteria: Study guides must include tips for managing stress during exams.
## 5 Progress Tracking
- **FR11:** -The system shall track and visualize mental wellness trends over time.
     - **Acceptance Criteria**: Trends must be displayed in a user-friendly dashboard with graphs and charts.
- **FR12:**- The system shall allow students to set mental wellness goals and track progress.
    - **Acceptance Criteria**: Students must receive notifications when they achieve milestones.

# 2. Non-Functional Requirements

## 2.1 Usability
- **NRF1:**- The system shall comply with **WCAG 2.1 AA standards** for accessibility.
   - **Acceptance Criteria**: All features must be accessible via keyboard navigation and screen readers.
- **NRF2:** - The system shall provide a user-friendly interface with intuitive navigation.
   - **Acceptance Criteria**: 90% of users must rate the interface as "easy to use" in a post-launch survey.
## 2.2 Deployability
- **NRF3:**-The system shall be deployable on **Windows and Linux servers**.
    - **Acceptance Criteria**: The system must pass deployment tests on both Windows and Linux environments.
- **NRF4:**-The system shall support **containerized deployment** using Docker.
    - **Acceptance Criteria**: The system must run successfully in a Docker container on both development and production environments.
- **NRF5:**-The system shall include **automated deployment scripts** for continuous integration/continuous deployment (CI/CD).
    - **Acceptance Criteria**: Deployment scripts must reduce deployment time by 50% compared to manual deployment.
## 2.3 Security
- **NRF6:**- All user data shall be encrypted using **AES-256**.
   - **Acceptance Criteria**: Data encryption must be verified through a security audit.
- **NRF7:**-The system shall comply with **educational data privacy regulations** (e.g., POPI, FERPA).
   - **Acceptance Criteria**: A compliance report must be generated and reviewed by legal experts.

## 2.4 Performance
- **NRF8:**-The system shall load pages within **3 seconds** on standard connections.
   - **Acceptance Criteria**: 95% of page loads must complete within 3 seconds under normal load.
- **NRF9:**-The system shall process assessment results within **2 seconds**.
   - **Acceptance Criteria**: 95% of assessments must be processed within 2 seconds.

## 2.5 Scalability
- **NRF10:**-The system shall support **1,000 concurrent users** during peak hours.
   - **Acceptance Criteria**: The system must handle 1,000 concurrent users without performance degradation.
- **NRF11:**- The system shall be scalable to accommodate future enhancements (e.g., trend tracking, real-time chat support).
     - **Acceptance Criteria**: The system must support a 20% increase in users without requiring major architectural changes.
## 2.6 Maintainability
- **NRF12:**- Documentation shall include an **API guide** for future integrations.
    - **Acceptance Criteria**: API documentation must cover all endpoints with examples.
- **NRF13:**- The system shall support **modular updates** without requiring a full system restart.
    - **Acceptance Criteria**: Updates to individual modules must not disrupt system functionality.
      
## 2.7 Reliability
- **NRF14:**-The system shall maintain **99.5% availability** during academic terms.
    - **Acceptance Criteria**: Downtime must not exceed 0.5% during academic terms.
- **NRF15:**- The system shall perform **automatic backups** of all user data.
    - **Acceptance Criteria**: Backups must occur daily and be stored securely offsite.




