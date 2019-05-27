Feature: Login Action

Background:
Given a global driver is used for test

@Login
Scenario: Date Check
Given User is on the application login page
When User navigate to application login page
Then Valid date displayed successfully

@Login
Scenario: Featured Image
Given User is on application home page
When User Navigate to application home page
Then Featured image displayed successfully

@Login
Scenario: Incorrect Login
Given User is on Home Page
When User enters Username and Password
Then User unable to login

@Login
Scenario: Correct Login
Given User is on application Page
When User enters credentials
Then User able to login successfully