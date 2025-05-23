
# 🔧 Git Automation Test

This repository demonstrates a Git automation framework built using **Java**, **Maven**, and **TestNG**. It automates key Git workflows using command-line interaction via Java’s `ProcessBuilder` and provides rich test reporting through **Allure**. This setup facilitates automated validation of Git operations like adding or updating files in a repository with dynamic input.

---

## ✅ Features Automated

The following Git operations are automated and validated:

1. **Add New File to a Git Repository**
    - ✅ Clone the provided Git repository (if not already cloned).
    - ✅ Create and add a new file with input-based filename and content.
    - ✅ Commit and push the file to the remote repository.

2. **Update Existing File in a Git Repository**
    - ✅ Clone the provided Git repository (if not already cloned).
    - ✅ Locate and append new content to the specified existing file.
    - ✅ Commit and push the updated file to the remote repository.

---

## 🔧 Prerequisites

Ensure the following dependencies and configurations are available on your system:

- Java 11 or higher
- Maven
- Git CLI installed and available in the system PATH
- Git credentials (HTTPS or SSH) properly configured and cached
- Write access to the repository and working directory
- Allure Commandline (for reporting)

> Frameworks & Tools Used:
> - Java (language)
> - Maven (build and dependency management)
> - TestNG (test framework)
> - Allure (reporting)

---

## 📁 Project Structure
```bash
gitAutomationFramework/
│
├── pom.xml                          # Maven configuration
├── testng.xml                       # TestNG suite configuration
├── README.md
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   └── gitPage.java     # Encapsulates Git operations
│   │       └── utils/
│   │           └── gitUtils.java    # Utility methods for Git process execution
│
│   └── test/
│       └── java/
│           └── tests/
│               └── gitTest.java     # TestNG test cases
│
└── target/
└── allure-report/              # Allure report output directory
└── allure-results/             # Allure results output directory
```
---

## 📌 Key Components

### 1. **`gitPage.java` (Page Layer)**
Handles encapsulated Git operations like cloning, file creation, content update, commit, and push.

### 2. **`gitUtils.java` (Utilities)**
Utility class that executes Git CLI commands via `ProcessBuilder`. Handles error streams, input streams, and command execution logic.

### 3. **`gitTest.java` (Test Layer)**
Contains the actual test cases to:
- Add a new file with given content.
- Update existing files with new content.
- Validate successful execution using assertions and console output.

### 4. **`testng.xml`**
Defines the test suite and includes all test classes for execution in a batch.

---

## ▶️ How to Run the Tests

### Step 1: **Run Test Suite**
Use Maven to execute the configured TestNG suite:

```bash 
mvn clean test -DsuiteXmlFile=testng.xml
```

### Step 2: **Generate and View Allure Report**
After the test execution, generate the Allure report using:

```bash 
mvn clean test verify -Pallure-report
```

Then open the report located at:

```
target/allure-report/index.html
```

---

## 📊 Reporting and Logging

- **Allure Report**: Provides detailed visual feedback on test results including:
    - Step-by-step logs
    - Attachments
    - Success/failure states

---

## 📌 Summary

This Git automation framework provides a robust and modular approach to validating essential Git operations programmatically. Built with maintainability and extensibility in mind, it delivers:

- **Command-Line Git Automation**: Executes real-world Git operations without using third-party libraries.
- **TestNG-Based Execution**: Organizes test logic cleanly and supports structured test configuration.
- **Allure Reporting**: Captures execution flow and outcomes for traceability and debugging.
- **Reusable Design**: Encapsulated page and utility classes promote DRY principles and future enhancements.

This project is ideal for validating Git workflows in CI/CD scenarios or integration testing environments.
