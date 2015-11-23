Feature: Navigating around the board

    In order to navigate around the board 
    As a player
    I want to be able to roll a dice to determine the outcome of movement
    
    Scenario: Rolling a dice at the start of the turn
    
        Given that the game has not been won yet
            And it is my turn
        Then I can roll two 6-sided dice
            And I move equal to the total of the dice faces clockwise around the board
        When I roll doubles, I must roll again after moving
        When I reach the last space (Mayfair), I can pass go
            And I collect £200
        But if I land on "go to jail" square, I must go to the jail space
            And if I land on a tax square, I must pay the amount to the bank
            
            
        
        
        
        
        