Feature: Transfer Funds Action

Background:
Given a webdriver is used for test

@Transfer
Scenario: Verify Transfer Funds Page
Given User is on the transfer funds page
When User click on transfer funds link
Then Transfer Funds page displayed successfully

@Transfer
Scenario: Verify funds transfer initiated
Given User is on the fund transfer page
When User enter from and to account
And user enter amount and click on transfer money button
Then Funds transfer message displayed successfully