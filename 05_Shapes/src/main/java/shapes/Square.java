package shapes;

/**
 *
 * @author Jiri.Turyna
 */
public class Square extends Shape {
    private double a;
    private double area;

    public Square(double a) {
        this.a = a;
        this.area = area();
    }

    private double area() {
        return a*a;
    }
    public double getArea(){
        return area;
    }

    public double getA() {
        return a;
    }
    
    @Override
    public double computeArea(){
        return area;
    }

    @Override
    public String toString() {
        return "Square{" + "a=" + a + '}';
    }
    
    
    
}
