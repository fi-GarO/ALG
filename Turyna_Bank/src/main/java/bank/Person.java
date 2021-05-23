package bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jiri.Turyna
 */
public class Person extends Client {

    private String name;
    
    public Person(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String salutation() {
        Pattern p = Pattern.compile("ova");
        Matcher m = p.matcher(name);
        if (m.find()){
            return "pani " + name;
        } else {
            return "pan " + name;
        }
    }
    
}
