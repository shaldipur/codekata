import java.time.*;
import java.util.ArrayList;

public class Job
{
    Hours hours = new Hours();

    ArrayList<LocalTime> familyPayHours = new ArrayList<LocalTime>();

    double startDouble;
    double endDouble;
    double hourDouble;


    LocalTime fivePM = hours.getFivePM();
    LocalTime sixPM = hours.getSixPM();
    LocalTime sevenPM = hours.getSevenPM();
    LocalTime eightPM = hours.getEightPM();
    LocalTime ninePM = hours.getNinePM();
    LocalTime tenPM = hours.getTenPM();
    LocalTime elevenPM = hours.getElevenPM();
    LocalTime twelveAM = hours.getTwelveAM();
    LocalTime oneAM = hours.getOneAM();
    LocalTime twoAM = hours.getTwoAM();
    LocalTime threeAM = hours.getThreeAM();
    LocalTime fourAM = hours.getFourAM();

    ArrayList<Integer> payList = new ArrayList<Integer>();

    // Family A
    private int payFiveThroughEleven = 15;
    private int payElevenThroughFour = 20;


    // Family B
    private int payFiveThroughTen = 12;
    private int payTenThroughTwelve = 8;
    private int payTwelveThroughFour = 16;

    // Family C
    private int payFiveThroughNine = 21;
    private int payNineThroughFour = 15;



    public double calculateHours(LocalTime startTime, LocalTime endTime)
    {

        // Calculate the number of hours between the endTime and startTime
        Duration duration = Duration.between(endTime,startTime);

        double seconds = duration.getSeconds();

        double hours = seconds/(3600);

        double remainingHours = hours - 2;


       return remainingHours;

    }


    public boolean verifyPayForFullHours(double hours)
    {
        boolean payForFullHours = false;


        if (hours- Math.floor(hours) == 0){
            payForFullHours = true;
        }


        return payForFullHours;
    }



    public int calculateFinalPay(LocalTime startTime, LocalTime endTime, String family)
    {
        int finalPay = 0;

        //Determine which family it is (A, B, or C)

        switch(family){

            case "Family A":

                // Family A

                // Determine the amount paid by the family based on the time range

                familyPayHours = addFamilyPayHours(family);

                // Determine the final pay

                finalPay = determineFinalPayFromPayScale(family, startTime, endTime, familyPayHours);


                break;

            case "Family B":

                // Family B

                // Determine the amount paid by the family based on the time range

                familyPayHours = addFamilyPayHours(family);

                // Determine the final pay

                finalPay = determineFinalPayFromPayScale(family, startTime, endTime, familyPayHours);



                break;

            case "Family C":

                //Family C


                // Determine the amount paid by the family based on the time range

                familyPayHours = addFamilyPayHours(family);

                // Determine the final pay

                finalPay = determineFinalPayFromPayScale(family, startTime, endTime, familyPayHours);

                break;

            default:

                System.out.print("Final pay could not be determined.");

        }

        return finalPay;
    }


    public  ArrayList<LocalTime> addFamilyPayHours(String family)
    {
        ArrayList<LocalTime> familyPayHours = new ArrayList<LocalTime>();

        if(family.equals("Family A")){

            // Preload hours: Between 5pm and 11pm: $15/hr

            familyPayHours.add(fivePM);
            familyPayHours.add(sixPM);
            familyPayHours.add(sevenPM);
            familyPayHours.add(eightPM);
            familyPayHours.add(ninePM);
            familyPayHours.add(tenPM);

            // Preload hours: Between 11pm and 4am: $20/hr

            familyPayHours.add(elevenPM);
            familyPayHours.add(twelveAM);
            familyPayHours.add(oneAM);
            familyPayHours.add(twoAM);
            familyPayHours.add(threeAM);
            familyPayHours.add(fourAM);

        }
        else if(family.equals("Family B"))
        {
            // Preload hours: Between 5pm and 10pm: $12/hr
            familyPayHours.add(fivePM);
            familyPayHours.add(sixPM);
            familyPayHours.add(sevenPM);
            familyPayHours.add(eightPM);
            familyPayHours.add(ninePM);

            // Preload hours: Between 10pm and 12am: $8/hr
            familyPayHours.add(tenPM);
            familyPayHours.add(elevenPM);

            // Preload hours: Between 12am and 4am: $16/hr
            familyPayHours.add(twelveAM);
            familyPayHours.add(oneAM);
            familyPayHours.add(twoAM);
            familyPayHours.add(threeAM);
            familyPayHours.add(fourAM);
        }
        else if(family.equals("Family C"))
        {
            // Preload hours: Between 5pm and 9pm: $21/hr
            familyPayHours.add(fivePM);
            familyPayHours.add(sixPM);
            familyPayHours.add(sevenPM);
            familyPayHours.add(eightPM);

            // Preload hours: Between 9pm and 4am: $15/hr
            familyPayHours.add(ninePM);
            familyPayHours.add(tenPM);
            familyPayHours.add(elevenPM);
            familyPayHours.add(twelveAM);
            familyPayHours.add(oneAM);
            familyPayHours.add(twoAM);
            familyPayHours.add(threeAM);
            familyPayHours.add(fourAM);
        }



        return familyPayHours;
    }


    public int determineFinalPayFromPayScale(String family, LocalTime startTime, LocalTime endTime, ArrayList<LocalTime> familyPayHours){

        boolean agreedUponHours;
        int finalPay = 0;

         for(LocalTime hour : familyPayHours){

            agreedUponHours = verifyAgreedUponHours(startTime, endTime, hour);

            // If the agreed upon hours are passed in then we need to filter down to the proper pay scales
            if(agreedUponHours){

                if(family.equals("Family A")){

                    //TODO: Trick this to say that pm is before am...when in fact am is before pm

                    //Between 5pm and 11pm: $15/hr pay scale
                    if(hour.equals(fivePM) || hour.isAfter(fivePM))
                    {
                        if(hour.isBefore(elevenPM))
                        {
                            payList.add(payFiveThroughEleven);
                        }
                    }
                    //  Between 11pm and 4am: $20/hr pay scale
                    else if(hour.equals(elevenPM) || hour.isAfter(elevenPM)){
                        if(hour.isBefore(fourAM));
                        {
                            payList.add(payElevenThroughFour);
                        }
                    }

                    for (int i: payList) {
                        finalPay += i;
                    }

                }
                else if(family.equals("Family B"))
                {
                    // Between 5pm and 10pm: $12/hr pay scale
                    if(hour.equals(fivePM) || hour.isAfter(fivePM))
                    {
                        if(hour.isBefore(tenPM)){
                            payFiveThroughTen +=1;
                        }
                    }
                    // Between 10pm and 12am: $8/hr pay scale
                    else if(hour.equals(tenPM) || hour.isAfter(tenPM)){
                        if(hour.isBefore(twelveAM)){
                            payTenThroughTwelve +=1;
                        }
                    }
                    // Between 12am and 4am: $16/hr pay scale
                    else if(hour.equals(twelveAM) || hour.isAfter(twelveAM)){
                        if(hour.isBefore(fourAM)){
                            payTwelveThroughFour+=1;
                        }
                    }

                    finalPay = payFiveThroughTen + payTenThroughTwelve + payTwelveThroughFour;
                }
                else if(family.equals("Family C"))
                {
                    //  Between 5pm and 9pm: $21/hr pay scale
                    if(hour.equals(fivePM) || hour.isAfter(fivePM))
                    {
                        if(hour.isBefore(ninePM))
                        {
                                payFiveThroughNine +=1;
                        }
                    }

                    //  Between 9pm and 4am: $15/hr pay scale
                    else if(hour.equals(ninePM) || hour.isAfter(ninePM))
                    {
                        if(hour.isBefore(fourAM))
                        {
                            payNineThroughFour +=1;
                        }
                    }

                    finalPay = payFiveThroughNine + payNineThroughFour;
                }
            }
        }

        return finalPay;

    }

    public boolean verifyAgreedUponHours(LocalTime startTime, LocalTime endTime, LocalTime hour){

        boolean agreedUponHours = false;

        // Do the hours match the startTime and endTime that have been passed in?
        // We don't want hours not agreed upon to be passed through (e.g. 13:00, 14:00, 15:00 etc.)

        // Time is linear, so am will always before pm.
        // We need to measure an event happening in a specific point and this goes from pm to am.
        // We need to convert from time to double (because we are also accounting for fractional hours)

        LocalTime midNight = LocalTime.of(0, 00);

        // Each startTime hour after 0 hr, subtract 12
        // Each startTime hour before  0 hr, add 12
        if(startTime.isAfter(midNight)){

            startDouble = parseDouble(startTime);

            startDouble = startDouble - 12.0;
        }
        else if(startTime.isBefore(midNight)){

            startDouble = parseDouble(startTime);

            startDouble = startDouble + 12.0;
        }

        // Each endTime hour before 0 hr, subtract 12
        // Each endTime hour after  0 hr, add 12
        if(endTime.isBefore(midNight)){

            endDouble = parseDouble(endTime);

            endDouble = endDouble - 12.0;

        }
        else if(endTime.isAfter(midNight)){

            endDouble = parseDouble(endTime);

            endDouble = endDouble + 12.0;
        }

        //Each hour passed in before 0 hr, subtract 12
        //Each hour passed in after  0 hr, add 12
        if(hour.isAfter(midNight)){

            hourDouble = parseDouble(hour);

            hourDouble = hourDouble - 12.0;

        }
        else if(hour.isBefore(midNight))
        {

            hourDouble = parseDouble(hour);

            hourDouble = hourDouble + 12.0;
        }


        if(hourDouble >= startDouble){
            if(hourDouble < endDouble){
                agreedUponHours = true;
            }
        }

        return agreedUponHours;

    }

    public double parseDouble(LocalTime time)
    {
        double timeDouble;

        String minutesAndSeparator = time.toString().substring(2,5);
        String minutes = time.toString().substring(3,5);
        timeDouble = Double.parseDouble(time.toString().replace(minutesAndSeparator, "." + minutes));

        return timeDouble;
    }

}
