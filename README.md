# AccessHQ_TripAccessHQ - Trip Planner Framework
Trip Planner is a web application for planning trips, consists of numerous pages and functionalities.

Project was done in Intellij using Maven repositories with JUnit framework (tested it on  Chrom Version 71.0.3578.98 )

After extracting the project folder, open the project with pom.xml and there after download all the maven dependencies 
About the maven dependencies used 
•	Junit  -unit testing framework
•	Selenium -automates browsers
•	Log4j –setting up logs
•	Okhtttp –setting up http client
•	Json –reading and extracting the reponse


Project Structure


Base Test –Contains the starting test methods, kept all the asserts in the base test and the imports to a minimum
CustomSeleniumLibrary – For web driver, finding web controls and inputting data 
Client- for http request and response, also json read 
Data- Contains URL’s, web control identifiers and test data 

 




