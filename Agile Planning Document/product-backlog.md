### Product Backlog Table (MoSCoW Prioritization)

| Story ID | User Story | Priority (MoSCoW) | Effort (1-5) | Dependencies |
|----------|-------------|-------------------|--------------|--------------|
| **US-001** | As a student, I want to register with my institutional email so I can securely access the system. | Must-have | 3 | None |
| **US-002** | As a user, I want multi-factor authentication (password + OTP) so my account remains secure. | Must-have | 4 | US-001 |
| **US-003** | As a student, I want to complete PHQ-9/GAD-7 assessments with real-time feedback to understand my mental health status. | Must-have | 5 | US-002 |
| **US-005** | As a student, I want personalized mental health resources within 2 seconds of assessment completion to get immediate support. | Must-have | 4 | US-003 |
| **US-006** | As a student, I want to filter resources by topic (stress/anxiety/depression) to find relevant support quickly. | Must-have | 2 | US-005 |
| **US-010** | As a student, I want to schedule counseling appointments with real-time calendar syncing to get timely help. | Must-have | 5 | US-001 |
| **US-007** | As a student, I want a dashboard visualizing my wellness trends to track progress over time. | Should-have | 3 | US-003 |
| **US-009** | As a counselor, I want to view anonymized wellness trends to support student groups effectively. | Should-have | 3 | US-003 |
| **US-015** | As a student, I want my profile to store academic year, major, and mental health preferences to receive tailored support. | Should-have | 2 | US-001 |
| **US-016** | As a counselor, I want to view correlations between mental health metrics and academic performance to identify at-risk students. | Should-have | 4 | US-003, Academic API |
| **US-004** | As a student, I want to customize assessment frequency (daily/weekly/monthly) to manage my wellness journey. | Could-have | 2 | US-003 |
| **US-008** | As a student, I want to set mental wellness goals and receive milestone notifications to stay motivated. | Could-have | 2 | US-007 |
| **US-012** | As a student, I want to generate and download a personal wellness report to share progress with counselors. | Could-have | 2 | US-007 |
| **US-013** | As a system admin, I want user data encrypted with AES-256 so security compliance is met. | Could-have | 3 | None |
| **US-014** | As a DevOps engineer, I want Docker containerization so deployment is consistent across environments. | Could-have | 3 | None |
| **US-011** | As a student, I want to submit anonymous feedback to share concerns privately. | Won’t-have | 1 | None |

---

### **Justification for Prioritization**  
1. **Must-have** (MVP Core):  
   - **US-001/US-002/US-003**: Foundational for secure access and core functionality (registration, authentication, assessments).  
   - **US-005/US-006/US-010**: Directly address student mental health needs (personalized resources, filtering, appointments).  
   - *Rationale*: Aligns with stakeholder success metrics for usability, security, and immediate student support.  

2. **Should-have**:  
   - **US-007/US-009/US-015/US-016**: Enhance user experience and counselor insights (dashboard, anonymized trends, profiles, academic correlations).  
   - *Rationale*: Secondary to MVP but critical for long-term adoption and institutional value.  

3. **Could-have**:  
   - **US-004/US-008/US-012/US-013/US-014**: Optional enhancements (custom frequency, goals, reports, encryption, Docker).  
   - *Rationale*: Valuable for future iterations but not essential for MVP launch.  

4. **Won’t-have**:  
   - **US-011**: Deferred due to low priority and minimal impact on MVP goals.  
