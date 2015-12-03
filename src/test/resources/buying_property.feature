Feature: Buying property

    In order to increase my properties
    As a player
    I want to be able to buy a property I land on 

Scenario: property owned by another player

    Given there is a player car
	And the player car has a balance 900 
	And there is a player shoe
	And the player car is on Oxford Street
	And the property Oxford Street is owned by another player using shoe
    When the player car attempts to buy Oxford Street
    Then the owner of Oxford Street is player shoe
	And the player car has a balance of 900

Scenario: not enough money for property

    Given there is a player car
	And the player car is on Bow Street
	And the Bow Street is not owned
	And the player car has a balance 50 
    When the player car attempts to buy Bow Street
    Then the player car has a balance of 50
	And the owner of Bow Street is null	

Scenario: buy an available property 

    Given there is a player car
	And the player car is on WhiteChapel Road
	And the WhiteChapel Road is not owned
	And the player car has a balance 90
    When the player car attempts to buy WhiteChapel Road 
    Then the player car has a balance of 9
	And the owner of WhiteChapel Road is player car
	


 
    
    
    
