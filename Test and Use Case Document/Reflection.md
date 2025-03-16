# Reflection: Challenges in Translating Requirements to Use Cases and Test Cases

## 1. Understanding and Refining Requirements
One of the biggest challenges in translating system requirements into use cases and test cases is ensuring clarity and completeness. Requirements are often ambiguous or high-level, requiring further refinement before they can be converted into structured use cases. For example, some requirements might state "The system should provide wellness assessments" without detailing how the assessments should be structured, scored, or accessed.

To address this, stakeholder feedback and refinement were necessary. Breaking down vague requirements into actionable steps was key to ensuring the system met real-world needs.

## 2. Identifying and Defining Actors
Another challenge was identifying all relevant actors and defining their roles. Some actors, like students and counselors, had clear roles, while others, like administrators and IT staff, needed further clarification.

For instance, in the "Configure System Settings" use case, IT staff and administrators both have roles, but their level of access differs. This required careful distinction to avoid redundant responsibilities.

## 3. Structuring Use Cases Logically
Ensuring that each use case had clear preconditions, postconditions, and logical flow was another challenge. Some processes were interconnected, requiring "include" and "extend" relationships.

For example:
- The "Complete Wellness Assessment" use case includes a risk assessment check to ensure students at high risk receive immediate help.
- The "Schedule Counseling Appointment" use case extends "Check Counselor Availability" to prevent double bookings.

## 4. Covering All Possible Scenarios
It was important to consider not just the basic success scenarios but also alternative flows and failure conditions. A common mistake is focusing too much on the happy path without addressing edge cases like:
- What happens if a student doesn’t complete an assessment?
- What if a counselor cancels an appointment?
- How does the system handle a sudden spike in user activity?

By incorporating alternative flows, the use cases became more robust and realistic.

## 5. Mapping Functional and Non-Functional Requirements to Test Cases
Translating functional requirements into test cases was straightforward, as each function mapped to a test case (e.g., searching for resources, booking appointments). However, non-functional requirements (e.g., performance, security, usability) were more difficult to test.

For example:
- **Performance Testing:** Simulating 500+ students submitting assessments required defining measurable criteria.
- **Security Testing:** Ensuring role-based access control and verifying encryption required specific test scenarios.

Balancing functional and non-functional test cases ensured the system was not only functional but also secure, efficient, and user-friendly.

## Conclusion
Translating requirements into use cases and test cases required a structured approach, iterative refinement, and a focus on real-world scenarios. Challenges such as vague requirements, actor-role confusion, complex workflows, and edge cases required critical thinking and stakeholder input to resolve. Despite these challenges, the process helped create a clear, testable, and structured system design, ensuring alignment with user needs.
