#Author: Saranya
@AssignStaff123
Feature: User Assign Staff Page

  Background: The Admin is logged in to LMS portal
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    And Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
    Then Admin clicks User button

  Scenario: Validate Assign Staff Popup window
    Given Admin is in manage user page for Staff
    When Admin clicks "Assign Staff" button
    Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

  Scenario: Validate input fields and their text boxes in Assign Staff form
    Given Admin is in manage user page for Staff
    When Admin clicks "Assign Staff" button
    Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes

  Scenario: Validate input fields and their text boxes in Assign Staff form
    Given Admin is in manage user page for Staff
    When Admin clicks "Assign Staff" button
    Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name

  Scenario: Validate radio button in Assign Staff Form
    Given Admin is in manage user page for Staff
    When Admin clicks "Assign Staff" button
    Then Admin should see two radio button for Status

  Scenario: Empty Form Submission
    Given Admin is in manage user page for Staff
    When Admin clicks "Assign Staff" button
    Then Admin gets a Error message alert for assign staff
