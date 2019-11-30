
package csce210lab2;
import java.util.*;

public class Student implements Comparable<Student>
{
    String fname, lname;
    int [] testScores;
    public Student(String fname, String lname, int [] scores)
    {
        this.fname = fname;
        this.lname = lname;
        this.testScores = scores;
    }
    @Override
    public String toString()
    {
        String str = String.format("%s, %s scores: %s",
                lname, fname,
                Arrays.toString(testScores)
        );
        return str;
    }

    @Override
    public boolean equals(Object ob) {

        if(ob == null || !(ob instanceof  Student)) {

            return false;

        }

        return ((Student)ob).fname.equals(fname) && 
                ((Student)ob).lname.equals(lname);

    }
    
    public int getSumOfScores() {
    
        int total = 0;
        
        for(int a : testScores) {
        
            total += a;
        
        }
        
        return total;
    
    }

    public int compareTo(Student S) {

        int fCompare = fname.compareTo(S.fname);
        int lCompare = lname.compareTo(S.lname);

        if(lCompare == 0) {

            return fCompare;

        } else {

            return lCompare;

        }

    }
    
    public static Comparator<Student> firstScoreComparator =
            (s1, s2) -> {
            
                return s2.testScores[0] - s1.testScores[0];
            
            };
    
    public static Comparator<Student> scoreTotalComparator =
            (s1, s2) -> {
            
                int s1Total = s1.getSumOfScores();
                int s2Total = s2.getSumOfScores();
                
                return s2Total - s1Total;
            
            };

}
