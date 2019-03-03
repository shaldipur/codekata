import java.util.*;
import java.time.*;


public class Babysitter {

    // Start time flags
    private boolean startTimeEqualsScheduledStartTime;
    private boolean startTimeIsAfterScheduledStartTime;

    // End time flags
    private boolean endTimeEqualsScheduledEndTime;
    private boolean endTimeIsBeforeScheduledEndTime ;

    public boolean verifyTimeRange(LocalTime startTime, LocalTime endTime)
    {
        boolean timeRangeCorrect = false;

        // Scheduled start time and scheduled end time
        LocalTime scheduledStartTime = LocalTime.of(17,00);
        LocalTime scheduledEndTime = LocalTime.of(4,00);

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

        // Get count of the families
        // If the count is 1 then return true.  If zero or greater than one, then return false.
        if(familiesCollection.size() == 1)
        {
            numFamiliesBabysat = true;
        }

        return numFamiliesBabysat;
    }

}
