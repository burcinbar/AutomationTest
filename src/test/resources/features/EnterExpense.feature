Feature: Enter expense

  @enterexpense @critical
  Scenario: Select one of the tags and enter expense
    Given I have registered successfully
    When I select one of the tags
    And I enter the amount of expense
    Then I have added expense

#
#  @ignore @launchAndRegister @critical
#  Feature: Dashboard screen shows the exact expense
#
#  Scenario: Navigate to dashboard page and see the expense added
#    Given I have registered successfully
#    When I have added expense with tag
#    And I navigated to Dashboard screen
#    Then I see correct expense with correct tag
#
#
#  @ignore @launchAndRegister @critical
#  Feature: Dashboard screen shows expenses in timeline
#
#  Scenario: Navigate to dashboard page and see the correct expenses with timeline
#    Given I have registered successfully
#    When I have added expense with tag
#    And I navigated to Dashboard screen and I navigate through days
#    Then I see correct expense with correct time