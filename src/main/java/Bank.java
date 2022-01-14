public class Bank {

    /** Instantiate other classes  */
    FieldManager fm = new FieldManager();
    PlayerManager pm = new PlayerManager();


    /** Changes the player's balance. */
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
    public void payRent(int field, int player, int diceSum) {
        String fieldType = fm.getType(field);
        int payee = fm.getOwner(field);
        int number = fm.getOwnedByType(fieldType, player);

        switch (fieldType){
            case "street":
                int stFieldRent = fm.getRent(field);
                payTo(player, payee, stFieldRent);
                break;

            case "ferry":
                int frFieldRent = fm.getRent(field, number);
                payTo(player, payee, frFieldRent);
                break;

            case "brewery":
                int bwFieldRent = diceSum * fm.getRent(field, number);
                payTo(player, payee, bwFieldRent);
                break;
        }
    }


    /** return the sum of all players non-liquid assets. */
    public int sumAssets(int player) {
        int sum = 0;
        int [] ownedFields = fm.getOwnedFields(player);
        for (int i : ownedFields){
            sum += (int) ((fm.getPrice(i) * 0.5) + (fm.getHouses(i) * fm.getHousePrice(i) * 0.5));
        }
        return sum;
    }

}
