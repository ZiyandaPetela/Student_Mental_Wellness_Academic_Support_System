# Reflection: Agile Planning Challenges  
**Word Count**: ~500 words  

## Introduction  
As the sole stakeholder and product owner for the Student Mental Wellness System, I faced significant challenges in balancing technical requirements, user needs, and Agile principles. Below is a candid reflection on prioritization, estimation, and internal resistance during the planning process.  

---

## 1. Prioritization Challenges  
### **Conflict Between Security and Usability**  
- **Example**: While US-013 (AES-256 encryption) was critical for compliance, it competed with user-facing features like US-007 (Wellness Dashboard).  
- **Internal Resistance**: As a stakeholder, I prioritized security (labeling it "Could-have") but later regretted not making it a "Must-have" due to legal risks.  

### **Counselor vs. Student Needs**  
- **Example**: US-016 (Academic-Mental Health Correlations) was crucial for counselors but less urgent for students.  
- **Resolution**: Deferred it to "Should-have" to focus on MVP student features, despite its long-term value.  

### **Technical Debt vs. Speed**  
- **Example**: US-014 (Docker) would improve deployment consistency but was labeled "Could-have" to accelerate MVP delivery.  
- **Impact**: Short-term gains risked long-term maintenance issues.  

---

## 2. Estimation Uncertainties  
### **Overconfidence in Effort Estimates**  
- **Example**: US-003 (PHQ-9 Assessments) was estimated as 5 points but required 14 hours of work due to real-time feedback complexity.  
- **Root Cause**: Lack of team input led to underestimating backend scoring logic.  

### **Story Point Misalignment**  
- **Example**: US-010 (Appointments) was labeled 5 points but took 18 hours due to calendar API integration hurdles.  
- **Lesson**: Should have used Fibonacci sequencing more rigorously (e.g., 8 instead of 5).  

### **Dependency Blindspots**  
- **Example**: Assumed US-005 (Resources) could start before US-003 (Assessments) was fully done, causing rework.  

---

## 3. Aligning Agile with Stakeholder Needs  
### **Resisting Scope Creep**  
- **Example**: US-011 (Anonymous Feedback) was tempting to include as a "quick win" but was deferred to "Won’t-have" to protect MVP focus.  

### **MVP Tunnel Vision**  
- **Example**: Initially ignored US-015 (Student Profiles) as "Should-have," but later realized it was critical for personalization (US-005).  

### **Tooling Adaptation**  
- **GitHub Projects Learning Curve**: Linking issues, managing dependencies, and tracking progress required iterative adjustments.  

---

## 4. Lessons Learned  
1. **Stakeholder Bias**: As the sole decision-maker, I deprioritized valuable features (e.g., US-009 Anonymized Trends) due to MVP urgency.  
2. **Task Breakdown**: Smaller subtasks (e.g., splitting US-003 into scoring logic and UI) would have improved estimation accuracy.  
3. **Dependency Mapping**: Visualizing dependencies earlier (e.g., US-002 → US-001) could have prevented bottlenecks.  

---

## Conclusion  
Balancing Agile principles with stakeholder demands was akin to "building the plane while flying it." While the MVP sprint delivered core functionality, future iterations must:  
1. Involve mock team feedback for estimation accuracy.  
2. Use dependency graphs during backlog refinement.  
3. Revisit "Could-have" items like encryption (US-013) post-MVP.  

This process highlighted the importance of humility in Agile planning – even as a solo stakeholder, assumptions must be constantly challenged.  
