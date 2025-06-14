Feature: Verify end-to-end functionality of the saucedemo app

  Scenario: Verify user can add a backpack to the cart and complete the order successfully

    Given browser is open
    When user is on the main page
    And user enters the "Username"
    And user enter the "Password"
    And user clicks the login button
    And user selects item backpack
    Then user selects shopping cart
    Then user selects checkout
    And user enters First Name "Joe"
    And user enters Last Name "Bloggs"
    And user enters Postal Code "OL7 9AP"
    And user clicks continue
    And user clicks finish
