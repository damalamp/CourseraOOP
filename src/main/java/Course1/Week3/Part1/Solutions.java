package Course1.Week3.Part1;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Solutions {

    public static void exporterOneProduct(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        int count = 0;
        for (CSVRecord record : parser){
            //System.out.println(record);
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)){
                printFullCountryInfo(record);
                count++;
            }
        }
        System.out.println("Count = " + count);
        //Look at the "Exports" column

        //Check if it contains exportOfInterest

        //If so, write down the "Country" from that row

        System.out.println("hey!");
    }

    public static void testExporterOneProduct() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        exporterOneProduct(parser, "cocoa");
    }

    public static void countryInfo(CSVParser parser, String countryName){
        for (CSVRecord record : parser){
            System.out.println("Now checking: " + record.get("Country"));
            if (record.get("Country").equals(countryName)){
                printFullCountryInfo(record);
                return;
            }
        }
        System.out.println("NOT FOUND");
    }

    public static void testCountryInfo() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");
    }

    public static void listExporterTwoProducts(CSVParser parser, String productOne, String productTwo){
        for (CSVRecord record : parser){
            //System.out.println("Now checking: " + record.get("Country"));
            if (record.get("Exports").contains(productOne) && record.get("Exports").contains(productTwo)){
                printFullCountryInfo(record);
            }
        }
        //System.out.println("NOT FOUND");
    }

    private static void printFullCountryInfo(CSVRecord record) {
        System.out.println(
                record.get("Country") + ": " +
                        record.get("Exports") + ": " +
                        record.get("Value (dollars)"));
    }

    public static void testListExporterTwoProducts() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporterTwoProducts(parser, "cotton", "flowers");
    }

    public static void numberOfExporters(CSVParser parser, String product){
        int count = 0;
        for (CSVRecord record : parser){
            //System.out.println("Now checking: " + record.get("Country"));
            if (record.get("Exports").contains(product)){
                count++;
            }
        }
        System.out.println("Exporter Count = " + count);
    }

    public static void testNumberOfExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        numberOfExporters(parser, "gold");
    }

    public static void bigExporters(CSVParser parser, String gross){
        int count = 0;
        for (CSVRecord record : parser){
            //System.out.println("Now checking: " + record.get("Country"));
            if (record.get("Value (dollars)").length() > gross.length()){
                printShortCountryInfo(record);
                count++;
            }
        }
        System.out.println("Count = " + count);
    }

    private static void printShortCountryInfo(CSVRecord record) {
        System.out.println(
                record.get("Country") + ": " +
                        record.get("Value (dollars)"));
    }

    public static void testBigExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }

}
