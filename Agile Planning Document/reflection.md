# Reflection: Agile Planning Challenges

## Introduction
As the sole stakeholder and product owner for the **Student Mental Wellness System**, I faced significant challenges in balancing technical requirements, user needs, and Agile principles. This reflection explores the difficulties I encountered in **prioritization**, **estimation**, and **aligning Agile practices with stakeholder needs**, along with lessons learned for future iterations.

---

## 1. Prioritization Challenges

### **Conflict Between Security and Usability**
- **Example**: While **US-013 (AES-256 encryption)** was critical for compliance, it competed with user-facing features like **US-007 (Wellness Dashboard)**.
- **Internal Resistance**: I initially labeled encryption as a "Could-have" to prioritize usability but later moved it to "Should-have" due to potential legal risks and again moved it to "Could-have".
- **Lesson**: Security should never be compromised, even if it delays user-facing features.


---

## 2. Estimation Uncertainties

### **Overconfidence in Effort Estimates**
- **Example**: **US-003 (PHQ-9 Assessments)** was estimated at 5 story points but required 14 hours of work due to the complexity of real-time feedback.
- **Root Cause**: Lack of team input led to underestimating the backend scoring logic.
- **Lesson**: Involving a mock team for estimation would improve accuracy.

### **Story Point Misalignment**
- **Example**: **US-010 (Appointment Scheduling)** was labeled 5 points but took 18 hours due to calendar API integration hurdles.
- **Lesson**: Using Fibonacci sequencing more rigorously (e.g., 8 instead of 5) would have provided a more realistic estimate.

### **Dependency Blindspots**
- **Example**: I assumed **US-005 (Personalized Resources)** could start before **US-003 (Assessments)** was fully complete, causing rework.
- **Lesson**: Visualizing dependencies earlier would prevent bottlenecks and inefficiencies.

---

## 3. Aligning Agile with Stakeholder Needs

### **Resisting Scope Creep**
- **Example**: **US-011 (Anonymous Feedback)** was tempting to include as a "quick win" but was deferred to "Won’t-have" to protect MVP focus.
- **Lesson**: Staying disciplined about scope is critical for delivering the MVP on time.

### **Tooling Adaptation**
- **GitHub Projects Learning Curve**: Linking issues, managing dependencies, and tracking progress required iterative adjustments.
- **Lesson**: Investing time upfront to master Agile tools pays off in the long run.

---

## 4. Lessons Learned

### **Stakeholder Bias**
- As the sole decision-maker, I deprioritized valuable features (e.g., **US-009 Anonymized Trends**) due to MVP urgency.
- **Lesson**: Regularly challenging assumptions ensures a balanced approach.

### **Task Breakdown**
- Breaking **US-003** into smaller subtasks (e.g., scoring logic and UI) would have improved estimation accuracy.
- **Lesson**: Smaller, well-defined tasks reduce uncertainty and improve planning.

### **Dependency Mapping**
- Visualizing dependencies earlier (e.g., **US-002 → US-001**) could have prevented bottlenecks.
- **Lesson**: Dependency graphs should be part of backlog refinement.

---

## Conclusion
Balancing Agile principles with stakeholder demands was akin to "building the plane while flying it." While the MVP sprint delivered core functionality, future iterations must:
1. Involve mock team feedback for better estimation accuracy.
2. Use dependency graphs during backlog refinement.
3. Revisit "Should-have" items like encryption (**US-013**) and counselor-focused features (**US-016**) post-MVP.

This process highlighted the importance of humility in Agile planning—even as a solo stakeholder, assumptions must be constantly challenged. By addressing these challenges, I aim to improve future sprints and deliver a more robust system.
