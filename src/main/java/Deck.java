import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Deck {

    private final Cards[] cards;
    private final Random randNum = new Random(); //random number generator
    private final int deckSize = 46; //amount of chance cards in total
    private int cardsLeft = 0; //The number of cards remaining in the deck
    private Integer[] deck = new Integer[deckSize]; //An array of random numbers corresponding to the cards' index values


    /** Constructor. Sets up the cards array */
    public Deck() {
        //Creates a card object corresponding to each chance card in the game
        cards = new Cards[deckSize];
        cards[0] = new Cards(1,"interactBank",-1000);//Pay the bank
        cards[1] = new Cards(2,"interactBank",-300);//Pay the bank
        cards[2] = new Cards(3,"interactBank",-200);//Pay the bank
        cards[3] = new Cards(4,"interactBank",-3000);//Pay the bank
        cards[4] = new Cards(5,"interactBank",-3000);//Pay the bank
        cards[5] = new Cards(6,"interactBank",-1000);//Pay the bank
        cards[6] = new Cards(7,"interactBank",-200);//Pay the bank
        cards[7] = new Cards(8,"interactBank",-1000);//Pay the bank
        cards[8] = new Cards(9,"interactBank",-200);//Pay the bank
        cards[9] = new Cards(10,"interactBank",-2000);//Pay the bank
        cards[10] = new Cards(11,"interactBankHouses",500);//Pay the bank (house dependent)
        cards[11] = new Cards(12,"interactBankHouses",800);//Pay the bank (house dependent)
        cards[12] = new Cards(13,"interactBank",500);//Receive from bank
        cards[13] = new Cards(14,"interactBank",500);//Receive from bank
        cards[14] = new Cards(15,"interactBank",1000);//Receive from bank
        cards[15] = new Cards(16,"interactBank",1000);//Receive from bank
        cards[16] = new Cards(17,"interactBank",1000);//Receive from bank
        cards[17] = new Cards(18,"interactBank",3000);//Receive from bank
        cards[18] = new Cards(19,"interactBank",1000);//Receive from bank
        cards[19] = new Cards(20,"interactBank",1000);//Receive from bank
        cards[20] = new Cards(21,"interactBank",1000);//Receive from bank
        cards[21] = new Cards(22,"interactBank",1000);//Receive from bank
        cards[22] = new Cards(23,"interactBank",1000);//Receive from bank
        cards[23] = new Cards(24,"interactBank",200);//Receive from bank
        cards[24] = new Cards(25,"interactBankCon",15000);//Receive from bank (condition)
        cards[25] = new Cards(26,"getFromPlayer",200);//Receive from players
        cards[26] = new Cards(27,"getFromPlayer",500);//Receive from players
        cards[27] = new Cards(28,"getFromPlayer",500);//Receive from players
        cards[28] = new Cards(29,"movePlayer",3);//Move player
        cards[29] = new Cards(30,"movePlayer",-3);//Move player
        cards[30] = new Cards(31,"movePlayer",-3);//Move player
        cards[31] = new Cards(32,"moveToField",0);//Move to field
        cards[32] = new Cards(33,"moveToField",0);//Move to field
        cards[33] = new Cards(34,"moveToField",11);//Move to field
        cards[34] = new Cards(35,"moveToField",15);//Move to field
        cards[35] = new Cards(36,"moveToField",24);//Move to field
        cards[36] = new Cards(37,"moveToField",32);//Move to field
        cards[37] = new Cards(38,"moveToField",19);//Move to field
        cards[38] = new Cards(39,"moveToField",39);//Move to field
        cards[39] = new Cards(40,"moveClosest2x",0);//Move to closest ferry 2x pay
        cards[40] = new Cards(41,"moveClosest2x",0);//Move to closest ferry 2x pay
        cards[41] = new Cards(42,"moveClosest",0);//Move to closest ferry
        cards[42] = new Cards(43,"moveToJail",0);//Move to Jail
        cards[43] = new Cards(44,"moveToJail",0);//Move to Jail
        cards[44] = new Cards(45,"getJailCard",0);//Get jailCard
        cards[45] = new Cards(46,"getJailCard",0);//Get jailCard
    }

    /** Shuffles the deck */
    private void shuffleDeck(){
        //Creates a list from 0 to 45 in random order
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < deckSize) {
            set.add(randNum.nextInt(deckSize));
        }
        //Adds the list to an array
        deck = set.toArray(deck);
    }

    /** Draw the top card of the deck and return its index value */
    public int drawCard(){
        //If there are no cards left, shuffle the deck
        if (cardsLeft == 0) {
            shuffleDeck();
            cardsLeft = deckSize;
        }
        //Draw the next card from the deck
        return deck[--cardsLeft];
    }

    /** Get action of the card */
    public String getAction(int currentCard) {
        return cards[currentCard].getAction();
    }

    /** Get value of the card*/
    public int getValue(int currentCard) {
        return cards[currentCard].getValue();
    }

    /** Get ID of the card*/
    public int getID(int currentCard) {
        return cards[currentCard].getID();
    }

}