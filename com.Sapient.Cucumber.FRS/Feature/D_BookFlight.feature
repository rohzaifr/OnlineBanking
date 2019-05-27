Feature: Book Flight Action

Background:
Given a global webdriver is used for test

@Book
Scenario: Book Flight
Given User is on the book flight page
When User successfully login to application
And User select flight details
Then Flight booked successfully