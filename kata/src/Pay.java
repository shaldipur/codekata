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

                    int familyCase = 0;

                    //Determine which family it is (A, B, or C)
                    switch(familyCase){
                        case 1:
                            family.equals("Family A");

                            //Determine the amount paid by the family based on the time range

                            //between 5pm and 11pm: $15/hr
                            //between 11pm and 4am: $20/hr

                            // Verify that babysitter gets paid for full hours (no fractional hours)
                            payForFullHours = j.verifyPayForFullHours(family);


                            break;
                        case 2:
                            family.equals(("Family B"));

                            //Determine the amount paid by the family based on the time range

                            //between 5pm and 10pm: $12/hr
                            //between 10pm and 12am: $8/hr
                            //between 12am and 4am: $16/hr


                            // Verify that babysitter gets paid for full hours (no fractional hours)
                            payForFullHours = j.verifyPayForFullHours(family);

                            break;

                        case 3:
                            family.equals(("Family C"));

                            //Determine the amount paid by the family based on the time range
                            //between 5pm and 9pm: $21/hr
                            //between 9pm and 4am: $15/hr


                            // Verify that babysitter gets paid for full hours (no fractional hours)
                            payForFullHours = j.verifyPayForFullHours(family);

                            break;
                        default:
                            family.equals("");
                            break;

                    }





                }

            }

        }



    }



}
