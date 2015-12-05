package monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MonopolySteps {
    Game game = new Game();
    Player player;
    Square prop;
    
    public Player getPlayer(String name) {
        Player tempPlayer = null;  
    	switch (name) {
            case "car":
       	        tempPlayer = game.getPlayer(Game.tokens.CAR);
       	        break;
       	 
       	    case "dog":
       	        tempPlayer = game.getPlayer(Game.tokens.DOG);
       	        break;
       	    case "hat":
       	        tempPlayer = game.getPlayer(Game.tokens.HAT);
       	        break; 
       	    case "ship":
       	        tempPlayer = game.getPlayer(Game.tokens.SHIP);
       	        break;
       	    case "shoe":
       	        tempPlayer = game.getPlayer(Game.tokens.SHOE);
       	        break;
       	    case "thimble":
       	        tempPlayer = game.getPlayer(Game.tokens.THIMBLE);
       	        break;
       	    default:
       	    	tempPlayer = null;
        }
        return tempPlayer;
    }
    
    @Before 
    public void beforeScenario() {
    	
    }

    @After
    public void afterScenario() {

    }

    @Given("^there is a player (.*)$")
    public void there_is_a_player(String name) throws Throwable {
        switch (name) {
            case "car":
                player = new Player(Game.tokens.CAR);
                break;
    	 
    	    case "dog":
    	        player = new Player(Game.tokens.DOG);
    	        break;
    	    case "hat":
    	        player = new Player(Game.tokens.HAT);
    	        break; 
    	    case "ship":
                player = new Player(Game.tokens.SHIP);
                break;
    	    case "shoe":
                player = new Player(Game.tokens.SHOE);
                break;
    	    case "thimble":
                player = new Player(Game.tokens.THIMBLE);
                break;
        }
    	 
        game.addPlayer(player);
    }
    
    @Given("^the player (.*) is on (.*)$")
    public void the_player_is_on_GO(String name, String square) throws Throwable {
        player = getPlayer(name);
        player.setLocation(game.board.getLocationByName(square));
    }

    @When("^the player (.*) has rolled (\\d+) and (\\d+)$")
    public void the_player_has_rolled_and(String name,int die1, int die2) throws Throwable {
        player = getPlayer(name);     
        player.getOutOfJail(die1, die2);
        Square locationToMove = game.board.getDestinationSquare(player,player.position,die1 + die2);
        player.setLocation(locationToMove);
    }

    @Then("^the player (.*) lands on (.*) square$")
    public void the_player_lands_on(String name, String square) throws Throwable {
        player = getPlayer(name);   	
        assertEquals(player.position,game.board.getLocationByName(square));
    }
    
    @Given("^the player (.*) has a balance (\\d+)$")
    public void the_player_has_a_balance(String name,int bal) throws Throwable {
        player = getPlayer(name);
        player.money = bal;
    }

    @Then("^the player (.*) has a balance of (.*)$")
    public void the_player_has_a_balance_of(String name,int bal) throws Throwable {
	    player = getPlayer(name);
        assertEquals(bal,player.money);
    }

    @Then("^the player (.*) gets out of jail$")
   	public void gets_out_of_jail(String name) throws Throwable {
        player = getPlayer(name);
        assertEquals(false,player.inJail);
    }

    @Given("^the player (.*) is in jail$")
    public void the_player_ship_is_in_jail(String name) throws Throwable {
        player = getPlayer(name);   		
        player.setInJail();
        player.setLocation(game.board.getLocationByName("Jail"));    
    }

    @Then("^player ship remains in jail$")
    public void player_remains_in_jail() throws Throwable {
        player = game.getPlayer(Game.tokens.SHIP);
        assertEquals(player.inJail,true);
        assertEquals(player.position,game.board.getLocationByName("Jail"));
    }
    
    //BUY PROPERTIES FEATURE
    
    @Given("^the player (.*) has landed on (.*) square$")
    public void the_player_has_landed_on_square(String play, String square) throws Throwable {
        player = getPlayer(play);
        player.setLocation(game.board.getLocationByName(square));
    }
    
    @Given("^the property (.*) is owned by another player using (.*)$")
    public void the_property_is_owned_by_another_player(String property,String owner) throws Throwable {
        prop = game.board.getLocationByName(property);
        player = getPlayer(owner);
        prop.setOwner(player); 
       
    }

    @Given("^the (.*) is not owned")
    public void property_not_owned (String property) throws Throwable {
        prop = game.board.getLocationByName(property);
        prop.setOwner(null);
    }
    
    @When("^the player (.*) attempts to buy (.*)$")
    public void the_player_attempts_to_buy_the_property(String name,String property) throws Throwable {
        prop = game.board.getLocationByName(property);
        player = getPlayer(name);
        game.buy(player,prop);
    }

    @Then("^the owner of (.*) is player (.*)$")
    public void the_owner_is(String property,String owner) throws Throwable {
        prop = game.board.getLocationByName(property);
        player = getPlayer(owner);  
        assertEquals(getPlayer(owner),prop.getOwner());
    }
    

    @Then("^the owner of (.*) is null$")
    public void the_owner_is_null(String property) throws Throwable {
        prop = game.board.getLocationByName(property);
        assertEquals(null,prop.getOwner());
    }
    
    //FEATURE RENT
    
    @Given("^player (.*) owns (.*)$")
    public void player_ship_owns_Bond_street(String name,String property) throws Throwable {
        player = getPlayer(name);
        prop = game.board.getLocationByName(property);
        prop.setOwner(player);
    }
    
    @When("^the player (.*) has landed on (.*)$")
    public void the_player_shoe_has_landed_on_Bond_Street(String name, String property) throws Throwable {
    	player = getPlayer(name);
        player.setLocation(game.board.getLocationByName(property));
    }
    
    //JAIL FEATURE
    @When("^the player (.*) pays to get out of jail$")
    public void the_player_hat_pays_to_get_out_of_jail(String name) throws Throwable {
        player = getPlayer(name);
        player.payOutOfJail();
    }

}

 

