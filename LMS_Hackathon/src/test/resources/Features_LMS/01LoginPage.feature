#Author: pranitha
@login
Feature: LoginPage Validation

  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page


  Scenario: Verify admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  Scenario: Verify the company logo
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see logo on the left  side

  Scenario: Verify application name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see  "LMS - Learning Management System"

  Scenario: Verify company name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name

  Scenario: Validate sign in content
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see Please login to LMS application

  Scenario: Verify text field is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see two text field

  Scenario: Verify text on the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "user" in the first text field

  Scenario: Verify asterik next to user text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to user text

  Scenario: Verify text on the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "password" in the second text field

  Scenario: Verify asterik next to password text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to password text

   

