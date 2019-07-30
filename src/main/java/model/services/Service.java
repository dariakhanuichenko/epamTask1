package model.services;

import model.Appliance;
import model.House;
import model.StationaryAppliance;
import model.StationaryAppliancesList;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static view.Messages.*;
import static view.Messages.MESSAGE_TRY_AGAIN;

public class Service {

    private Scanner scan = new Scanner(System.in);
    private View view;


    public Service() {
        this.view = new View("en");
    }

    public Service(View view) {
        this.view = view;
    }

    /**
     * @return created array of portable appliances
     */
    public House createArrayListPortableAppliances() {
        return new House();
    }

    /**
     * @return created array of stationary appliances
     */
    /*List<Appliance> createArrayListStationaryAppliances() {
        return new ArrayList<Appliance>();
    }*/

    /**
     * @param array- array of Appliances of which we will get array of their names
     * @return array with strings ( applience names)
     */
    public List<String> getArrayNames(List<Appliance> array) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < array.size(); i++) {
            temp.add(array.get(i).getName());
        }
        return temp;
    }

    /**
     * @param arr - array, where we will do swap
     * @param i   - index first element,  which will be displaced
     * @param j   - index second element,which will be displaced
     */
    public void swap(List<Appliance> arr, int i, int j) {
        Appliance temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * @param arr-  array, which we will sort
     * @param low-  index of begin sorting part
     * @param high- index of end sorting part
     * @return index
     */
    public int partition(List<Appliance> arr, int low, int high) {
        int pivot = arr.get(high).getPower();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr.get(j).getPower() <= pivot) {
                i++;

                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);

        return i + 1;
    }

    /**
     * @param arr-       array, which we will sort
     * @param low-       index of begin sorting part
     * @param high-index of end sorting part
     * @return
     */
    public List<Appliance> sort(List<Appliance> arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
        return arr;
    }

    /**
     * @param array - ArrayList which will type cast to ArrayList<Appliance>
     * @return -ArrayList<Appliance>
     */
    public List<Appliance> toArrayListAppliance(List array) {
        List<Appliance> arrAppliance = new ArrayList<Appliance>();
        for (Object obj : array) {
            arrAppliance.add((Appliance) obj);
        }
        return arrAppliance;
    }

    /**
     * get working power from one array of Appliances
     *
     * @param array- array of appliances
     * @return- working power for one array
     */
    public int getUsePower(List<Appliance> array) {
        int sumPower = 0;
        for (Appliance a : array
        ) {
            if (a.isOn())
                sumPower += a.getPower();
        }
        return sumPower;
    }

    /**
     * get working power from array of portable appliances and array of stationary appliances
     *
     * @param array1-      array of portable appliances
     * @param array2-array of stationary appliances
     * @return- working power for two arrays
     */
    public int sumaWorkingPower(List<Appliance> array1, List<Appliance> array2) {
        return getUsePower(array1) + getUsePower(array2);
    }

    /**
     * @param array-  array of  appliances in which we will check parametrs
     * @param begin-  first parametr( number of power)
     * @param end-    second parametr( number of power)
     * @param result- array in which we will write appliances which is suit for parametrs begin & end
     */
    public void getAppliancesByParametrs(List<Appliance> array, int begin, int end, List<Appliance> result) {
        for (Appliance a : array
        ) {
            if (a.getPower() >= begin && a.getPower() <= end)
                result.add(a);
        }
    }

    /**
     * @param array1- array of  appliances in which we will check parametrs
     * @param array2- array of  appliances in which we will check parametrs
     * @param begin-  first parametr( number of power)
     * @param end-    second parametr( number of power)
     * @return- array in which we will write appliances which is suit for parametrs begin & end
     */
    public ArrayList<Appliance> getAllAppliancesByParametrs(List<Appliance> array1, List<Appliance> array2,
                                                            int begin, int end) {

        ArrayList<Appliance> result = new ArrayList();
        if (begin > end)
            begin = begin + end - (end = begin);
        getAppliancesByParametrs(array1, begin, end, result);
        getAppliancesByParametrs(array2, begin, end, result);
        view.printStringInput(MESSAGE_ITS_ALL_APPLIANCE_BY_PARAMETRS);
        return result;
    }

    /**
     * @param array - checking array
     * @return- if array is empty return false  if array is not empty return true
     */
    public boolean checkArrayNotEmpty(List array) {
        return array.size() == 0 ? false : true;
    }

    /**
     * @param array- array of appliances in which we will switch on/off appliances
     * @param flag-  if we want to switch on (true) switch off(false)
     */
    public void setIsOnAppliances(List<Appliance> array, boolean flag) {
        int key;
        while (true) {
            view.printArrayNames(getArrayNames(array));
            key = validationKeyBysizeArray(array);

            if (array.get(key).isOn() == flag) {
                view.printStringInput(MESSAGE_IS_ON);
                view.printStringInput(flag ? MESSAGE_ON : MESSAGE_OFF);
            } else
                array.get(key).setOn(flag);
            view.printStringInput(MESSAGE_CONTINUE);
            int answer = readKey(); // 1-continue
            if (answer != 1) return;

        }
    }

    /**
     * @return return integer
     */
    public int readKey() {
        view.printStringInput(MESSAGE_INPUT_NUMBER);
        while (!scan.hasNextInt()) {
            view.printStringInput(MESSAGE_IT_IS_NOT_NUMBER);
            scan.next();
            view.printStringInput(MESSAGE_TRY_AGAIN);
        }
        return scan.nextInt();
    }

    /**
     * @param array - array of appliances
     * @return checked key
     */
    public int validationKeyBysizeArray(List<Appliance> array) {
        int key;
        do {
            key = readKey();
        }
        while (key < 0 || key > array.size());
        return key;
    }

    public void readEnum(List AppliancesArray) {
        for (StationaryAppliancesList a :
                StationaryAppliancesList.values()) {
            AppliancesArray.add(new StationaryAppliance(a.getX(), a.getY(), a.getName(), a.getPower()));
        }
    }
}
