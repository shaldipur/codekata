import java.time.*;
import java.util.ArrayList;


public class Execution {

    public static void main(String[]args)
    {

        ArrayList<String> familiesCollection;


        // Step 1: Set a start and end time for the babysitter to work.
        LocalTime startTime = LocalTime.of(17,00);
        LocalTime endTime = LocalTime.of(4,00);

        // Step 2: Choose a family.  Be sure to choose one family at a time for successful completion.
        familiesCollection = loadFamily("Family A");

        //Uncomment the families below, one to test.
        //familiesCollection = loadFamily("Family B");
        //familiesCollection = loadFamily("Family C");

        Pay pay = new Pay();

        pay.calculationProcess(startTime, endTime, familiesCollection);

    }

    public static ArrayList<String> loadFamily(String family)
    {
        ArrayList<String> familiesCollection = new ArrayList<String>();

        if (family == "Family A")
        {
            familiesCollection.add(family);
        }

        if (family == "Family B")
        {
            familiesCollection.add(family);
        }

        if (family == "Family C")
        {
            familiesCollection.add(family);
        }

        return familiesCollection;
    }



}
