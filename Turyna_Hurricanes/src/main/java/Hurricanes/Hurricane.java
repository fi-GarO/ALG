package Hurricanes;

/**
 *
 * @author Jiri.Turyna
 */
public class Hurricane {

    private final int year;
    private final String month;
    private final int pressure;
    private final int speed;
    private final String name;

    public Hurricane(int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public double knotsToKMH() {
        double kToKMH = speed * 1.852;
        return kToKMH;
    }

    @Override
    public String toString() {
        return "Hurricane: " + "Name = " + name + ", Year = " + year + ", Month = " + month + ", Pressure = " + pressure + ", Speed = " + speed;
    }
    

    public int getSaffirSimpson() {
        if (knotsToKMH() >= 119 && knotsToKMH() <= 153) {
            return 1;
        }
        if (knotsToKMH() >= 154 && knotsToKMH() <= 177) {
            return 2;
        }
        if (knotsToKMH() >= 178 && knotsToKMH() <= 208) {
            return 3;
        }
        if (knotsToKMH() >= 209 && knotsToKMH() <= 251) {
            return 4;
        }
        if (knotsToKMH() >= 252) {
            return 5;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Hurricane h = new Hurricane(1996, "June", 150, 85, "Pepega");
        System.out.println(h.knotsToKMH());
        System.out.println(h.getSaffirSimpson());
         
     }
}
