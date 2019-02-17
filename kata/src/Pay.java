import java.time.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.lang.Math;


public class Pay {

    private boolean timeRangeIsCorrect;
    private boolean numFamiliesBabysatIsOne;
    private boolean payForFullHours;

    public void calculationProcess(LocalTime startTime, LocalTime endTime, String familyA, String familyB, String familyC)
    {

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
                    // Calculate time difference between start time and end time
                    long hours = j.calculateHours(startTime,endTime);

                    // Verify that babysitter gets paid for full hours (no fractional hours)
                    payForFullHours = j.verifyPayForFullHours(hours);

                    // If the babysitter is getting paid for the full hours then proceed to calculate final pay
                    if(payForFullHours)
                    {
                      int finalPay =  j.calculateFinalPay(hours, startTime, endTime, family);

                      System.out.print("The final pay is $ " + Integer.toString(finalPay) + " for " + family + "." );

                    }
                }
            }
        }
    }

}
