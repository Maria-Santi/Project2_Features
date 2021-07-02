Feature: Customer actions

  Scenario Outline: Customer selects a mood
    Given The Customer is on the customer dashboard
    When The Customer chooses "<mood>"
    Then An item should be added to the order
    Examples:
      | mood |
      | Happy |
      | Sad |
      | Angry |
      | Anxious |
      | Sleepy |

  Scenario Outline: Customer selects a category
    Given The Customer is on the customer dashboard
    When The Customer chooses a "<category>"
    Then The menu is updated with "<category>" items
    Examples:
      | category |
      | Cold Drinks |
      | Hot Drinks |
      | Food |
      | Coffee Beans |
      | Merch |

  Scenario: Customer adds an item to the order
    Given The Customer is on the customer dashboard
    When The Customer adds an item from the menu
    Then The item appears in the order

  Scenario: Customer removes an item from the order
    Given The Customer is on the customer dashboard
    When The Customer adds an item from the menu
    Then The item appears in the order
    When The Customer removes the item
    Then The item disappears from the order

  Scenario: Customer submits an order
    Given The Customer is on the customer dashboard
    When The Customer adds an item from the menu
    Then The item appears in the order
    When The customer clicks the order button
    Then The order is placed and the customer is logged out

  Scenario: Customer updates the quantity of an item
    Given The Customer is on the customer dashboard
    When The Customer adds an item from the menu
    Then The item appears in the order
    When The Customer increments the quantity of the item
    Then The total quantity is incremented

  Scenario: Customer logs out
    Given The Customer is on the customer dashboard
    When The Customer clicks the logout button
    Then The customer is logged out
