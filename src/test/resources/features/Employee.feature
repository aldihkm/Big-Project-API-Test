@Employee
Feature: Employee on OrangeHRM

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User Add Employee
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Add Employee Page
    And i set "Sebastian" as first name and "Vettel" as last name
    Then employee created already added

  @NegativeCase @RegressTest
  Scenario: User cannot Add employee without input mandatory fields
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Add Employee Page
    And i save without input on mandatory fields
    Then user will get error after save data
