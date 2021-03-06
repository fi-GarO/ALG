package comparingstudents;

import comparingstudents.mycomparing.MyComparing;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Vyuziti metody sort z tridy Arrays nebo Collections a interface Comparable
 *
 * @author jiri.turyna
 */
public class Comparing {

    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        //TODO pridat studentum znamky
        
        students[0].addGrade(5); // Alice
        students[0].addGrade(1);

        students[1].addGrade(2); // Bob
        
        students[2].addGrade(3); // Cyril
        students[2].addGrade(1);

        //test shodnosti objektu - chceme: nemusi byt stejny objekt, staci, kdyz ma stejna data
        System.out.println(students[0].equals(students[1]));

        //pouziti Comparable interface
        MyComparing.print(students);
        System.out.println("Sort by number");
        Arrays.sort(students); //students musi byt typove kompatibilni s interface Comparable
        MyComparing.print(students);

        List<Student> students1 = Datasource.loadDataAsList();
        MyComparing.print(students1);
        System.out.println("Sort by number");
        Collections.sort(students1); //students musi byt typove kompatibilni s interface Comparable
        MyComparing.print(students);

        //pouziti Comparator interface
        System.out.println("Sort by firstname");
        Arrays.sort(students, new ComparatorByFirstName());
        MyComparing.print(students);

        System.out.println("Sort by lastname");
        Arrays.sort(students, new Comparator<Student>() { //anonymni trida implementujici Comparator interface
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs", "CZ")); //tovarni metoda
                return col.compare(o1.getLastName(), o2.getLastName());
                //return o1.getLastName().compareTo(o2.getLastName()); //trideni Stringu podle ASCII 
            }
        });
        MyComparing.print(students);

        //TODO setridit podle prumeru
        System.out.println("Sort by Average grade");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAVG() > o2.getAVG()) {
                    return 1;
                } else if (o1.getAVG() == o2.getAVG()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
        );
        MyComparing.print(students);

    }
}
