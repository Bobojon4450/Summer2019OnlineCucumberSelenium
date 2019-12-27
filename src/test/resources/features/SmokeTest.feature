@smoke_test
Feature: Smoke Test

  Background: open login page and login as store manager
    Given user is on the login page
    Then user logs in as store manager

  Scenario: Verify dashboard page
    And user verifies the "Dashboard" page subtitle is displayed

  Scenario: Verify Manage Dashboards page
    When user navigates to "Dashboards" then to "Manage Dashboards"
    And user verifies the "All Manage Dashboards" page subtitle is displayed

  Scenario: Verify Vehicle page
    When user navigates to "Dashboards" then to "Manage Dashboards"
    And user verifies the "All Manage Dashboards" page subtitle is displayed

#  Scenario: Verify Vehicle page
#    And user navigates to "Fleet" then to "Vehicles"
#    Then user verifies that "All Cars" page subtitle is displayed
#
#  Scenario: Verify Accounts page
#    And user navigates to "Customers" then to "Accounts"
#    Then user verifies that "All Accounts" page subtitle is displayed