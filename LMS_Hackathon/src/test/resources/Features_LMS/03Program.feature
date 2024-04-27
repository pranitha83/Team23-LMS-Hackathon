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
And Admin gets a message alert 'Description is required'

Scenario: Enter only Program Description
Then Admin enters only<Program description> in text box and clicks Save button
And Admin gets a message alert 'Name is required'

Scenario: Select Status only
Then Admin selects only Status and clicks Save button
And Admin gets a message alert 'Name and Description required'






