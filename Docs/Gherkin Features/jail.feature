Feature: Jail

In order to manage the jail system
As players of the game
I want a fair and reliable system to be put in and escape jail

Scenario: Going to jail

    Given it is my turn
        And I land on a "go to jail" square
        But I can also move to jail by rolling a third double on my turn
    Then I must go to the jail square, and miss the rest of my turn
        And if I pass go, I do not collect £200
        And I cannot move on my next turn

Scenario: Escaping jail

    Given it is my turn
    When I roll doubles
    Then I can escape jail and move on the next turn
        But if I fail to roll doubles, I miss the turn and can try next turn
    When I pay £50
        Then I can leave jail early
        But if I don't role doubles on three turns, I must pay £50 and be released from jail
        
    
