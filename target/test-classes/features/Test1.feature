
Feature: Amazon test

  Scenario: Search amazon products
  	Given Open chrome browser and launch google site
    And search for amazon on google
    When I enter product on amazon search box
    And click on search button
    Then I validate that products are listed
    And User enters Credentials to LogIn
    | testuser_1 | Test@153 |

  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |