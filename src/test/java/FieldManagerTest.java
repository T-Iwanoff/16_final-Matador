import org.junit.*;
import org.junit.Assert;

public class FieldManagerTest {

    private FieldManager fm;

    @Before
    public void setUp() {
        fm = new FieldManager();
    }

    @Test
    public void testGetOwnedFields() {
        int[] owned = fm.getOwnedFields(1);
        Assert.assertEquals(0,owned.length); //The array should be empty since no fields are owned
        fm.claimField(1,1); //claimField takes a field position as input
        fm.claimField(3,1); //An invalid field position can give unexpected results
        fm.claimField(6,1);
        owned = fm.getOwnedFields(1);
        Assert.assertEquals(3,owned.length); //The array should now contain 3 fields
        Assert.assertEquals(1,owned[0]); //The first field in the array should be field 2
        Assert.assertEquals(6,owned[2]); //The last field in the array should be field 7
    }



}
