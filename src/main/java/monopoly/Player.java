package monopoly;

import java.util.List;

import monopoly.Game.tokens;

public class Player {
    public String name;
    public double money;
    public Square position;
    public tokens token;
    public List<Square> properties;

    public Player (tokens token) {
        this.token = token;
    }
    
    public void setLocation(Square location) {
        position = location;
    }

    public void pay(double amount) {
        money = -amount;
    }
    
    public double getBalance() {
        return money;
    }
 
}
