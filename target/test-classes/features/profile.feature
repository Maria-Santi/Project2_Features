Feature: Multiple Customer Orders Should Be Supported

  Background: The Customer is on the Customer Profile Page
    Given Customer is on the Customer Profile Page


  Scenario: The Customer is on the Customer Profile Page 1
    When I click on the Mood button
#    Then A drop down list of  All Moods should appear
#    When I Select on a Mood
#    Then I should see a recommendation on the recommendations table based on the mood
#    When I Select an Item from the Recommendations table
#    When I click on Delete
#    Then The Item should be Removed
#    When I enter a number into quantity field for a recommendation
#    Then The price value should change based on the quantity
#
#
#    Scenario: The Customer is On The Customer Profile Page 2
#      When I click on a Category from the drop down list
#      Then The Menu should be sorted by that category
#      When I click on the Add button for an Item
#      Then The Item should be added to my Orders
#
#
#
#  Scenario: The Customer is on The Customer Profile Page 3
#    When I click on the Order button
#    Then I should see all my orders
#    When I click on Submit
#    Then I should see an alert with pickup time and thank you message
#    Then I should be redirected to the Coffee Shop Home Page