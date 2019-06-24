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

public class Part2StringCounter {
  public Integer timesStringFound (String mainString, String searchString){
    Integer count = 0;
    Integer lastFoundIndex = mainString.indexOf(searchString);
    if (lastFoundIndex == -1){
      return count;
    }
    count++;
    while(true){
      lastFoundIndex = mainString.indexOf(searchString,lastFoundIndex+1);
      if (lastFoundIndex == -1){
        return count;
      }
      count++;
    }
  }

public void testCountingStrings() {
    String mainString = "aaaaa";
    String searchString = "a";
    System.out.println("count of 'a' in 'aaaaa' = " + timesStringFound(mainString, searchString));
    mainString = "aaaaabaabaa";
    searchString = "aaa";
    System.out.println("count of 'aaa' in 'aaaaabaabaa' = " + timesStringFound(mainString, searchString));
}
}
