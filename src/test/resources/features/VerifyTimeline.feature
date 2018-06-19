Feature: Verify Timeline

  @verifyTimeline @critical
  Scenario: Navigate to dashboard page and see the correct expenses with timeline
    Given I have registered successfully
    When I have added expense with tag
    And I navigated to Dashboard screen and I navigate through days
    Then I see correct   expense with correct time