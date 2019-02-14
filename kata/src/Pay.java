import java.time.*;
import java.util.ArrayList;


public class Pay {

    public void calcTotalPay(LocalTime startTime, LocalTime endTime, String familyA, String familyB, String familyC)
    {

        boolean timeRangeIsCorrect = false;
        boolean numFamiliesBabysatIsOne = false;
        boolean payForFullHours = false;

        ArrayList<String> familiesCollection = new ArrayList<String>();

        familiesCollection.add(familyA);
        familiesCollection.add(familyB);
        familiesCollection.add(familyC);

        Babysitter bs = new Babysitter();
        Job j = new Job();


        // Verify that start and end times are followed and that end time is not before start time
        timeRangeIsCorrect = bs.verifyTimeRange(startTime, endTime);

        // Verify number of families babysat (should only be one family at a time)
        numFamiliesBabysatIsOne = bs.verifyNumFamiliesBabysat(familiesCollection);

        // If timeRangeIsCorrect flag and numFamiliesBabysatIsOn flag
        // both return true then execute the code in the if block

        if(timeRangeIsCorrect && numFamiliesBabysatIsOne)
        {
            for(String family: familiesCollection)
            {
                if (!family.equals(""))
                {
                    // Verify that babysitter gets paid for full hours (no fractional hours)
                    payForFullHours = j.verifyPayForFullHours(family);
                }

            }

        }

        // If payForFullHours flag returns true, then calculate the total pay based on
        // based on the family, the time ranges specified and the number of hours worked

        // Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night


        // Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night


        // Family C pays $21 per hour before 9pm, then $15 the rest of the night


    }



}
