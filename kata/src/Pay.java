import java.time.*;
import java.util.ArrayList;


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
                    int hrs = 0;

                    //Calculate the number of hours between the start time and end time
                    hrs = j.calculateHours(startTime, endTime, hrs);

                    // Verify that babysitter gets paid for full hours (no fractional hours)
                    payForFullHours = j.verifyPayForFullHours(family);

                    // If the babysitter is getting paid for the full hours then proceed to calculate final pay
                    if(payForFullHours)
                    {
                      int finalPay =  j.calculateFinalPay(hrs, startTime, endTime, family);

                      System.out.print("The final pay is $ " + Integer.toString(finalPay) + " for " + family + "." );

                    }
                }
            }
        }
    }

}
