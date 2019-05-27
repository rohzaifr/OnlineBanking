Feature: Banking Home Action

Background:
Given a driver is used for test

@Banking
Scenario: Verify Account Information Page
Given User is on the account information page
When User click on go button
Then Account information page displayed successfully

@Banking
Scenario: Verify that account number displayed in heading Account History is same as bank account selected
Given User is on the account information page of user
When Note account number and user click on go
Then Account number displayed in heading Account History is same as bank account selected

@Banking
Scenario: Verify that current date is displayed in Balance Detail table
Given User is on the account detail page
When User click on go button on account information page
Then Verify that current date is displayed in Balance Detail table