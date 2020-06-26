
/**
 * Write a description of MiniProject here.
 * 
 * @author (Md.Samiul Haque) 
 * @version (1.0)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class MiniProject {
    public void printNames() {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
               System.out.println("Name "+rec.get(0)+
                                " Gendder "+rec.get(1)+
                                 " Num Born "+ rec.get(2));
            }
        }
    }
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths = totalBirths + numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("Total births = "+totalBirths);
        System.out.println("Total girls = "+totalGirls);
        System.out.println("Total boys = "+totalBoys);
    }
    
    public int getRank (int year,String name,String gender) {
        FileResource fr = new FileResource();
        int clmCount = 0;
        for (CSVRecord rc : fr.getCSVParser(false)) {
            if (rc.get(1).equals(gender)) {
                clmCount = clmCount + 1;
                
                if (rc.get(0).equals(name)) {
                    return clmCount;
                }
                
                    
                
            }
        }
        return -1;
    }
    
    public String getName (int year,int rank,String gender) {
        FileResource fr = new FileResource();
        int clmCount = 0;
        for (CSVRecord rc : fr.getCSVParser(false)) {
            if (rc.get(1).equals(gender)) {
                clmCount = clmCount + 1;
                
                if (clmCount == rank) {
                    String fname =rc.get(0);
                    return fname;
                }
                
                    
                
            }
        }
        return "NO NAME";
    }
    
    public String whatIsNameInYear (String name,int year,int newYear,String gender) {
        //String yearName = "yob"+year;
        FileResource fr = new FileResource();
        int clmCount = 0;
        for (CSVRecord rc : fr.getCSVParser(false)) {
            if (rc.get(1).equals(gender)) {
                clmCount = clmCount + 1;
                
                if (rc.get(0).equals(name)) {
                    break;
                }
                
                    
                
            }
        }
        //String newYearName = "yob"+newYear;
        FileResource file = new FileResource();
        int count = 0;
        for (CSVRecord rc : file.getCSVParser(false)) {
            if (rc.get(1).equals(gender)) {
                count = count + 1;
                
                if (count == clmCount) {
                    String fname =rc.get(0);
                    return fname;
                    
                }
                
                    
                
            }
        }
        return "NO NAME";
        
    }
    //****************************************************
    
    //***************************************************
    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public void testerGetRank () {
        System.out.println(getRank(2012,"Frank","M"));
    }
    
    public void testerGetName () {
        System.out.println(getName(2012,450,"M"));
    }
    
    public void testerWhatIsNameInYear () {
        System.out.println(whatIsNameInYear("Susan",2012,2014,"F"));
    }
}
