package view;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    private  final ResourceBundle bundle ;

    /**
     *
     * @param key -locale name
     */
    public View(String key){
        if(key.toLowerCase().equals("ua"))
            bundle = ResourceBundle.getBundle(
                MESSAGES_BUNDLE_NAME,
                new Locale("ua", "UA"));

        else  bundle = ResourceBundle.getBundle(
                        MESSAGES_BUNDLE_NAME,
                        new Locale("en"));
    }

    /**
     *
     * @param arr- array , which we will print
     */
    public void printArray(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

    /**
     *
     * @param array- array of strings, which we will print
     */
    public void printArrayNames(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++)
            System.out.println(i + ". " + array.get(i));
    }

    /**
     *
     * @param message- string, which we will print
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     *
     * @param message- string(locale)
     * @param number- number, which we will print
     */
    public void printInteger(String message, int number){
        printStringInput(message);
        System.out.println(number);
    }

    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    /**
     *
     * @param message- string(locale), which we will print
     */
    public void printStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(message)));
    }

}

