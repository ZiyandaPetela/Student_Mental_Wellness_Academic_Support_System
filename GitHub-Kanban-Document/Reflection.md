# Reflection on GitHub Project Template Selection and Customization

## Challenges Encountered

### Template Selection Challenges

1. **Balancing Simplicity and Functionality:**
   One of the most significant challenges was finding a template that offered sufficient automation capabilities without overwhelming complexity. The Basic Kanban was too simple for our needs, while Team Planning offered features we didn't require. The Automated Kanban provided the right balance, but still required significant customization.

2. **Alignment with Dual Workflows:**
   Our system uniquely spans both clinical mental health and academic support domains. No pre-built template adequately addressed this dual nature, requiring creative adaptation to support parallel clinical and academic review processes.

3. **Integration with Existing Sprint Plan:**
   Transferring our previously defined user stories from Assignment 6 into the new Kanban structure required careful mapping to ensure nothing was lost in translation. Some user stories needed to be split into smaller tasks to fit effectively into the Kanban workflow.

### Customization Challenges

1. **Defining Appropriate WIP Limits:**
   Determining appropriate work-in-progress limits for each column required balancing team capacity with the need for flow. We initially set limits too high, which defeated their purpose, and had to adjust them downward after observing workflow patterns.

2. **Creating Meaningful Automation Rules:**
   Setting up automation rules that moved cards appropriately based on our dual-domain workflow was technically challenging. We needed to create custom issue labels and branch naming conventions to trigger the right automated movements.

3. **Adapting to GitHub's Limitations:**
   GitHub Projects lacks some features found in dedicated project management tools. For example, creating dependencies between tasks or setting up conditional transitions required workarounds using labels and manual linking.

## Comparison with Other Project Management Tools

### GitHub Projects vs. Trello

**Strengths of GitHub Projects over Trello:**
- Direct integration with code repositories and issues
- Built-in automation for development workflows (PR status integration)
- Unified platform for both code and project management

**Weaknesses compared to Trello:**
- Less intuitive drag-and-drop interface
- Fewer third-party power-up integrations
- Limited customization of card appearances and fields

### GitHub Projects vs. Jira

**Strengths of GitHub Projects over Jira:**
- Simpler setup and learning curve
- Better GitHub code integration
- No additional cost for teams already using GitHub

**Weaknesses compared to Jira:**
- Less robust reporting and metrics
- Fewer advanced workflow customization options
- Limited support for complex hierarchical relationships between issues
- Less powerful query language for filtering and organizing issues

## Lessons Learned

1. **Start with Minimal Customization:**
   We initially over-customized our board, adding too many columns and automation rules. We learned it's better to start with minimal customization and evolve the board based on actual usage patterns.

2. **WIP Limits Are Essential:**
   The true power of Kanban emerged when we implemented and respected WIP limits. This forced conversations about priorities and helped identify process bottlenecks that weren't visible before.

3. **Integration Trumps Feature Richness:**
   While other tools offer more features, GitHub Projects' direct integration with our code repository provided more value than additional features would have. The seamless connection between issues, pull requests, and project cards created a natural workflow.

4. **Board Design Impacts Team Behavior**
   We observed that the structure of the board directly influenced how the team worked. Adding the Clinical and Academic Review columns encouraged more thorough validation before considering work complete.

## Future Improvements

For future projects, we would:
1. Create custom issue templates aligned with our board columns
2. Implement more granular labeling to better support automated workflows
3. Integrate automated testing results into the board visualization
4. Develop custom GitHub Actions to enhance the board's capabilities beyond standard automations

This experience has demonstrated that the right project management approach can significantly impact team efficiency and project quality. The custom Kanban implementation we created not only meets the assignment requirements but has genuinely improved our development process.
