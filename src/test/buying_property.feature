Feature: Buying property

In order to increase my properties
As a player
I want to be able to buy a property I land on 

Scenario: buy an available property 

   Given a player is using the car
   And the player is on WhiteChapel Road
   And the WhiteChapel Road is not owned
   And the player's money is 559m
   When the player decides to buy the property 
   Then the player's money will decrease by 550m
   And WhiteChapel Road is owned by the player using car


Scenario: not enough money for property

     Given there is a player using car
     And the player is on Oxford street
	 And the player's has 400m 
	 And Oxford Street's value is 550
     When the player tries to buy the property 
     Then the player's money remain 400m
     And owner of the property remains null

Scenario: property owned by another player

	Given there is a player using car
	And the player lands on Oxford street
	And the property is owned by another player using hat
	When the player attempts to buy the property
	Then the car player's money doesn't change
	And the owner of the property does not change

	


 
    
    
    
