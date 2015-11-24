Feature: Navigating around the board

    In order to navigate around the board 
    As a player
    I want to be able to roll a dice to see how many steps to move
    
    Scenario: Rolling a dice at the start of the turn
    
        Given the player is on GO
	When the player rolls 6
        Then the player should land on the angel Islington square
        
      


  Scenario: Landing on Go to jail square
	Given the player is on Leicester square
	When the player rolls 4
	Then should land on go to jail square 
	And the player move to the jail square


       
  Scenario: Passing go
	Given the player is on Mayfair
	When the player rolls 2
	Then the player lands Old Kent Road
	And the players money will increase by 200


   Scenario: Landing on income tax
	Given the player is on GO
	And the player rolls 4 
	When the player lands on Income tax
	Then the players money decrease by 100
	And the bank balance increases by 100

  
  Sceanrio: Double roll
	Given the player is on Free parking square
	When the player has rolled 3(1,2)	
	And the player has rolled 4(2,2)
	Then theplayer lands on Coventry Street

  Scenario: Player in jail rolls double
	Given the player is in jail 
	When the player rolls 6(3,3)
	Then he moves to  Bow Street square

  Scenario: Player in jail does not roll a double
	Given the player is in jail
	When the player rolls 5 (2,3)
	The player remains in jail


	
  
    
            
        
        
        
        
        
