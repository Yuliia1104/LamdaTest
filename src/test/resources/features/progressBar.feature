Feature: Progress Bar Percentage Feature

  Scenario: Verify progress bar reaches 100%
    Given I am on the Progress Bar page
    When I start the progress bar
    Then I should see the progress bar reach 100%
    Then I should see the Download completed! message
