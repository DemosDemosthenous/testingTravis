Feature: Buying property

In order to increase my properties
As a player
I want to be able to buy a property i land on 

Scenario: buy an available property 

    Given that I land on a property square after my movement
        And it is not already owned by another player
        And my money equals or is greater than the property's indicated value
   When i decide to buy the property 
   Then my money will decrease by the property value
   And the bank balance will increase by the property's value  
   And the number of my properties increases


Scenario: not enough money for property

     Given that I land on a property square after my movement
        And it is not already owned by another player
	And my money is less than the property's value   
     When i decide to buy the property 
     Then the message "You don't have enough money for that property" is displayed
     And owner of the property remains null

Scenario: property owned by another player

	Given that i land on a property square after my movement
	And the property is owned by another player 
	When I attempt to buy the property
	Then the message "Property is already owned" is displayed
	And owner of the property does not change

	


 
    
    
    
