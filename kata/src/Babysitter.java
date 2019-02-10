import java.util.*;
import java.time.*;


public class Babysitter {

    ArrayList<String> collectFamilies = new ArrayList<String>();
    ArrayList<String> numFamilies = new ArrayList<String>();

    public boolean verifyTimeRange(LocalTime startTime, LocalTime endTime)
    {
        boolean timeRangeCorrect = false;

        // Scheduled start time and scheduled end time
        LocalTime scheduledStartTime = LocalTime.of(17,00);
        LocalTime scheduledEndTime = LocalTime.of(4,00);

        // Start time flags
        boolean startTimeEqualsScheduledStartTime = false;
        boolean startTimeIsAfterScheduledStartTime = false;
        boolean startTimeIsBeforeScheduledEndTime = false;


        // End time flags
        boolean endTimeEqualsScheduledEndTime = false;
        boolean endTimeIsBeforeScheduledEndTime = false;
        boolean endTimeIsAfterScheduledStartTime = false;


        // Start time comparisons
        startTimeEqualsScheduledStartTime = startTime.equals(scheduledStartTime);
        startTimeIsAfterScheduledStartTime = startTime.isAfter(scheduledStartTime);

        startTimeIsBeforeScheduledEndTime = startTime.isBefore(scheduledEndTime);


        // End time comparisons
        endTimeEqualsScheduledEndTime = endTime.equals(scheduledEndTime);
        endTimeIsBeforeScheduledEndTime = endTime.isBefore(scheduledEndTime);

        endTimeIsAfterScheduledStartTime = endTime.isAfter(scheduledStartTime);

        //Final time comparisons

        if((startTimeEqualsScheduledStartTime == true  || startTimeIsAfterScheduledStartTime == true) && startTimeIsBeforeScheduledEndTime == true )
        {
            if((endTimeEqualsScheduledEndTime == true || endTimeIsBeforeScheduledEndTime == true) && endTimeIsAfterScheduledStartTime)
            {
                timeRangeCorrect = true;
            }

        }


        return timeRangeCorrect;
    }

    public boolean verifyNumFamiliesBabysat(String familyA, String familyB, String familyC)
    {
        boolean numFamiliesBabysat = false;


        // Get count of the families
        collectFamilies.add(familyA);
        collectFamilies.add(familyB);
        collectFamilies.add(familyC);

        // Loop thru array list and remove any null family values

        // Empty family values represent families that are not being babysat for
        // because the babysitter can only babysit for one family per night

        for(String family: collectFamilies)
        {

            if (!family.equals(""))
            {
                numFamilies.add(family);
            }

        }

        if(numFamilies.size() == 1)
        {
            numFamiliesBabysat = true;
        }

        return numFamiliesBabysat;
    }

    public boolean verifyPayForFullHours()
    {
        boolean payForFullHours = false;



        return payForFullHours;
    }
}
