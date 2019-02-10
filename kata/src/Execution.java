import java.time.*;



public class Execution {

    public static void main(String[]args)
    {
        //int startTime = 5;
        //int endTime = 11;

        LocalTime startTime = LocalTime.of(17,00);
        LocalTime endTime = LocalTime.of(4,00);


        String familyA = "Family A";
        String familyB = "Family B";
        String familyC = "Family C";



        Pay pay = new Pay();

        pay.calcTotalPay(startTime, endTime, familyA, "", "");

    }
}
