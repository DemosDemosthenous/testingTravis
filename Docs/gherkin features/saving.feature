Feature: Saving the game
In order to allow the game to be played in intervals 
As a developer
I want to develop a database-utilizing savegame feature

Scenario: Saving the game

    Given that the game has started
    Then I can save the game at any time
        And the save file must be given a name
        And the save file is stored in the database
        
Scenario: Loading the game

    Given that a save file exists in the database
    Then I can load the game from the save file
        And the state of the game at the time of saving will be loaded
        