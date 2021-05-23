package shapes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jiri.Turyna
 */
public class ShapesApp {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    clearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    printObjects();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWithMaxArea();
                    break;
                case 8:
                    getObjectInfo();
                    break;
                default:
                    System.out.println("Chybna volba");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. List vsech objektu");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis objekt s nejvetsi plochou");
        System.out.println("8. Vypis plochu objektu");
        System.out.println("0. Konec programu");
    }

    private static int readChoice() {
        System.out.println("Zadejte volbu: ");
        return sc.nextInt();
    }

    //TODO - umozni zadat novou sadu objektu
    private static void clearObjects() {
        shapes.clear();
    }

    //TODO - Square
    private static void addSquare() {
        double a;
        System.out.println("Zadejte rozmer ctverce: ");
        a = sc.nextDouble();
        shapes.add(new Square(a));
    }

    //TODO
    private static void addRectangle() {
        double a, b;
        System.out.println("Zadejte rozmery obdelniku: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        shapes.add(new Rectangle(a, b));
    }

    //TODO
    private static void addCircle() {
        double r;
        System.out.println("Zadejte polomer kruhu: ");
        r = sc.nextDouble();
        shapes.add(Circle.getInstanceR(r));
    }

    //TODO - typ, rozmery, obsah o vsech
    private static void printObjects() {
        System.out.println("List vsech zadanych objektu: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    //TODO - vsech
    private static void computeArea() {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.computeArea();
        }
        System.out.println("Obsah plochy vsech objektu je: " + area);
    }

    //TODO - info o objektu s max area
    private static void findWithMaxArea() {
        double max = 0;
        int tmp = 0;
        for (int i = 0; i < shapes.size(); i++){
            if (shapes.get(i).computeArea() > max){
                max = shapes.get(i).computeArea();
                tmp = i;
            }
        }
        System.out.println("Rozmery objektu s nejvetsi plochou: " + shapes.get(tmp));
        System.out.println("Jeho obsah: " + max);
                
    }

    //TODO - zobrazit vsechny, nechat vybrat a o vybranem zobrazit info
    private static void getObjectInfo() {
        int i;
        printObjects();
        System.out.println("Zadejte index vybraneho objektu (0-n)");
        i = sc.nextInt();
        System.out.println("Rozmery objektu: " + shapes.get(i));
        System.out.println("Obsah objektu: " + shapes.get(i).computeArea());

    }
}
