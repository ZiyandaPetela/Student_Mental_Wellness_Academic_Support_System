# Contributing Guide
Welcome! 👋 I am excited you want to contribute to this Java project.  
Follow these steps to set up, code, and submit changes.

## Prerequisites

- **Java JDK 17+** 
- **Maven 3.8+** 
- **Git 2.25+**
 

## Setup Instructions

### 1. Fork and Clone the Repository
1. **Fork** this repository using the "Fork" button at the top-right of this page.
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/ZiyandaPetela/Student_Mental_Wellness_Academic_Support_System.git
   cd https://github.com/ZiyandaPetela/Student_Mental_Wellness_Academic_Support_System.git

## How to Code
Build the project:
```bash
Maven:
mvn clean install
```
## Coding Standards
- Follow the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
- Write **JUnit tests** for new features.
  
### Running Tests
```bash
# For Maven projects
mvn test

```
## Dependency Setup  
- Maven: Dependencies are in `pom.xml`.  
  
## How to Contribute
### Picking Issues
- Choose issues labeled good-first-issue.
- For advanced tasks, pick feature-request issues.

### Submitting a Pull Request (PR)
- Create a branch
```bash
- git checkout -b Write tests for AppointmentBuilder-30
```
### Commit changes:

```bash
git commit -m "feat: Write tests for AppointmentBuilder (closes #30)" 
```
### Push to your fork:
```bash
git push origin Write tests for AppointmentBuilder-30
```
## How to Pick Issues

1. Browse the issues labeled `good-first-issue` for beginner-friendly tasks
2. Check `feature-request` for new features to implement
3. Comment on the issue you want to work on to let maintainers know
4. Wait for the assignment or confirmation before starting work

## Code Review Process

1. All PRs require at least one review before merging
2. Address all feedback from reviews
3. Make sure all tests pass before requesting a review
4. Keep PRs focused on a single issue or feature

## Additional Resources

- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-introduction.html)
- [Design Patterns Book](https://refactoring.guru/design-patterns)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

Thank you for contributing to the Student Mental Health System!
