@launchAndRegister @critical
Feature: Launch and Register

  Scenario: Swipe launch pages and register
    Given Application is launched succesfully with no login
    When I swipe till login page
    And I set and confirmed my password
    Then I am registered