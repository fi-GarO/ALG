package bank;

import java.util.ArrayList;

/**
 *
 * @author Jiri.Turyna
 */
public abstract class Client {

    private String name;
    private ArrayList<Account> arrayOfAccounts = new ArrayList();

    public abstract String salutation();

    public Client(String name) {
        this.name = name;
    }

    public void newAccount(double v) {
        Account account = new Account(v);
        arrayOfAccounts.add(account);
    }

    public double sumOfAll() {
        double sumOfAll = 0;
        for (Account account : arrayOfAccounts){
            sumOfAll += account.getSum();
        }
        return sumOfAll;
        
    }
}
