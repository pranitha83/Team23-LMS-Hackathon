@DeleteUser
Feature: Delete User

Background: Admin is on dashboard page after Login and clicks User on the navigation bar
    Given Admin is on Manage User Page
    #When Admin clicks + A New User button
    #Given Admin is on  User details pop up

  Scenario: Validate row level delete icon
    When Admin clicks the delete icon of the user
    Then Admin should see a alert open with heading Confirm along with YES and NO button for deletion

  Scenario Outline: Click Yes on deletion window
    When Admin clicks the delete icon of the user from the given "<SheetName>" and rownumber <RowNum>
    And Admin clicks yes option on the alert box
    Then Admin gets a message "User Deleted" alert
    And Admin do not see the user from the given "<SheetName>" and rownumber <RowNum> 
  Examples:
   |SheetName|RowNum| 
   |AddUser|4|
   
   Scenario: Click No on deletion window
     When Admin clicks the delete icon of the user
     And Admin clicks No option on the alert box
     Then Admin can see the deletion alert disappears without deleting the user
     
    Scenario: Validate Close(X) icon on Confirm Deletion alert
      When Admin clicks the delete icon of the user
      And Admin clicks on close button
      Then Admin can see the deletion alert disappears without any changes in the user 