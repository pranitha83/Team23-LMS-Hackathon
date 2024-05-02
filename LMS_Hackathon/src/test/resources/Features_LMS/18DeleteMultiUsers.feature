@DeleteMultiUser
Feature: Delete Multiple User

Background: Admin is on dashboard page after Login and clicks User on the navigation bar
    Given Admin is on Manage User Page

  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    When Admin clicks any checkbox in the data table of the users
    Then Admin should see common delete option enabled under header Manage User

  Scenario Outline: Validate multiple program deletion by selecting Single checkbox
    When Admin select the check box of the user from the given "<SheetName>" and rownumber <RowNum> 
    And Admin click common delete button of the manage user page
    And Admin clicks yes option on the alert box
    Then Admin can see the selected user is deleted from the data table
    Examples:
   |SheetName|RowNum| 
   |AddUser|4|
   
  Scenario Outline: Validate multiple program deletion by selecting Single checkbox
    When Admin select the check box of the user from the given "<SheetName>" and rownumber <RowNum> 
    And Admin click common delete button of the manage user page
    And Admin clicks No option on the alert box
    Then Admin can see the selected user is from the given "<SheetName>" and rownumber <RowNum> not deleted from the data table   
     Examples:
   |SheetName|RowNum| 
   |AddUser|3|
   
  Scenario: Validate multiple program deletion by selecting multiple check boxes
    When Admin selects the multiple checkboxes on the manage user page
    And Admin click common delete button of the manage user page
    And Admin clicks yes option on the alert box
    Then Admin should land on Manage User page and can see the selected users are deleted from the data table
    
   Scenario: Validate multiple program deletion by selecting multiple check boxes
     When Admin selects any multiple checkboxes on the manage user page 
     And Admin click common delete button of the manage user page
     And Admin clicks No option on the alert box
     Then Admin should land on Manage User page and can see the selected users are not deleted from the data table  