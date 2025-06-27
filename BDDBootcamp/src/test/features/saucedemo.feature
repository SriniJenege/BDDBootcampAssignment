Feature: Verify end-to-end functionality of the saucedemo app

  Background:
    Given browser is open
    When  user is on the main page
    And   user enters the "username"
    And   user enter the "password"
    And   user clicks the login button


  Scenario: Verify user can add a backpack to the cart and complete the order successfully

    And user selects item backpack
    Then user selects shopping cart
    Then user selects checkout
    And user enters First Name "Joe"
    And user enters Last Name "Bloggs"
    And user enters Postal Code "OL7 9AP"
    And user clicks continue
    And user clicks finish

    Scenario: Exercise 2 - Verify user can add a bike light to the cart and complete the order successfully

      And user selects Price low to high from the dropdown
      Then user selects item bike-light
      Then user select item fleece-jacket
      Then user selects a shopping cart
      Then remove item fleece-jacket
      Then user selects menu item All items
      Then user select shopping cart
      Then user selects a checkout
      And user enters First Name "Joe"
      And user enters Last Name "Bloggs"
      And user enters Postal Code "OL7 9AP"
      And user clicks continue
      And user checks tax is $0.80
      And user clicks finish



