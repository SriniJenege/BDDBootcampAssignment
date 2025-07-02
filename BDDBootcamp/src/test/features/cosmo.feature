Feature: Verify whether primary language is spanish in Argentina

  Scenario: Excercise - 3, Table check is primary language is Spanish in Argentia

    Given New browser is open
    When user is on the main landing page
    And checks "Spanish" is spoken in "Argentina"
