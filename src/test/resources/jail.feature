Feature: Jail

In order to follow the rules of the game
As a developer
I want to be able to put players in and out of jail

Scenario: Pay 50 to get out of jail

	Given there is a player hat
		And the player hat is in jail
	    And the player hat has a balance 200
	When the player hat pays to get out of jail
	Then the player hat gets out of jail
	    And the player hat has a balance of 150
		And the player hat is on Jail
		
Scenario: Failing to roll doubles 3 times

	Given there is a player ship
		And the player ship is in jail
	    And the player ship has a balance 250
	    And the player ship has rolled 5 and 4
	    And the player ship has rolled 3 and 1
	When the player ship has rolled 3 and 4
	Then the player ship gets out of jail
	    And the player ship has a balance of 200
		
	
	

        
    
