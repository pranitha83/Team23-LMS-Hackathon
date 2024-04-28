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

  @AddBatch
  Feature:AddBatch
    Scenario: Check if the fields exist in popup window
      Given A new pop up with Batch details appears
      When Admin clicks + A New Batch button
#      Then The pop up should include the fields Name, Number of classes and Description
#
#      Scenario: Check if description is optional field
#        When Fill in all the fields except description with valid values and click save
#        Then The newly added batch should be present in the data table in Manage Batch page
#
#       Scenario: Check if the program details are added in data table
#         When Fill in all the fields with valid values and click save
#         Then The newly added batch should be present in the data table in Manage Batch page
#
#        Scenario: Check for error messages for invalid fields
#          When Any of the fields have invalid values
#          Then Error message should appear
#
#          Scenario: Check for error messages for mandatory fields
#            When Any of the mandatory fields are blank
#            Then Error message should appear
#
#  @EditBatch
#    Feature:EditBatch
#          Scenario:Validate row level edit icon
#            Given The edit icon on row level in data table is enabled
#            When Admin clicks the edit icon
#            Then A new pop up with Batch details appears
#
#          Scenario: Check if the fields are updated
#            Given Admin clicks the edit icon
#            When Update the fields with valid values and click save
#            Then The updated batch details should appear on the data table
#
#           Scenario: Check if the update throws error with invalid values
#             When Update the fields with invalid values and click save
#             Then Error message should appear
#
#            Scenario: Check if you get error message when mandatory fields are erased
#              When Erase data from mandatory field
#              Then Error message should appear
#
#             Scenario: Check if description field is optional in update
#               When Erase data from mandatory field
#               Then The updated batch details should appear on the data table






