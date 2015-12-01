Feature: Becoming a player

In order to identify myself on board
As a player
I want to have a unique token


Scenario: Players are less than 2
	Given the number of players is less than two
	When the game starts
	Then the message "You need more players!" is displayed
	And a new player is created


Scenario: The  number of players is at most 8

	Given the number of players is at most 8
	When a new player tries to join
	Then the message "There's too many players" is displayed
	And no new player is created


	
   
