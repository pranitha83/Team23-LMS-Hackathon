#AuthorVinothini
@ProgramEdit
Feature: Edit New Program

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given Admin is in Home Page
   When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
  #Given Admin is on Manage Program Page
  When Admin clicks <Edit> button on the data table for any row
  # When Admin is on Program Details Popup window to Edit

Scenario: Validate Edit Feature
Then Admin should see a popup open for Program details to edit

Scenario: Edit Program Name
When Admin edits the Name column and clicks save button	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program

Scenario: Edit Program description
When Admin edits the Description column and clicks save button	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program

Scenario: Change Program Status
When Admin changes the Status and clicks save button	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program


Scenario: Validate Cancel button on Edit popup
When Admin clicks <Cancel>button on edit popup	
Then Admin can see the Program details popup disappears and can see nothing changed for particular program

Scenario: Validate Save button on Edit popup
When Admin clicks <Save>button on edit popup	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program


