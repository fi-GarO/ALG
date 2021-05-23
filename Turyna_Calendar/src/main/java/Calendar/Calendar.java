package Calendar;

/**
 *
 * @author Jiri.Turyna
 */
public class Calendar {
    
    private int day;
    private int month;
    private int year;
    private static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int calcDayInWeek(int day, int month, int year) {
        
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        
        int k = year % 100;
        int j = year / 100;

        // 0 = Saturday, 1 = Sunday, 2 = Monday, 3 = Tuesday, 4 = Wednesday, 5 = Thursday, 6 = Friday 
        int dayOfWeek = ((day + (((month + 1) * 26) / 10)
                + k + (k / 4) + (j / 4)) + (5 * j)) % 7;
        
        return dayOfWeek;
    }
    
    public String calandarCreator() {
        int daysInM = monthDays[(month) - 1];
        StringBuilder calendar = new StringBuilder();
        calendar.append("MON TUE WED THU FRI SAT SUN");
        
        calendar.append("\n");
        
        if (month == 2 && leapYear(year)) {
            daysInM = 29;
        }
        
        int tmp = calcDayInWeek(1, month, year);
        for (int i = 0; i < tmp; i++) {
            calendar.append("  ");
            
        }
        for (int i = 1; i <= daysInM; i++) {
            if (i < 10){ calendar.append(i + "   "); }
            else { calendar.append(i + "  "); }
            
            if (calcDayInWeek(i, month, year) == 1){
               calendar.append("\n");
            }
        }
        
        
        return calendar.toString();
        
    }
    
    public void nextMonth() {
        day = 1;
        if (month == 12) {
            year++;
            month = 1;
        } else {
            month++;
        }
    }
    
    public void previousMonth() {
        day = 1;
        if (month == 1) {
            year--;
            month = 12;
        } else {
            month--;
        }
        
    }
    
    public static boolean leapYear(int year) {
        boolean leap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        
        return leap;
    }
    
    public static int daysInYear(int year) {
        int a = 366;
        int b = 365;
        if (leapYear(year)) {
            return a;
        } else {
            return b;
        }
    }
    
    public static void main(String[] args) {
        Calendar c = new Calendar(22, 4, 2020);
        
        System.out.println(c.calandarCreator());
        
    }

}
