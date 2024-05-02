#Author: Vidya
@User
Feature: User

  Background: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin gives the correct LMS portal URL
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

  Scenario: Sort user by id Ascending Order
    Given Admin is on the Manage User Page
    When Admin clicks on the ID sort icon
    Then Admin should see User details are sorted by id Ascending Order

  Scenario: Sort user by id Descending Order
    Given Admin is on the Manage User Page
    When Admin clicks on ID sort icon button twice
    Then Admin should see User details are sorted by id Descending Order

  Scenario: Sort user by name Ascending Order
    Given Admin is on the Manage User Page
    When Admin clicks on name sort icon
    Then Admin should see User details are sorted by name Ascending Order

  Scenario: Sort user by name Descending Order
    Given Admin is on the Manage User Page
    When Admin clicks on name sort icon button twice
    Then Admin should see User details are sorted by name Descending Order

  Scenario: Sort user by Location Ascending Order
    Given Admin is on the Manage User Page
    When Admin clicks on Location sort icon
    Then Admin should see User details are sorted by Location Ascending Order

  Scenario: Sort user by Location Descending Order
    Given Admin is on the Manage User Page
    When Admin clicks on Location sort icon twice
    Then Admin should see User details are sorted by Location Descending Order

  Scenario: Sort user by Phone number Ascending Order
    Given Admin is on the Manage User Page
    When Admin clicks on Phone number sort icon
    Then Admin should see User details are sorted by Phone number Ascending Order

  Scenario: Sort user by Phone number Descending Order
    Given Admin is on the Manage User Page
    When Admin clicks on Phone number sort icon twice
    Then Admin should see User details are sorted by Phone number Descending Order
