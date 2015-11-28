package monopoly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    public static Board board = new Board();
    public Die die1;
    public Die die2;
    public Map<tokens,Player> players = new HashMap();
    
    public enum tokens {DOG, SHIP, SHOE,HAT,THIMBLE,CAR};
    public static Bank bank;
    public boolean gameOver;

    public void addPlayer(Player play) {
        players.put(play.token, play);
    }

    public Player getPlayer(Game.tokens token) {
        return players.get(token);
    }
    
    public static void main(String[]args){
    	Game game = new Game();
    	for (int i=0;i<33;i++)
    		System.out.println( game.board.getLocationByName(game.board.squares.get(i).name)+ " "+game.board.squares.get(i).name);
    }
    
    public static Bank getBank(){
    	return bank;
    }
}