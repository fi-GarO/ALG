package polynoms;

/**
 * 
 * @author Jiri Turyna
 */

public class Polynoms {

    // knihovní třída 
    private Polynoms() {

    }   

    public static Polynom sum(Polynom a, Polynom b) {
        boolean isABigger = a.getDegree() > b.getDegree();
        Polynom max = isABigger ? a : b; // Math.max(a.getDegree(), b.getDegree());
        Polynom min = isABigger ? b : a;

        double[] sumCoef = new double[max.getDegree() + 1]; // 3. stupen -> potřebujeme pole o velikosti 4
        for (int i = 0; i < max.getDegree() + 1; i++) {
            sumCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);

        }
        return Polynom.getInstance(sumCoef);

    }

    //TODO -> Multiply
    public static Polynom multiply(Polynom a, Polynom b) {
        boolean isABigger = a.getDegree() > b.getDegree();
        Polynom max = isABigger ? a : b; 
        Polynom min = isABigger ? b : a;

        double[] multCoef = new double[max.getDegree() + 1];
        for (int i = 0; i < max.getDegree() + 1; i++) {
            multCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            if (max.getCoefAt(i) == 0 && min.getCoefAt(i) != 0) {   // podmínky: 0x1 * 3x1 != 0, ale = 1 
                multCoef[i] = 1 * min.getCoefAt(i);
            } else if (min.getCoefAt(i) == 0 && max.getCoefAt(i) != 0) {
                multCoef[i] = 1 * max.getCoefAt(i);
            } else {
                multCoef[i] = multCoef[i] * min.getCoefAt(i);
            }

        }
        return Polynom.getInstance(multCoef);

    }

    public static void main(String[] args) {
                      
        Polynom p1 = Polynom.getInstanceReverted(6,0,3,5); //6 + 0x1 + 3x2 + 5x3
        Polynom p2 = Polynom.getInstanceReverted(1,3,6); //  0 + 1x1 + 3x2 + 6x3
        
        System.out.println(sum(p2, p1));
    }

}
