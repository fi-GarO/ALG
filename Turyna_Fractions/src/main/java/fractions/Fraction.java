package fractions;

/**
 *
 * @author Jiri.Turyna
 */
public class Fraction {

    private int nominator;
    private int denominator;

    private Fraction(int citatel, int jmenovatel) {
        if (jmenovatel == 0){
            throw new IllegalArgumentException("deleni nulou");
        }
        
        this.denominator = jmenovatel;
        this.nominator = citatel;
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static Fraction getInstance(int citatel, int jmenovatel) {
        return new Fraction(citatel, jmenovatel);
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    public void simplify() {
        int c;
        int a = nominator;
        int b = denominator;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        nominator = nominator / a;
        denominator = denominator / a;
    }
}
