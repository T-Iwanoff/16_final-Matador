import org.junit.*;
import org.junit.Assert;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("tester");
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("tester",player.getName()); //Player should get the name specified in the setUp
        Assert.assertEquals(0,player.getPosition()); //Player should that at position 0
    }


    @Test
    public void testMovePlayer() {
        player.movePlayer(5);
        Assert.assertEquals(5,player.getPosition()); //The player should have moved 5 fields
        player.movePlayer(6);
        Assert.assertEquals(11,player.getPosition()); //The position should be additive (5+6)
        player.setPosition(25);
        player.movePlayer(7);
        Assert.assertEquals(32,player.getPosition()); //The method should accept outside changes in the player's position
        player.movePlayer(10);
        Assert.assertEquals(2,player.getPosition()); //Reaching 40 should reset the position to 0

    }



}
