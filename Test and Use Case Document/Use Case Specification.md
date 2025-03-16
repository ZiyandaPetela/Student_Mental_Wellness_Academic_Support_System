# Use Case Specifications

## 1. Complete Wellness Assessment
### Actor: Student
### Description: 
Student completes a mental health assessment questionnaire to evaluate their current wellness state.
### Preconditions:
- Student is logged into the system
- Student has not completed an assessment in the past 14 days
### Postconditions:
- Assessment results are stored in the system
- System generates personalized recommendations based on results
- Risk flags are raised if critical thresholds are met
### Basic Flow:
1. Student selects "Complete Assessment" option
2. System presents assessment questionnaire
3. Student answers all questions
4. Student submits completed assessment
5. System validates all required fields are completed
6. System processes and scores the assessment
7. System displays confirmation of completion
8. System notifies student that recommendations are available
### Alternative Flows:
**A1: Incomplete Assessment**
1. Student leaves required questions unanswered
2. System highlights missing responses
3. System prompts student to complete all required fields
4. Flow returns to Basic Flow step 3

**A2: Critical Risk Detected**
1. System identifies responses indicating severe mental health risk
2. System displays urgent support resources
3. System sends alert to counseling staff
4. Process continues with Basic Flow step 7

## 2. View Personalized Recommendations
### Actor: Student
### Description:
Student accesses tailored recommendations for resources, activities, and support services based on their wellness assessment results and academic profile.
### Preconditions:
- Student is logged into the system
- Student has completed at least one wellness assessment
- System has processed the assessment results
### Postconditions:
- System records which recommendations were viewed
- Student can access recommended resources
- Student feedback on recommendations is captured (if provided)
### Basic Flow:
1. Student selects "View Recommendations" from dashboard
2. System retrieves recommendations based on assessment results
3. System categorizes recommendations (academic, wellness, counseling)
4. System displays recommendations with priority indicators
5. Student can select individual recommendations for details
6. System provides access links or instructions for each resource
7. Student can bookmark or save recommendations for later
### Alternative Flows:
**A1: No Assessment Data Available**
1. System detects no completed assessments
2. System displays message prompting student to complete an assessment
3. System provides direct link to assessment page
4. Basic flow terminates

**A2: Recommendations Feedback**
1. Student provides feedback on recommendation relevance
2. System records feedback for algorithm improvement
3. System acknowledges feedback submission
4. Flow returns to Basic Flow step 4

## 3. Track Mental Wellness Goals
### Actor: Student
### Description:
Student creates, monitors, and updates personal wellness goals to improve mental health and academic performance.
### Preconditions:
- Student is logged into the system
- Student has completed at least one wellness assessment
### Postconditions:
- New goals or updates are saved in the system
- Progress tracking metrics are established
- Reminders are scheduled according to student preferences
### Basic Flow:
1. Student selects "Mental Wellness Goals" from dashboard
2. System displays existing goals and progress (if any)
3. Student selects "Create New Goal" option
4. System presents goal templates by category
5. Student selects goal type and customizes parameters
6. Student sets milestone markers and target dates
7. Student saves the goal configuration
8. System confirms goal creation and displays tracking options
### Alternative Flows:
**A1: Update Existing Goal**
1. Student selects existing goal to modify
2. System displays current goal details and progress
3. Student updates parameters, milestones, or target dates
4. Student saves modifications
5. System updates goal information and confirms changes

**A2: Mark Progress**
1. Student selects "Log Progress" for a specific goal
2. System displays progress tracking interface
3. Student enters progress data or achievement information
4. System updates goal progress metrics
5. System provides encouragement message based on progress
6. If milestone reached, system displays celebration notification

## 4. Schedule Counselling Appointment
### Actor: Student, Counsellor
### Description:
Student books an appointment with a counsellor through the system's scheduling interface.
### Preconditions:
- Student is logged into the system
- Counsellors have updated their availability
- Student is eligible for counselling services
### Postconditions:
- Appointment is confirmed and booked in the system
- Calendar entries are created for both student and counsellor
- Reminder notifications are scheduled
### Basic Flow:
1. Student selects "Schedule Appointment" from dashboard
2. System displays available counsellors with specializations
3. Student selects preferred counsellor or "first available"
4. System shows available time slots within the next two weeks
5. Student selects preferred date and time
6. System prompts for appointment reason and any special requirements
7. Student submits appointment request
8. System confirms availability and creates appointment
9. System sends confirmation to both student and counsellor
### Alternative Flows:
**A1: No Suitable Slots Available**
1. System finds no available slots matching student preferences
2. System offers alternative counsellors or time periods
3. Student selects from alternatives or requests waitlist option
4. If waitlist selected, system places student on waitlist for cancellations
5. System confirms waitlist status and notification preferences

**A2: Urgent Appointment Needed**
1. Student indicates urgent need for appointment
2. System highlights urgent support resources
3. System flags request as urgent in counsellor queue
4. System provides estimated wait time for urgent response
5. System offers alternative immediate support options while waiting

## 5. Monitor Student Wellness Trends
### Actor: Counsellor, Administrator
### Description:
Authorized staff access anonymized aggregate data on student mental wellness trends to identify patterns and inform support initiatives.
### Preconditions:
- User is logged in with counsellor or administrator privileges
- Sufficient assessment data exists in the system
### Postconditions:
- Trend reports are generated and displayed
- System logs access to aggregated data for audit purposes
### Basic Flow:
1. User selects "Wellness Trends" from administrative dashboard
2. System prompts for reporting parameters (time period, student groups)
3. User selects desired parameters and anonymization level
4. System processes data according to privacy policies
5. System generates trend visualizations and statistical analysis
6. System displays trend dashboard with key metrics highlighted
7. User can interact with visualizations to explore specific trends
8. User can export reports in various formats if needed
### Alternative Flows:
**A1: Insufficient Data for Analysis**
1. System detects limited data for meaningful analysis
2. System displays warning about statistical reliability
3. System offers to expand parameters or timeframe
4. User adjusts parameters or acknowledges limitations
5. Flow returns to Basic Flow step 4

**A2: Risk Pattern Detected**
1. System identifies concerning pattern in aggregate data
2. System highlights pattern with visual indicators
3. System suggests possible intervention strategies
4. User can generate focused report on specific pattern
5. Flow continues with Basic Flow step 6

## 6. Generate Risk Assessment Reports
### Actor: Counsellor, Administrator
### Description:
Authorized staff generate reports identifying students who may be at risk for mental health issues, enabling proactive intervention.
### Preconditions:
- User is logged in with counsellor or administrator privileges
- Risk assessment algorithms are configured in the system
### Postconditions:
- Risk reports are generated with appropriate privacy protections
- Intervention recommendations are provided
- Report access is logged for compliance purposes
### Basic Flow:
1. User selects "Risk Assessment" from administrative dashboard
2. System presents risk parameter configuration options
3. User selects risk thresholds and student population scope
4. User confirms compliance with privacy policies
5. System processes assessment data through risk algorithms
6. System identifies students meeting risk criteria
7. System generates report with anonymized summary data
8. System provides individual student details only to authorized counsellors
### Alternative Flows:
**A1: Critical Risk Identified**
1. System detects students at critical risk levels
2. System generates high-priority alerts
3. System notifies appropriate intervention team
4. System provides recommended intervention protocols
5. Flow continues with Basic Flow step 7

**A2: Privacy Constraint Violation**
1. System detects potential privacy violation in report parameters
2. System displays warning about privacy requirements
3. System suggests parameter modifications
4. User adjusts parameters to comply with privacy policies
5. Flow returns to Basic Flow step 4

## 7. Analyze Assessment Data
### Actor: Counsellor, Administrator
### Description:
Authorized staff analyze individual and aggregate assessment data to evaluate program effectiveness and inform wellness initiatives.
### Preconditions:
- User is logged in with counsellor or administrator privileges
- Assessment data is available in the system
### Postconditions:
- Analysis results are available for planning purposes
- Data privacy is maintained throughout analysis
### Basic Flow:
1. User selects "Assessment Analytics" from administrative dashboard
2. System displays analysis parameter options
3. User selects assessment types, time periods, and demographic filters
4. System retrieves and processes relevant data
5. System generates statistical analysis and visualizations
6. System highlights significant findings and correlations
7. User can interact with data visualizations for deeper analysis
8. User can save analysis configurations for future use
### Alternative Flows:
**A1: Comparative Analysis**
1. User selects comparative analysis option
2. System prompts for comparison parameters (time periods, groups)
3. User selects parameters for multiple data sets
4. System generates side-by-side comparison visualizations
5. System highlights significant differences between data sets
6. Flow continues with Basic Flow step 7

**A2: Data Export Request**
1. User requests to export analysis data
2. System verifies export permissions
3. System generates anonymized data export
4. System logs export activity for compliance
5. System provides export in requested format
6. Flow returns to Basic Flow step 7

## 8. Configure System Settings
### Actor: Administrator, IT Staff
### Description:
Technical staff configure and maintain system settings, including assessment parameters, notifications, access controls, and integration points.
### Preconditions:
- User is logged in with administrative or IT staff privileges
- User has appropriate permission level for requested configuration
### Postconditions:
- System settings are updated according to specifications
- Configuration changes are logged for audit purposes
- Affected system components reflect new settings
### Basic Flow:
1. User selects "System Configuration" from administrative menu
2. System displays configuration categories (user management, assessments, notifications, etc.)
3. User selects category to modify
4. System displays current settings with modification options
5. User makes desired changes to configuration
6. System validates changes for consistency and security
7. User confirms changes
8. System applies new configuration and logs the changes
9. System displays confirmation of successful update
### Alternative Flows:
**A1: Validation Failure**
1. System detects invalid configuration settings
2. System displays specific validation errors
3. System prevents saving of invalid configuration
4. User corrects errors in configuration
5. Flow returns to Basic Flow step 6

**A2: Emergency Configuration Override**
1. User indicates emergency configuration change
2. System requests additional authentication
3. User provides elevated authentication
4. System bypasses standard validation checks
5. System applies changes with emergency override flag
6. System notifies all technical administrators of emergency change
7. System schedules mandatory review of emergency changes
## Analyze Academic Impact
### Actor: Counsellor
Description: Correlates mental health metrics with academic performance
### Preconditions:
- Student has completed ≥2 assessments
- Academic records available
### Postconditions:
- Correlation report generated
- Intervention list created
### Basic Flow:
1. Select student(s) for analysis
2. Choose academic metrics (GPA/attendance)
3. Set analysis timeframe
4. Generate correlation matrix
5. Flag students with >0.7 negative correlation
6. Export report for academic advisors
### Alternative Flows:
- A1: No significant correlation → Suggest reassessment in 4 weeks
