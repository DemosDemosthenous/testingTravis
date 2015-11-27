package monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MonopolySteps {

    Game game;
    Player car;
    Square prop;
    
    @Before 
    public void beforeScenario() {
        game = new Game();
    }

    @After
    public void afterScenario() {

    }


    @Given("^a player is using the car$")
    public void a_player_is_using_the_car() throws Throwable {
        car = new Player(Game.tokens.CAR);
        game.addPlayer(car);
    }

    @Given("^the player is on WhiteChapel Road$")
    public void the_player_is_on_WhiteChapel_Road() throws Throwable {
        Square location = game.board.getLocationByName("WhiteChapel Road");
        car.setLocation(location);
    }
    
    @Given("^the WhiteChapel Road is not owned$")
    public void the_WhiteChapel_Road_is_not_owned() throws Throwable {
        Square prop = game.board.getLocationByName("WhiteChapel Road");
        prop.setOwner(null);
    }

    @Given("^the player's money is (\\d+)m$")
    public void the_player_s_money_is_m(int money) throws Throwable {
        car.money = money;
    }

    @When("^the player decides to buy the property$")
    public void the_player_decides_to_buy_the_property() throws Throwable {
        prop = game.board.getLocationByName("WhiteChapel Road");
        prop.buy(car);
    }

    @Then("^the player's money equals (\\d+)m$")
    public void the_player_s_money_equals(int money) throws Throwable {
        assertEquals(car.getBalance(),money);
    }
/*
@Then("^the bank balance will increase by (\\d+)m$")
public void the_bank_balance_will_increase_by_m(int arg1) throws Throwa                                                     ble {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
*/ 
    @Then("^WhiteChapel Road is owned by the player using car$")
    public void whitechapel_Road_is_owned_by_the_player_using_car() throws Throwable {
        prop = game.board.getLocationByName("WhiteChapel Road");
        assertEquals(car,prop.getOwner());
    }

/*
@Given("^there is a player using car$")
public void there_is_a_player_using_car() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Given("^the player lands on Oxford street$")
public void the_player_lands_on_Oxford_street() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^the player's money remain (\\d+)m$")
public void the_player_s_money_remain_m(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^owner of the property remains null$")
public void owner_of_the_property_remains_null() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Given("^the property is owned by another player using hat$")
public void the_property_is_owned_by_another_player_using_hat() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^the player attempts to buy the property$")
public void the_player_attempts_to_buy_the_property() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^the car player's money doesn't change$")
public void the_car_player_s_money_doesn_t_change() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^the owner of the property does not change$")
public void the_owner                                                     _of_the_property_does_not_change() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}*/

}
