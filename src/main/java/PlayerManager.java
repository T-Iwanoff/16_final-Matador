import java.util.HashMap;

/**
 * The PlayerManager keep track of all players.
 */

public class PlayerManager {
    /** A HashMap containing player's ID and the corresponding player Object */
    private HashMap<Integer,Player> players = new HashMap<>();
    /** The number of players */
    private int playerCount = 0;

    /** Creates a Player and adds them to the HashMap */
    public void addPlayer(String name) { //Increases player count by 1 and adds it along with a new Player object to the HashMap
        players.put(++playerCount,new Player(name));
    }

    /** Returns the names of all players */
    public String[] listPlayers() {
        String[] temp = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            temp[i] = players.get(i).getName();
        }
        return temp;
    }

    /** get player count */
    public int getPlayerCount() {return playerCount;}


}