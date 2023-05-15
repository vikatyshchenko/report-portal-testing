Feature: Edit widget

  Background: User Navigates to the Dashboards Page
    Given User can navigate to the Dashboards Page
    And User have chosen a Dashboard

  Rule: Edit widget name
    Background:
      Given User is on a Dashboard Page

    Scenario Outline: User edits widget to set new valid widget name
      Given Widget is visible
        | type | LAUNCH_STAT            |
        | name | LAUNCH STATISTICS AREA |
      When User presses Edit Widget button
      And enters new name "<widgetName>"
      Then widget name is changed to new name
      And can be changed to default name "LAUNCH STATISTICS AREA"

      Examples:
        | widgetName             |
        | TST                    |
        | 0123456789             |
        | [$&+,:;=?@#<>.-^*()%!] |
        | randomString           |

  Rule: Edit widget description
    Background:
      Given User is on a Dashboard Page

    Scenario Outline: User edits widget to set new valid widget name
      Given Widget is visible
        | type | LAUNCH_STAT            |
        | name | LAUNCH STATISTICS AREA |
      When User presses Edit Widget button
      And enters new description "<widgetDesc>"
      Then widget description is changed to new description
      And can be changed to default description
      But widget description is not visible

      Examples:
        | widgetDesc             |
        | TST                    |
        | 0123456789             |
        | [$&+,:;=?@#<>.-^*()%!] |
        | randomString           |