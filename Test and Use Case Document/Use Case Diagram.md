# Student Mental Wellness Academic Support System  

## 1. Use Case Diagram  

![Use Case Diagram](your-diagram-image-link.png)  

## 2. Use Case Diagram Explanation  

### Key Actors and Their Roles  
The system has six primary actors, each playing a key role:  

- **Student**: Completes wellness assessments, views recommendations, tracks wellness goals, and schedules counseling appointments.  
- **Faculty**: Monitors student wellness trends and accesses wellness resources.  
- **Parent**: Can view student wellness trends and access mental health resources (if permitted).  
- **Counsellor**: Supports students by managing wellness assessments, scheduling appointments, and generating risk reports.  
- **Administrator**: Configures system settings, manages user access, and oversees wellness data trends.  
- **IT Staff**: Maintains system security, ensures functionality, and updates system configurations.  

### Relationships Between Actors and Use Cases  

The use case diagram follows UML relationships to define system behavior:  

- **Inclusion ("<<include>>") Relationships**  
  - *"Complete Wellness Assessment"* **includes** *"Generate Risk Assessment Reports"* → Risk reports are generated based on assessment responses.  
  - *"Schedule Counselling Appointment"* **includes** *"Check Counsellor Availability"* → Appointments depend on available slots.  

- **Extension ("<<extend>>") Relationships**  
  - *"View Personalized Recommendations"* **extends** *"Complete Wellness Assessment"* → Recommendations are only available after an assessment.  
  - *"Monitor Student Wellness Trends"* **extends** *"Analyze Assessment Data"* → Trend reports depend on assessment analytics.  

- **Communication ("<<communicate>>") Relationships**  
  The *"communicate"* relationship in the use case diagram represents direct **interactions** between actors and specific use cases. Examples include:  
  - **Student ↔ Counsellor**: When a student schedules a counselling appointment, they communicate directly with a counsellor.  
  - **Counsellor ↔ Administrator**: Counsellors may communicate with administrators regarding system reports and policy adjustments.  
  - **Student ↔ Parent**: If permitted, students can share wellness data with parents.  

This relationship ensures that the system **facilitates direct interaction between stakeholders** where necessary, improving **support accessibility and collaboration**.  

### How the Diagram Addresses Stakeholder Concerns  
The system is designed to **support mental wellness** while ensuring **data security and accessibility**:  

- **Students** receive structured mental health support through assessments, recommendations, and goal tracking.  
- **Counsellors & Administrators** monitor student wellness trends and intervene when necessary.  
- **IT Staff & Admins** ensure system security and customization for smooth functionality.  
- **Faculty & Parents** (if authorized) access anonymized insights to provide additional support.  

By incorporating these use cases and relationships, the system ensures **efficient mental health monitoring, timely intervention, and data security**, meeting all stakeholder needs.  

    
  
