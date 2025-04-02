# Reflection on Dynamic Modeling

## 1. Challenges in Granularity
**Problem**: Balancing detail and readability in diagrams  
**Solutions & Lessons**:  
- **State Diagrams**:  
  - *Challenge*: Deciding whether to split "HighRisk" into substates (e.g., "Urgent", "Critical").  
  - *Solution*: Kept it atomic after realizing substates didn’t add actionable info (alerts trigger at "HighRisk" regardless).  
  - *Evidence*: Simplified `EmergencyAlert` state diagram by 40% without losing FR-12 compliance.  

- **Activity Diagrams**:  
  - *Challenge*: Over-detailing parallel actions in "Counselor Review" workflow.  
  - *Solution*: Grouped steps like "Verify Student History" into a single action after confirming with sprint team.  
  - *Lesson*: Agile’s "just enough" principle applies to UML granularity.  

## 2. Aligning Diagrams with Agile User Stories  
**Successes**:  
- **Traceability**: Embedded US-03 ("High-risk alerts") directly into `PHQ9_Assessment.mmd` as comments:  
  ```mermaid
  flowchart TD
      A[Score ≥8] -->|US-03| B[Alert Counselor]
  ```  
- **Sprint Planning**: Used activity diagrams as visual task breakdowns (e.g., "Generate PDF" action → SP-17 in Kanban).  

**Challenges**:  
- *Ambiguity*: US-05 ("Track progress") didn’t specify dashboard updates.  
  - *Resolution*: Clarified with product owner, added "Trend Graphs" state to match FR-11.  

## 3. State vs. Activity Diagrams: Key Comparisons  
| **Aspect**          | **State Diagrams**                     | **Activity Diagrams**               |  
|----------------------|----------------------------------------|-------------------------------------|  
| **Purpose**          | Object lifecycle (e.g., `Assessment`)  | Process flow (e.g., "Submit Form")  |  
| **Agile Alignment**  | Maps to *acceptance criteria* (FRs)    | Maps to *user story steps*          |  
| **Complexity**       | Fewer states = better readability      | Can handle parallel flows           |  
| **Example**          | `Unstarted → Submitted → Analyzed`     | `Student → System → Counselor` lanes|  

**Key Insight**:  
- State diagrams excel at showing *constraints* (e.g., "Can’t cancel archived appointments").  
- Activity diagrams reveal *collaboration pain points* (e.g., handoffs between swimlanes).  

## Lessons Learned  
1. **Validation**: Early Mermaid prototypes exposed 3 mismatches between FRs and user stories.  
2. **Tooling**: GitHub’s native Mermaid support improved team collaboration.  
3. **Agile Synergy**: Diagrams became living docs—updated during sprint retrospectives.  
