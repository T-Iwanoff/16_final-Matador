import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class GameController {
    Bank bank = new Bank();
    DiceCup dc = new DiceCup();
    PlayerManager pm = new PlayerManager();
    boolean gameEnd = false;
    int playerTurn = 0;
    int pairsRolled = 0;

    /** Constructor */
    public GameController() {
        runGame();
    }

    /** Runs the game */
    public void runGame() {
        startGame(); //Sets up the game
        do {
            playRound(); //Repeats playing a round until the game ends
        } while (!gameEnd);
        //Announces the winner
        GUICreator.getInstance().showMessage(Language.getLine("endMessage")+"\n"+getWinner()+" "+Language.getLine("winner"));
    }

    /** Sets up the game */
    private void startGame() {
        setLanguage();
        registerPlayers();
    }

    /** Lets the user input the players' names and sets up the players */
    private void registerPlayers() { //
        GUI GUI = GUICreator.getInstance();
        //Registers the amount of players
        int playerCount;
        do {
            playerCount = GUI.getUserInteger(Language.getLine("pSelect_num"));
            if (!(playerCount > 2 && playerCount < 7)) {
                GUI.showMessage(Language.getLine("pSelect_numError"));
            }
        }
        while (!(playerCount > 2 && playerCount < 7));
        //Registers the names of the players
        String[] names = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            String name;
            //Accepts a name and checks whether it is already taken
            do {
                name = GUI.getUserString(Language.getLine("pSelect_name")+" "+(i + 1));
                if (checkListMatch(names,name)) {
                    GUI.showMessage(Language.getLine("pSelect_nameError"));
                }
            } while (checkListMatch(names,name));
            //bank.addPlayer(name);
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
        GUI chooseLanguage = new GUI(new GUI_Field[0],new Color(51, 204, 0));
        String[] languages = Language.getLanguages();
        Language.setLanguage(chooseLanguage.getUserSelection(Language.getLine("lSelect"), languages));
        chooseLanguage.close();
    }

    /** Returns the name of the player with the most assets */
    private String getWinner() { //
        int winner, sum = 0;
        //for (int i = 1; i<=bank.getPlayerCount(); i++) {
            //if (sum < (bank.sumAssets(i)+bank.getPlayerBalance(i))) {
            //    winner = i;
            //    sum = bank.sumAssets(i)+bank.getPlayerBalance(i);
            //}
        //}
        //return bank.getPlayerName(winner);
        return "none";
    }

    /** Plays a round */
    private void playRound() { //
        //Makes each player take a turn, unless someone loses
        //for (playerTurn = 1; playerTurn<=bank.getPlayerCount(); playerTurn++) {
        //    if (gameEnd) continue;
        //    playTurn(playerTurn);
        //}
        //Gives the users the choice to end the game
        if (!gameEnd) {
            String button = GUICreator.getInstance().getUserButtonPressed(Language.getLine("pChoice1.m"),
                            Language.getLine("pChoice1.1"),Language.getLine("pChoice1.2"));
            if (button.equals(Language.getLine("pChoice1.2"))) {gameEnd = true;}
        }
    }

    /** Plays a turn */
    private void playTurn(int player) { //
        dc.rollDice();
        //Gives the player an extra turn if they rolled a pair
        if (dc.isPair()) {
            if (++pairsRolled == 3) {
                //bank.setJailStatus(player, true);
                pairsRolled = 0;
            }
            playerTurn--;
        }
        //Moves the player to forward and simulates them landing on a field
        //bank.movePlayer(player,dc.getSum());
        //fieldAction(player,bank.getPlayerPosition())
        //Checks whether the player needs to sell something to avoid going bankrupt
        //if ( (bank.getPlayerBalance(player) <= 0) && ((bank.getPlayerBalance(player)+bank.sumAssets(player)) > 0) ) {
        //    forceSale(player);
        //}
        //Checks whether anyone has lost
        //if (bank.checkLoser) {
        //    gameEnd = true;
        //}
        //Gives the player the option to buy and sell fields and houses or end their turn
        //else {
        //    turnMenu(player);
        //}
    }

    /** Executes an action based on which field the player landed on */
    private void fieldAction(int player, int field) {
        String fieldType = GUICreator.getInstance().getFields()[field].getClass().getSimpleName();
        switch (fieldType) {
            case "GUI_Street":
                //streetAction(player, field);
                break;
            case "GUI_Chance":
                //chanceAction(player);
                break;
            case "GUI_Tax":
                //taxAction(player, field);
                break;
            case "GUI_Brewery":
                //breweryAction(player);
                break;
            case "GUI_Shipping":
                //shippingAction(player);
                break;
            case "GUI_Jail":
                //jailAction(player, field);
            case "GUI_Start":
            case "GUI_Refuge":
                break;
        }
    }

    /** Forces the player to sell their fields or houses until they have a positive balance */
    private void forceSale(int player) {}

    /** Handles letting the player choose between buying, selling and ending their turn */
    private void turnMenu(int player) {}
}

