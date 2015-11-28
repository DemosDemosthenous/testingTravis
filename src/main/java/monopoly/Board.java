package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    List<Square> squares = new ArrayList<> ();
    Map<String,Square> squaresMap = new HashMap<> ();

    public Board () {
        this.addSquare("GO",0);
        this.addSquare("Vine Street",15);
        this.addSquare("Coventry Street",57);
        this.addSquare("Income Tax",100);
        this.addSquare("Marylebone Station",500);
        this.addSquare("Leicester Square",68);
        this.addSquare("Bow Street",71);
        this.addSquare("WhiteChapel Road",81);
        this.addSquare("Jail",0);
        this.addSquare("The Angel Islington",91);
        this.addSquare("Eleectric Company",12400);
        this.addSquare("Trafalgar Square",97);
        this.addSquare("Northumberland Avenue",112);
        this.addSquare("Fenchurch st Station",700);
        this.addSquare("M'Borough Street",125);
        this.addSquare("Fleet Street",148);
        this.addSquare("Old Kent Road",208);
        this.addSquare("Free Parking",0);
        this.addSquare("Whitehall",211);
        this.addSquare("Pentonville Road",215);
        this.addSquare("Pall Mall",228);
        this.addSquare("Kings Cross Station",16000);
        this.addSquare("Bond Street",217);
        this.addSquare("Strand",320);
        this.addSquare("Water Works",8000);
        this.addSquare("Regent Street",370);
        this.addSquare("Go to jail",0);
        this.addSquare("Euston Road",404);
        this.addSquare("Picadilly",440);
        this.addSquare("Oxford Street",550);
        this.addSquare("Liverpool Street Station",15000);
        this.addSquare("Park Lane",562);
        this.addSquare("Super Tax",200);
        this.addSquare("Mayfair",18000);
    }

    public void addSquare(String name, double value) {
        Square square = new Square(name,value);
        this.squares.add(square);
        this.squaresMap.put(square.name, square);
    }
   
    public Square getLocationByName(String name) {
        return squaresMap.get(name);
    }
    
    public Square getDestinationSquare(Player player,Square current,int steps){
    	int curIndex = this.squares.indexOf(current);
    	
    	Square newPosition;
    	int total = curIndex + steps;
    	
    	
    	if(!player.inJail){
    	        newPosition = squares.get(total);
    	}else
        	newPosition = current;
    	
    	//checking if player has passed from go
    	if (curIndex>Game.board.squares.indexOf(newPosition))
    		player.passGO();
    	
    	//check if on special squares like Tax or GO to jail
    	switch(newPosition.name){
    	    case "Income Tax":
    	    	player.pay(100);
    	    	break;
    	    case "Super Tax":
    	    	player.pay(200);
    	    	break;
    	    case "Go to jail":
    	    	newPosition = Game.board.getLocationByName("Jail");
    	    	player.setLocation(newPosition);
    	    	player.setInJail();
    	    	break;
    	}
    	return newPosition;
    }
}
