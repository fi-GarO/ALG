package competition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jiri.Turyna
 */
public class Competition {

    private ArrayList<Runner> runners = null;

    public void load(String startFile, String finishFile) throws FileNotFoundException {
        // nacitani pomoci Scanneru
        File startFileF = new File(startFile);
        Scanner inStart = new Scanner(startFileF);
        while (inStart.hasNext()) {
            int number = inStart.nextInt();
            String firstname = inStart.next();
            String lastname = inStart.next();
            String startTime = inStart.next();
            Runner r = new Runner(firstname, lastname, number);
            r.setStartTime(startTime);
            runners.add(r);
        }
    }

    public String getResults() {
        Collections.sort(runners);
        Iterator<Runner> iterator = runners.iterator();
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        while (iterator.hasNext()) {
            Runner r = iterator.next();
            sb.append(String.format("%-4d. %s", n, r));
            n++;
        }
        return sb.toString();
    }

    public void saveResults(String resultFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Competition c = new Competition();
        try {
            c.load("start.txt", "finish.txt");
            System.out.println(c);
        } catch (FileNotFoundException e) {
            System.out.println("Nenalezen soubor");
        }
    }
}
