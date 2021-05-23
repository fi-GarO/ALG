package bank;

/**
 *
 * @author Jiri.Turyna
 */
public class Account {

    private double suma;

    public Account(double suma) {
        this.suma = suma;
    }

    public static Account creatNewAccount(double s) {
        return new Account(s);
    }

    public double getSum() {
        return suma;
    }

    @Override
    public String toString() {
        return "Vas zustakek na uctu je: " + suma;
    }

    public static Account createEmptyAccount() {
        return new Account(0);
    }

    public void insert(double v) {
        if (v > 0) {
            suma += v;
        } else {
            System.out.println("Nelze pridat zapornou hodnotu");
        }
    }

    public void withdraw(double v) {
        if ((suma - v) < 0) {
            System.out.println("Nemate na svem ucte dostatecne finance");
        } else {
            suma -= v;
        }

    }

    public static void main(String[] args) {
        Account a = Account.creatNewAccount(50);
        System.out.println(a);

    }
}
