
# GitHub Project Templates Comparative Analysis

## Overview of Available Templates
GitHub offers several project management templates designed to support different workflow needs and project types.

## Comparative Matrix

| Feature | Basic Kanban | Automated Kanban | Bug Triage | Team Planning |
|---------|--------------|------------------|------------|---------------|
| Complexity | Low | Medium | Medium | High |
| Automation | Minimal | Moderate | Moderate | Advanced |
| Workflow Flexibility | Limited | Moderate | Specialized | High |
| Agile Support | Basic | Good | Moderate | Excellent |
| Best For | Small Projects | Dev Projects | Bug Tracking | Complex Teams |
# GitHub Project Templates Analysis

## Comparison Table

| Template          | Columns               | Automation Features                          | Agile Suitability       | Best Use Case          |
|-------------------|-----------------------|---------------------------------------------|-------------------------|-----------------------|
| Basic Kanban      | To Do, In Progress, Done | None | Basic task tracking | Small personal projects |
| Automated Kanban  | Backlog, Todo, In Progress, Done | Auto-moves closed PRs to Done | Sprint-based workflows | CI/CD teams |
| Bug Triage       | New, High Priority, In Progress, Fixed | Auto-labels by severity | Bug-focused teams | QA/maintenance |

## Selected Template: Automated Kanban

**Justification:**
This template best supports our project from Assignments 5-6 because:

1. **Backlog Management**:
   - Matches our sprint planning needs
   - Allows prioritization of user stories

2. **Automated Workflow**:
   - Auto-moves issues when PRs merge (matches our CI/CD pipeline)
   - Reduces manual board maintenance

3. **Customization Potential**:
   - Easy to add Testing/QA columns
   - Supports WIP limits for our Agile process

4. **Traceability**:
   - Clear progression from Todo → In Progress → Done
   - Links directly to our code repository
  
# Template Analysis and Selection

## Comparison of GitHub Project Templates

The table below compares three GitHub project templates based on key features such as columns, workflows, automation, and Agile suitability.

| Template           | Columns & Workflow                      | Automation Features                 | Agile Suitability |
|--------------------|----------------------------------------|-------------------------------------|-------------------|
| **Basic Kanban**   | To Do, In Progress, Done              | No automation                      | Suitable for simple workflows |
| **Automated Kanban** | New, In Progress, Review, Done      | Auto-moves issues based on status  | Supports Agile sprints and automation |
| **Team Planning**  | Backlog, Ready, In Progress, Done     | Assigns tasks to team members      | Ideal for team-based Agile projects |

## Justification for Selected Template

After analyzing the available templates, I have chosen the **Automated Kanban** template for this project due to the following reasons:

- **Automation Features**: This template supports auto-moving issues, reducing manual effort and improving workflow efficiency.
- **Agile Suitability**: It aligns well with Agile methodologies by supporting sprint tracking and continuous delivery.
- **Improved Task Management**: With columns like *New, In Progress, Review, and Done*, it provides clear visibility into project status.

By using the **Automated Kanban** template, we can efficiently track project progress, minimize manual task updates, and ensure a smooth Agile workflow.
# Assignment 7: GitHub Project Template Analysis and Selection  
**For Student Mental Wellness Academic Support System**  

## GitHub Project Templates Comparative Analysis  

### Overview of Available Templates  
GitHub offers four project management templates evaluated against our system requirements from [Assignment 5](#) and [Assignment 6](#).  

---

## Template Comparison Table  

| Template | Columns & Workflow | Automation Features | Agile Suitability | Best For | Limitations for Our Project |  
|----------|--------------------|---------------------|-------------------|----------|-----------------------------|  
| **Basic Kanban** | To Do, In Progress, Done | None | Basic | Simple projects | Cannot handle clinical/academic dual workflows |  
| **Automated Kanban** | Backlog, Todo, In Progress, Done | Auto-moves closed PRs, status sync | High (Scrum/Kanban) | CI/CD teams | Requires 2 custom columns added |  
| **Bug Triage** | New, High Priority, In Progress, Fixed | Auto-labels bugs | Medium | QA teams | No support for feature development (US-001 to US-016) |  
| **Team Planning** | Icebox, Ready, In Progress, Done | Milestone tracking | High | Large teams | Overkill for our 4-person team |  

---

## Selected Template: **Enhanced Automated Kanban**  

### Justification with User Story References  

#### 1. Agile Sprint Support  
- **Backlog Column**: Matches our [Sprint 1 backlog](#) (US-001 to US-010)  
- **WIP Limits**: Enforces focus (critical for US-003 assessment development)  
- **Automation**: Closes issues when PRs merge (supports US-002 MFA implementation)  

#### 2. Clinical-Academic Workflow  
```mermaid  
graph TD  
    A[Backlog] --> B[In Dev]  
    B --> C[Clinical Review<br><i>For US-003, US-005</i>]  
    B --> D[Academic Review<br><i>For US-010, US-016</i>]  
    C & D --> E[Compliance Check<br><i>US-013</i>]  
    E --> F[Student Beta<br><i>TC003, TC004</i>]  


