package Hurricanes;

import java.io.FileNotFoundException;

/**
 *
 * @author Jiri.Turyna
 */
public interface Interface {
    public void load();
    public String yearInterval(int year1, int year2);
    public String infoByName(String name);
    public String sortBySpeed();    
}
