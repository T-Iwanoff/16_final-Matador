
/** Changes the balance of the player */

public class Bank {

    /** Instantiate other classes  */
    FieldManager fm = new FieldManager();
    PlayerManager pm = new PlayerManager();
    DiceCup dc = new DiceCup();


    /** Change player balance. */
    public void changeBalance(int player, int amount) {
            int playerBalance = pm.getBalance(player);
            pm.setBalance(player,playerBalance + amount);
    }

    /** Pay to another player. */
    public void payTo(int payer, int payee, int amount) {
        int payAmount = -amount;

        changeBalance(payer, payAmount);
        changeBalance(payee, amount);
    }

    /** Pays for the field. */
    public void buyField(int field, int player) {
        int fieldPrice = fm.getPrice(field);
        fieldPrice = -fieldPrice;

        fm.claimField(field, player);
        changeBalance(player, fieldPrice);
    }

    /** Pay rent of the field to the owner. */
    public void payRent(int field, int player) {
        String fieldType = fm.getType(field);
        int payee = fm.getOwner(field);
        int number = fm.getOwnedByType(fieldType, player);
        int diceSum = dc.getSum();

        switch (fieldType){

            case "street":
                int stFieldRent = fm.getRent(field, number);
                payTo(player, payee, stFieldRent);
                break;

            case "ferry":
                int frFieldRent;
                if (number == 1){
                    frFieldRent = 500;
                }
                else {
                    frFieldRent = (number - 1) * 500 * 2;
                }
                payTo(player, payee, frFieldRent);
                break;

            case "brewery":
                int bwFieldRent = diceSum * (number * 100);
                payTo(player, payee, bwFieldRent);
                break;
        }
    }


    /** return the sum of all players non-liquid assets. */


}
