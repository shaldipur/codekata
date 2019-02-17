import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import java.time.*;
import java.util.ArrayList;


public class TestClass {

    Pay pay;
    Babysitter bs;
    Job j;

    LocalTime startTime = LocalTime.of(17,00);
    LocalTime endTime = LocalTime.of(4,00);

    ArrayList familiesCollection = new ArrayList();

    String familyA = "Family A";
    String familyB = "Family B";
    String familyC = "Family C";


    @Before
    public void setUp()
    {

        pay = new Pay();
        bs = new Babysitter();
        j = new Job();

    }


    @Test
    public void verifyTimeRangeReturnsTrue()
    {
        assertEquals(true,bs.verifyTimeRange(startTime,endTime));
    }


    @Test
    public void verifyFamiliesBabySatReturnTrue()
    {
        familiesCollection.add(familyA);
        familiesCollection.add(familyB);
        familiesCollection.add(familyC);

        assertEquals(true, bs.verifyNumFamiliesBabysat(familiesCollection));
    }

    //calculate hours

    @Test
    public void verifyPayForFullHoursReturnsTrue()
    {
        assertEquals(true, j.verifyPayForFullHours(familyA));
    }


    //calculate final pay



}
