import java.time.*;
import java.util.ArrayList;



public class Pay {

    private boolean timeRangeIsCorrect;
    private boolean numFamiliesBabysatIsOne;
    private boolean payForFullHours;

    public void calculationProcess(LocalTime startTime, LocalTime endTime, ArrayList<String> familiesCollection)
    {

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
            // Get the family that is paying the babysitter
            String family = familiesCollection.get(0);

            // Calculate time difference between start time and end time

            // Determining the hours worked ties into seeing if the pay is for full hours
            // instead of fractional hours
            double hours = j.calculateHours(startTime,endTime);

            // Verify that babysitter gets paid for full hours (no fractional hours)
            payForFullHours = j.verifyPayForFullHours(hours);

            // If the babysitter is getting paid for the full hours then proceed to calculate final pay
            if(payForFullHours)
            {
              int finalPay =  j.calculateFinalPay(startTime, endTime, family);

              System.out.print("The final pay is $ " + Integer.toString(finalPay) + " for " + family + "." );

            }
        }
    }

}
