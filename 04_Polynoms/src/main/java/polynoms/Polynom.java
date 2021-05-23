package polynoms;

import java.util.Arrays;
import java.lang.*;

/**
 * 
 * @author Jiri Turyna
 */

public class Polynom {

    // Data: 5x3 + 3x2 + 6  -> jak uložit 
    // - pole, 5x3 + 3x2 + 6 = [6][0][3][5] = 6*x0 + 0*x1 + 3*x2 + 5*x3
    private double[] coef;

    // Konstruktory: Vstupní hodnoty
    // uživatel zadá 6 0 3 5 (postupně od nejmenší mocniny)
    public Polynom(double[] coef) { // Defenzivní kopie - zapouzdření, privatní hodnoty pole
        double[] coefTemp = new double[coef.length];
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }

    // tovární(factory) metoda - uživatel zadá [6 0 3 5] (postupně od nejmenší mocniny)       
    public static Polynom getInstanceReverted(double... coef) {
        return new Polynom(coef);
    }

    // tovární metoda - uživatel zadá [5 3 0 6] (postupně od největší mocniny)   
    public static Polynom getInstance(double... coef) { // Znamená, že to bude reagovat na všechny typy doublů
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coefTemp.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);

    }

    // metody
    
    // gettery
    public double getCoefAt(int exp) {
        return coef[exp];
    }

    public double[] getAllCoef() { // defenzivní metoda, jinak bychom předávali adresy hodnot
        return Arrays.copyOf(coef, coef.length);
    }

    public int getDegree() { 
        return coef.length - 1;
    }

    // 5x3 zderivované na 15x2
    public Polynom derivate() {
        double[] coefD = new double[this.coef.length - 1];
        for (int i = 0; i < coefD.length; i++) {
            coefD[i] = coef[i + 1] * (i + 1);
        }
        return new Polynom(coefD);
    }

    // TODO - vypsat matematicky správně 1 + 2x + 3x^2 + ... , 0 se nevypíše
    @Override
    public String toString() {

        StringBuilder tmp = new StringBuilder("");

        for (int i = 0; i < coef.length; i++) {

            if (coef[i] == 0) { // 0 se nevypisuje
            } else if (i == 0) {
                tmp.append(coef[i]).append(" + ");

            } else if (i == 0 && i + 1 == coef.length) {
                tmp.append(coef[i]);

            } else if (i + 1 == coef.length) { // pro poslední prvek se nevypíše "+"

                tmp.append(coef[i]).append("x^").append(i);

            } else {
                tmp.append(coef[i]).append("x^").append(i).append(" + ");
            }

        }
        return tmp.toString();
    }

    // TODO -> Horneovo schéma
    // y = 5x3 + 3x2 + 6; x = 1, y = 5+3+6 = 14
    public double computeValue(double x) {
        double sum = coef[coef.length - 1];
        for (int i = coef.length - 1; i > 0; i--) {
            sum *= x;
            sum += coef[i - 1];
        }
        return sum;
    }

    //TODO -> bonus: integral na rozsahu od A do B
    public double integrate(double a, double b) {

        double max = (a > b) ? a : b;
        double min = (a > b) ? b : a;

        double meze;
        double sum = 0;
        double tmpMax;
        double tmpMin;
        double temp = 0;

        for (int i = 0; i < coef.length; i++) {
            if (coef[i] == 0) {
            } else {
                temp = coef[i] / (i + 1);
            }
            tmpMax = Math.pow(max, i + 1);
            tmpMin = Math.pow(min, i + 1);
            meze = (tmpMax * temp) - (tmpMin * temp);
            sum = sum + meze;
        }
        return sum;
    }

    public static void main(String[] args) {
        double[] a = {1, 5, 3, 6};
        //Polynom p1 = Polynom.getInstance(a);
        Polynom p1 = Polynom.getInstance(5,3,4,0);
        Polynom p2 = Polynom.getInstance(1, 3, 6);

        System.out.println(p1.integrate(2, 3));

    }

}
