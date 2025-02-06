# UISauceDemoApp
# Selenium TestNG Cucumber Framework
# Overview
This framework enables seamless test automation for web applications with the following features:

Selenium WebDriver for browser automation
TestNG for test execution and parallel execution
Cucumber for behavior-driven development (BDD) with feature files and step definitions
Composition approach instead of inheritance to provide more flexibility and modularity


# Key Concepts
Composition Over Inheritance
I want to manage WebDriver instances for flexibility and better testability. It allows each part of your system (like the browser driver setup or test reporting) to function independently and be replaced or extended without affecting the entire framework.          

It’s also easier to maintain and extend without creating deep inheritance hierarchies.
DriverFactory: Manages the WebDriver lifecycle. It ensures the correct browser is initialized and handles parallel execution efficiently using ThreadLocal.

# Parallel Execution with TestNG
Parallel execution is configured via the testng.xml file, allowing tests to be run concurrently across multiple browsers.

# Setup and Configuration
**Dependencies**

**Selenium WebDriver**: For interacting with web browsers.   
**TestNG**: For test execution and parallel execution.  
**Cucumber**: For behavior-driven development (BDD).   
**Maven**: Dependency management.   
**Report Generation**: 

Use CucumberReport for simple visualization.    
Use ExtentReports for detailed and customizable reports.




# Test Execution 
Use **mvn test** command to run the Framework from the Terminal


# Contacts

Email: mohamed.abdelrahman.ishak@gmail.com.   
LinkedIn: https://www.linkedin.com/in/mohamed-ishak-%F0%9F%87%B5%F0%9F%87%B8-4a160a163/
