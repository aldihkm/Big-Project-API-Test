@Attendance
Feature: User do the Attendance

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User open to Punch In/Out Page
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i click Time button
    And i click Attendance Punch In/Out button
    Then i can see Punch In available

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User do Punch In
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Punch In Page
    And i click Punch In button with "Masuk" as notes
    Then i can notification success Punch In

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User do Punch Out
    Given i on homepage after login with credential "aldihak" as username and "s3Kol4HQA!*" as password
    When i on Punch Out Page
    And i click Punch Out button with "Pulang" as notes
    Then i can see notification success Punch Out
