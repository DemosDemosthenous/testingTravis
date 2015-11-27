package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    List<Square> squares = new ArrayList<> ();
    Map<String,Square> squaresMap = new HashMap<> ();

    public Board () {
        this.addSquare("GO");
        this.addSquare("Old Kent Road");
        this.addSquare("WhiteChapel Road");
        this.addSquare("Income Tax");
        this.addSquare("King' cross Station");
        this.addSquare("The angel Islington");
        this.addSquare("Euston Road");
        this.addSquare("Pentoville Road");
        this.addSquare("Jail");
        this.addSquare("Pall Mall");
        this.addSquare("Eleectric Company");
        this.addSquare("Whitehall");
        this.addSquare("Northumberland Avenue");
        this.addSquare("Marylebone Station");
        this.addSquare("Bow Street");
        this.addSquare("Marlbourhough Street");
        this.addSquare("Vine Street");
        this.addSquare("Free Parking");
        this.addSquare("Strand");
        this.addSquare("Fleet Street");
        this.addSquare("Trafalgar Square");
        this.addSquare("Fenchurch station");
        this.addSquare("Leicester Square");
        this.addSquare("Coventry Street");
        this.addSquare("Water Works");
        this.addSquare("Picadilly");
        this.addSquare("Go to jail");
        this.addSquare("Regent Street");
        this.addSquare("Oxford Street");
        this.addSquare("Bond Street");
        this.addSquare("Liverpool Street Station");
        this.addSquare("Park Lane");
        this.addSquare("Super Tax");
        this.addSquare("Mayfair");
    }

    public void addSquare(String name) {
        Square square = new Square(name);
        this.squares.add(square);
        this.squaresMap.put(square.name, square);
    }
   
    public Square getLocationByName(String name) {
        return squaresMap.get(name);
    }
}
