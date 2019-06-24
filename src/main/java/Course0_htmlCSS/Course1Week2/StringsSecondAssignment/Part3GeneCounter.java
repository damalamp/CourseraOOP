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

public class Part3GeneCounter {
public Integer findEndCodon(String dna, Integer atgIndex, String endCodon){
        Integer foundIndex = atgIndex + 3;
        while (true) {
                foundIndex = dna.indexOf(endCodon, foundIndex);
                if (foundIndex == -1) {
                        //System.out.println("entered -1 loop");
                        return dna.length()+1;
                }
                if ((foundIndex-atgIndex)%3 == 0) {
                        return foundIndex;
                }
                foundIndex++;
        }
}

public Integer minGeneEnd(String dna, Integer atgIndex){
        Integer tagIndex = findEndCodon(dna, atgIndex, "tag");
        Integer taaIndex = findEndCodon(dna, atgIndex, "taa");
        Integer tgaIndex = findEndCodon(dna, atgIndex, "tga");

        Integer minEnd = Math.min(tagIndex,taaIndex);
        return Math.min(minEnd, tgaIndex);
}

public Integer findNextGeneEnd(String dna, Integer atgIndex) {
        int start = dna.indexOf("atg", atgIndex);
        if (start == -1) {
                return start;
        }
        Integer minEnd = minGeneEnd(dna, atgIndex);

        if (minEnd > dna.length()) {
          return start;
        }
        return minEnd;
}

public Integer countGenes(String dna){
        Integer startIndex = 0;
        Integer count = 0;
        Integer lastEnd = findNextGeneEnd(dna,0);
        if (lastEnd == -1) {
                return 0;
        }
        count++;
        while(true) {
                if (findNextGeneEnd(dna,lastEnd) == -1) {
                  break;
                }
                lastEnd = findNextGeneEnd(dna,lastEnd);
                count++;
        }
        return count;
}

public void testGeneCounter() {
    /*    
    String dna = "atgtaa";
    System.out.println("index = " + findEndCodon(dna,1, "taa"));
    dna = "atgataa";
    System.out.println("index = " + findEndCodon(dna,1, "taa"));
    dna = "atg1taabbbcccdetaabbbcccdddtaa1taa1taa1taa";
    System.out.println("index = " + findEndCodon(dna,7, "taa"));
    */
    String dna = "atg111FIRST1222333taaatgSECONDtgaatg2223331taa2taa3THIRD1taaENDSTUFF";
    System.out.println("Count of Genes = " + countGenes(dna));
       
}
}
