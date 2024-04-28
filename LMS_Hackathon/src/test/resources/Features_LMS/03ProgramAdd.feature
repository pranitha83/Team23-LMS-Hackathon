#AuthorVinothini
@Program
Feature: Add New Program

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given Admin is in Home Page
   When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    #Then Admin should land on dashboard page
   Given Admin is on Manage Program Page
   When Admin clicks <A New Program>button


Scenario: Validate Program Details Popup window
Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

Scenario: Validate input fields and their text boxes in Program details form 
Then Admin should see two input fields and their respective text boxes in the program details window

Scenario: Validate radio button for Program Status 
Then Admin should see two radio button for Program Status

Scenario: Empty form submission
Then Admin clicks <Save>button without entering any data
And Admin gets a Error message alert 

Scenario: Enter only Program Name
Then Admin enters only<Program Name> in text box and clicks Save button
And Admin gets a message alert Description is required

Scenario: Enter only Program Description
Then Admin enters only<Program description> in text box and clicks Save button
And Admin gets a message alert Name is required

Scenario: Select Status only
Then Admin selects only Status and clicks Save button
And Admin gets a message alert Name and Description required


Scenario: Validate invalid values on the name text column
Then Admin enters only numbers or special char in name  column 
And Admin gets a special char Error message alert for name column  

Scenario: Validate invalid values on the desc text column
Then Admin enters only numbers or special char in desc column 
And Admin gets a special char Error message alert for desc column 

Scenario: Validate Cancel/Close(X) icon on Program Details form
Then Admin clicks Cancel or Close(X) Icon on Program Details form 
And Program Details popup window should be closed without saving 

 Scenario Outline: Validate Save button on Program Details form
Then Enter all the required fields with valid values in given sheetname "<sheetName>" and rowNumber <rowNo> and then click Save button 
And Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table

  Examples:
|sheetName|rowNo|
|ProgramPage|0|

Scenario: Validate Cancel button on Program Details form
Then Admin clicks <Cancel>button 
And Admin can see the Program details popup disappears without creating any program








