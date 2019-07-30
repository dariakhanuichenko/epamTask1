package controller;

import reader.FileRead;
import view.View;

import java.io.IOException;
import java.util.ArrayList;

import static view.Messages.*;

public class Menu {
    private FileRead fileRead = new FileRead();
    private View view;
    private UtilityArrayListAppliance utility;


    public Menu(View view) {
        this.view = view;
        utility = new UtilityArrayListAppliance(view);
    }

    /**
     * @param portableAppliancesArray- the array in which we read the array from the file
     * @param message - string(locale) to notify user what's happen
     * @param fileName- name of file from which we will read
     */
    public void menuItemCreatePortable(ArrayList portableAppliancesArray, String message, String fileName) {
        try {
            fileRead.readApplianceePortableArray(fileName, portableAppliancesArray);
            view.printStringInput(message);
            view.printArray(portableAppliancesArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param stationaryAppliance- the array in which we read the array from the file
     * @param message - string(locale) to notify user what's happen
     * @param fileName- name of file from which we will read
     */
    public void menuItemCreateStationary(ArrayList stationaryAppliance, String message, String fileName) {
        try {
            fileRead.readApplianceePortableArray(fileName, stationaryAppliance);
            view.printStringInput(message);
            view.printArray(stationaryAppliance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param appliancesArray- array in which we will make variable isOn=true
     */
    public void menuItemSetOn(ArrayList appliancesArray) {

        if (utility.checkArrayNotEmpty(appliancesArray)) {
            view.printStringInput(MESSAGE_NUMBER_BY_APPLIANCE);
            utility.setIsOnAppliances(utility.toArrayListAppliance(appliancesArray), true);

        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }

    /**
     *
     * @param appliancesArray- array which we will sort
     */
    public void menuItemSortArray(ArrayList appliancesArray) {

        if (utility.checkArrayNotEmpty(appliancesArray)) {
            view.printStringInput(MESSAGE_LIST_OF_APPLIANCES);
            view.printArray(utility.sort(
                    utility.toArrayListAppliance(appliancesArray),
                    0, appliancesArray.size() - 1));
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);

    }

    /**
     * @param appliancesArray1-array in which we will find working power
     * @param appliancesArray2-array in which we will find working power
     */
    public void menuItemGetResultPower(ArrayList appliancesArray1, ArrayList appliancesArray2) {
        if (utility.checkArrayNotEmpty(appliancesArray1) || utility.checkArrayNotEmpty(appliancesArray2)) {
            view.printInteger(MESSAGE_RESULT_POWER,
                    utility.getAllUsePower(utility.toArrayListAppliance(appliancesArray1),
                            utility.toArrayListAppliance(appliancesArray2)));
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }

    /**
     * @param stationaryAppliancesArray- array in which we will find appliances beetwen input parametrs(by power)
     * @param portableAppliancesArray- array in which we will find appliances beetwen input parametrs(by power)
     */
    public void menuItemGetArrayBetweenParametrs(ArrayList stationaryAppliancesArray,
                                                 ArrayList portableAppliancesArray) {
        if (utility.checkArrayNotEmpty(stationaryAppliancesArray) || utility.checkArrayNotEmpty(portableAppliancesArray)) {
            view.printArray(utility.getAllAppliancesByParametrs(
                    utility.toArrayListAppliance(stationaryAppliancesArray),
                    utility.toArrayListAppliance(portableAppliancesArray),
                    utility.readKey(), utility.readKey()));
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }

    /**
     *
     * @param stationaryAppliancesArray- array of stationary appliances which we will print
     * @param portableAppliancesArray- array of portable appliances which we will print
     */
    public void menuItemPrintArrayList(ArrayList stationaryAppliancesArray,
                                       ArrayList portableAppliancesArray) {
        if (utility.checkArrayNotEmpty(stationaryAppliancesArray) || utility.checkArrayNotEmpty(portableAppliancesArray)) {
            view.printStringInput(MESSAGE_LIST_OF_APPLIANCES);
            view.printArray(portableAppliancesArray);
            view.printArray(stationaryAppliancesArray);
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }
}
