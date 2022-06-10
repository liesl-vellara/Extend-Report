# Extend-Report
ExtentReports is an open-source reporting library useful for test automation. It can be easily integrated with major testing frameworks like JUnit, NUnit, TestNG, etc. These reports are HTML documents that depict results as pie charts

# Dependencies
1. Selenium Stand Alone
2. Extend Reports Jar/ plugin
3. TestNG
4. Apache freeMarker

# What is the extend-config xml document
1. it is a configuration
2. tags:
    1. whenever we create a html report, there will be a standard theme
    2. encoding is standard too
    3. protocol is http so that the document will come out
    4. document title is 2.0 (version), you can change the title of the document here
    5. we can give a report name
    6. we can give a report headline (automation report, selenium report)
    7. date format and time format are taken automatically
3. we can change only few, not everything

# Java Class (entendReport.java)

1. start writing the code
2. create two variables
    1. `extent` with the class `ExtentReports`
    2. `logger` with the class `ExtentTest`
3. the import files are 
    1. `import com.relevantcodes.extentreports.ExtentReports;`
    2. `import com.relevantcodes.extentreports.ExtentTest;`
4. the two classes `ExtentReports` and `ExtentTest`
    1. is basically to tell where our extent report configuration file
    2. so we have to load the configuration file

## in the Before Test

1. We have to initialize extent
    1. `extent = new ExtentReports(System.getProperty(”user.dir”)+”//TestOutput//Liesl.html”, true);`
    2. this line says that a new extent report called Liesl.html is created in TestOutput
    3. true means that the file has to be created
2. How to load the configuration file
    1. `extent.loadConfig(new File(System.getProperty(”user.dir”)+”//src//extent-config.xml”));`

## In the @Test method

### Start Test

1. in the first line of the @Test method, we add the following lines of code
2. `logger = extent.startTest(”Whatever name we want to give”);`
3. now it takes the extent report and uses logger to append it

### Adding Status

1. we can added status by
2. `logger.log(LogStatus.PASS, “the message we want to give: webpage opend”);`
3. We can add it where ever we want 
4. we can also add properties we get from the programm
    1. String title = driver.getTitle();
    2. `logger.log(LogStatus.PASS, title);`

### End Test

1. we add the lines of code to end the test
2. `extent.endTest(logger);`
3. `extent.flush();`
    1. to flush the report into html
4. `extent.close()`

# Execution of the project

1. run the test method
2. refresh the project
    1. the test out put file will be created 
        1. with a html is added
    2. Reports
        1. with the logger reports within them
        2. it has nothing in it because we have not put anything in the log4j class

# The report itself
1. the time the report is opened
2. the logger messages
3. automation report is just the name

## Dashboard
1. the test, and number of steps to execute the test
2. the environment details
