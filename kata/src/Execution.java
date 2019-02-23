import java.time.*;
import java.util.ArrayList;


public class Execution {

    public static void main(String[]args)
    {
        //int startTime = 5;
        //int endTime = 11;

        LocalTime startTime = LocalTime.of(17,00);
        LocalTime endTime = LocalTime.of(4,00);


        ArrayList<String> familiesCollection = new ArrayList<String>();

        // Choose one at a time for successful completion
        String familyA = "Family A";
        String familyB = "Family B";
        String familyC = "Family C";

        // Choose one at a time for successful completion
        familiesCollection.add(familyA);
//        familiesCollection.add(familyB);
//        familiesCollection.add(familyC);

        //...any number of families can be added to collection


        Pay pay = new Pay();

        pay.calculationProcess(startTime, endTime, familiesCollection);

    }
}
