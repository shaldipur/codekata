import java.util.*;
import java.time.*;


public class Babysitter {

    public boolean verifyTimeRange(LocalTime startTime, LocalTime endTime)
    {
        boolean timeRangeCorrect = false;

        // Scheduled start time and scheduled end time
        LocalTime scheduledStartTime = LocalTime.of(17,00);
        LocalTime scheduledEndTime = LocalTime.of(4,00);


        // Start time flags
        boolean startTimeEqualsScheduledStartTime = false;
        boolean startTimeIsAfterScheduledStartTime = false;



        // End time flags
        boolean endTimeEqualsScheduledEndTime = false;
        boolean endTimeIsBeforeScheduledEndTime = false;



        // Start time comparisons
        startTimeEqualsScheduledStartTime = startTime.equals(scheduledStartTime);
        startTimeIsAfterScheduledStartTime = startTime.isAfter(scheduledStartTime);

        // End time comparisons
        endTimeEqualsScheduledEndTime = endTime.equals(scheduledEndTime);
        endTimeIsBeforeScheduledEndTime = endTime.isBefore(scheduledEndTime);



        //Final time comparisons
        if((startTimeEqualsScheduledStartTime || startTimeIsAfterScheduledStartTime)
              && (endTimeEqualsScheduledEndTime || endTimeIsBeforeScheduledEndTime))
        {
            timeRangeCorrect = true;
        }


        return timeRangeCorrect;
    }

    public boolean verifyNumFamiliesBabysat(ArrayList<String> familiesCollection)
    {
        boolean numFamiliesBabysat = false;


        // Empty family values represent families that are not being babysat for
        // because the babysitter can only babysit for one family per night


        // Get count of the families
        // If the count is 1 then return true.  If zero or greater than one, then return false.
        if(familiesCollection.size() == 1)
        {
            numFamiliesBabysat = true;
        }

        return numFamiliesBabysat;
    }



}
