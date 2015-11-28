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
    public Bank bank;
    public boolean gameOver;

    public void addPlayer(Player play) {
        players.put(play.token, play);
    }

    public Player getPlayer(Game.tokens token) {
        return players.get(token);
    }
    
    
}