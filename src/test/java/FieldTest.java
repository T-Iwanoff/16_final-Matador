import org.junit.*;
import org.junit.Assert;

public class FieldTest {

    Field Street, Brewery, Ferry;

    @Before
    public void setUp() throws Exception {
        Street = new Field(1,1500,1000,100,400,1000,2000,4000,10000,"street","nbh1");
        Brewery = new Field(2,"brewery");
        Ferry = new Field(3,"ferry",4000);
    }

    @Test
    public void testGetRent() {
        Assert.assertEquals(100,Street.getRent()); //The street has no houses, so it should return rent0
        Street.setHouses(4);
        Assert.assertEquals(4000,Street.getRent()); //The street has 4 houses, so it should return rent4
        Assert.assertEquals(100,Street.getRent(0)); //Should return the rent for 0 houses (rent0)
        Assert.assertEquals(10000,Street.getRent(5)); //Should return the rent for 5 houses (ie. 1 hotel) (rent5)
        Assert.assertEquals(100,Brewery.getRent(1)); //Should return the rent for having 1 brewery
        Assert.assertEquals(200,Brewery.getRent(2)); //Should return the rent for having 2 breweries
        Assert.assertEquals(1000,Ferry.getRent(2)); //Should return the rent for having 2 ferries
        Assert.assertEquals(4000,Ferry.getRent(4)); //Should return the rent for having 4 ferries
    }



}
