package Course1.Week3.Part2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Solutions {
    public static CSVRecord lowestHourInFile(CSVParser parser, String columnName){
        double minTemp = 9999;
        CSVRecord coldestRecord = null;
        for (CSVRecord record : parser){
            double temp = Double.parseDouble(record.get(columnName));
            //System.out.println("this record's temp: " + temp);
            if (temp > -9999){
                if (temp < minTemp) {
                    minTemp = temp;
                    coldestRecord = record;
                }
            }
        }
        System.out.println("Lowest in file = " + minTemp + " (" + columnName + ")");
        return coldestRecord;
    }


    public static void testColdedHourInFile(){
        //FileResource fr = new FileResource("/Users/david.lamp/Documents/Developer/Coursera Intro to Java/IntelliJProjects/CourseraJava/src/main/java/Course1/Week3/Part2_BreakingCaesarCipher/nc_weather/2012/weather-2012-01-01.csv");
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        lowestHourInFile(parser, "TemperatureF");
    }

    public static String fileWithLowestValue(String columnName){
        DirectoryResource files = new DirectoryResource();
        //FileResource coldestFile = null;
        double totalColdest = 9999;
        double currentColdest = 9999;
        String coldestPath = null;
        String currentPath = null;
        String coldestFileName = null;
        for (File file : files.selectedFiles()){
            try {
                currentPath = file.getCanonicalPath();
            } catch (Exception e) {
                System.out.println("Exception triggered?");
            }
            FileResource fileR = new FileResource(file);
            System.out.println("File being processed: " + currentPath);
            CSVRecord record = lowestHourInFile(fileR.getCSVParser(), columnName);
            try {            currentColdest = Double.parseDouble(record.get(columnName));
            } catch (Exception e){
                System.out.println("Error trying to get stuff");
            }
            if (currentColdest < totalColdest){
                System.out.println("New Lowest = " + currentPath);
                totalColdest = currentColdest;
                coldestPath = currentPath;
                coldestFileName = file.getName();
                //coldestFile = fileR;
            }
        }
        System.out.println("Lowest Day on File " + coldestFileName + " (" + columnName + ")");
        System.out.println("Lowest that Day was " + totalColdest + " (" + columnName + ")");
        FileResource fr = new FileResource(coldestPath);
        CSVParser parser = fr.getCSVParser();
        System.out.println("All the " + columnName + " on the lowest day were:");
        for (CSVRecord record : parser){
            System.out.println(recordDetails(record, columnName));
        }
        return coldestPath;
    }

    public static void testFileWithLowestValue(){
        fileWithLowestValue("TemperatureF");
    }

    public static String recordDetails(CSVRecord record, String columnName){
        return record.get("DateUTC") + ": " + record.get(columnName);
    }

    public static double averageTemperatureInFile(CSVParser parser){
        double sumTemperature = 0;
        double rowCount = 0;
        for (CSVRecord record : parser){
            sumTemperature += Double.parseDouble(record.get("TemperatureF"));
            rowCount++;
        }
        return sumTemperature/rowCount;
    }

    public static void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average Temp: " + averageTemperatureInFile(parser));
    }

    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, Integer value) {
        double sumTemperature = 0;
        double rowCount = 0;
        Integer humidity;
        for (CSVRecord record : parser) {
            humidity = Integer.parseInt(record.get("Humidity"));
            System.out.println("humidity = " + humidity);
            System.out.println("value = " + value);

            if (humidity >= value) {
                sumTemperature += Double.parseDouble(record.get("TemperatureF"));
                rowCount++;
            }
        }
        if (rowCount == 0) {
            System.out.println("No temperatures with that humidity");
            return -9999;
        } else {
            return sumTemperature / rowCount;
        }
    }

    public static void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Integer value = 80;
        System.out.println("Average Temp for days with humidity > " + value + ": " + averageTemperatureWithHighHumidityInFile(parser, value));
    }
}
