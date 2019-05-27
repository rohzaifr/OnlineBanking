Feature: Search Flight Action

Background:
Given a driver is used for test

@Search
Scenario: Search a Flight
Given User is on the search flight page
When User login to application
And User provide valid creteria
Then Flight details displayed