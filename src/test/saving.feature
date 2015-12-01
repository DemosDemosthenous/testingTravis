Feature: Saving and loading the game

In order to pause and continue my game later
As a player
I want to be able to save and load my game

Scenario: Saving the board state

	Given that the game has started
	And there are 5 players on board
	When I save the game
	Then the state of the board should be in the database
	
Scenario: Storing Player position

	Given player boot is on Mayfair
	When I save the game 
	Then the state of player boot is saved to the database
	
Scenario: Storing Player properties

	Given player iron has 3 properties
	When I save the player iron's state
	Then the state of the player iron is stored to database
	

Scenario: Loading the board state
	
	Given the state of the board is in the database
	And there are 5 people on board
	When I loaded the board state
	Then the board must have 5 players on it
		
Scenario: Loading player position

	Given the state of player boot is save on the database
	When I load player boot's state from database
	Then player boot should be located on Mayfair
	
Scenario: Loading player properties

	Given the state of player iron is on database
	When I load player iron's state 
	Then player iron should own 3 properties
