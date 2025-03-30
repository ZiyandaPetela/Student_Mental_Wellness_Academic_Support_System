# Custom Kanban Board Implementation for Student Mental Wellness System

## Board Structure with Populated Issues

I've implemented our customized Kanban board using the **Automated Kanban template** as a starting point, adding specialized columns to support our dual clinical-academic workflow. Below is the current state of our populated board:

## Current Board Status
| Column | Issues | In Progress | Notes |
|--------|--------|-------------|-------|
| **Backlog** | 10 | - | All unstarted user stories |
| **Ready** | 5 | - | Prioritized for upcoming work |
| **In Progress** | 1 | US-001 (Registration) | Actively being developed |
| **Clinical Review** | 0 | - | Awaiting PHQ-9 validation |
| **Academic Review** | 0 | - | Awaiting scheduling verification |
| **Compliance Check** | 0 | - | Final security gate |
| **Done** | 0 | - | Completed items |

### Backlog (10 issues)
These items are not yet ready for development but are prioritized for future sprints:

1. **US-008: Goals** (Clinical Team, Could-have, Sprint 3)
2. **US-009: Trends** (Clinical Team, Should-have, Sprint 2)
3. **US-011: Feedback** (Academic Team, Won't have)
4. **US-012: Reporting** (Clinical Team, Should-have, Sprint 2)
5. **US-013: Encryption** (Security Team, Should-have, Sprint 2)
6. **US-014: Containerization** (Dev Team, Should-have, Sprint 2)
7. **US-015: Profile** (Dev Team, Should-have, Sprint 2)
8. **US-016: Correlation** (Academic Team, Should-have, Sprint 2)
9. **US-004: Customization** (Clinical Team, Should-have, Sprint 2)
10. **US-007: Dashboard** (Academic Team, Should-have, Sprint 2)

### Ready (5 issues)
These items are fully defined and ready to be picked up for development in Sprint 1:

1. **US-002: Multiple-Factor Authentication** (Security Team, Must-have, Sprint 1)
2. **US-003: PHQ-9 Assessment** (Clinical Team, Must-have, Sprint 1)
3. **US-005: Resources** (Dev Team, Must-have, Sprint 1)
5. **US-006: Filtering Resources** (Dev Team, Must-have, Sprint 1)
6. **US-010: Schedule counseling appointments** (Academic Team, Must-have, Sprint 1)

### In Progress (1 issue)
Currently being actively worked on:
1. **US-001: Registration** (Dev Team, Must-have, Sprint 1)

## Customization Rationale

### 1. Column Structure Justification

I customized the standard Automated Kanban template by adding specialized columns that address our system's unique requirements:

| Column | Purpose | Customization Rationale |
|--------|---------|-------------------------|
| **Backlog** | Store all defined issues | Standard column, maintained from template |
| **Ready** | Sprint-ready issues | Standard column, maintained from template |
| **In Progress** | Active development | Standard column, maintained from template |
| **Clinical Review** | Mental health feature validation | **Added column** - Critical for ensuring PHQ-9 and other clinical features are reviewed by qualified mental health professionals before proceeding |
| **Academic Review** | Academic feature validation | **Added column** - Ensures academic support features align with university policies and educational best practices |
| **In Review** | Technical code review | Modified from template's "Review" to clarify this is specifically for code/technical review |
| **Compliance Check** | Privacy and security verification | **Added column** - Essential for verifying FERPA compliance and security requirements for sensitive student data |
| **Done** | Completed work | Standard column, maintained from template |

### 2. Work-in-Progress (WIP) Limits

I've implemented the following WIP limits to maintain flow and prevent bottlenecks:

- **In Progress**: Limit of 3 tasks (reduced from default 16)
  - *Rationale*: With a small team, focusing on fewer items increases completion rate
- **Clinical Review**: Limit of 2 tasks
  - *Rationale*: Limited availability of clinical staff for reviews
- **Academic Review**: Limit of 2 tasks
  - *Rationale*: Limited availability of academic advisors for reviews
- **In Review**: Limit of 3 tasks (reduced from default 5)
  - *Rationale*: Prevent code review bottlenecks
- **Compliance Check**: Limit of 2 tasks
  - *Rationale*: Thorough compliance checks require focus and attention to detail

### 3. Board Automation Rules

I've implemented the following automation rules to enhance workflow efficiency:

1. **Issue Progress Automation**:
   - When a Pull Request is linked to an issue, automatically move the issue to "In Progress"
   - When a Pull Request is merged, move linked issues to appropriate review column:
     - Issues with "clinical" label → Clinical Review
     - Issues with "academic" label → Academic Review
     - Issues with "security" label → Compliance Check

2. **Review Process Automation**:
   - When approved in Clinical/Academic Review, automatically move to "In Review"
   - When approved in "In Review", automatically move to "Compliance Check"
   - When approved in "Compliance Check", automatically move to "Done"

## Implementation Screenshots

[Note: Insert screenshots of your populated Kanban board here, showing the different columns and at least some of the issues placed in appropriate columns]

## Board Organization Strategy

### Team-Based Labels 

I've organized our board with color-coded labels that align with our team structure:

- **Clinical Team** (purple): Mental health assessment features
- **Academic Team** (green): Educational support features
- **Security Team** (red): Authentication and data protection features
- **Development Team** (blue): Core technical implementation

### Priority-Based Organization

Within columns, issues are organized by priority using MoSCoW labels:
- **Must-have**: Top priority(P0) (Sprint 1 focus)
- **Should-have**: Medium priority(P1) (Sprint 2 focus)
- **Could-have**: Lower priority(P2) (Sprint 3 focus)
- **Won't have**: Out of current scope

### Sprint Planning Integration

The board visualization directly supports our sprint planning from Assignment 6:
- Sprint 1 items are primarily in Ready/In Progress
- Sprint 2 items are primarily in Backlog
- Later sprint items remain lower in the Backlog

## Future Board Refinements

As our project progresses, I plan to refine the board by:
1. Adding more detailed checklists within issues to track subtasks
2. Refining automation rules based on actual workflow patterns
3. Implementing sprint-based milestones to track velocity
4. Integrating testing status visualization into the board

This Kanban implementation successfully addresses both the technical and domain-specific requirements of our Student Mental Wellness Academic Support System while maintaining Agile principles and efficient workflow management.
# Custom Kanban Board Implementation


## Screenshot Documentation
![Kanban Board Screenshot]()
*Caption*: Shows:
- Custom columns (highlighted in yellow)
- US-001 in "In Progress" with assignee @DevTeamMember
- Labels: `must-have` (red), `technical` (blue)
- WIP limits visible on columns
![Alt Text](![Kanban Board 1](https://github.com/user-attachments/assets/17351812-e1ca-4487-a47a-874d11f3ec79)
image-path.png)
