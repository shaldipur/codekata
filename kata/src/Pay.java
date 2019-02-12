import java.time.*;
import java.util.ArrayList;


public class Pay {

    public void calcTotalPay(LocalTime startTime, LocalTime endTime, String familyA, String familyB, String familyC)
    {

        boolean timeRangeIsCorrect = false;
        boolean numFamiliesBabysatIsOne = false;
        boolean payForFullHours = false;

        ArrayList<String> familiesCollection = new ArrayList<String>();

        // Get count of the families
        familiesCollection.add(familyA);
        familiesCollection.add(familyB);
        familiesCollection.add(familyC);

        Babysitter bs = new Babysitter();
        Job j = new Job();


        // Verify that start and end times are followed and that end time is not before start time
        timeRangeIsCorrect = bs.verifyTimeRange(startTime, endTime);

        // Verify number of families babysat (should only be one family at a time)
        numFamiliesBabysatIsOne = bs.verifyNumFamiliesBabysat(familyA, familyB, familyC);

        // Verify that babysitter gets paid for full hours (no fractional hours)

        if(timeRangeIsCorrect && numFamiliesBabysatIsOne)
        {
            for(String family: familiesCollection)
            {

                if (!family.equals(""))
                {
                    payForFullHours = j.verifyPayForFullHours(family);
                }

            }

        }

    }



}
