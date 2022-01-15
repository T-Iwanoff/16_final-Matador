import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Deck {

    private Cards[] cards;
    private Random randNum = new Random(); //random number generator
    private Set<Integer>set = new LinkedHashSet<Integer>(); //random number container
    private Integer[] randomArray = {}; //random number array


    /** Constructor. Sets up the cards array */
    public Deck() {
        //Creates a card object corresponding to each chance card in the game
        cards = new Cards[46];
        cards[0] = new Cards(1,1,-1000);//Pay the bank
        cards[1] = new Cards(2,1,-300);//Pay the bank
        cards[2] = new Cards(3,1,-200);//Pay the bank
        cards[3] = new Cards(4,1,-3000);//Pay the bank
        cards[4] = new Cards(5,1,-3000);//Pay the bank
        cards[5] = new Cards(6,1,-1000);//Pay the bank
        cards[6] = new Cards(7,1,-200);//Pay the bank
        cards[7] = new Cards(8,1,-1000);//Pay the bank
        cards[8] = new Cards(9,1,-200);//Pay the bank
        cards[9] = new Cards(10,1,-2000);//Pay the bank
        cards[10] = new Cards(11,2,0);//Pay the bank (house dependent)
        cards[11] = new Cards(12,2,0);//Pay the bank (house dependent)
        cards[12] = new Cards(13,1,500);//Receive from bank
        cards[13] = new Cards(14,1,500);//Receive from bank
        cards[14] = new Cards(15,1,1000);//Receive from bank
        cards[15] = new Cards(16,1,1000);//Receive from bank
        cards[16] = new Cards(17,1,1000);//Receive from bank
        cards[17] = new Cards(18,1,3000);//Receive from bank
        cards[18] = new Cards(19,1,1000);//Receive from bank
        cards[19] = new Cards(20,1,1000);//Receive from bank
        cards[20] = new Cards(21,1,1000);//Receive from bank
        cards[21] = new Cards(22,1,1000);//Receive from bank
        cards[22] = new Cards(23,1,1000);//Receive from bank
        cards[23] = new Cards(24,1,200);//Receive from bank
        cards[24] = new Cards(25,3,0);//Receive from bank (condition)
        cards[25] = new Cards(26,4,200);//Receive from players
        cards[26] = new Cards(27,4,500);//Receive from players
        cards[27] = new Cards(28,4,500);//Receive from players
        cards[28] = new Cards(29,5,3);//Move player
        cards[29] = new Cards(30,5,-3);//Move player
        cards[30] = new Cards(31,5,-3);//Move player
        cards[31] = new Cards(32,6,1);//Move to field
        cards[32] = new Cards(33,6,1);//Move to field
        cards[33] = new Cards(34,6,11);//Move to field
        cards[34] = new Cards(35,6,15);//Move to field
        cards[35] = new Cards(36,6,24);//Move to field
        cards[36] = new Cards(37,6,32);//Move to field
        cards[37] = new Cards(38,6,19);//Move to field
        cards[38] = new Cards(39,6,39);//Move to field
        cards[39] = new Cards(40,7,0);//Move to field (closest) 2x pay
        cards[40] = new Cards(41,7,0);//Move to field (closest) 2x pay
        cards[41] = new Cards(42,8,0);//Move to field (closest)
        cards[42] = new Cards(43,9,0);//Move to Jail
        cards[43] = new Cards(44,9,0);//Move to Jail
        cards[44] = new Cards(45,10,0);//Get jailCard
        cards[45] = new Cards(46,10,0);//Get jailCard
    }


    /** create array with random card order*/
    public void createDeck(){
        while (set.size() < 45) {
            set.add(randNum.nextInt(45)+1);
        }

        Integer[] randomArray = new Integer[set.size()];
        randomArray = set.toArray(randomArray);
}

    /** reshuffle the deck*/
    private void reShuffle(){
        set.clear();
        while (set.size() < 45) {
            set.add(randNum.nextInt(45)+1);
        }
        randomArray = set.toArray(randomArray);
    }

    /** draw the top card of the deck and get the ID*/
    public int drawCard(){
        int cardsLeft = set.size();
        int ID = -1;

        if (cardsLeft > 0){
            ++ID;
            --cardsLeft;

            return ID;
        }
        else{
            reShuffle();
            cardsLeft = set.size();
            ID = -1;
            ++ID;
            --cardsLeft;

            return ID;
        }
    }


}