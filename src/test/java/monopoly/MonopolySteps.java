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
    
    @Before 
    public void beforeScenario() {
    	
    }

    @After
    public void afterScenario() {

    }

    @Given("^there is a player (.*)$")
    public void there_is_a_player_car(String name) throws Throwable {
    	 switch(name){
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
        switch(name){
      	 case "car":
      		 player = game.getPlayer(Game.tokens.CAR);
      		 break;
      	 
      	 case "dog":
      		 player = game.getPlayer(Game.tokens.DOG);
      		 break;
      	 case "hat":
      		 player = game.getPlayer(Game.tokens.HAT);
      		 break; 
      	 case "ship":
      		 player = game.getPlayer(Game.tokens.SHIP);
      		 break;
      	 case "shoe":
      		 player = game.getPlayer(Game.tokens.SHOE);
      		 break;
      	 case "thimble":
      		 player = game.getPlayer(Game.tokens.THIMBLE);
      		 break;
      	 }
    	
    	 
         player.setLocation(game.board.getLocationByName(square));
    }

    @When("^the player (.*) has rolled (\\d+) and (\\d+)$")
    public void the_player_has_rolled_and(String name,int die1, int die2) throws Throwable {
        
        
        switch(name){
   	 case "car":
   		 player = game.getPlayer(Game.tokens.CAR);
   		 break;
   	 
   	 case "dog":
   		 player = game.getPlayer(Game.tokens.DOG);
   		 break;
   	 case "hat":
   		 player = game.getPlayer(Game.tokens.HAT);
   		 break; 
   	 case "ship":
   		 player = game.getPlayer(Game.tokens.SHIP);
   		 break;
   	 case "shoe":
   		 player = game.getPlayer(Game.tokens.SHOE);
   		 break;
   	 case "thimble":
   		 player = game.getPlayer(Game.tokens.THIMBLE);
   		 break;
   	 }
      
        player.getOutOfJail(die1, die2);
        Square locationToMove = game.board.getDestinationSquare(player,player.position,die1 + die2);
        player.setLocation(locationToMove);
    }

   /* @Then("^the player (.*) lands on (.*) square$")
    public void the_player_lands_on(String name, String square) throws Throwable {
    	switch(name){
     	 case "car":
     		 player = game.getPlayer(Game.tokens.CAR);
     		 break;
     	 
     	 case "dog":
     		 player = game.getPlayer(Game.tokens.DOG);
     		 break;
     	 case "hat":
     		 player = game.getPlayer(Game.tokens.HAT);
     		 break; 
     	 case "ship":
     		 player = game.getPlayer(Game.tokens.SHIP);
     		 break;
     		 
     	 case "shoe":
     		 player = game.getPlayer(Game.tokens.SHOE);
     		 break;
     	 case "thimble":
     		 player = game.getPlayer(Game.tokens.THIMBLE);
     		 break;
     	 }
  		
    	
    	 assertEquals(player.position,game.board.getLocationByName(square));
    }
    */
    @Given("^the player (.*) has a balance (\\d+)$")
    public void the_player_has_a_balance(String name,int bal) throws Throwable {
    	switch(name){
	    case "car":
		    player = game.getPlayer(Game.tokens.CAR);
		    break;
	 
	    case "dog":
		    player = game.getPlayer(Game.tokens.DOG);
		    break;
	    case "hat":
		    player = game.getPlayer(Game.tokens.HAT);
		    break; 
	    case "ship":
		    player = game.getPlayer(Game.tokens.SHIP);
		    break;
		case "shoe":
		    player = game.getPlayer(Game.tokens.SHOE);
		    break;
	    case "thimble":
		    player = game.getPlayer(Game.tokens.THIMBLE);
		    break;
   }
        player.money = bal;
    }

   	/*@Then("^the player (.*) has a balance of (.*)$")
       public void the_player_has_a_balance_of(String name,int bal) throws Throwable {
   		switch(name){
    	    case "car":
    		    player = game.getPlayer(Game.tokens.CAR);
    		    break;
    	 
    	    case "dog":
    		    player = game.getPlayer(Game.tokens.DOG);
    		    break;
    	    case "hat":
    		    player = game.getPlayer(Game.tokens.HAT);
    		    break; 
    	    case "ship":
    		    player = game.getPlayer(Game.tokens.SHIP);
    		    break;
    		case "shoe":
    		    player = game.getPlayer(Game.tokens.SHOE);
    		    break;
    	    case "thimble":
    		    player = game.getPlayer(Game.tokens.THIMBLE);
    		    break;
       }
           assertEquals(bal,player.money);
       }*/

   	@Then("^get gets out of jail$")
   	public void get_gets_out_of_jail() throws Throwable {
   	   player = game.getPlayer(Game.tokens.DOG);
   		assertEquals(player.inJail,false);
   	}

   	@Given("^the player (.*) is in jail$")
   	public void the_player_ship_is_in_jail(String name) throws Throwable {
        switch(name){
      	 case "car":
      		 player = game.getPlayer(Game.tokens.CAR);
      		 break;
      	 
      	 case "dog":
      		 player = game.getPlayer(Game.tokens.DOG);
      		 break;
      	 case "hat":
      		 player = game.getPlayer(Game.tokens.HAT);
      		 break; 
      	 case "ship":
      		 player = game.getPlayer(Game.tokens.SHIP);
      		 break;
      		 
      	 case "shoe":
      		 player = game.getPlayer(Game.tokens.SHOE);
      		 break;
      	 case "thimble":
      		 player = game.getPlayer(Game.tokens.THIMBLE);
      		 break;
      	 }
   		
   		
   		player.setInJail();
   	    player.setLocation(game.board.getLocationByName("Jail"));    
   	}

   	@Then("^player ship remains in jail$")
   	public void player_remains_in_jail() throws Throwable {
   	    player = game.getPlayer(Game.tokens.SHIP);
   	    assertEquals(player.inJail,true);
   	    assertEquals(player.position,game.board.getLocationByName("Jail"));
   	}

   
    
}

