import org.junit.*;
import org.junit.Assert;

public class DieTest {

    private Die die;

    @Before
    public void setUp() {
        die = new Die(6);
    }

    @Test
    public void testRollDie() {
        int highest = 0;
        int lowest = 4;
        for (int i = 0; i < 100; i++) {
            int roll = die.rollDie();
            if (roll > highest) {highest = roll;}
            if (roll < lowest) {lowest = roll;}
        }
        Assert.assertEquals(6,highest); //The rolls should never go higher than 6
        Assert.assertEquals(1,lowest); //The rolls should never go lower than 1
    }



}
