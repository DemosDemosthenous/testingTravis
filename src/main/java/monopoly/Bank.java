package monopoly;

/**
 * Bank.java
 * <br/>
 * This class represents the bank that is used in a monopoly game
 * <br/>
 * @author CO2012_Group19
 *
 */
public class Bank {
	/**
	 * balance variable describes the initial balance of the bank
	 */
    int balance = 90000000;
    
    /**
     * getTaxes is used to increase the balance of the bank
     * <br/>when a player lands on a tax square 
     * 
     * @param amount is the tax cost paid by the player
     */
    public void getTaxes(int amount) {
        balance = + amount;
    }
    
    /**
     * getPropertyVal is used to increase the balance of the bank
     * <br/>when a player buys an unowned property
     * 
     * @param amount is the tax cost paid by the player
     */
    public void getPropertyVal(int amount) {
    	balance = balance + amount;
    }
}
