package controller;

import model.PortableAppliance;
import model.StationaryAppliance;
import view.View;

import java.util.ArrayList;

import static view.Messages.*;

public class Controller {
    Menu menu;// = new Menu();
    View view;//= new view();
    UtilityArrayListAppliance utility;// = new UtilityArrayListAppliance();

    /**
     *
     * @param locale- parametr for licale in view
     */
    public Controller(String locale) {
        view = new View(locale);
        utility = new UtilityArrayListAppliance(view);
        menu = new Menu(view);
    }

    /**
     * main method
     */
    public void program() {

        ArrayList<PortableAppliance> portableAppliancesArray = utility.createArrayListPortableAppliances();
        ArrayList<StationaryAppliance> stationaryAppliancesArray = utility.createArrayListStationaryAppliances();

        int key;
        while (true) {
            view.printStringInput(MENU);
            do {
                key = utility.readKey();
            }
            while (key < 0 || key > 8);
            switch (key) {
                case 1:
                    menu.menuItemCreatePortable(portableAppliancesArray, MESSAGE_CREATE_LIST_PORTABLE, "src/portable.txt");
                    menu.menuItemCreateStationary(stationaryAppliancesArray, MESSAGE_CREATE_LIST_STATIONARY, "src/stationary");
                    view.printStringInput(MESSAGE_IS_CREATED);
                    break;
                case 2:
                    menu.menuItemSetOn(stationaryAppliancesArray);
                    break;
                case 3:
                    menu.menuItemSetOn(portableAppliancesArray);
                    break;
                case 4:
                    menu.menuItemSortArray(portableAppliancesArray);
                    break;
                case 5:
                    menu.menuItemSortArray(stationaryAppliancesArray);
                    break;
                case 6:
                    menu.menuItemGetResultPower(stationaryAppliancesArray, portableAppliancesArray);
                    break;
                case 7:
                    menu.menuItemGetArrayBetweenParametrs(stationaryAppliancesArray, portableAppliancesArray);
                    break;
                case 8:
                   menu.menuItemPrintArrayList(stationaryAppliancesArray,portableAppliancesArray);
                    break;
                case 0:
                    return;
            }


        }
    }
}
