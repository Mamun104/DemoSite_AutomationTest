# DemoSite_AutomationTest

# Technology:

1.Tool: selenium Webdriver

2.IDE: IntelIJ IDEA

3.Build tool: Gradle

4.Language: Java

5.Test runner: TestNG

# Prerequisite:

1.Need to install jdk 11, gradle and allure

2.Configure Environment variable for jdk 11, gradle and allure

3.Need good internet connectivity

4.Clone this project and unzip it

5.Open the project folder

6.Double click on "build.gradle" and open it through IntellIJ IDEA

7.Let the project build successfully

8.In "./src/test/resources/Users.json" replace the whole JSON content with [] and save

9.Click on "Terminal" and run the automation scripts

# Run the automation script:

1.Type the command:

          gradle clean test
  
2.Selenium will open the browser and start automation

3.To view report, type this command one after another:

            allure generate allure-results --clean -o allure-report
            
            allure serve allure-results
  




