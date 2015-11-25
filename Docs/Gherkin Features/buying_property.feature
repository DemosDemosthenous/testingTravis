Feature: Buying property

In order to increase my properties
As a player
I want to be able to buy a property I land on 

Scenario: buy an available property 

    Given that the player lands on a property square 
        And the property is not already owned by another player
        And the player's money equals or is greater than the property's indicated value
   When the player decides to buy the property 
   Then the player's money will decrease by the property's value
   And the bank balance will increase by the property's value  
   And the number of the player's properties increases by 1


Scenario: not enough money for property

     Given that the player lands on a property square
        And it is not already owned by another player
	And the player's money is less than the property's value   
     When the player decides to buy the property 
     Then the message "You don't have enough money for that property" is displayed
     And owner of the property remains null

Scenario: property owned by another player

	Given that the player lands on a property square after my movement
	And the property is owned by another player 
	When the player attempts to buy the property
	Then the message "Property is already owned" is displayed
	And the owner of the property does not change

	


 
    
    
    
