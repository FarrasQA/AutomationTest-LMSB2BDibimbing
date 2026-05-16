# LMS B2B Automation Testing Framework

Comprehensive automation testing framework for LMS B2B platform using **UI Automation** and **API Automation** with scalable architecture, clean code implementation, and regression-ready structure.

---

# Overview

This project was developed to automate end-to-end testing for the LMS B2B platform, covering:

- UI Automation Testing
- API Automation Testing
- GraphQL Validation
- Cross-browser Testing
- Regression Testing
- Smoke Testing
- Parallel Execution

The framework combines UI and API automation into a single maintainable project for better scalability and efficiency.

---

# Tech Stack

## UI Automation
- Java 17
- Selenium WebDriver
- TestNG
- WebDriverManager
- Page Object Model (POM)

## API Automation
- Rest Assured
- GraphQL API Testing
- Jackson Databind

## Utilities
- Gradle
- SLF4J Logging
- Config Properties
- ThreadLocal Driver Management

---

# Features

✅ Scalable framework architecture  
✅ UI + API integrated automation  
✅ GraphQL request validation  
✅ Thread-safe WebDriver implementation  
✅ Cross-browser support  
✅ Parallel execution ready  
✅ Reusable Base Test structure  
✅ Clean Page Object Model implementation  
✅ Centralized configuration management  
✅ Smoke & Regression test grouping  
✅ Easy maintenance & extensibility  

---

# Test Coverage

## UI Testing
- Login Validation
- Employee Management
- Division Management
- Dashboard Validation
- CRUD Workflow Testing

## API Testing
- GraphQL Query Testing
- GraphQL Mutation Testing
- Authentication Validation
- Positive & Negative Test Cases
- Response Validation

---

# Installation

## Clone Repository

```bash
git clone https://github.com/your-username/your-repository.git
```

---

# Install Dependencies

```bash
./gradlew build
```

---

# Running Test

## Run All Tests

```bash
./gradlew test
```

## Run Regression Suite

```bash
./gradlew regression
```

## Run Smoke Suite

```bash
./gradlew smoke
```

## Run Specific Browser

### Chrome

```bash
./gradlew test -Dbrowser=chrome
```

### Firefox

```bash
./gradlew test -Dbrowser=firefox
```

---

# Configuration

Edit configuration file:

```properties
src/main/resources/config.properties
```

# Testing Strategy

This framework implements:

- Positive Testing
- Negative Testing
- Boundary Validation
- Smoke Testing
- Regression Testing
- UI + API Integration Testing

---

# Scalability Goals

Designed with:
- Clean architecture
- Reusable components
- Minimal duplicated code
- Easy onboarding for new automation cases
- Stable parallel execution
- CI/CD friendly structure

---
