import java.util.Date;

public class Execution {

    public static void main(String[]args)
    {
        int startTime = 5;

        int endTime = 11;

        String familyA = "Family A";
        String familyB = "Family B";
        String familyC = "Family C";



        Pay pay = new Pay();

        pay.calcTotalPay(startTime, endTime, familyA, "", "");

    }
}
