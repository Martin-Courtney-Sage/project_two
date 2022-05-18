Feature: Users and Managers can login to their profile

  Scenario: Login to profile
    Given The User and Manager is on the Home Page
    When The username and passcode is entered into the fields and the Login button is selected
    Then The User should be on the Profile Page
