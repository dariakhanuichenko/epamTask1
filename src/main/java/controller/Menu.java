package controller;

import model.services.Service;
import reader.FileRead;
import view.View;

import java.io.IOException;

import java.util.List;

import static view.Messages.*;

class Menu {
    private FileRead fileRead;
    private View view;
    private Service service;


     Menu(View view) {
        this.fileRead = new FileRead();
        this.view = view;
        this.service = new Service(view);
    }

    /**
     * @param portableAppliancesArray- the array in which we read the array from the file
     * @param message                  - string(locale) to notify user what's happen
     * @param fileName-                name of file from which we will read
     */
     void menuItemCreatePortable(List portableAppliancesArray, String message, String fileName) {
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
     * @param message              - string(locale) to notify user what's happen
     */
     void menuItemCreateStationary(List stationaryAppliance, String message) {
        service.readEnum(stationaryAppliance);
        view.printStringInput(message);
        view.printArray(stationaryAppliance);
    }

    /**
     * @param appliancesArray- array in which we will make variable isOn=true
     */
     void menuItemSetOn(List appliancesArray) {

        if (service.checkArrayNotEmpty(appliancesArray)) {
            view.printStringInput(MESSAGE_NUMBER_BY_APPLIANCE);
            service.setIsOnAppliances(appliancesArray, true);

        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }

    /**
     * @param appliancesArray- array which we will sort
     */
     void menuItemSortArray(List appliancesArray) {

        if (service.checkArrayNotEmpty(appliancesArray)) {
            view.printStringInput(MESSAGE_LIST_OF_APPLIANCES);
            view.printArray(service.sort(
                    appliancesArray,
                    0, appliancesArray.size() - 1));
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);

    }

    /**
     * @param appliancesArray1-array in which we will find working power
     * @param appliancesArray2-array in which we will find working power
     */
     void menuItemGetResultPower(List appliancesArray1, List appliancesArray2) {
        if (service.checkArrayNotEmpty(appliancesArray1) || service.checkArrayNotEmpty(appliancesArray2)) {
            view.printInteger(MESSAGE_RESULT_POWER,
                    service.sumaWorkingPower(appliancesArray1,
                            appliancesArray2));
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }

    /**
     * @param stationaryAppliancesArray- array in which we will find appliances beetwen input parametrs(by power)
     * @param portableAppliancesArray-   array in which we will find appliances beetwen input parametrs(by power)
     */
     void menuItemGetArrayBetweenParametrs(List stationaryAppliancesArray,
                                                 List portableAppliancesArray) {
        if (service.checkArrayNotEmpty(stationaryAppliancesArray) || service.checkArrayNotEmpty(portableAppliancesArray)) {
            view.printArray(service.getAllAppliancesByParametrs(
                    stationaryAppliancesArray, portableAppliancesArray, service.readKey(), service.readKey()));

        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }

    /**
     * @param stationaryAppliancesArray- array of stationary appliances which we will print
     * @param portableAppliancesArray-   array of portable appliances which we will print
     */
     void menuItemPrintArrayList(List stationaryAppliancesArray,
                                       List portableAppliancesArray) {
        if (service.checkArrayNotEmpty(stationaryAppliancesArray) || service.checkArrayNotEmpty(portableAppliancesArray)) {
            view.printStringInput(MESSAGE_LIST_OF_APPLIANCES);
            view.printArray(portableAppliancesArray);
            view.printArray(stationaryAppliancesArray);
        } else view.printStringInput(MESSAGE_SELECT_FIRST_STATEMENT);
    }
}
