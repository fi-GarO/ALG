package shapes;

import java.util.ArrayList;

/**
 *
 * @author Jiri.Turyna
 */
public class Main {

    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2, 3);
        Circle c2 = Circle.getInstanceR(2.6);

        System.out.println("1. Varianta");
        double allArea1 = c1.computeArea() + r1.getArea() + c2.computeArea();
        System.out.println(allArea1);

        System.out.println("2. varianta");
        // Může obsahovat cokoliv co je typově kompatibilní s "Object" = každá třída -> všechno
        ArrayList shapes2 = new ArrayList();
        shapes2.add(c1);
        shapes2.add(r1);
        shapes2.add(Circle.getInstanceR(2.6));

        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) { // going through using index
            if (shapes2.get(i) instanceof Circle) {
                allArea2 += ((Circle) shapes2.get(i)).computeArea();
            } else if (shapes2.get(i) instanceof Rectangle) {
                allArea2 += ((Rectangle) shapes2.get(i)).computeArea();
            }
            System.out.println(allArea2);

            System.out.println("3. varianta");
            // může obsahovat cokoliv co je typově kompatibilní s typem "Shape" (Shape, circle, rectangle)
            ArrayList<Shape> shapes3 = new ArrayList<>(); //dynamické pole objektů typu shape

            shapes3.add(c1);
            shapes3.add(r1);
            shapes3.add(Circle.getInstanceR(2.6));
            double allArea3 = 0;
            for (Shape shape : shapes3) { // for each
                allArea3 += shape.computeArea(); // polymorfismus
            }
            System.out.println(allArea3);

        }

    }

}
