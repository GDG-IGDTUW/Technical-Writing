# SDLC- Development and Testing Phases

## What is SDLC?
The **Software Development Life Cycle (SDLC)** is a well-defined process for producing high-quality, cost-effective software in the shortest time possible, while exceeding customer expectations.
SDLC has many phases, including:
- Requirement Analysis
- Design
- Development/ Implementation
- Testing
- Deployment & Maintenance

## Development Phase of SDLC
The development phase is where the actual software is built. The system design and requirements defined in earlier phases are converted into working code.
Developers must adhere to the coding requirements set forth by the customer/boss.

### a) Coding Practices
Good coding practices ensure the software is reliable, readable, and maintainable.
Key practices include:
#### 1. Writing clean and readable code: 
Using meaningful variable names, proper indentation, and consistent formatting.
#### 2. Modular programming: 
Breaking the application into small, reusable modules or functions.
#### 3. Following coding standards: 
Adhering to language-specific or organisational standards (e.g., PEP 8 for Python).
#### 4. Code documentation: 
Adding comments and documentation to explain logic and usage.
#### 5. Error handling and logging : 
Anticipating failures and edge cases and handling them gracefully.



These practices reduce bugs, make debugging easier, and help other developers understand the code.

### b) Version Control
Version control systems (VCS) manage changes to source code over time.

**Common tools: Git, GitHub, GitLab, Bitbucket**

#### Importance of version control:
- Tracks who changed what and when
- Allows multiple developers to work simultaneously
- Supports branching and merging
- Enables rollback to previous stable versions
- Prevents loss of code
**Example:**
Developers work on feature branches
Code is reviewed and merged into the main branch
### c) Team Collaboration
Modern software is rarely built by one person.
Collaboration involves:
- Task division using issue trackers (Jira, GitHub Issues)
- Code reviews to maintain quality and share knowledge
- Regular communication via meetings or chat tools
- Continuous integration (CI), where code is automatically built and tested
Effective collaboration can boost productivity and reduce integration problems.
## 2. Testing Phase of SDLC
The testing phase verifies that the software works as expected and meets requirements. Its goal is to identify defects before deployment.
It enables businesses to do a thorough evaluation of software and verify that their product meets the expectations of their customers. The purpose of this phase is to report, monitor, troubleshoot, and retest software components until they meet the quality requirements.

It involves
1. Unit Testing
2. Integration Testing
3. System Testing
4. Acceptance Testing
### a) Unit Testing
- Tests individual units or functions
- Usually performed by developers
- Ensures each component works in isolation
**Example:**
Testing a function that calculates the total price
**Importance:**
 Catches bugs early and simplifies debugging.
### b) Integration Testing
- Tests interactions between combined modules
- Focuses on data flow and interfaces
**Example:**
Testing whether the login module correctly communicates with the database
**Importance:**
 Detects issues caused by module interactions.
### c) System Testing
- Tests the entire system as a whole
- Performed in an environment similar to production
- Includes functional and non-functional tests (performance, security)
**Importance:**
 Ensures the complete system meets technical and business requirements.
### d) User Acceptance Testing (UAT)
- Performed by end users or clients
- Validates the system against real-world usage and expectations
**Example:**
Users verify whether the software solves their actual problem
**Importance:**
 Confirms the software is ready for deployment and acceptable to users.

## Importance of Testing in Software Quality
- Reduces failures in production
- Improves reliability and security
- Ensures user satisfaction
- Saves cost by detecting issues early
- Builds confidence in the system
