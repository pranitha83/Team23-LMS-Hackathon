#AuthorVinothini
@ProgramDelete
Feature: Delete New Program

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
Given Admin is on Manage Program Page
When Admin clicks <Delete> button on the data table for any row


Scenario: Delete Feature
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

Scenario: Validate details for Confirm Deletion form
Then Admin should see a message "Are you sure you want to delete <Program name>?"

Scenario: Click Yes on deletion window
When Admin clicks <YES> button on the alert	
Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table

Scenario: Click No on deletion window
When Admin clicks <NO> button on the alert	
Then Admin can see the deletion alert disappears without deleting

Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
When Admin clicks Cancel or Close(X) Icon on Deletion alert	
Then Admin can see the deletion alert disappears without any changes

