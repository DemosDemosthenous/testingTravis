package monopoly;

/**Square.java
 * Represents a property on the board
 * @author CO2012_Group19
 *
 */
public class Square {
	/**
	 * Name of the property
	 */
    String name;
    /**
     * Holds the owner of the property
     */
    Player owner;
    /**
     * Holds the rent price for the property
     */
    int rent;
    /**
     * Holds the value of the property
     */
    int sellPrice;
    
    /**
     * Creates a square and sets the name, sellPrice and rent
     * @param name - the name of the property to be created
     * @param value - the sellPrice of the property to be created
     * @param rent - the rent of the property to be created
     */
    public Square(String name,int value, int rent) {
        this.name = name;
        sellPrice = value;
        this.rent = rent;
    }
    
    /**
     * Sets the owner of the property
     * @param play the player to be assigned as the owner
     */
    public void setOwner(Player play) {
        this.owner = play;
        
        
    }
    
  
    
    /**
     * Returns the owner of the property
     * @return
     */
    public Player getOwner() {
        return this.owner;
    }
    
    /**
     * Returns the rent price of the property
     * @return
     */
    public int getRent() {
    	return rent;
    }
}
