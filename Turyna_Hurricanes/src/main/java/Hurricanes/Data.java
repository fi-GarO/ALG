package Hurricanes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jiri.Turyna
 */
public class Data implements Interface {

    ArrayList<Hurricane> hurricaneData = new ArrayList<>();

    @Override
    public String yearInterval(int year1, int year2) {
        StringBuilder sb = new StringBuilder();
        for (Hurricane h : hurricaneData) {
            if (h.getYear() >= year1 && h.getYear() <= year2) {
                sb.append(h);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String infoByName(String name) {
        StringBuilder sb = new StringBuilder();
        for (Hurricane h : hurricaneData) {
            if (h.getName().equals(name)) {
                sb.append("Hurricane " + name + " Category: " + h.getSaffirSimpson() + ", Speed: " + h.knotsToKMH() + " KM/H" + "\n");
            }
        }

        if (sb.toString() != null) {
            return sb.toString();
        } else {
            return "Hurricane not found";
        }
    }

    @Override
    public String sortBySpeed() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Hurricane> sortedData = hurricaneData;
        Collections.sort(sortedData, Collections.reverseOrder(Comparator.comparing(Hurricane::knotsToKMH)));

        for (Hurricane h : sortedData) {
            sb.append(h);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void load() {
        File f = new File("data/hurricanedata.txt");

        int year;
        String month;
        int pressure;
        int speedInKnots;
        String name;

        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                year = sc.nextInt();
                month = sc.next();
                pressure = sc.nextInt();
                speedInKnots = sc.nextInt();
                name = sc.next();
                Hurricane h = new Hurricane(year, month, pressure, speedInKnots, name);
                hurricaneData.add(h);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hurricane h : hurricaneData) {
            sb.append(h);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.load();

        System.out.println(data);

    }

}
