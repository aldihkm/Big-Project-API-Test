@Directory
Feature: Employee Directory

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User search employee
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on employee directory page
    And i search "Aldi" as employee name
    Then employee that i searched is appear
