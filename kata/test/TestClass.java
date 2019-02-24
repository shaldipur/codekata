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

    // Setting up families
    ArrayList familiesCollection = new ArrayList();


    @Before
    public void setUp()
    {

        pay = new Pay();
        bs = new Babysitter();
        j = new Job();


        // To test verifyFamiliesBabySatReturnTrue():

        // For verifyFamiliesBabySatReturnTrue to pass, add one family at a time to collection.
        // This is the default setting, hence it is uncommented.
        // For example:
        familiesCollection.add("Family A");

        // For verifyFamiliesBabySatReturnTrue to fail, pass in more than one family to collection.
        // For example:

        //familiesCollection.add("Family A");
        //familiesCollection.add("Family B");

    }


    // See comments in setUp() function to test verifyFamiliesBabySatReturnTrue

    @Test
    public void verifyFamiliesBabySatReturnTrue()
    {

        assertEquals(true, bs.verifyNumFamiliesBabysat(familiesCollection));
    }


    // The code below is prep for the three functions below that follow
    // Set up for the schedule
    // Feel free to alter accordingly to test.
    LocalTime startTime = LocalTime.of(17,00);
    LocalTime endTime = LocalTime.of(4,00);

    // This is just a test hour to test the verification of agreed upon hours
    // Feel free to alter accordingly.
    LocalTime hour = LocalTime.of(17,00);

    // Calculate the number of hours between the start time and end time
    Duration duration = Duration.between(startTime,endTime);

    long seconds = duration.getSeconds();

    // Convert seconds to hours
    long hours = TimeUnit.SECONDS.toHours(seconds);


    // Test pay for full hours
    @Test
    public void verifyPayForFullHoursReturnsTrue()
    {
        assertEquals(true, j.verifyPayForFullHours(hours));
    }

    // Test out the time ranges and schedule verifications
    @Test
    public void verifyTimeRangeReturnsTrue()
    {
        assertEquals(true,bs.verifyTimeRange(startTime,endTime));
    }

    // Test that the hours worked are the hours that are set in the schedules by each of the families.
    @Test
    public void verifyAgreedUponHours()
    {
        assertEquals(true, j.verifyAgreedUponHours(startTime, endTime, hour));
    }

}
