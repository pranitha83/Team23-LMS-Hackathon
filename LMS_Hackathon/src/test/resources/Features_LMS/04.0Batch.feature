#Author: Rekha Thulasiram


@batch
Feature:  Batch page Validation

  Background: Admin is on dashboard page after Login
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    Given Admin is on dashboard page after Login
    When Admin clicks Batch from navigation bar
    Then Admin should see the Manage Batch in the URL

  Scenario: Validate header in Batch page
    Then Admin should see the Manage Batch in the header

  Scenario: Validate pagination in Batch page
    Then Admin should see the pagination controls under the data table

  Scenario: Validate data table headers in Batch page
    Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete

  Scenario: Validate delete button in Batch page
    Then Admin should be able to see the delete icon button that is disabled

  Scenario: Validate A New batch in Batch Page
    Then Admin should be able to see the A New batch button

  Scenario:Validate data rows
    Then Each row in the data table should have a checkbox

  Scenario:Validate data rows
    Then Each row in the data table should have a edit icon that is enabled

  Scenario: Validate pop up for adding batch
    When Admin clicks A New Batch button
    Then A new pop up with Batch details appears

   @navigationToDifferentPages
  Scenario:  Validating program link on navigation bar
     When Admin clicks on Program link on Manage Batch page
     Then Admin is re-directed to Program page

   Scenario:  Validating User link on navigation bar
     When Admin clicks on User link on Manage Batch page
     Then Admin is re-directed to User page

  Scenario:  Validating Logout link on navigation bar
    When Admin clicks on logout link on Manage Batch page
    Then Admin is re-directed to logout page