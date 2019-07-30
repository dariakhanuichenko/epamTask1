package controller;

import model.Appliance;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

public class UtilityArrayListApplianceTest {

    UtilityArrayListAppliance utility = new UtilityArrayListAppliance();

    @Test
    public void sort() {

        ArrayList<Appliance> tempArray = utility.toArrayListAppliance(utility.createArrayListPortableAppliances());
        utility.sort(tempArray,
                0, tempArray.size() - 1);
        for (int i = 0; i < tempArray.size(); i++) {
            if (tempArray.get(i).getPower() > tempArray.get(i + 1).getPower()) Assert.fail();
        }
    }

    @Test
    public void checkArrayNotEmpty() {
        ArrayList tempArray = new ArrayList();
        if ((tempArray.size() == 0) == (utility.checkArrayNotEmpty(tempArray)))
            Assert.fail();

        tempArray = utility.createArrayListPortableAppliances();
        if ((tempArray.size() == 0) == (utility.checkArrayNotEmpty(tempArray)))
            Assert.fail();
    }
}
