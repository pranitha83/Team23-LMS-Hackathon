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
    Then Error message should appear for description

     Examples:
      |sheetName|rowNo|
      |BatchModule|0  |
      |BatchModule|1  |
      |BatchModule|2  |


  Scenario Outline: Check if the program details are added in data table
    When Fill in all the fields with valid values "<sheetName>" and click save <rowNo>
    Then The newly added batch should be present in the data table "<sheetName>" in Manage Batch page <rowNo>
    Examples:
      | sheetName   | rowNo |
      | BatchModule | 0     |
      | BatchModule | 1     |
      | BatchModule | 2     |

  Scenario Outline: Check for error messages for invalid fields
    When Any of the fields have invalid values "<sheetName>" <rowNo>
    Then Error message should appear
    Examples:
      | sheetName   | rowNo |
      | BatchModule | 3     |

  Scenario: Check for error messages for mandatory fields
    When Any of the mandatory fields are blank
    Then Error message should appear

