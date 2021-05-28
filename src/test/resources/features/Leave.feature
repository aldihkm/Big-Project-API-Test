@Leave
Feature: Leave OHRM Page

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User add Leave Entitlement
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Add Leave Entitlement page
    And i Add Leave Entitlement with "Aldi" as name and "1.00" as Entitlement
    Then Leave should already added

  @NegativeCase @RegressTest
  Scenario: User add Leave Entitlement without input name and entitlement
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Add Leave Entitlement page
    And i not input name and Entitlement
    Then i should get an error message

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User request Leave
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Assign Leave page
    And i add leave with "Aldi" as name
    And i set leave "2021-07-16" as From Date and "2021-07-16" as To Date
    Then leave should added

  @NegativeCase @RegressTest
  Scenario: User request Leave without input mandatory fields
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Assign Leave page
    And i request leave without input any fields
    Then i failed to request leave

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User see their leave request
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Leave List page
    And search "Aldi" as name
    Then i can see my leave lists
