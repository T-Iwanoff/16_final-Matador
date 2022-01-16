public class Bank {

    /** Instantiate other classes  */
    FieldManager fm = new FieldManager();
    PlayerManager pm = new PlayerManager();


    /** Adds an amount to the player's balance. */
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
                if (fm.getOwner(field) == fm.getOwner(fm.getNeighbourhood(field))) {
                    stFieldRent = stFieldRent*2;
                }
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


    /** Returns the sum of all players non-liquid assets. */
    public int sumAssets(int player) {
        int sum = 0;
        int[] ownedFields = fm.getOwnedFields(player);
        for (int i : ownedFields){
            sum += (int) ((fm.getPrice(i) * 0.5) + (fm.getHouses(i) * fm.getHousePrice(i) * 0.5));
        }
        return sum;
    }

    /** Checks whether anybody has lost */
    public boolean checkLoser() {
        for (int i = 1; i <= pm.getPlayerCount(); i++) {
            if ( (pm.getBalance(i) <= 0) && ((pm.getBalance(i)+sumAssets(i)) <= 0) ) {
                return true;
            }
        }
        return false;
    }

    /** Adds a player */
    public void addPlayer(String name) {
        pm.addPlayer(name);
    }

    /** Returns the amount of players in the game */
    public int getPlayerCount() {
        return pm.getPlayerCount();
    }

    /** Returns the balance of the player */
    public int getPlayerBalance(int player) {
        return pm.getBalance(player);
    }

    /** Returns the position of the player */
    public int getPlayerPosition(int player) {
        return pm.getPosition(player);
    }

    /** Sets the position of the player */
    public void setPlayerPosition(int player, int position) {
        pm.setPosition(player, position);
    }

    /** Returns the name the player */
    public String getPlayerName(int player) {
        return pm.getName(player);
    }

    /** Sets whether the player is in jail */
    public void setJailStatus(int player, boolean status) {
        pm.setJailStatus(player, status);
    }

    /** Returns whether the player is in jail */
    public boolean getJailStatus(int player) {
        return pm.isJailed(player);
    }

    /** Sets whether the player has a 'get out of jail' card */
    public void setJailCard(int player, boolean card) {
        pm.setJailCard(player,card);
    }

    /** Returns whether the player has a 'get out of jail' card */
    public boolean getJailCard(int player) {
        return pm.hasJailCard(player);
    }

    /** Moves the player a given distance */
    public void movePlayer(int player, int distance) {
        if ((distance+pm.getPosition(player)) >= 40) {
            changeBalance(player,4000);
        }
        pm.movePlayer(player,distance);
    }

    /** Returns the owner of the field */
    public int getFieldOwner(int field) {
        return fm.getOwner(field);
    }

    /** Returns whether the field is owned */
    public boolean isOwned(int field) {
        return fm.isOwned(field);
    }

    /** Returns the price of a field */
    public int getFieldPrice(int field) {
        return fm.getPrice(field);
    }

    /** Lists all fields owned by the player */
    public int[] getOwnedFields(int player) {
        return fm.getOwnedFields(player);
    }

    /** Returns the neighbourhood of the field */
    public String getNeighbourhood(int field) {
        return fm.getNeighbourhood(field);
    }

    /** Returns whether the neighbour is owned by a player */
    public boolean checkNeighbourhood(String nbh, int player) {
        return fm.checkNeighbourhood(nbh,player);
    }

    /** Marks the player as the owner of a neighbourhood */
    public void claimNeighbourhood(String nbh, int player) {
        fm.claimNeighbourhood(nbh, player);
    }

    /** Returns whether the field is ready for development */
    public boolean isBuildable(int field) {
        return fm.isBuildable(field);
    }

    /** Returns how many of the listed fields the player can build on */
    public int getBuildables(int[] fields) {
        return fm.getBuildables(fields);
    }

    /** Returns the number of houses present on the field */
    public int getHouses(int field) {
        return fm.getHouses(field);
    }

    /** Returns the price of a house on the field */
    public int getHousePrice(int field) {
        return fm.getHousePrice(field);
    }

    /** Pays for and places a house on the field */
    public void buyHouse(int field, int player) {
        changeBalance(player, -fm.getHousePrice(field));
        fm.setHouses(field,fm.getHouses(field)+1);
    }

    /** Sells a field and makes it available again */
    public void sellField(int field) {
        changeBalance(fm.getOwner(field),fm.getPrice(field)/2);
        fm.claimField(field,0);
    }

    /** Sells a house from the field */
    public void sellHouse(int field) {
        changeBalance(fm.getOwner(field),fm.getHousePrice(field)/2);
        fm.setHouses(field,fm.getHouses(field)-1);
    }

    /** Returns the field type */
    public String getFieldType(int field) {
        return fm.getType(field);
    }
}
