/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team
 */
import edu.duke.*;
import java.io.*;
import java.lang.Math.*;

    public class Part1 {
public Integer findEndCodon(String dna, Integer atgIndex, String endCodon){
        //dna = dna.toLowerCase();
        Integer foundIndex = atgIndex;
        while (true) {
                foundIndex = dna.indexOf(endCodon, foundIndex);
                if (foundIndex == -1) {
                        //System.out.println("entered -1 loop");
                        return dna.length()+1;
                        
                }
                if ((foundIndex-atgIndex)%3 == 0) {
                        //System.out.println("foundIndex = " + foundIndex);
                        //System.out.println("atgIndex = " + atgIndex);
                        return foundIndex;
                }
                foundIndex++;
                //System.out.println("whiling again. ");
        }
}

public Integer minGeneEnd(String dna, Integer start){
        //dna = dna.toLowerCase();
        Integer tagIndex = findEndCodon(dna, start, "tag");
        Integer taaIndex = findEndCodon(dna, start, "taa");
        Integer tgaIndex = findEndCodon(dna, start, "tga");

        Integer minEnd = Math.min(tagIndex,taaIndex);
        return Math.min(minEnd, tgaIndex);
}

public String findGene(String dna, Integer atgIndex) {
        //dna = dna.toLowerCase();
        Integer minEnd = minGeneEnd(dna, atgIndex+3);
        if (minEnd > dna.length()) {    
                return "";
        }
        System.out.println("genez: " + dna.substring(atgIndex, minEnd+3));
        return dna.substring(atgIndex, minEnd+3);
}

public StorageResource findGenes(String dna){
        dna = dna.toLowerCase();
        int startIndex = 0;
        StorageResource genes = new StorageResource();
        String newGene = "";

        while(true) {
                startIndex = dna.indexOf("atg", startIndex);
                //System.out.println("StartIndes = " + startIndex);
                if (startIndex == -1) {
                        System.out.println("no ATG found, breaking");
                        break;
                }
                newGene = findGene(dna,startIndex);
                if (newGene.length() == 0) {
                        //System.out.println("breaking!");
                        break;
                }
                //System.out.println("DNA: "+ findGene(dna,startIndex));
                genes.add(newGene);
                startIndex = minGeneEnd(dna,startIndex+3)+3;
        }
        return genes;
}

public Integer timesStringFound (String mainString, String searchString){
        Integer count = 0;
        Integer lastFoundIndex = mainString.indexOf(searchString);
        if (lastFoundIndex == -1) {
                return count;
        }
        count++;
        while(true) {
                lastFoundIndex = mainString.indexOf(searchString,lastFoundIndex+1);
                if (lastFoundIndex == -1) {
                        return count;
                }
                count++;
        }
}

public float cgRatio(String dna){
        Integer countC = timesStringFound(dna,"c");
        Integer countG = timesStringFound(dna,"g");
        return (float) countC/countG;
}

/*
   public void testFindGenes() {
        String dna = "AATGCTAACTAGCTGACTAAT";
        StorageResource genes = findGenes(dna);
        //System.out.println("Genes = ");
        for (String s : genes.data()) {
                //System.out.println("gene: " + s);
        }
   }
 */

public void processGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        //String dna = "atg1tga2tga3tga";
        System.out.println("proof I'm working: " + dna);
        StorageResource genes = findGenes(dna);
        Integer countNinePlus = 0;
        Integer countCGHigh = 0;
        Integer lengthOfLongestGene = 0;
        for(String s : genes.data()) {
                if(s.length()>60) {
                        System.out.println("gene longer than 60 characters: " + s);
                        countNinePlus++;
                }
                if(cgRatio(s)>.35) {
                        System.out.println("C/G > .35: " + s);
                        countCGHigh++;
                }
                if(s.length()> lengthOfLongestGene) {
                        lengthOfLongestGene = s.length();
                }
        }
        System.out.println("count of longer than 60 chars: " + countNinePlus);
        System.out.println("count of C/G > .35 genes: " + countCGHigh);
        System.out.println("longest gene is this long: " + lengthOfLongestGene);
        System.out.println("count of genes: " + genes.size());

}

public void testcgRatio(){
        String dna = "ccgggaaa";
        System.out.println("Ratio is (cc/ggg): " + cgRatio(dna));

}

public void testProcessGenes(){
        //String dna = "atgtaaatgataafftagatgccccccccccg111222333444tga1taa2taatgaatg1taa2taa3taa";
        processGenes();
}
}
