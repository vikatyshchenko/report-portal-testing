Feature:  Add new widget

  Background: User Navigates to the Dashboards Page
    Given User can navigate to the Dashboards Page
    And User have chosen a Dashboard

  Scenario Outline: User can add new widget
    Given User is on a Dashboard Page
    When User creates new Widget
      | type | <widgetType> |
      | name | <widgetName> |
    Then New widget is created and visible on a Dashboard Page
    And Widget can be deleted

    Examples:
      | widgetType        | widgetName         |
      | LAUNCH_STAT       | Launch statistics  |
      | LAUNCH_DURATION   | Launch duration    |
      | OVERALL_STAT      | Overall statistics |
      | FAILED_CASE_TREND | Failed case trend  |