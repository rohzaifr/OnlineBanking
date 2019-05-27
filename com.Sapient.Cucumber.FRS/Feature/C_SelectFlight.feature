Feature: Select Flight Action

Background:
Given a webdriver is used for test

@Select
Scenario: Check sorting
Given User is on the select flight page
When User login to application with credentials
And User search for flights
Then Flight details are sorted based on price

@Select
Scenario: Select flight
Given User is on the select flight page
When User login to application with credentials
And User search for flights
Then Select flight details and click continue button