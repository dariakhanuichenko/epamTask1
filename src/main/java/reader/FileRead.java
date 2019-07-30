package reader;

import model.PortableAppliance;
import model.StationaryAppliance;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
    /**
     *
     * @param fileName - name of input-file
     * @param AppliancesArray-array where we write array from file
     * @throws IOException- attempt to read from file had failure
     */
    public void readApplianceePortableArray(String fileName, ArrayList AppliancesArray) throws IOException {

        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            AppliancesArray.add(new PortableAppliance(validationNumber(scan.nextLine()), validationNumber(scan.nextLine()), scan.nextLine(), validationNumber(scan.nextLine())));
        }
        fr.close();
    }

    /**
     *
     * @param fileName - name of input-file
     * @param AppliancesArray-array where we write array from file
     * @throws IOException- attempt to read from file had failure
     */
    public void readApplianceeStationaryArray(String fileName, ArrayList AppliancesArray) throws IOException {

        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            AppliancesArray.add(new StationaryAppliance(validationNumber(scan.nextLine()), validationNumber(scan.nextLine()), scan.nextLine(), validationNumber(scan.nextLine())));
        }
        fr.close();
    }

    /**
     *
     * @param str- check string
     * @return- if string is number return this number, else return 0
     */
    public int validationNumber(String str) {
        return str.matches("[0-9]+") ? Integer.parseInt(str) : 0;
    }

}
