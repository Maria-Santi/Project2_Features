Feature: User Login

  Scenario Outline: Customer logs in
    Given The User is on the Login Page
    When The User types "<username>" into the username bar
    When The User types "<password>" into the password bar
    When The User clicks the login button
    Then The title should be "<title>"
    Examples:
      | username | password | title |
      | hellothere | general | Git Your Java Customer |
      | donduck  | pass | Git Your Java Customer |
      | BD | pass | Git Your Java Employee |
      | DB2 | pass | Git Your Java Employee |

  Scenario Outline: Customer fails to log in
    Given The User is on the Login Page
    When The User types "<username>" into the username bar
    When The User types "<password>" into the password bar
    When The User clicks the login button and accepts the alert
    Then The title should be "<title>"
    Examples:
      | username | password | title |
      | hellothere | gener | Login |
      | donduck  | pass3 | Login |
      | BD | pass2 | Login |
      | DB2 | pass4 | Login |