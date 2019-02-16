import java.time.*;
import java.util.ArrayList;


public class Pay {

    public void calculationProcess(LocalTime startTime, LocalTime endTime, String familyA, String familyB, String familyC)
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

                    int familyCase = 0;
                    int hrs = 0;

                    //Determine which family it is (A, B, or C)
                    switch(familyCase){
                        case 1:
                            family.equals("Family A");

                            calculateHoursAndPay(startTime,endTime,family,hrs, payForFullHours, j);

                            break;
                        case 2:
                            family.equals(("Family B"));

                            calculateHoursAndPay(startTime,endTime,family,hrs, payForFullHours, j);

                            break;

                        case 3:
                            family.equals(("Family C"));

                            calculateHoursAndPay(startTime,endTime,family,hrs, payForFullHours, j);

                            break;
                        default:
                            family.equals("");
                            break;

                    }

                }

            }

        }

    }

    public void calculateHoursAndPay(LocalTime startTime, LocalTime endTime, String family, int hrs, boolean payForFullHours, Job j)
    {

        //Calculate the number of hours between the start time and end time
        hrs = j.calculateHours(startTime, endTime);

        // Verify that babysitter gets paid for full hours (no fractional hours)
        payForFullHours = j.verifyPayForFullHours(family);

        // If the babysitter is getting paid for the full hours then proceed to calculate final pay
        if(payForFullHours)
        {
            j.calculateFinalPay(hrs, startTime, endTime);
        }
    }

}
