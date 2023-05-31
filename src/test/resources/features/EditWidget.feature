Feature: Edit widget

  Background: User Navigates to the Dashboards Page
    Given I navigate to the Dashboards Page
    And I choose a Dashboard
    Then I am on a Dashboard Page

  Rule: Edit widget name

    Scenario Outline: User edits widget to set new valid widget name
      Given Widget is visible
        | type | LAUNCH_STAT            |
        | name | LAUNCH STATISTICS AREA |
      When I press Edit Widget button
      And I enter new widget description "<widgetName>"
      Then Widget description is changed to new description
      And I change widget name to default name "LAUNCH STATISTICS AREA"

      Examples:
        | widgetName             |
        | TST                    |
        | 0123456789             |
        | [$&+,:;=?@#<>.-^*()%!] |
        | randomString           |

  Rule: Edit widget description

    Scenario Outline: User edits widget to set new valid widget name
      Given Widget is visible
        | type | LAUNCH_STAT            |
        | name | LAUNCH STATISTICS AREA |
      When I press Edit Widget button
      And I enter new widget description "<widgetDesc>"
      Then Widget description is changed to new description
      And I change widget description to default
      But Widget description is not visible

      Examples:
        | widgetDesc             |
        | TST                    |
        | 0123456789             |
        | [$&+,:;=?@#<>.-^*()%!] |
        | randomString           |