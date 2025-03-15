# Use Case: Complete Wellness Assessment
## Actor: Student
### Description: Student completes a mental health assessment questionnaire to evaluate their current wellness state.

## Preconditions:
- Student is logged into the system
- Student has not completed an assessment in the past 14 days

## Postconditions:
- Assessment results are stored in the system
- System generates personalized recommendations based on results
- Risk flags are raised if critical thresholds are met

## Basic Flow:
1. Student selects "Complete Assessment" option
2. System presents assessment questionnaire
3. Student answers all questions
4. Student submits completed assessment
5. System validates all required fields are completed
6. System processes and scores the assessment
7. System displays confirmation of completion
8. System notifies student that recommendations are available

## Alternative Flows:
A1: Incomplete Assessment
1. Student leaves required questions unanswered
2. System highlights missing responses
3. System prompts student to complete all required fields
4. Flow returns to Basic Flow step 3

## A2: Critical Risk Detected
1. System identifies responses indicating severe mental health risk
2. System displays urgent support resources
3. System sends alert to counseling staff
4. Process continues with Basic Flow step 7
