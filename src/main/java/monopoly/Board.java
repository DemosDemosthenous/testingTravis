package monopoly;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Board.java
 * <br/>
 * Represents the monopoly board
 * @author CO2012_Group19
 */

public class Board {
	
    List<Square> squares = new ArrayList<> ();
    Map<String,Square> squaresMap = new HashMap<> ();

    /**
     * Board constructor sets all the properties by creating
     * <br/> squares by using the square constructor
     */
    public Board () {
        this.addSquare("GO",0,0);
        this.addSquare("Vine Street",15,16);
        this.addSquare("Coventry Street",57,22);
        this.addSquare("Income Tax",100,0);
        this.addSquare("Marylebone Station",500,25);
        this.addSquare("Leicester Square",68,22);
        this.addSquare("Bow Street",71,14);
        this.addSquare("WhiteChapel Road",81,4);
        this.addSquare("Jail",0,0);
        this.addSquare("The Angel Islington",91,6);
        this.addSquare("Electric Company",12400,75);
        this.addSquare("Trafalgar Square",97,20);
        this.addSquare("Northumberland Avenue",112,12);
        this.addSquare("Fenchurch st Station",700,25);
        this.addSquare("M'Borough Street",125,14);
        this.addSquare("Fleet Street",148,18);
        this.addSquare("Old Kent Road",208,2);
        this.addSquare("Free Parking",0,0);
        this.addSquare("Whitehall",211,10);
        this.addSquare("Pentonville Road",215,8);
        this.addSquare("Pall Mall",228,10);
        this.addSquare("Kings Cross Station",16000,25);
        this.addSquare("Bond Street",217,28);
        this.addSquare("Strand",320,18);
        this.addSquare("Water Works",8000,75);
        this.addSquare("Regent Street",370,26);
        this.addSquare("Go to jail",0,0);
        this.addSquare("Euston Road",404,6);
        this.addSquare("Picadilly",440,22);
        this.addSquare("Oxford Street",550,26);
        this.addSquare("Liverpool Street Station",15000,25);
        this.addSquare("Park Lane",562,35);
        this.addSquare("Super Tax",200,0);
        this.addSquare("Mayfair",18000,50);
    }

    /**
     * Adds a square into the squareMap and squares
     * @param name is the name of the property
     * @param value the value of the property
     * @param rent is the retn of the property
     */
    public void addSquare (String name, int value, int rent) {
        Square square = new Square (name,value,rent);
        this.squares.add (square);
        this.squaresMap.put (square.name, square);
    }
   
    /**
     * Returns a Square based on the parameter name
     * @param name is the name of the square to be returned
     */
    public Square getLocationByName (String name) {
        return squaresMap.get (name);
    }
    
    /**
     * Determines the players destination square based on the numbers that the player has rolled
     *
     * @param player - the player who rolled the dice
     * @param current - the players current position
     * @param steps - the steps that the player will move forward
     * @return
     */
    public Square getDestinationSquare (Player player,Square current,int steps) {
        int curIndex = this.squares.indexOf (current);
        
        
        Square newPosition;
        int total = curIndex + steps;

        //checking if player passed from go 
        if (total > 34) {  //34 squares
            player.passGO (); //increases players money by 200
            total = total - 34; //34 squares on board
            newPosition = squares.get(total);
        	
        }
        
    	if (!player.inJail) {
            newPosition = squares.get (total);
        } else
            newPosition = current;  		
    	
    	//check if on special squares like Tax or GO to jail
    	switch (newPosition.name) {
    	    case "Income Tax":
    	    	player.pay (100);
    	    	break;
    	    case "Super Tax":
    	    	player.pay (200);
    	    	break;
    	    case "Go to jail":
    	    	newPosition = Game.board.getLocationByName ("Jail");
    	    	player.setLocation (newPosition);
    	    	player.setInJail ();
    	    	break;
    	}
    	return newPosition;
    }
    
}
