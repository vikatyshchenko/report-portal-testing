Feature:  Add new widget

  Background: User Navigates to the Dashboards Page
    Given I navigate to the Dashboards Page
    When I choose a Dashboard
    Then I am on a Dashboard Page

  Scenario Outline: User can add new widget
    When I create new Widget
      | type | <widgetType> |
      | name | <widgetName> |
    Then New widget is created and visible on a Dashboard Page
    And I delete widget

    Examples:
      | widgetType        | widgetName         |
      | LAUNCH_STAT       | Launch statistics  |
      | LAUNCH_DURATION   | Launch duration    |
      | OVERALL_STAT      | Overall statistics |
      | FAILED_CASE_TREND | Failed case trend  |