import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class TestClass {

    Pay pay;
    Babysitter bs;
    Job j;

    // Setting up times
    LocalTime startTime = LocalTime.of(17,00);
    LocalTime endTime = LocalTime.of(4,00);
    LocalTime hour = LocalTime.of(17,00);

    // Calculate the number of hours between the start time and end time
    Duration duration = Duration.between(startTime,endTime);

    long seconds = duration.getSeconds();

    // Convert seconds to hours
    long hours = TimeUnit.SECONDS.toHours(seconds);

    // Setting up families
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

        familiesCollection.add(familyA);
        familiesCollection.add(familyB);
        familiesCollection.add(familyC);

    }


    @Test
    public void verifyTimeRangeReturnsTrue()
    {
        assertEquals(true,bs.verifyTimeRange(startTime,endTime));
    }


    @Test
    public void verifyFamiliesBabySatReturnTrue()
    {


        assertEquals(true, bs.verifyNumFamiliesBabysat(familiesCollection));
    }


    @Test
    public void verifyPayForFullHoursReturnsTrue()
    {
        assertEquals(true, j.verifyPayForFullHours(hours));
    }


    @Test
    public void verifyAgreedUponHours()
    {
        assertEquals(true, j.verifyAgreedUponHours(startTime, endTime, hour));
    }




}
