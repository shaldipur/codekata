import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestClass {

    Pay pay;


    @Before
    public void setUp()
    {
        pay = new Pay();

    }

    @Test
    public void numberOfFamiliesBabySatReturnOne()
    {
        assertEquals("1", pay.familyNumberBabySat(1));
    }




}
