#Author: pranitha
@login
Feature: Login Validation

  Scenario: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
