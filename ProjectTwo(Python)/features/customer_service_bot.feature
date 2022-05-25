Feature: Customer Service Bot

  Scenario: Users and Managers can access the Customer Service Bot on Customer Center Page
    Given The Users and Managers are on Customer Center Page
    When The Customer Service Bot button is selected
    Then The chat box will show, and interaction with the bot can occur

  Scenario: Users and Managers can input information to the Customer Service Bot
    Given The chat box is showing
    When The user selects inside the input field, they can type information that will be sent to the Customer Service Bot
    Then The Customer Service Bot will read the information

  Scenario: Customer Service Bot can direct users based on inputted information
    Given The Customer Service Bot is active
    When The bot receives information from the user input field, and reads the designated keywords from the input
    Then The bot will generated an automated response that will suggest the direction that that individual shall take

