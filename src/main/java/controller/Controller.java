package controller;

import model.Appliance;
import model.House;
import model.PortableAppliance;
import model.StationaryAppliance;
import model.services.Service;
import view.View;

import java.util.ArrayList;
import java.util.List;

import static view.Messages.*;

public class Controller {
    private Menu menu;// = new Menu();
    private View view;//= new view();
    private Service service;// = new UtilityArrayListAppliance();
    private House house;

    /**
     *
     * @param locale- parametr for licale in view
     */
    public Controller(String locale, House house) {
        view = new View(locale);
        service = new Service(view);
        menu = new Menu(view);
        this.house=house;
    }

    /**
     * main method
     */
    public void program() {


        int key;
        while (true) {
            view.printStringInput(MENU);
            do {
                key = service.readKey();
            }
            while (key < 0 || key > 8);
            switch (key) {
                case 1:
                    menu.menuItemCreatePortable(house.getPortableAppliances(),
                            MESSAGE_CREATE_LIST_PORTABLE, "src/portable.txt");
                    menu.menuItemCreateStationary(house.getStationaryAppliances(),
                            MESSAGE_CREATE_LIST_STATIONARY);
                    view.printStringInput(MESSAGE_IS_CREATED);
                    break;
                case 2:
                    menu.menuItemSetOn(house.getStationaryAppliances());
                    break;
                case 3:
                    menu.menuItemSetOn(house.getPortableAppliances());
                    break;
                case 4:
                    menu.menuItemSortArray(house.getPortableAppliances());
                    break;
                case 5:
                    menu.menuItemSortArray(house.getStationaryAppliances());
                    break;
                case 6:
                    menu.menuItemGetResultPower(house.getStationaryAppliances(), house.getPortableAppliances());
                    break;
                case 7:
                    menu.menuItemGetArrayBetweenParametrs(house.getStationaryAppliances(), house.getPortableAppliances());
                    break;
                case 8:
                   menu.menuItemPrintArrayList(house.getStationaryAppliances(),house.getPortableAppliances());
                    break;
                case 0:
                    return;
            }


        }
    }
}
