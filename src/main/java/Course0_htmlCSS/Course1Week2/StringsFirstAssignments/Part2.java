
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findGeneSimple(String dna, int startCodon, int stopCodon)
    {
        String dnaUpper = dna.toUpperCase();
        int startIndex = dnaUpper.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int endIndex = dnaUpper.indexOf("TAA",startIndex+3);
        if (endIndex == -1){
            return "";
        }
        if ((endIndex - startIndex) % 3 == 0){
            //System.out.println("Gene = " + dna.substring(startIndex,endIndex+3));
            return dna.substring(startIndex,endIndex+3);
        }
        return "";
    }
    
    public void testFindGeneSimple()
    {
        String dna = "AATATGAAATAATG"; //mod 3 == 0, good gene
        System.out.println("Good DNA strand is: " + dna);
        String gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene);      
        
        dna = "AATATGATEE"; //mod 3 != 0, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene);
        
        dna = "AATATAAATEE"; //no ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene); 
        
        dna = "AATAAGTAATGAAATEE"; //No TAA after ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene); 
        
        dna = "aatatgaageaatgataatg"; //mod 3 == 0, good gene
        System.out.println("Good DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene);        
        
        dna = "aatatgagagtee"; //mod 3 != 0, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene);
        
        dna = "aatataaatee"; //no ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene); 
        
        dna = "aataagtaatgaaatee"; //No TAA after ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene); 
        
        dna = "ataatgaatgaaatee"; //No TAA after ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna, 1, 1);
        System.out.println("Gene is " + gene);         
    }
}
