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

    @loginCredientialsFromExcel
    
    Scenario Outline: Validate login with valid credentials from Excel
    Given Admin is in Home Page
    When Admin enter valid credentials fromgiven sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button
    Then Admin should land on dashboard page
    
    Examples:
|sheetName|rowNo|
|Login|0|