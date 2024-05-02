#Author: Saranya
@AssignStudent
Feature: User Page

  Background: The Admin is logged in to LMS portal
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    And Admin enter valid credentials  and clicks login button
    And Admin should land on dashboard page
    And Admin clicks User button
    Then Admin should see a pop up open for user details

  @1
  Scenario: Validate Assign Student Popup window
    Given Admin is in manage user page
    When Admin clicks User button
    Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

  Scenario: Validate input fields and their text boxes in Assign Student form
    Given Admin is in manage user page
    When Admin clicks Assign Student button
    Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.

  @3
  Scenario: Validate Dropdown in Assign Student Form
    Given Admin is in manage user page
    When Admin see Assign Student Email Id (no need i guess)
    Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name

  @4
  Scenario: Validate radio button in Assign Student Form
    Given Admin is in manage user page
    When Admin clicks Assign Student Program Name
    Then Admin should see two radio button for Status

  @5
  Scenario: Empty Form Submission
    Given Admin is in Assign Student details pop up page
    When Admin clicks "Save" button with entering any data
    Then Admin gets a Error message alert

  @6
  Scenario: Validate the Assign Student form page without giving Student Email id
    Given Admin is in Assign Student details pop up page
    When Admin clicks "Save" button without entering Student Email id
    Then Admin gets a Error message alert as "Student Email id is required"

  @7
  Scenario: Validate the Assign Student form page without selecting Program
    Given Admin is in Assign Student details pop up page
    When Admin clicks "Save" button without selecting program
    Then Admin gets a Error message alert as "Program is required"

  @8
  Scenario: Validate the Assign Student form page without selecting batch
    Given Admin is in Assign Student details pop up page
    When Admin clicks "Save" button without selecting batch
    Then Admin gets a Error message alert as "Batch is required"

  @9
  Scenario: Validate the Assign Student form page without giving Status 9
    Given Admin is in Assign Student details pop up page
    When Admin clicks "Save" button without giving status
    Then Admin gets a Error message alert as "Status is required"

  @10
  Scenario: Validate Cancel/Close(X) icon on Assign Student form 10
    Given Admin is in Assign Student details pop up page
    # When Admin clicks Cancel/Close(X) Icon on Assign Student form
    Then Assign Student popup window should be closed without saving

  @11
  Scenario: Validate Save button on Assign Student form 11
    #Given Admin is in Assign Student details pop up page
    When Enter all the required fields with valid values and click Save button
    Then Admin gets a message "Successfully Student Assigned" alert

  @12
  Scenario: Validate Cancel button on Assign Student form 12
    #Given Admin is in Assign Student details pop up page
    When Admin clicks Cancel button
    Then Admin can see the Assign Student popup disappears without assigning
