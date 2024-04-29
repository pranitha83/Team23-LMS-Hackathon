@dashboard
Feature: Dashboard Page

  Background: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

  Scenario: DashboardPage_ Verify after login admin lands on manage program as dashboard page
    Then Admin should see manage program as "Manage Program" header

  Scenario: DashboardPage_Verify the response time
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  Scenario: DashboardPage_Verify broken link
    Then HTTP response >= 400. The link is broken

  Scenario: DashboardPage_Verify LMS title
    Then Admin should see "LMS - Learning Management System"  as title

  Scenario: DashboardPage_Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  Scenario: DashboardPage_Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  Scenario: DashboardPage_Validate LMS title has correct spelling and space
    Then Admin should see correct spelling and space in LMS title

  Scenario: DashboardPage_Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side

  Scenario: DashboardPage_Validate navigation bar order 1st Program
    Then Admin should see program in the 1st place

  Scenario: DashboardPage_Validate navigation bar order 2nd Batch
    Then Admin should see batch in the 2nd place

  Scenario: DashboardPage_Validate navigation bar order 3rd User
    Then Admin should see user in the 3rd place

  Scenario: DashboardPage_Validate navigation bar order 4th Logout
    Then Admin should see logout in the 4th place

  Scenario: Verify data table on the Program page
    Then Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete)

  Scenario: Verify Sort arrow icon on the data table
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  Scenario: Verify Check box on the data table
    Then Admin should see check box on the left side in all rows of the data table

  Scenario: Verify Edit and Delete buttons
    Then Admin should see the Edit and Delete buttons on each row of the data table

  Scenario: Verify Search bar on the Program page
    Then Admin should see Search bar with text as "Search..."

  Scenario: Validate that number of records (rows of data in the table) displayed
    Then Admin should see the number of records (rows of data in the table) displayed on the page are 5

  Scenario: Validate Add New Program
    Then Admin should see a "A New Program" button with plus icon on the program page above the data table

  Scenario: Validating the default state of Delete button
    Then Admin should see a Delete button on the top left hand side as Disabled

  Scenario: DashboardPage_Verify Logout button function
    Given Admin is in dashboard page
    When Admin click Logout button on navigation bar
    Then Admin should land on login in page
