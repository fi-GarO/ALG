package shapes;

/**
 *
 * @author Jiri.Turyna
 */
public class Circle extends Shape { // Circle je typově kompatibilní s "Shape", Circle is a Shape

    // data
    private double r;

    private Circle(double r) {
        this.r = r;
    }

    /*public Circle(double d) { -> Nelze přetížit/overwhelm metodu (mají stejný datový typ)
        this.r = d/2;
    }*/

    // tovarní metoda - factory method
    public static Circle getInstanceD(double d) {
        return new Circle(d / 2);
    }
    
    public static Circle getInstanceR(double r) {
        return new Circle(r);
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }
    
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }

    public static void main(String[] args){
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
        System.out.println(c1.computeArea());
    }
}
