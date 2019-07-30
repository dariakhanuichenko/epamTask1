package controller;

import model.Appliance;
import model.House;
import model.services.Service;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    private Service service=new Service();
    private House house=new House();

    @Test
    public void sort() {

        List<Appliance> tempArray = service.toArrayListAppliance(house.getPortableAppliances());
        service.sort(tempArray,
                0, tempArray.size() - 1);
        for (int i = 0; i < tempArray.size(); i++) {
            if (tempArray.get(i).getPower() > tempArray.get(i + 1).getPower()) Assert.fail();
        }
    }

    @Test
    public void checkArrayNotEmpty() {
        List tempArray = new ArrayList();
        if ((tempArray.size() == 0) == (service.checkArrayNotEmpty(tempArray)))
            Assert.fail();

        tempArray = house.getPortableAppliances();
        if ((tempArray.size() == 0) == (service.checkArrayNotEmpty(tempArray)))
            Assert.fail();
    }
}
