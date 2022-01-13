import java.util.HashMap;

import gui_fields.GUI_Player;


/**
 * The PlayerManager keep track of all players.
 */

public class PlayerManager {

    /** initiation of Player class */
    Player player = new Player();

    /** Player variables */


    /** Creating a HashMap containing player's ID and the corresponding player name */
    HashMap<Integer,String> players=new HashMap<Integer,String>();


    /** Initializes a new player */

    public void createPlayer(String name, int balance, getRandomCar()) {
        GUI_Player GUIPlayer = new GUI_Player(name, startBalance,getRandomCar());
        balance = new balance(GUIPlayer);
        Player player = new Player(GUIPlayer);
        GUIController.getInstance().addPlayer(GUIPlayer);
        players.put();
    }


    /** get player count */
    private final int playerCount = players.size();
    public int getPlayerCount() {return playerCount;};


}