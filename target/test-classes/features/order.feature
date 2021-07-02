Feature: Employees Can Handle Submitted Orders

  Scenario: The Employee can view an orders details
    Given The Employee is on the Order Management Page
    When The Employee select the order table
    Then The Employee can view the details of the order
    When The Employee click an order from the order table
 #   When The Employee marks the order as fulfilled
#    Then The Order disappears from the Order table
