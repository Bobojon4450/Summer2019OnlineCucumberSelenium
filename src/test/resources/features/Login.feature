@Login
Feature: Login
  As a user, I want to be able to login into vytrack
  under different roles with username and password.

#  Any step that was implemented before, can be reused
#  If test step has yellow background, that means it doesn't have implementation yet.
#  click command/ctrl + option/alt + L to organize code, save like in java
#  I had somewhere from 2 to 25 scenarios in every feature file
#  By passing parameters/strings in "some word" we can reuse test steps
#  In my project, I was trying to keep scenarios short

  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies the "Dashboard" page subtitle is displayed

  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as driver
    And user verifies the "Dashboard" page subtitle is displayed

  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as sales manager
    And user verifies the "Dashboard" page subtitle is displayed

  @negative_test
  Scenario: Verify that warning message is displayed when password is incorrect
    Given user is on the login page
    Then user enters "storemanager85" username and "wrong" password
    And user verifies that "Invalid user name or password." message is displayed

  @negative_test
  Scenario: Verify that warning message is displayed when username is not correct
    Given user is on the login page
    Then user enters "wrong_username" username and "UserUser123" password
    And user verifies that "Invalid user name or password." message is displayed

  @driver_with_data_table
  Scenario: Login as a driver(data table example)
    Given user is on the login page
    Then user logs in as driver with following credentials
      | username | user160     |
      | password | UserUser123 |
    And user verifies the "Quick Launchpad" page subtitle is displayed


































#    comment ctrl + /