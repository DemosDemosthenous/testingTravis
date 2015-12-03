Feature: Rent

    In order to make income
    As a property owner
    I want to be able to charge people who land on my property

Scenario: Landing on a player-owned property square

    Given player iron owns Bond street
        And there is a player boot
    When player boot lands on Bond street
    Then the player boot's money decreases by Bond street's rent value
        And the player iron's money increases by the Bond street's rent value
	
Scenario: Landing on an unowned property

    Given Bond Street is unowned
        And player car lands on it
    Then player car's money remain the same
	

	
