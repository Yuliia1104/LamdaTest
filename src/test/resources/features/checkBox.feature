Feature: CheckBox Feature

  Scenario: Verify checkbox is clicked
    Given I am on the CheckBox page
    When I click on checkbox
    Then I should see a message Checked
