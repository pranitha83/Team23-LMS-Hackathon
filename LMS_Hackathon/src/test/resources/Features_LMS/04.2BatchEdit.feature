@EditBatch
Feature:EditBatch
  Background: Admin is on dashboard page after Login
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    Given Admin is on dashboard page after Login
    When Admin clicks Batch from navigation bar


  Scenario Outline:Validate row level edit icon
    Given The edit icon on row level in data table is enabled
    When Admin clicks the edit icon "<sheetName>" <rowNo>
    Then A new pop up with Batch details appears
    Examples:
      | sheetName   | rowNo |
      | BatchModule | 0     |

  Scenario Outline: Check if the fields are updated
    Given Admin clicks the edit icon "<sheetName>" <rowNo>
    When Update the fields with valid values and click save "<sheetName>" <rowNo>
    Then The updated batch details should appear on the data table "<sheetName>" <rowNo>
    Examples:
      | sheetName   | rowNo |
      | BatchModule | 0     |

  Scenario: Check if the update throws error with invalid values
    When Update the fields with invalid values and click save
    Then Error message should appear edit

  Scenario: Check if you get error message when mandatory fields are erased
    When Erase data from mandatory field noc
    Then Error message should appear edit field

  Scenario: Check if description field is optional in update
    When Erase data from mandatory field
    Then Error message should appear edit






