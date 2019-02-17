import java.time.*;
import java.util.concurrent.TimeUnit;

public class Job
{


    public long calculateHours(LocalTime startTime, LocalTime endTime)
    {

        //Calculate the number of hours between the start time and end time
        Duration duration = Duration.between(startTime,endTime);

        long seconds = duration.getSeconds();

        //Convert seconds to hours
        long hours = TimeUnit.SECONDS
                .toHours(seconds);


       return hours;

    }


    public boolean verifyPayForFullHours(String family)
    {
        boolean payForFullHours = false;






        return payForFullHours;
    }



    public int calculateFinalPay(long hours, LocalTime startTime, LocalTime endTime, String family)
    {
        int finalPay = 0;
        int familyCase = 0;

        //Determine which family it is (A, B, or C)
        switch(familyCase){
            case 1:
                family.equals("Family A");

                //Determine the amount paid by the family based on the time range

                //Family A
                //between 5pm and 11pm: $15/hr
                //between 11pm and 4am: $20/hr


                break;
            case 2:
                family.equals(("Family B"));
                // Family B

                //between 5pm and 10pm: $12/hr
                //between 10pm and 12am: $8/hr
                //between 12am and 4am: $16/hr


                break;

            case 3:
                family.equals(("Family C"));

                //Family C

                //between 5pm and 9pm: $21/hr
                //between 9pm and 4am: $15/hr


                break;
            default:
                family.equals("");
                break;

        }

        return finalPay;
    }

}
