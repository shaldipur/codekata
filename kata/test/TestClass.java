import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import java.time.*;


public class TestClass {

    Pay pay;
    Babysitter bs;

    LocalTime startTime = LocalTime.of(17,00);
    LocalTime endTime = LocalTime.of(4,00);

    @Before
    public void setUp()
    {

        pay = new Pay();
        bs = new Babysitter();

    }


    @Test
    public void verifyTimeRangeReturnsTrue()
    {
        assertEquals(true,bs.verifyTimeRange(startTime,endTime));
    }


//    @Test
//    public void verifyFamiliesBabySatReturnTrue()
//    {
//        assertEquals(true, bs.verifyNumFamiliesBabysat("familyA", "", ""));
//    }
//
//    @Test
//    public void verifyPayForFullHoursReturnsTrue()
//    {
//        assertEquals(true, bs.verifyPayForFullHours());
//    }




}
