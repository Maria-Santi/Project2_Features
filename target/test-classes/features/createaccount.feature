Feature: User Creates a New Account

  Scenario Outline: Customer creates a new account
    Given The Customer is on the Create Account Page
    When The Customer types "<firstname>" into the first name bar
    When The Customer types "<lastname>" into the last name bar
    When The Customer types "<username>" into the username bar
    When The Customer types "<password>" into the password bar
    When The Customer clicks the login button
    Then The title should be "<title>"
    Examples:
      | firstname | lastname | username | password | title |
      | C | A | test16 | testpass | Git Your Java Customer |
      | C | A | test17 | testpass | Git Your Java Customer |
      | C | A | test18 | testpass | Git Your Java Customer |


  Scenario Outline: The Customer tries to create an account with a taken username
    Given The Customer is on the Create Account Page
    When The Customer types "<firstname>" into the first name bar
    When The Customer types "<lastname>" into the last name bar
    When The Customer types "<username>" into the username bar
    When The Customer types "<password>" into the password bar
    When The Customer clicks the login button
    Then The Customer should still be on the Create Account Page
    Examples:
      | firstname | lastname | username | password |
      | Jordan    | P        | jordanP  | pass     |

