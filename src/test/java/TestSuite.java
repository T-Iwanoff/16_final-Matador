import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        DieTest.class,
        FieldTest.class,
        PlayerTest.class,
        DiceCupTest.class,
        FieldManagerTest.class
})

public class TestSuite {
}  