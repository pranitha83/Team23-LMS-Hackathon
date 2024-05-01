#AuthorVinothini
@Programpagination
Feature: Program Pagination

  Background: Admin is on Manage Program Page after logged in
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    Given Admin is on Manage Program Page 

  #Pagination
  Scenario: Verify Next page link
    When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has "Next" active link

  Scenario: Verify Last page link
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  Scenario: Verify First page link
    Given Admin is on last page of Program table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link

  Scenario: Verify Start page link
    Given Admin is on Previous Program page
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

  # Multipledelete
  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option enabled under header Manage Program

  Scenario: Validate multiple program deletion by selecting Single checkbox
    Given Admin clicks delete button under header after selecting the check box in the data table
    When Admin is on Confirm Deletion alert
    When Admin clicks program deletion YES button on the alert
    Then Admin should land on Manage Program page and can see the selected program is deleted from the data table

  Scenario: Validate multiple program deletion by selecting Single checkbox
    Given Admin clicks delete button under header after selecting the check box in the data table
    When Admin is on Confirm Deletion alert
    When Admin clicks program deletion NO button on the alert
    Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

  Scenario: Validate multiple program deletion by selecting multiple check boxes
    Given Admin clicks delete button under header after selecting multiple checkboxes in the data table
    When Admin is on Confirm Deletion alert
    When Admin clicks program deletion YES button on the alert
    Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table

  Scenario: Validate multiple program deletion by selecting multiple check boxes
    Given Admin clicks delete button under header after selecting multiple checkboxes in the data table
    When Admin is on Confirm Deletion alert
    When Admin clicks program deletion NO button on the alert
    Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table

  #Navigation
  Scenario: Batch link on navigation bar
    When Admin clicks on Batch link on Manage Program page
    Then Admin is re-directed to Batch page

  Scenario: User link on navigation bar
    When Admin clicks on User link on Manage Program page
    Then Admin is re-directed to User page

  Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage Program page
    Then Admin is re-directed to Login page
