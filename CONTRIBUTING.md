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
- git checkout -b fix-issue-123  # Replace "123" with the issue number
```
### Commit changes:

```bash
git commit -m "feat: add anxiety assessment validation (closes #123)" 
```
### Push to your fork:
```bash
git push origin fix-issue-123
```
