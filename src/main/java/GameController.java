import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class GameController {
    Bank bank = new Bank();
    DiceCup dc = new DiceCup();
    boolean gameEnd = false;
    int playerTurn = 0;
    int pairsRolled = 0;

    /** Constructor */
    public GameController() {
        runGame();
    }

    /** Runs the game */
    public void runGame() {
        //Sets up the game
        startGame();
        //Repeats playing a round until the game ends
        do {
            playRound();
        } while (!gameEnd);
        //Announces the winner then closes the GUI
        GUICreator.getInstance().showMessage(Language.getLine("endMessage")+"\n"+getWinner()+" "+Language.getLine("winner"));
        GUICreator.getInstance().close();
    }

    /** Sets up the game */
    private void startGame() {
        setLanguage();
        registerPlayers();
    }

    /** Lets the user input the players' names and sets up the players */
    private void registerPlayers() {
        GUI GUI = GUICreator.getInstance();
        //Lets the users input the number of players
        int playerCount;
        //Repeats until a player count between 3-6 is chosen
        do {
            playerCount = GUI.getUserInteger(Language.getLine("pSelect_num"));
            if (!(playerCount > 2 && playerCount < 7)) {
                GUI.showMessage(Language.getLine("pSelect_numError"));
            }
        }
        while (!(playerCount > 2 && playerCount < 7));
        //Registers the names of the players
        String[] names = new String[playerCount];
        //Accepts a name and creates a player with that name
        for (int i = 0; i < playerCount; i++) {
            String name;
            //Repeats whenever a name is already taken
            do {
                name = GUI.getUserString(Language.getLine("pSelect_name")+" "+(i + 1));
                if (checkListMatch(names,name)) {
                    GUI.showMessage(Language.getLine("pSelect_nameError"));
                }
            } while (checkListMatch(names,name));
            bank.addPlayer(name);
            names[i] = name;
        }
    }

    /** Returns whether a String is present in a String array */
    private boolean checkListMatch(String[] array, String string) {
        boolean temp = false;
        for (String i : array) {
            if (i != null) {
                if (i.equals(string)) {
                    temp = true;
                }
            }
        }
        return temp;
    }

    /** Opens a new window to let the user select a language */
    private void setLanguage() {
        //Opens an empty GUI
        GUI chooseLanguage = new GUI(new GUI_Field[0],new Color(51, 204, 0));
        //Creates a drop-down menu for selecting language
        String[] languages = Language.getLanguages();
        Language.setLanguage(chooseLanguage.getUserSelection(Language.getLine("lSelect"), languages));
        //Closes the empty GUI
        chooseLanguage.close();
    }

    /** Returns the name of the player with the most assets */
    private String getWinner() {
        int winner = 0, sum = 0;
        //Goes through all the players, checks whether their wealth is higher than the current frontrunner
        for (int i = 1; i<=bank.getPlayerCount(); i++) {
            int tempSum = bank.sumAssets(i)+bank.getPlayerBalance(i);
            if (sum < tempSum) {
                winner = i;
                sum = tempSum;
            }
        }
        return bank.getPlayerName(winner);
    }

    /** Plays a round */
    private void playRound() {
        //Makes each player take a turn, unless anyone has lost
        for (playerTurn = 1; playerTurn<=bank.getPlayerCount(); playerTurn++) {
            if (gameEnd) {return;}
            playTurn(playerTurn);
        }
        //Gives the users the choice to end the game
        if (!gameEnd) {
            String button = GUICreator.getInstance().getUserButtonPressed(Language.getLine("pChoice1.m"),
                            Language.getLine("pChoice1.1"),Language.getLine("pChoice1.2"));
            if (button.equals(Language.getLine("pChoice1.2"))) {gameEnd = true;}
        }
    }

    /** Plays a turn */
    private void playTurn(int player) {
        //Redirects the game if the player starts their turn in jail
        if (bank.getJailStatus(player)) {
            playerJailed(player);
            //If the player is still jailed, ends their turn
            if (bank.getJailStatus(player)) {
                return;
            }
        }
        //If the player wasn't jailed, has them roll the dice
        else {
            GUICreator.getInstance().showMessage(Language.getLine("turnMsg1")+" "+
                            bank.getPlayerName(player)+Language.getLine("turnMsg2"));
            dc.rollDice();
            }
        //Gives the player an extra turn if they rolled a pair
        if (dc.isPair()) {
            //If they have rolled a pair 3 times, they get jailed
            if (++pairsRolled == 3) {
                bank.setJailStatus(player, true);
                bank.setPlayerPosition(player, 10);
                pairsRolled = 0;
                GUICreator.getInstance().showMessage(Language.getLine("rolled3pairs"));
                return;
            }
            playerTurn--;
            GUICreator.getInstance().showMessage(Language.getLine("rolledpair"));
        }
        //If they didn't roll a pair, resets pair counter
        else {pairsRolled = 0;}
        //Moves the player to forward and simulates them landing on a field
        bank.movePlayer(player,dc.getSum());
        fieldAction(player,bank.getPlayerPosition(player));
        //Checks whether anyone has lost
        if (bank.checkLoser()) {
            gameEnd = true;
            return;
        }
        //Checks whether the player ended up in jail
        if (bank.getJailStatus(player)) {
            return;
        }
        //Checks whether the player needs to sell something to avoid going bankrupt
        if (bank.getPlayerBalance(player) <= 0) {
            forceSale(player);
        }
        //Gives the player the option to buy and sell fields and houses or end their turn
        turnMenu(player);
    }

    /** Goes through the player's options if they are jailed */
    private void playerJailed(int player) {
        //If the player has a 'get out of jail' card
        if (bank.getJailCard(player)) {
            bank.setJailCard(player,false);
            bank.setJailStatus(player,false);
            GUICreator.getInstance().showMessage(Language.getLine("prisonCardOut1")+" "+
                    bank.getPlayerName(player)+Language.getLine("prisonCardOut2"));
            dc.rollDice();
            return;
        }
        //Otherwise, the player is asked to pay or roll their way out
        String button = GUICreator.getInstance().getUserButtonPressed(
                Language.getLine("pChoice2.m1")+" "+bank.getPlayerName(player)+Language.getLine("pChoice2.m2"),
                Language.getLine("pChoice2.1"),Language.getLine("pChoice2.1"));
        //If the player chose pay
        if (button.equals(Language.getLine("pChoice2.1"))) {
            bank.changeBalance(player,-1000);
            bank.setJailStatus(player,false);
            GUICreator.getInstance().showMessage(Language.getLine("pChoice2.1m"));
            dc.rollDice();
            return;
        }
        //If the player chose to roll for freedom
        if (button.equals(Language.getLine("pChoice2.2"))) {
            GUICreator.getInstance().showMessage(Language.getLine("pChoice2.2m"));
            for (int i=0; i<3; i++) {
                dc.rollDice();
                if (dc.isPair()) {
                    bank.setJailStatus(player,false);
                    GUICreator.getInstance().showMessage(Language.getLine("prisonRoll1"));
                    break;
                }
                else if (i<2) {GUICreator.getInstance().showMessage(Language.getLine("prisonRoll2"));}
            }
            //If the player failed to get out
            GUICreator.getInstance().showMessage(Language.getLine("prisonRoll3"));
        }
    }

    /** Executes an action based on which field the player landed on */
    private void fieldAction(int player, int field) { //
        //Checks which field type the player landed on and redirects them
        String fieldType = GUICreator.getInstance().getFields()[field].getClass().getSimpleName();
        switch (fieldType) {
            case "GUI_Street":
            case "GUI_Brewery":
            case "GUI_Shipping":
                ownableAction(player, field);
                break;
            case "GUI_Chance":
                //chanceAction(player);
                break;
            case "GUI_Tax":
                taxAction(player, field);
                break;
            case "GUI_Jail":
                jailAction(player, field);
                break;
            case "GUI_Start":
                GUICreator.getInstance().showMessage(Language.getLine("landOnStart"));
                break;
            case "GUI_Refuge":
                GUICreator.getInstance().showMessage(Language.getLine("landOnRefuge"));
                break;
        }
    }

    /** Executes landing on a street */
    private void ownableAction(int player, int field) {
        GUI GUI = GUICreator.getInstance();
        //Checks if the field is owned
        if (bank.isOwned(field)) {
            GUI.showMessage(Language.getLine("landOn")+" "+Language.getLine("f"+(field+1)+"_title")+Language.getLine("landOnOwned"));
            //Pay rent
            bank.payRent(field,player,dc.getSum());
        }
        else {
            //Checks if the player can afford the field
            if (bank.getPlayerBalance(player)<bank.getFieldPrice(field)) {
                GUI.showMessage(Language.getLine("landOn") + " " + Language.getLine("f" + (field + 1) + "_title")
                        + Language.getLine("landOnUnowned"));
                return;
            }
            //Offers for the player to buy the field
            String button = GUI.getUserButtonPressed(Language.getLine("landOn")+" "
                            +Language.getLine("f"+(field+1)+"_title")+Language.getLine("pChoice3.m"),
                            Language.getLine("pChoice3.1"), Language.getLine("pChoice3.2"));
            //If the player chose to buy it
            if (button.equals(Language.getLine("pChoice3.1"))) {
                bank.buyField(field,player);
                GUI.showMessage(Language.getLine("pChoice3.1m")+" "+Language.getLine("f"+(field+1)+"_title"));
            }
        }
    }

    /** Executes landing on a tax field */
    private void taxAction(int player, int field) {
        //Checks which tax field the player landed on
        switch (field) {
            case 4:
                //Choose between paying 10% of your wealth or 4000
                String button = GUICreator.getInstance().getUserButtonPressed(Language.getLine("f5_desc"),
                        Language.getLine("landOnTax4000"),Language.getLine("landOnTax10"));
                //If paying 4000
                if (button.equals(Language.getLine("landOnTax4000"))) {
                    bank.changeBalance(player,-4000);
                    GUICreator.getInstance().showMessage(Language.getLine("landOnTax") + " 4000");
                    break;
                }
                //If paying 10%
                if (button.equals(Language.getLine("landOnTax10"))) {
                    int take10 = (bank.getPlayerBalance(player) + bank.sumAssets(player)) / 10;
                    bank.changeBalance(player, -take10);
                    GUICreator.getInstance().showMessage(Language.getLine("landOnTax") + " " + take10);
                    break;
                }
            case 38:
                //Pay 2000
                GUICreator.getInstance().showMessage(Language.getLine("f39_desc"));
                bank.changeBalance(player,-2000);
        }
    }

    /** Executes landing on a jail field */
    private void jailAction(int player, int field) {
        //Checks which jail field the player landed on
        switch (field) {
            case 10:
                //Visiting jail
                GUICreator.getInstance().showMessage(Language.getLine("landOnJail1"));
                break;
            case 30:
                //Get arrested
                GUICreator.getInstance().showMessage(Language.getLine("landOnJail2"));
                bank.setPlayerPosition(player,10);
                bank.setJailStatus(player,true);
        }
    }

    /** Forces the player to sell their fields or houses until they have a positive balance */
    private void forceSale(int player) {

    }

    /** Handles letting the player choose between buying, selling and ending their turn */
    private void turnMenu(int player) {}
}

