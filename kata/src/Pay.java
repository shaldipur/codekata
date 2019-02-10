import java.time.*;


public class Pay {


    public String familyNumberBabySat(Integer inputNum)
    {

        return inputNum.toString();
    }


    public void calcTotalPay(LocalTime startTime, LocalTime endTime, String familyA, String familyB, String familyC)
    {

        boolean timeRange = false;
        boolean numFamiliesBabysat = false;
        boolean payForFullHours = false;

        Babysitter bs = new Babysitter();


        // Verify that start and end times are followed
        // Verify that end time is not before start time
        timeRange = bs.verifyTimeRange(startTime, endTime);

        // Verify number of families babysat
        numFamiliesBabysat = bs.verifyNumFamiliesBabysat(familyA, familyB, familyC);

        // Verify that babysitter gets paid for full hours
        payForFullHours = bs.verifyPayForFullHours();


    }



}
