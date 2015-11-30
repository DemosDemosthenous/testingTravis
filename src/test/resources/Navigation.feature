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
		And the player hat is on Mayfair
		And the player hat has a balance 300
		When the player hat has rolled 3 and 2
		Then the player hat lands on Marylebone Station square
		And the player hat has a balance of 500
		
	Scenario: Player in jail rolls double
		Given there is a player dog
		And the player dog is in jail
        When the player dog has rolled 2 and 2	
		Then the player dog gets out of jail 
		And the player dog lands on Northumberland Avenue square

	Scenario: Player in jail does not roll a double
		Given there is a player ship
		And the player ship is in jail
		When the player ship has rolled 3 and 2
		Then player ship remains in jail
		
	Scenario: Landing on Go to jail square
	    Given there is a player hat
	    And the player hat is on Strand
	    When the player hat has rolled 1 and 2 
        Then the player hat lands on Jail square
	    And the player hat is in jail
  
    
    Scenario: Landing on super tax
    	Given there is a player shoe
     	And the player shoe is on Oxford Street
	    And the player shoe has a balance 300
	    When the player shoe has rolled 1 and 2 
	    Then the player shoe lands on Super Tax square
	    And the player shoe has a balance of 100
	  
    Scenario: Landing on income tax
    	Given there is a player shoe
     	And the player shoe is on GO
	    And the player shoe has a balance 300
	    When the player shoe has rolled 1 and 2 
	    Then the player shoe lands on Income Tax square
	    And the player shoe has a balance of 200  
        
        
        
