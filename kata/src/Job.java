import org.assertj.core.internal.bytebuddy.asm.Advice;

import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Job
{
    Hours hours = new Hours();

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
        int familyCase = 0;

        // Family A
        int payFiveThroughTen = 15;
        int payElevenThroughFour = 20;



        boolean agreedUponHours = false;

        ArrayList<LocalTime> familyPayHours = new ArrayList<LocalTime>();

        //Determine which family it is (A, B, or C)


        switch(familyCase){

            case 1:
                family.equals("Family A");

                // Determine the amount paid by the family based on the time range

                // Family A

                familyPayHours = addFamilyPayHours(family);


                //TODO: Function with for loop inside with familyPayHours as parameter
                for(LocalTime hour : familyPayHours){

                    //TODO: Break out into a boolean function with hour as parameter (create unit test)
                    // Do the hours match the startTime and endTime that have been passed in?
                    // We don't want hours not agreed upon to be passed through (e.g. 13:00, 14:00, 15:00 etc.)
                    if(hour.equals(startTime) || hour.isAfter(startTime)){
                        if(hour.isBefore(endTime) || hour.equals(endTime)){
                            agreedUponHours = true;
                        }
                    }

                    //TODO: Break out into function and pass in agreedUponHours and family as parameters
                    // If the agreed upon hours are passed in then we need to filter down to the proper pay scales
                    if(agreedUponHours){

                        //Family A
                        // $15 pay scale
                        if(hour.equals(LocalTime.of(17,00)) || hour.isAfter(LocalTime.of(17,00)))
                        {
                            if(hour.isBefore(LocalTime.of(22,00)) || hour.equals(LocalTime.of(22,00)))
                            {
                                payFiveThroughTen +=1;
                            }
                        }
                        // $20 pay scale
                        else if(hour.equals(LocalTime.of(23,00)) || hour.isAfter(LocalTime.of(23,00))){
                            if(hour.isBefore(LocalTime.of(4,00)) || hour.equals(LocalTime.of(4,00)));
                            {
                                payElevenThroughFour +=1;
                            }
                        }
                    }

                }


                finalPay = payFiveThroughTen + payElevenThroughFour;

                break;

            case 2:
                family.equals(("Family B"));
                // Family B

                familyPayHours = addFamilyPayHours(family);






                break;

            case 3:
                family.equals(("Family C"));

                //Family C

                familyPayHours = addFamilyPayHours(family);





                break;
            default:
                family.equals("");
                break;

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
            // Between 5pm and 9pm: $21/hr
            familyPayHours.add(fivePM);
            familyPayHours.add(sixPM);
            familyPayHours.add(sevenPM);
            familyPayHours.add(eightPM);

            // Between 9pm and 4am: $15/hr
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


}
