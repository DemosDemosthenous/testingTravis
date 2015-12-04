package monopoly;

import java.util.ArrayList;
import java.util.List;

import monopoly.Game.tokens;

/**
 * Player.java
 * <br/>
 * Represents a monopoly player
 * @author CO2012_Group19
 *
 */
public class Player {
	
	/**
	 * Player's name
	 */
    public String name;
    /**
     * Player's money
     */
    public int money;
    /**
     * Player's current position
     */
    public Square position;
    
    /**
     * The token representing the player
     */
    public tokens token;
    /**
     * The players properties
     */
    public List<Square> properties = new ArrayList<Square>();
    /**
     * Keeps track of whether the player is in jail
     */
    public boolean inJail = false;
    
    /**
     * Player constructor that creates a player and sets the token
     * @param token
     */
    public Player (tokens token) {
        this.token = token;
    }
    
    /**
     * Holds how many timme the player hasn't rolled a double in a row. 
     * It is reset when it reaches 3
     */
    public int nOfNonDoubles; 
    
    /**
     * Sets the players current location
     * @param location is the location that the player has to move to 
     */
    public void setLocation(Square location) {
    	position = location;
    	payRent(position);
    }
    
    /**
     * Takes a specified amount of money out of the players money
     * @param amount is the amount to be withdrawn
     */
    public void pay(int amount) {
        money = money - amount;
    }
    
    /**
     * Returns the player's money
     * @return
     */
    public int getBalance() {
        return money;
    }
    
    /**
     * Puts the player in jail
     */
    public void setInJail() {
    	inJail = true;
    	position = Game.board.getLocationByName("Jail");
    }
 
    /**
     * Sets the player out of jail if rolled a double
     * @param die1 number rolled on first die
     * @param die2 number rolled on second die
     */
    public void getOutOfJail(int die1, int die2) {
    	if (hasRolledDouble(die1, die2))
    	    inJail = false;
    }
    
    /**
     * Increases the player's money by 200. Used when passing from GO
     */
    public void passGO() {
    	money = money + 200;
    }
    
    /**
     * Tkes care of rent payment when a player lands on an owned property
     * @param property The property for hih the player is paying rent
     */
    public void payRent(Square property) {
    	Player owner = property.getOwner();
    	int ownerBal;
    	if (owner != null) {
    	    ownerBal = owner.getBalance();
    	    money = money - property.rent;
    	    owner.money = ownerBal + property.getRent(); 
    	}
    		
    }
    
    /**
     * Sets the name of the property
     * @param name the name to be given to the player
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /**
     * Adds a property into the properties list
     * @param property
     */
    public void addProperty(Square property) {
        System.out.println(property);
        this.properties.add(property);
    }
    
    /**
     * Sets the player out of jail
     */
    public void payOutOfJail() {
    	this.inJail = false;
    	money -= 50;
    }
    
    /**
     * Checks whether a playerr has rolled a double
     * 
     */
    public boolean hasRolledDouble(int die1, int die2) {
    	if (die1 == die2){
    		nOfNonDoubles = 0;
    		return true;
    	}
    	else{
    		nOfNonDoubles++;
    		if (nOfNonDoubles == 3){
    		    nOfNonDoubles = 0;
			    if(inJail){
					payOutOfJail();
				}
			}
    		return false;
    	} 	
    }
}
