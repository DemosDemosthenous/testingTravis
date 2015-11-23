Feature: Becoming a player

In order to be represented in the game
As a player
I want to have a unique identifier so I know who I am.

Scenario: Choosing my play piece

    Given that there at least 2 players participating
        And there are no more than 8 players participating
    Then I can choose my unique game counter
        And I can assign a unique name to myself