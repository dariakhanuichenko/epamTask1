import controller.Controller;
import model.House;

import java.util.Scanner;

/**
 * @author  Daria Khaniuchenko
 */
public class Main {

    public static void main(String[] args){
        String locale=validationLocaleName();
        Controller controller=new Controller(locale, new House());
        controller.program();
    }


    /**
     *
     * @return string
     */
    private static String readString(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Choose language(ua/en)");
        while (!scan.hasNextLine()) {
            System.out.println("Invalid input");
            scan.nextLine();
            System.out.println("Try again");
        }
        return scan.nextLine();

    }

    /**
     *
     * @return checked string, it is like "ua|en|UA|EN|eN|En|Ua|uA"
     */

    private static String validationLocaleName() {
        String str;
        do {
            //view.printStringInput(MESSAGE_INPUT_NUMBER_BETWEEN);
            str = readString();
        }
        while (!str.matches("ua|en|UA|EN|eN|En|Ua|uA"));
        return str;
    }
}
