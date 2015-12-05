package monopoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MonopolyDAO {
    Connection connection;
    /**
    * Create the connection to the database.
    */
     public SnakesAndLaddersDao() {
    try {
      Class.forName("com.mysql.jdbc.Driver" );
      connection = DriverManager.getConnection("jdbc:mysql://" + System.getProperty("db_host") 
          + ":" + System.getProperty("db_port")  
          + "/" + System.getProperty("db_name")  
          + "?user=" + System.getProperty("db_user")  
          + "&password=" + System.getProperty("db_pass"));
      
        } catch (Exception e) {
            System.err.println("ERROR: failed to get database connection.");
            e.printStackTrace();
        }
    } 
	  
	  
    public String getToken (Player player) {
        String token = "";
    	switch (player.token) {
            case CAR:
                token = "car";
                break;
	        
            case SHIP:
                token = "ship";
                break;
            case SHOE:
                token = "shoe";
                break;
            case DOG:
                token = "dog";
                break;
            case HAT:
                token = "hat";
                break;
            case THIMBLE:
                token = "thimble";
                break;
        }
        return token;
    }
    /**
    * Kill the connection for this DAO
    */
    public void closeConnection() {
        try {
            this.connection.close();        
	} catch (Exception e) {
            System.err.println("ERROR: failed to get database connection.");
            e.printStackTrace();
        }
    }
	  
    /**
    * Update or add a genre to the database depending on whether it is already there
    * @param genre The genre.
    */
    public void persistPlayer(Player player) {
        if (player.token != null) {
            this.updatePlayer(player);
        } else {
            this.addPlayer(player);
        }
    }
	  
	  
    /**
    * Update a genre in the database
    * @param genre The genre to update.
    */
    private void updatePlayer(Player player) {
        String token = "";
        token = getToken(player);
    
        try {
            String updatePlayer = "UPDATE genre SET name = '" + player.name + "' ,money = " + 
                player.money + " , position = '" + player.position.name + "' , token = '" + token +
                "' , inJail = " + player.inJail + " WHERE ID = " + player.id ;
   		    				     
            Statement statement = connection.createStatement();
            statement.executeUpdate(updatePlayer);
      
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	  
    /**
    * Add the genre to the database.
    * @param genre the genre to add
    */
    private void addPlayer(Player player) {
        String token = "";
        token = getToken(player);
        try {
            String insertPlayer = "INSERT INTO player values (" + player.name + "," + player.money + "," + player.position.name + "," + token + ")";
	      
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertPlayer, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
	      
            while (keys.next()) {  
                player.id = keys.getInt(1);
            } 
            keys.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	  
    /**
    * Delete a player from the DB. 
    * @param genre The player to delete from the DB
    */
    public void deleteGenre(Player player) {
        try {
            String sql = "DELETE FROM players where id = " + player.id;      
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
    * Get a specific genre.
    * @param id the id of the object to fetch.
    * @return the requested object.
    */
    public Player findPlayerById(int id) {

        Player player = null;

        try {
            // Run the query to get the data for this object  
            String sql = "SELECT * FROM  WHERE id =" + id;      
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
 
           // If there are results create and populate the object.
            if (results.next()) {
                switch (results.getString("token")) {
                    case "car":
                        player = new Player(Game.tokens.CAR);
                        break;

                    case "ship":
                        player = new Player(Game.tokens.SHIP);
                        break;
 
                    case "shoe":
                        player = new Player(Game.tokens.SHOE);
                        break;
                    case "dog":
                        player = new Player(Game.tokens.DOG);
                        break;
                    case "hat":
                        player = new Player(Game.tokens.HAT);
                        break;
                    case "thimble":
                        player = new Player(Game.tokens.THIMBLE);
                        break;
                } 

                player.id = id;
                player.name = results.getString("name");
                player.money = results.getInt("money");
                player.inJail = results.getBoolean("inJail");
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
        return player; // return the object or null if it wasn't there.
    }

    public Map<Integer, Player> fetchAllPlayers() {
        Map<Integer, Player> objects = new HashMap<>();
        try {
            // First we'll get all the ids, then use our other function
            // to populate the objects        
            String sql = "SELECT id FROM players";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {

                // For each returned Id, fetch the object then 
                // Add it to our map mapping it from its ID
                Integer id = results.getInt("id");
                Player player = this.findPlayerById(id);
                objects.put(id, player);
            }

        } catch (SQLException e) {  
            e.printStackTrace();
        }
        return objects;
    }
}
