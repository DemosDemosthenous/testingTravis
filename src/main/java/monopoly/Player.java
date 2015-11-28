package monopoly;

import java.util.List;

import monopoly.Game.tokens;

public class Player {
    public String name;
    public int money;
    public Square position;
    public tokens token;
    public List<Square> properties;
    public boolean inJail = false;
    
    public Player (tokens token) {
        this.token = token;
    }
    
    public void setLocation(Square location) {
    	position = location;
    }

    public void pay(int amount) {
        money = money - amount;
    }
    
    public int getBalance() {
        return money;
    }
    
    public void setInJail(){
    	inJail = true;
    	position = Game.board.getLocationByName("Jail");
    }
 
    public void getOutOfJail(int die1, int die2){
    	if (die1 == die2)
    		inJail = false;
    }
    
    public void passGO(){
    	money = money+200;
    }
    
}
