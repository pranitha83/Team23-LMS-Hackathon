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

  Scenario: DashboardPage_Verify Logout button function
    Given Admin is in dashboard page
    When Admin click Logout button on navigation bar
    Then Admin should land on login in page
