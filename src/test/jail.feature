Feature: Jail

    In order to follow the rules of the game
    As a developer
    I want to be able to put players in and out of jail

Scenario: Going to jail

    Given the player is on Pall Mall square
    When the player rolls 6
    Then the player goes to Jail square
        And the player is imprisoned

Scenario: Pay 50 to get out of jail

    Given the player is imprisoned
    When the player pays 50
    Then the player gets out of jail
        And the players money decreases by 50
	And the bank balance increases by 50

Scenario: Failing to roll doubles 3 times

    Given the player is imprisoned
        And the player rolls 9(5,4)
        And the player rolls 4(3,1)
    When the player rolls 7(3,4)
    Then the player gets out of jail
        And the players balance decreases by 50
        And the money in the bank increase by 50
	

        
    
