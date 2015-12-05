package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

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
    public List<Player> playerList = new ArrayList<>();
    
    public MonopolyDAO dao = new MonopolyDAO(System.getProperty("db_host"),System.getProperty("db_port"),
         System.getProperty("db_user"),System.getProperty("db_name"),System.getProperty("db_pass"));
    
    /**
     *Holds the tokens
     */
    public enum tokens { 
        DOG, SHIP, SHOE, HAT, THIMBLE, CAR 
    };
    
    public static Bank bank;

    /**
     * Adds a new player to the player list
     * @param play
     */
    public void addPlayer(Player play) {
        players.put(play.token, play) ;
        playerList.add(play);
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
     * @throws PropertyAlreadyOwnedException when the property is already owned by someone else
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
    
    public void saveGame() {
        for (int i = 0; i < playerList.size();i++) {
            dao.persistPlayer(playerList.get(i));
        }
    }
}
