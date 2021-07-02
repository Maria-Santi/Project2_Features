Feature: Employees Can Handle Submitted Orders

  Scenario: The Employee can view an orders details
    Given The Employee is on the Order Management Page
    When The Employee click an order from the order table
    Then The Employee can view the details of the order

  Scenario: The Employee can fulfill an order
    Given The Employee is on the Order Management Page
    When The Employee click an order from the order table
    Then The Employee can view the details of the order
    When The Employee clicks the fulfill order button
    Then The Order is fulfilled and removed from the order table

  Scenario: The Employee can logout
    Given The Employee is on the Order Management Page
    When The Employee clicks on the logout button
    Then The Employee is logged out and redirected to the Homepage