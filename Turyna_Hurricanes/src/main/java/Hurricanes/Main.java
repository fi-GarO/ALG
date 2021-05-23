package Hurricanes;

import java.util.Scanner;

/**
 *
 * @author Jiri.Turyna
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Interface i = new Data();
        try {
            i.load();
            System.out.println("Insert years to print Hurricanes from that interval");
            System.out.println(i.yearInterval(sc.nextInt(), sc.nextInt()));
            System.out.println("\n");
            
            System.out.println("Insert name of Hurricane");
            System.out.println(i.infoByName(sc.next()));
            System.out.println("\n");
            
            System.out.println("Press any key to show List of Sorted Hurricanes by Speed (descending)");
            System.in.read();
            System.out.println(i.sortBySpeed());
            
        } catch (Exception e) {
            System.out.println("main: File not found");
        }   

        
    }

}
