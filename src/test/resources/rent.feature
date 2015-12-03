Feature: Rent

    In order to make income
    As a property owner
    I want to be able to charge people who land on my property

Scenario: landing on a player-owned property square
    Given there is a player ship
	And player ship owns Bond Street
	And the player ship has a balance 500
	And there is a player shoe
	And the player shoe has a balance 400
    When the player shoe has landed on Bond Street
    Then the player ship has a balance of 528
	And the player shoe has a balance of 372
	
Scenario: landing on an unowned property
    Given there is a player dog
	And the Bond Street is not owned
	And the player dog has a balance 300
    When the player dog has landed on Bond Street
    Then the player dog has a balance of 300 
	

	
