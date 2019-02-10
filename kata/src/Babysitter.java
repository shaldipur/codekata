import java.util.*;

public class Babysitter {

    ArrayList<String> collectFamilies = new ArrayList<String>();
    ArrayList<String> numFamilies = new ArrayList<String>();

    public boolean verifyTimeRange()
    {
        boolean timeRangeCorrect = false;




        return timeRangeCorrect;
    }

    public boolean verifyNumFamiliesBabysat(String familyA, String familyB, String familyC)
    {
        boolean numFamiliesBabysat = false;


        // Get count of the families
        collectFamilies.add(familyA);
        collectFamilies.add(familyB);
        collectFamilies.add(familyC);

        // Loop thru array list and remove any null family values

        // Empty family values represent families that are not being babysat for
        // because the babysitter can only babysit for one family per night

        for(String family: collectFamilies)
        {

            if (!family.equals(""))
            {
                numFamilies.add(family);
            }

        }

        if(numFamilies.size() == 1)
        {
            numFamiliesBabysat = true;
        }

        return numFamiliesBabysat;
    }

    public boolean verifyPayForFullHours()
    {
        boolean payForFullHours = false;



        return payForFullHours;
    }
}
