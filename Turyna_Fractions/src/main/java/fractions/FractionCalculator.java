package fractions;

/**
 *
 * @author Jiri.Turyna
 */
public class FractionCalculator {
    public static Fraction plus(Fraction a, Fraction b){
        
        int denomA = a.getDenominator();
        int denomB = b.getDenominator();
        
        int nomA = a.getNominator();
        int nomB = b.getNominator();
        
        int denom = findDenominator(denomA, denomB);
        
        int nom = ((denomA / denom) * nomA) + ((denomB / denom) * nomB);
        
        return Fraction.getInstance(nom, denom);
        
    }
    
    public static Fraction minus(Fraction a, Fraction b){
        int denomA = a.getDenominator();
        int denomB = b.getDenominator();
        
        int nomA = a.getNominator();
        int nomB = b.getNominator();
        
        int denom = findDenominator(denomA, denomB);
        
        int nom = ((denomA / denom) * nomA) - ((denomB / denom) * nomB);
        
        return Fraction.getInstance(nom, denom);
    }
    
    public static Fraction divide(Fraction a, Fraction b){
        int denomA = a.getDenominator();
        int denomB = b.getDenominator();
        
        int nomA = a.getNominator();
        int nomB = b.getNominator();
        
        int nom = nomA * denomB;
        int denom = denomA * nomB;
        
        return Fraction.getInstance(nom, denom);
    }
    
    public static Fraction multiply(Fraction a, Fraction b){
        int denomA = a.getDenominator();
        int denomB = b.getDenominator();
        
        int nomA = a.getNominator();
        int nomB = b.getNominator();
        
        int nom = nomA * nomB;
        int denom = denomA * denomB;
        
        return Fraction.getInstance(nom, denom);
        
    }
    
    public static int findDenominator(int a, int b){
        int denom = 0;
        if (a != b) {
            denom = a*b;
        } else {
            denom = a;
        }   
        return denom;
    }
}
