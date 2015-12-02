package monopoly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Game.java
 * <br/>
 * Represents a monopoly Game
 * @author CO2012_Group19
 *
 */
public class Game {
    public static Board board = new Board();
    public Die die1;
    public Die die2;
    public Map<tokens,Player> players = new HashMap();
    
    /**
     *Holds the tokens
     */
    public enum tokens {DOG, SHIP, SHOE,HAT,THIMBLE,CAR};
    
    
    public static Bank bank;
    public boolean gameOver;

    /**
     * Adds a new player to the player list
     * @param play
     */
    public void addPlayer(Player play) {
        players.put(play.token, play) ;
    }

    /**
     * Returns a player based on the token parameter
     * @param token 
     * @return
     */
    public Player getPlayer(Game.tokens token) {
        return players.get(token);
    }
    
    /**
     * Enables a player to buy the property of it's not already owned
     * @param buyer - the player who wants to buy the property
     */
    public void buy(Player buyer, Square property) {
    	if (buyer.getBalance() >= property.sellPrice) {
    	    if (property.owner == null) {
                buyer.pay(property.sellPrice);
                property.setOwner(buyer);  	
            }
    		
        }
    	
    }
    /**
     * returns the bank of the game object
     * @return
     */
    public static Bank getBank() {
    	return bank; 
    }
}