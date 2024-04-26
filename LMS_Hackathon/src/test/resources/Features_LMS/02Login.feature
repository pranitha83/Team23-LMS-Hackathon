#Author: pranitha
@login
Feature: Login Validation

  Background: Admin is in Home Page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

  Scenario: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
