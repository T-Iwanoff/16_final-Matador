import org.junit.*;
import org.junit.Assert;

public class DiceCupTest {

    private DiceCup dice;

    @Before
    public void setUp() {
        dice = new DiceCup();
        dice.rollDice();
    }

    @Test
    public void testRollDie() {
        int highest = 0;
        int lowest = 6;
        for (int i = 0; i < 200; i++) {
            int roll = dice.rollDice();
            if (roll > highest) {highest = roll;}
            if (roll < lowest) {lowest = roll;}
        }
        Assert.assertEquals(12,highest); //The rolls should never go higher than 12
        Assert.assertEquals(2,lowest); //The rolls should never go lower than 2
    }

    @Test
    public void testGetFaces() {

        int[] rolls = dice.getFaces();
        Assert.assertEquals(2,rolls.length); //The DiceCup should always return two dice values
        for (int i=0;i<100;i++) {
            rolls = dice.getFaces();
            Assert.assertTrue(rolls[0]<=6 && rolls[1]<=6); //The dice should always be 6 or lower
            Assert.assertTrue(rolls[0]>=1 && rolls[1]>=1); //The dice should always be 1 or higher
        }
    }

    @Test
    public void testGetSum() {
        for (int i=0;i<100;i++) {
            int[] rolls = dice.getFaces();
            Assert.assertEquals(rolls[0]+rolls[1],dice.getSum()); //GetSum should always return the sum of the two dice
        }
    }

    @Test
    public void testIsPair() {
        for (int i=0;i<100;i++) {
            int[] rolls = dice.getFaces();
            Assert.assertEquals((rolls[0] == rolls[1]),dice.isPair()); //isPair should always return whether
                                                                       // the two dice show the same amount of eyes
        }
    }


}
