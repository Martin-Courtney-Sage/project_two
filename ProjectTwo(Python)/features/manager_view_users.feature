Feature: Manager can view all Users

  Scenario: Manger views all Users
    Given The Manager is on their Profile Page
    When The Manager clicks on the View Users button
    Then The Manager can see all the Users registered with the application
