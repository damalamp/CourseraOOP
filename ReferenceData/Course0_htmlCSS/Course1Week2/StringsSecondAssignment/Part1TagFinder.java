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

public class Part1TagFinder {
public Integer findEndCodon(String dna, Integer atgIndex, String endCodon){
        dna = dna.toLowerCase();
        Integer foundIndex = atgIndex + 3;
        while (true) {
                foundIndex = dna.indexOf(endCodon, foundIndex);
                if (foundIndex == -1) {
                        //System.out.println("entered -1 loop");
                        return dna.length()+1;
                }
                if ((foundIndex-atgIndex)%3 == 0) {
                        System.out.println("foundIndex = " + foundIndex);
                        System.out.println("atgIndex = " + atgIndex);
                        return foundIndex;
                }
                foundIndex++;
                //System.out.println("whiling again. ");
        }
}

public Integer minProteinEnd(String dna, Integer atgIndex){
        dna = dna.toLowerCase();
        Integer tagIndex = findEndCodon(dna, atgIndex, "tag");
        Integer taaIndex = findEndCodon(dna, atgIndex, "taa");
        Integer tgaIndex = findEndCodon(dna, atgIndex, "tga");

        Integer minEnd = Math.min(tagIndex,taaIndex);
        return Math.min(minEnd, tgaIndex);
}

public String findProtein(String dna, Integer atgIndex) {
        dna = dna.toLowerCase();
        int start = dna.indexOf("atg", atgIndex);
        if (start == -1) {
                System.out.println("no ATG found");
                return "";
        }

        Integer minEnd = minProteinEnd(dna, start);

        if (minEnd > dna.length()) {
                return "";
        }
        return dna.substring(start, minEnd+3);
}

public void printProteins(String dna){
        Integer startIndex = 0;
        while(true) {
                if (findProtein(dna,startIndex).length() == 0) {
                        System.out.println("breaking!");
                        break;
                }
                System.out.println("DNA: "+ findProtein(dna,startIndex));
                startIndex = minProteinEnd(dna,startIndex);
                System.out.println("Setting startIndex to: " + startIndex);
        }
}

public void testFindingEndCodon() {
        /*
           String dna = "atgtaa";
           System.out.println("index = " + findEndCodon(dna,1, "taa"));
           dna = "atgataa";
           System.out.println("index = " + findEndCodon(dna,1, "taa"));
           dna = "atg1taabbbcccdetaabbbcccdddtaa1taa1taa1taa";
           System.out.println("index = " + findEndCodon(dna,7, "taa"));
         */
        String dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println("Genes = ");
        printProteins(dna);

}
}
