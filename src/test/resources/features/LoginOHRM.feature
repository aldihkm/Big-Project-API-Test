@Login
Feature: Login Orange HRM

  @NegativeCase @RegressTest
  Scenario Outline: User Failed Login to Orange HRM
    Given i on Login page
    When i input wrong credentials <username> and <password>
    Then error message should appear

    Examples: 
      | username | password    |
      | Admin    | admin       |
      | aadmin   | s3Kol4HQA!* |

  @PositiveCase @RegressTest @SmokeTest
  Scenario: User Login to Orange HRM
    Given i on Login page
    When i input credentials "aldihak" as username and "s3Kol4HQA!*" as password
    Then i go to homepage
