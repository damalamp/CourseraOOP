package Course1.Week4.Part1;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.synth.SynthDesktopIconUI;

public class Solutions {

    public static void totalBirth(CSVParser parser){
        int boys = 0;
        int girls = 0;
        for (CSVRecord record : parser){
            System.out.println("record(1) = " + record.get(1));
            if (record.get(1).equals("F")){
                girls++;
                //female
            } else {
                boys++;
                //male
            }
        }
        System.out.println("Boys: " + boys);
        System.out.println("Girls: " + girls);
        int total = boys+girls;
        System.out.println("Total: " + total);
    }

    public static void testTotalBirths(){
        FileResource file = new FileResource("Week4Part1_us_babynames/us_babynames_by_year/yob1905.csv");
        CSVParser parser = file.getCSVParser(false);
        totalBirth(parser);
    }

    public static Integer getRank(Integer year, String name, String gender){
        String fileLocation = "Week4Part1_us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource file = new FileResource(fileLocation);
        CSVParser parser = file.getCSVParser(false);
        int rank = 0;
        for (CSVRecord record : parser){
            if (record.get(1).equals(gender)){
                rank++;
                if (record.get(0).equals(name)) {
                    System.out.println(name + " is ranked: " + rank + " in year " + year);
                    return rank;
                }
                //System.out.println("Current name: " + record.get(0));
                //System.out.println("now on ranked: " + rank);
            }
        }
        System.out.println("Nah, no such " + name + " found for gender " + gender);
        return -1;
    }

    public static void testGetRank(){
        getRank(1971, "Mich", "M");
    }

    public static String getName(Integer year, Integer rank, String gender){
        String fileLocation = "Week4Part1_us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource file = new FileResource(fileLocation);
        CSVParser parser = file.getCSVParser(false);
        int count = 0;
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                count++;
            }
            if (count == rank){
                System.out.println("Rank " + rank + " with gender " + gender + " is name: " + record.get(0));
                return record.get(0);
            }
        }
        return "";
    }

    public static void testGetName(){
        getName(1982, 450, "M");
    }

    public static void whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
        Integer rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " in year " + year + " would be " + newName + " in " + newYear);
    }

    public static void testWhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }

    public static Integer yearOfHighestRank(String name, String gender){
        int currRank;
        int bestRank = -1;
        int bestYear = -1;
        for (int i = 1880; i<2015; i++){
            if (bestRank < 0) {
                bestRank = getRank(i, name, gender);
                System.out.println("Setting best rank (first time) = " + bestRank);
            }
            currRank = getRank(i,name,gender);
            if (currRank < bestRank && currRank > 0){
                System.out.println("Setting best rank = " + currRank);
                bestRank = currRank;
                bestYear = i;
            }
        }
        System.out.println("Best Rank found for "  + name + " (" + gender + ") is " + bestRank + " in year " + bestYear);
        return bestRank;
    }

    public static void testYearOfHighestRank(){
        yearOfHighestRank("Sam", "M");
    }

    public static double getAverageRank(String name, String gender, Integer startYear, Integer endYear){
        double rankCount = 0;
        double rankSum = 0;
        double rankAverage;
        for (int i = startYear; i<=endYear; i++){
            rankSum += getRank(i,name,gender);
            rankCount ++;
        }
        rankAverage = rankSum/rankCount;
        System.out.println("Average rank for "  + name + " (" + gender + ") is " + String.format("%1$,.2f", rankAverage) + " taken from  " + rankCount + " rank counts and a " + rankSum + " rank sum");
        return rankAverage;
    }

    public static void testGetAverageRank(){
        getAverageRank("Robert", "M", 1880,2014);
    }

    public static Integer getTotalBirthsRankedHigher(Integer year, String name, String gender){
        String fileLocation = "Week4Part1_us_babynames/us_babynames_by_year/yob" + year + ".csv";
        //String fileLocation = "Week4Part1_us_babynames/us_babynames_test/example-small.csv";
        FileResource file = new FileResource(fileLocation);
        CSVParser parser = file.getCSVParser(false);
        int birthCount = 0;
        System.out.println("input name: " + name);
        System.out.println("input gender: " + gender);
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                System.out.println(name);
                if (record.get(0).equals(name)) {
                    System.out.println("record name matches! " + record.get(0).equals(name));
                    //System.out.println("record gender: " + record.get(1));
                    System.out.println("birth count = " + birthCount);
                    //System.out.println("Int parsed: " + Integer.parseInt(record.get(2)));
                    return birthCount;
                }
                birthCount += Integer.parseInt(record.get(2));
            }
        }
        return -1;
    }

    public static void testGetTotalBirthsRankedHigher(){
        getTotalBirthsRankedHigher(1990, "Drew", "M");
    }
}
