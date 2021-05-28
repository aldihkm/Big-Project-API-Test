@Admin
Feature: Admin OrangeHRM

  @PositiveCase @RegressTest @SmokeTest
  Scenario: Admin able to Add User
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on add user page
    And i set "Nana" as employee name and "testnw" as username
    Then user should added

  @NegativeCase @RegressTest
  Scenario: Admin not able to Add User if not input mandatory fields
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on add user page
    And i directly click save
    Then user cannot save
