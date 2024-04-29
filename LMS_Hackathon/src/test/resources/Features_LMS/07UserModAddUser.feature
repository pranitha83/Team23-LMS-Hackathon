
Feature: Add new User

Background: Admin is on dashboard page after Login and clicks User on the navigation bar
    Given Admin is on Manage User Page
    When Admin clicks + A New User button
    Given Admin is on  User details pop up
     
  Scenario: Validate User Details Popup window
    Then Admin should see pop up window for user details 

  Scenario: Validate input fields and text boxes in user details form
     Then Admin should see text boxes for the fields 
          
  Scenario: Validate drop downs in new user form
     Then Admin should see drop downs for the fields User Role, Role status, Visa status 
#bug 
  Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
     When Admin fills mandatory fields in the form from the given sheetname "<SheetName>" and rownumber <RowNum>
     And Admin clicks submit
     Then Admin gets message "User added Successfully" 
   Examples:
   |SheetName|RowNum| 
   |AddUser|0|
        
  Scenario Outline: Check if user is created when only optional fields are entered with valid data
     When Admin fills optional fields in the form from the given sheetname "<SheetName>" and rownumber <RowNum>
     And Admin clicks submit
     Then Admin should see error message below the mandatory fields and the field will be highlighed in red color
  Examples:
   |SheetName|RowNum| 
   |AddUser|1|
          
  Scenario Outline: check if user is created when invalid data is entered in all of the fields
     When Admin fills invalid data in all of the fields from the given sheetname "<SheetName>" and rownumber <RowNum>
     And Admin clicks submit
     Then Admin gets error message and user is not created
  Examples:
   |SheetName|RowNum| 
   |AddUser|2|   
  
  Scenario: Empty form submission
     When Admin clicks on submit button without entering data 
     Then user will not be created and Admin gets error message below all the fields
     
  Scenario: Validate Cancel/Close(X) icon on User Details form
     When Admin clicks Cancel Icon on User Details form
     Then User Details popup window should be closed without saving
  
  Scenario: Validate Cancel button on User Details form
     When Admin clicks Cancel Icon on User Details form
     Then Admin can see the User details popup disappears without adding any user
     
  Scenario Outline: Check if the user details are added in data table
     When Fill in all the fields with valid datas from the given sheetname "<SheetName>" and rownumber <RowNum>
     And Admin clicks submit
     Then The newly added user from the excel with sheetname "<SheetName>" and rownumber <RowNum> should be present in the User page
  Examples:
   |SheetName|RowNum| 
   |AddUser|3|
   #|AddUser|4|
   |AddUser|5|                   
        
            
 
