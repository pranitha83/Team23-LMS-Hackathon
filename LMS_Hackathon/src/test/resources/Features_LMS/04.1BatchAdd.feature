@AddBatch
Feature:AddBatch
  Background: Admin is on dashboard page after Login
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    Then Admin enter valid credentials  and clicks login button
    Given Admin is on dashboard page after Login
    When Admin clicks Batch from navigation bar


  Scenario: Check if the fields exist in popup window
    Given A new pop up with Batch details appears for add
    When Admin clicks + A New Batch button
    Then The pop up should include the fields Name, Number of classes and Description

  Scenario Outline: Check if description is optional field
    When Fill in all the fields except description with valid values and click save for given "<sheetName>" and rowNumber <rowNo>
    Then The newly added batch should be present in the data table in Manage Batch page

     Examples:
      |sheetName|rowNo|
      |BatchModule|0  |


  Scenario: Check if the program details are added in data table
    When Fill in all the fields with valid values and click save
    Then The newly added batch should be present in the data table in Manage Batch page

  Scenario: Check for error messages for invalid fields
    When Any of the fields have invalid values
    Then Error message should appear

  Scenario: Check for error messages for mandatory fields
    When Any of the mandatory fields are blank
    Then Error message should appear

