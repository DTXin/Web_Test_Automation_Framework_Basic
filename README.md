# # Introduction
This is a sample basic to practice Web Test Automation!. The Sample using Eclipse IDE, Selenium WebDriver Framework, Java language, Maven, ExtentReport and TestNG.

# Test Subject
Visit to website http://travel.agileway.net/. We will book a flight one trip or return trip. Then we will fill passenger's information and payment it.  

# Libraries and Frameworks
This sample using the following libraries and frameworks:
- Java JDK-1.8 as the programming language
- Selenium WebDriver as Web browser automation
- Maven as Build and package management
- Extent Report as the testing report strategy
- TestNG as a testing framework to support the test creation, execution and reporting

# Test Architecture
We know that any automation project starting with a good test architecture. This sample can be your initial test architecture for a faster start. You will see the following items in this architecture:

- Page Object Model (POM) 
- Page Factory
- TestListener
- Screenshot
- Reporting

# Page Object Model and Page Factory
Page Object Model (POM) is a design pattern, popularly used in test automation that creates Object Repository for web UI elements. The advantage of the model is that it reduces code duplication and improves test maintenance.

**Page Class**: This page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements. To init the elements, we using the Page Factory

**AbstractPage**: 
Collection all action of a page. All the page classes should extend the AbstractPage.

**AbstractTest**: 
This testing pattern was implemented on the test class to automatically run the pre (setupBrowser) and post (quitBrowser) conditions.

The pre-condition uses *@BeforeMethod* from TestNG creates the browser instance based. The post-condition uses *@AfterMethod* to close the browser instance. Both have the alwaysRun parameter as true to force the run on a pipeline.

Pay attention that it was designed to open a browser instance to each *@Test* located on the test class.

This class also the TestListener that is a custom TestNG listener.

# TestListener
The TestListener is a class that implements ITestListener. The following method is used to help logging errors and attach additional information to the test report:

- onTestStart: add the browser information into the test report
- onTestFailure: log the exceptions and add a screenshot to the test report
- onTestSuccess: add the success test on the log

# Screenshot
- getScreenshot() method is used to indicates driver to capture a screenshot and store it in //screenshot/ directory.

![This is a image](https://i.ibb.co/Vx2vzqM/Screenshot-2021-11-12-141844-Error.png)

# Reporting
- The Extent Report framework produce extent.html report. It resides in the 'target\surefire-reports\html' folder.
- File extent.html is a html report, it save all detailed descriptions of execution test cases. It can open it with browser.

![This is a image](https://i.ibb.co/vXG207Z/Screenshot-2021-11-12-141936-Main.png)
