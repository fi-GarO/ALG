package comparingstudents;

import comparingstudents.mycomparing.CompareInterface;
import java.util.Objects;

/**
 *
 * @author jiri.turyna
 */
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int studentNumber;
    private double[] grades;;

    public Student(String firstName, String lastName, int studentNumber, double... grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.grades = new double[grades.length];
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    
    public double[] addGrade(double znamka){
    double[] znamky = this.grades;
    this.grades = new double[znamky.length +1];
        System.arraycopy(znamky, 0, this.grades, 0, znamky.length);
        this.grades[this.grades.length -1] = znamka;
        return znamky;
    }
    
    public double getAVG(){
        double prumer = 0;
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
             prumer += grades[i];
             n++;
        }
        prumer = prumer / n;
        return prumer;
    }
    
    @Override
    public String toString() {
        return String.format("%10s%10s%10d",firstName, lastName, studentNumber);
    }

    public boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber;
    }

    //potrebne pro MyComparing
    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber;
    }

    /*@Override
    public int compareTo(Object o) {
        return this.studentNumber - ((Student)o).studentNumber;
    }*/

    //potrebne pro Comparing
    @Override
    public int compareTo(Student o) {
        return this.studentNumber - o.studentNumber;
    }
    
    //pri zmene equals zmenit i hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + this.studentNumber;
        return hash;
    }
    
    //default in Object 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
}
