import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

/** The PlayerManager keep track of all players.  */

public class Bank {

    /** Instantiate other classes  */

    FieldManager fm = new FieldManager();
    PlayerManager pm = new PlayerManager();


    /** Change player balance. */
    public void changeBalance(int player, int amount) {
            int playerBalance = pm.getBalance(player);
            pm.setBalance(player,playerBalance + amount);

    }

    /** Pays for the field. */
    public void buyField(int field, int player) {
        int fieldPrice = fm.getPrice(field);
        fieldPrice = -fieldPrice;

        fm.claimField(field, player);
        changeBalance(player, fieldPrice);
    }


    /** Pay rent of the field to the owner. */


    /** return the sum of all players non-liquid assets. */



    /**
     * Changes the balance of the player
     * player the player object whose balance will be changed
     * change the change in balance
     */

}
