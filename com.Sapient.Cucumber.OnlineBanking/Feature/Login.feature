Feature: Login Action

Background:
Given a global driver is used for test

@Login
Scenario: Logo verification
Given User is on the application login page
When User navigate to application login page
Then Logo displayed successfully

@Login
Scenario: Login with invalid credentials
Given User is on application home page
When User Navigate to application home page
And User enters invalid Username and Password
Then Invalid attempt message displayed successfully

@Login
Scenario: Successful Login with valid credentials
Given User is on Home Page
When User Navigate to Login Page
And User enters Username and Password
Then Message displayed Login Successfully

@Login
Scenario: Verify that tabs are displayed at the top
Given User is on application Page
When User Navigate to application main Page
Then Tabs displayed Successfully

@Login
Scenario: Successful Logout
Given User is on main Page
When User click on signoff button
Then User logout Successfully