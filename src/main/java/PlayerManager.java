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
    public void addPlayer(String name) {
        //Increases player count by 1 and adds it along with a new Player object to the HashMap
        players.put(++playerCount,new Player(name));
    }

    /** Returns the names of all players */
    public String[] listPlayers() {
        //Creates a temporary list of player names and adds the name of each player to the list
        String[] temp = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            temp[i] = players.get(i).getName();
        }
        return temp;
    }

    /** Returns the number of players */
    public int getPlayerCount() {return playerCount;}

    /** Returns the name of a player */
    public String getName(int ID) {return players.get(ID).getName();}

    /** Returns the position of a player */
    public int getPosition(int ID) {return players.get(ID).getPosition();}

    /** Returns whether a player is in jail */
    public boolean isJailed(int ID) {return players.get(ID).getJailStatus();}

    /** Returns whether a player has a 'get out of jail' card */
    public boolean hasJailCard(int ID) {return players.get(ID).getJailCard();}

    /** Returns the player's balance */
    public int getBalance(int ID) {return players.get(ID).getGUIPlayer().getBalance();}

    /** Sets the position of a player */
    public void setPosition(int ID, int pos) {players.get(ID).setPosition(pos);}

    /** Sets whether a player is in jail */
    public void setJailStatus(int ID, boolean status) {players.get(ID).setJailStatus(status);}

    /** Sets whether a player has a 'get out of jail' card */
    public void setJailCard(int ID, boolean card) {players.get(ID).setJailCard(card);}

    /** Sets the player's balance */
    public void setBalance(int ID, int bal) {players.get(ID).getGUIPlayer().setBalance(bal);}
}