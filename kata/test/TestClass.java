import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestClass {

    Pay pay;
    Babysitter bs;

    @Before
    public void setUp()
    {

        pay = new Pay();
        bs = new Babysitter();

    }

    @Test
    public void numberOfFamiliesBabySatReturnOne()
    {
        assertEquals(true, bs.verifyNumFamiliesBabysat("familyA", "", ""));
    }




}
