@User
Feature: Edit User

  Background: Admin is on dashboard page after Login and clicks User on the navigation bar
    Given Admin is on Manage User Page

  Scenario: Validate row level edit icon
    When Admin clicks on the edit icon
    And A new pop up with User details appears

  Scenario Outline: Check if the fields are updated with valid data
    When Update the user that created from the given sheetname "<SheetName>" and rownumber <RowNum>
    And Admin clicks submit
    Then Admin gets message "User Updated Successfully" and see the updated values in data table

    Examples: 
      | SheetName | RowNum |
      | AddUser   |      3 |

  Scenario Outline: Check if the fields are updated with invalid values
    When Update the user from the given sheetname "<SheetName>" and rownumber <RowNum> with invalid values
    And Admin clicks submit
    Then Admin should get Error message

    Examples: 
      | SheetName | RowNum |
      | AddUser   |      4 |

  Scenario Outline: Check if the mandatory fields are updated with valid data
    When Update the mandatory fields of the user from the given sheetname "<SheetName>" and rownumber <RowNum>
    And Admin clicks submit
    Then Admin gets message "User Updated Successfully" in the user manage page
    And Admin can see the updated values of user from the given sheetname "<SheetName>" and rownumber <RowNum>

    Examples: 
      | SheetName | RowNum |
      | AddUser   |      3 |

  Scenario Outline: Check if the optional fields are updated with valid data
    When Update the optional fields of the user from the given sheetname "<SheetName>" and rownumber <RowNum>
    And Admin clicks submit
    Then Admin gets message "User Updated Successfully" and see the updated values in data table

    Examples: 
      | SheetName | RowNum |
      | AddUser   |      3 |

  Scenario Outline: Validate invalid values in the text fields
    When Admin gives only numbers or special char in the text fields of the user from given sheetname "<SheetName>" and rownumber <RowNum>
    And Admin clicks submit
    Then Admin should get Error message

    Examples: 
      | SheetName | RowNum |
      | AddUser   |      4 |

  Scenario Outline: Validate Cancel button on Edit popup
    When Admin clicks edit button of the user from the given sheetname "<SheetName>" and rownumber <RowNum>
    And Admin clicks cancel button
    Then Admin can see the User details popup disappears
    And User can see nothing changed for User from the given sheetname "<SheetName>" and rownumber <RowNum>

    Examples: 
      | SheetName | RowNum |
      | AddUser   |      5 |
