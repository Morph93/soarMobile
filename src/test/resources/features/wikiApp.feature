Feature: Add code points

  @WikiTests
  Scenario: Scroll down and open my list, history and nearby while waiting for three seconds on each page and then go back to home page and scroll up.
    When Scroll down
    And  Open My lists page and wait three seconds
    And  Open History page and wait three seconds
    And  Open Nearby page and wait three seconds
    And  Go back to Home page
    Then Scroll up to the top

  @WikiTests
  Scenario: Click on search bar and Search for New York then validate if results are shown, after that close search bar and return to the Home page.
    When Click search bar
    And  Enter New York
    And  Validate that results are shown
    Then  Click X twice

  @WikiTests
  Scenario: Go to settings and disable all options then go back to home page
    When User opens settings
    And  Disables all options
    Then User goes to the home page

