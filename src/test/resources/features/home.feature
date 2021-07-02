Feature: The User Navigates the Home Page

  Scenario: The User navigates to the Login Page
    Given The User is on the Home Page
    When The User clicks on the login link
    Then The User should be on the Login Page

  Scenario: The User navigates to the Create Account Page
    Given The User is on the Home Page
    When The User clicks on the create account link
    Then The User should be on the Create Account Page


