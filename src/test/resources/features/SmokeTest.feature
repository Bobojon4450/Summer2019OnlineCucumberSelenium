@smoke_test
Feature: Smoke Test

  Background: open login page and login as store manager
    Given user is on the login page
    Then user logs in as store manager
  @driver
  Scenario: Verify dashboard page
    And user verifies the "Dashboard" page subtitle is displayed

  Scenario: Verify Manage Dashboards page
    When user navigates to "Dashboards" then to "Manage Dashboards"
    And user verifies the "All Manage Dashboards" page subtitle is displayed
#All Manage Dashboards "s"
  Scenario: Verify Vehicle page
    When user navigates to "Dashboards" then to "Manage Dashboards"
    And user verifies the "All Manage Dashboards" page subtitle is displayed

  Scenario: Verify Vehicle page
    And user navigates to "Fleet" then to "Vehicles"
    Then user verifies the "All Cars" page subtitle is displayed

  Scenario: Verify Accounts page
    And user navigates to "Customers" then to "Accounts"
    Then user verifies the "All Accounts" page subtitle is displayed

# This is an example of how one letter makes the statement to be implemented/developed
# Here we changed second statement's word from "the" to "that"
#  Scenario: Verify Accounts page
#    And user navigates to "Customers" then to "Accounts"
#    Then user verifies that "All Accounts" page subtitle is displayed