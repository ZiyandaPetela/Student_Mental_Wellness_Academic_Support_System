# User Stories

This document contains the user stories for the Student Mental Wellness Academic Support System, derived from the functional requirements (Assignment 4) and use cases (Assignment 5). Each user story follows the format: 
*"As a [role], I want [action] so that [benefit]."* 

The stories are designed to meet the **INVEST criteria** (Independent, Negotiable, Valuable, Estimable, Small, Testable) and include **acceptance criteria** to ensure clarity and testability. These stories will guide the development of the system and form the basis for the product backlog and sprint planning.

---

## Table of User Stories


| Story ID | User Story | Acceptance Criteria | Priority      | 
|----------|------------|---------------------|---------------|
| **US-001** | As a student, I want to register with my institutional email so I can securely access the system. | - Registration rejects non-institutional emails<br>- Validation works for valid domains | High | 
| **US-002** | As a user, I want multi-factor authentication (password + OTP) so my account remains secure. | - 100% of logins require 2FA<br>- OTP delivery ≤30 seconds | High | 
| **US-003** | As a student, I want to complete PHQ-9/GAD-7 assessments with real-time feedback so I understand my mental health status. | - Results display within 2 seconds<br>- Critical risks trigger alerts | High | Functional | FR4 (A4) |
| **US-004** | As a student, I want to customize assessment frequency (daily/weekly/monthly) so I can manage my wellness journey. | - Reminder settings persist across sessions | Medium |
| **US-005** | As a student, I want personalized mental health resources within 2 seconds of assessment completion so I get immediate support. | - Recommendations match assessment results | High |
| **US-006** | As a student, I want to filter resources by topic (stress/anxiety/depression) so I find relevant support quickly. | - Filter accuracy = 100% | High | 
| **US-007** | As a student, I want a dashboard visualizing my wellness trends so I can track progress over time. | - Graphs update in ≤3 seconds | Medium| 
| **US-008** | As a student, I want to set mental wellness goals and receive milestone notifications so I stay motivated. | - Notifications trigger on achievement | Low | F
| **US-009** | As a counselor, I want to view anonymized wellness trends so I can support student groups effectively. | - No PII exposed in reports | Medium | 
| **US-010** | As a student, I want to schedule counseling appointments with real-time calendar syncing so I get timely help. | - Appointments reflect in calendars ≤3 seconds | High | Use Case | TC004 (A5) |
| **US-011** | As a student, I want to submit anonymous feedback so I can share concerns privately. | - No user metadata stored with feedback | Low | 
| **US-012** | As a student, I want to generate and download a personal wellness report so I can share progress with counselors. | - Report includes accurate data and is downloadable as PDF | Medium | 
| **US-013** | As a system admin, I want user data encrypted with AES-256 so security compliance is met. | - Encryption verified via security audit | Medium | Non-
| **US-014** | As a DevOps engineer, I want Docker containerization so deployment is consistent across environments. | - Runs in Docker for dev/prod | Medium | 
| **US-015** | As a student, I want my profile to store academic year, major, and mental health preferences so I receive tailored support. | - Mandatory fields enforced<br>- Data persists across sessions | Medium | 
| **US-016** | As a counselor, I want to view correlations between mental health metrics and academic performance so I can identify at-risk students. | - Reports show anonymized links between PHQ-9 scores and attendance/grades | Medium |

## Traceability
- **US-001** maps to **FR1** (User Registration) from Assignment 4.  
- **US-010** maps to **Use Case 4** (Schedule Counselling Appointment) from Assignment 5.  

---

## Notes
- **Priority**: High, Medium, or Low, based on stakeholder needs and project goals.  
- **Acceptance Criteria**: Specific conditions that must be met for the story to be considered complete
- **Issues**: All stories are tracked as GitHub Issues in the project repository.  
