import java.util.Date;

public class Execution {

    public static void main(String[]args)
    {
        int startTime = 5;

        int endTime = 11;

        String family = "Family A";



        Pay pay = new Pay();

        pay.calcTotalPay(startTime, endTime, family);

    }
}
