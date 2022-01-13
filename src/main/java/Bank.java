import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

/** The PlayerManager keep track of all players.  */

public class Bank {

    /** Pays for the field. */
    public void buyField() {
        int fieldPrice = FieldManager.getPrice();
        int playerBalance = PlayerManager.getBalance();

        int total = playerBalance - fieldPrice;

        PlayerManager.setBalance(total);
    }


    /** Pay rent of the field to the owner. */

    /** Change player balance. */


    /** return the sum of all players non-liquid assets. */



    /**
     * Changes the balance of the player
     * player the player object whose balance will be changed
     * change the change in balance
     */

}
