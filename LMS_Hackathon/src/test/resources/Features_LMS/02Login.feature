#Author: pranitha
@2
Feature: Login Validation

  Background: Admin is in Home Page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

  Scenario: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

  Scenario Outline: Validate login with  username as null
    Given Admin is in Home Page
    When Admin enter only password from given sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button
    Then Admin should see Error message "please check username/password"

    Examples: 
      | sheetName | rowNo |
      | Login     |     0 |

  Scenario Outline: Validate login with  password as null
    Given Admin is in Home Page
    When Admin enter password null from given sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button
    Then Admin should see Error message "please check username/password"

    Examples: 
      | sheetName | rowNo |
      | Login     |     1 |

  Scenario Outline: Validate login with  invalid credentials
    Given Admin is in Home Page
    When Admin enter invalid credentials from given sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button
    Then Admin should see Error message please check username/password

    Examples: 
      | sheetName | rowNo |
      | Login     |     2 |

  Scenario Outline: Validate login with valid credentials from Excel
    Given Admin is in Home Page
    When Admin enter valid credentials fromgiven sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | sheetName | rowNo |
      | Login     |     3 |

  Scenario Outline: verify login button action through keyboard
    Given Admin is in Home Page
    When Admin enter valid credentials fromgiven sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button through keyboard
    Then Admin should land on dashboard page

    Examples: 
      | sheetName | rowNo |
      | Login     |     3 |

  Scenario Outline: verify login button action through mouse
    Given Admin is in Home Page
    When Admin enter valid credentials fromgiven sheetname "<sheetName>" and rowNumber <rowNo> and clicks login button through mouse
    Then Admin should land on dashboard page

    Examples: 
      | sheetName | rowNo |
      | Login     |     3 |
