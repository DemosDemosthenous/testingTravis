Feature: Navigating around the board

    In order to navigate around the board 
    As a player
    I want to be able to roll a dice to see how many steps to move
    
    Scenario: Rolling a dice at the start of the turn
        Given there is a player car
        And the player car is on GO
		When the player car has rolled 2 and 4
        Then the player car lands on Bow Street square
        
	Scenario: Double roll
		Given there is a player car
		And the player car is on GO
		When the player car has rolled 2 and 2	
		And the player car has rolled 1 and 2
		Then the player car lands on WhiteChapel Road square

	Scenario: Passing go
		Given there is a player hat
		And the player hat is on Mayfair square
		And the player hat has a balance 200
		When the player hat has rolled 1 and 1
		Then the player hat lands on Vine Street square
		And the player hat has a balance of 400
		
	Scenario: Player in jail rolls double
		Given there is a player dog
		And the player dog is in jail
        When the player dog has rolled 2 and 2	
		Then get gets out of jail 
		And the player dog lands on Northumberland Avenue square

	Scenario: Player in jail does not roll a double
		Given there is a player ship
		And the player ship is in jail
		When the player ship has rolled 3 and 2
		Then player ship remains in jail
		
	Scenario: Landing on Go to jail square
	    Given there is a player hat
	    And the player hat is on Bond Street square
	    When the player hat has rolled 2 and 2
	    Then the player hat lands on Go to jail square 
     	And the player moves to the jail square
	    And the player hat is in jail
  
    
            
      
   Scenario: Landing on income tax
	Given the player is on GO
	And the player rolls 4 
	When the player lands on Income tax
	Then the players money decrease by 100
	And the bank balance increases by 100  
        
        
        
        
