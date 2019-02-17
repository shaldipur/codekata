import org.assertj.core.internal.bytebuddy.asm.Advice;

import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Job
{

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

        int payRateFiveThroughTen = 15;
        int payHourCounterFiveThroughTen = 0;

        int payRateElevenThroughFour = 20;
        int payHourCounterElevenThroughFour = 0;


        boolean agreedUponHours = false;

        ArrayList<LocalTime> familyPayHours = new ArrayList<LocalTime>();

        //Determine which family it is (A, B, or C)


        switch(familyCase){

            case 1:
                family.equals("Family A");

                // Determine the amount paid by the family based on the time range

                // Family A

                //TODO: Break out into function
                // Preload hours: Between 5pm and 11pm: $15/hr

                familyPayHours.add(LocalTime.of(17,00));
                familyPayHours.add(LocalTime.of(18,00));
                familyPayHours.add(LocalTime.of(19,00));
                familyPayHours.add(LocalTime.of(20,00));
                familyPayHours.add(LocalTime.of(21,00));
                familyPayHours.add(LocalTime.of(22,00));

                // Preload hours: Between 11pm and 4am: $20/hr

                familyPayHours.add(LocalTime.of(23,00));
                familyPayHours.add(LocalTime.of(24,00));
                familyPayHours.add(LocalTime.of(1,00));
                familyPayHours.add(LocalTime.of(2,00));
                familyPayHours.add(LocalTime.of(3,00));
                familyPayHours.add(LocalTime.of(4,00));

                for(LocalTime hour : familyPayHours){

                    //TODO: Break out into a function (create unit test)
                    // Do the hours match the startTime and endTime that have been passed in?
                    // We don't want hours not agreed upon to be passed through (e.g. 13:00, 14:00, 15:00 etc.)
                    if(hour.equals(startTime) || hour.isAfter(startTime)){
                        if(hour.isBefore(endTime) || hour.equals(endTime)){
                            agreedUponHours = true;
                        }
                    }

                    //TODO: Break out into a function
                    // If the agreed upon hours are passed in then we need to filter down to the proper pay scales
                    if(agreedUponHours){
                        // $15 pay scale
                        if(hour.equals(LocalTime.of(17,00)) || hour.isAfter(LocalTime.of(17,00)))
                        {
                            if(hour.isBefore(LocalTime.of(22,00)) || hour.equals(LocalTime.of(22,00)))
                            {
                                payHourCounterFiveThroughTen +=1;
                            }
                        }
                        // $20 pay scale
                        else if(){

                        }
                    }

                }

                int payFiveThroughTen = payHourCounterFiveThroughTen * payRateFiveThroughTen;

                int payElevenThroughFour = payHourCounterElevenThroughFour * payRateElevenThroughFour;

                finalPay = payFiveThroughTen + payElevenThroughFour;


                break;
            case 2:
                family.equals(("Family B"));
                // Family B

                // Between 5pm and 10pm: $12/hr
                // Between 10pm and 12am: $8/hr
                // Between 12am and 4am: $16/hr


                break;

            case 3:
                family.equals(("Family C"));

                //Family C

                // Between 5pm and 9pm: $21/hr
                // Between 9pm and 4am: $15/hr


                break;
            default:
                family.equals("");
                break;

        }

        return finalPay;
    }


}
