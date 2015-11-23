Feature: Rent
In order to make income
As a property owner
I want to be able to charge people to spend their turn on my owned square

Scenario: landing on a player-owned property square

    Given that I land on a square that contains a property owned by another player
    Then I must pay the player that owns the square the value of the rent, determined by the number of properties on the square
        But if I am in jail, I cannot earn rent from my own properties
