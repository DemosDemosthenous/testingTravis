Feature: Saving and loading the game

In order to pause and continue my game later
As a player
I want to be able to save and load my game

Scenario: Saving the players of the game
    
    Given there is a player hat 
    And there is a player car
    When the game is saved
    Then the player hat has has an id
    And the player car has an id
	

