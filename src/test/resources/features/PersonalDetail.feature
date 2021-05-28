@PersonalDetail
Feature: Personal Detail Information

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User able to Edit Personal Detail
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on My Info Page
    And set "Niki" as Middle Name and "12345" as license number
    And set "Passport" as other id and "2025-09-09" as license expiry date
    Then user able to edit personal detail
