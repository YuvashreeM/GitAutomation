# Git Automation Test

This repository contains the source code to automate these 2 test cases:
1. Given a git repo, clone it, add a new file with some content to this repo (file name and content should be an input)
2. Given a git repo, clone it, update an existing file by appending new content to this repo (file name and content should be an input)

## Assumptions

- Java 11 or higher version is installed
- Git CLI is installed and available in system PATH
- Git credentials (via HTTPS or SSH) are already set up locally (cached or configured)
- User must have Write access to executing this script
- Maven-based Java project structure is used
- TestNG is used as the testing framework and Allure for reporting
- Git repo will only be cloned if the provided repo is not cloned already in the provided directory
- Git cloning operation will be skipped if directory already exist

## How It Works

- Uses `ProcessBuilder` to invoke CLI git commands
- As pre-requisites, clone the repo and check if the directory already exists
- Test 1 Adds a new file with content
- Test 2 Updates content to an existing file
- As post-requisites, an added file will be deleted
- Uses TestNG as the test framework
- All test cases of a class are included in `testng.xml` to execute in one go

## Project Structure

```
main/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── gitPage.java
│   │       └── utils/
│   │           ├── gitUtils.java
│   └── test/
│       └── java/
│           └── tests/
│               ├── gitTest.java
├── testng.xml
└── target/
    └── allure-report/
        └── [Files related to Allure reports]
```

## Run Instructions

- Run `mvn clean test -DsuiteXmlFile=testng.xml` to execute all the test cases configured in `testng.xml`

## Allure Report

- Run `mvn clean test verify -Pallure-report ` to generate the Allure report after the test case results once `testng.xml` is executed
- The Allure report will be generated at: `target/allure-report/index.html`

************************************************************************************************************************************************************************************
`
