Feature: Buying property

In order to buy property
As a player
I want to have a system to identify and buy available property

Scenario: landing on an available property square

    Given that I land on a property square after my movement
        And it is not already owned by another player
        And I have more money than its indicated value
        And it has a unique name
    Then I can pay the bank the indicated value to buy the property
    When the property is bought, my money should decrease by the same value
    
    
    