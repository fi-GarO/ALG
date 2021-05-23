package competition;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jiri.Turyna
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadje jmena vstupnych souboru:");
        Competition c = new Competition();
        String startFile = sc.next();
        String finishFile = sc.next();
        while (true) {
            try {
                c.load(startFile, finishFile);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Neexistujici soubory");
                System.out.println("Zadej znovu");
            }
        }
        System.out.println(c.getResults());
        System.out.println("Zadej jmeno souboru s vysledky");
        String resultFile = sc.next();
        c.saveResults(resultFile);
    }

}
