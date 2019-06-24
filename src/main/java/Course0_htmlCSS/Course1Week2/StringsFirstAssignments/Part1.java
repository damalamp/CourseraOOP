
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findGeneSimple(String dna)
    {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf("TAA",startIndex+3);
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
        String dna = "AATATGATEE"; //mod 3 != 0, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATATGAAATAATG"; //mod 3 == 0, good gene
        System.out.println("Good DNA strand is: " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATATAAATEE"; //no ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene); 
        
        dna = "AATAAGTAATGAAATEE"; //No TAA after ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene); 
        
        dna = "ATAATGAATGAAATEE"; //No TAA after ATG, bad gene
        System.out.println("Bad DNA strand is: " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene); 
    }

}
