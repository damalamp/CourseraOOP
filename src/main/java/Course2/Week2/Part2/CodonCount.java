package Course2.Week2.Part2;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer> codonCount;

    public CodonCount(){
        codonCount = new HashMap<String, Integer>();
    }

    public static void buildCodonMap(int start, String dna){
        if (start > 2){
            System.out.println("Nah, bad input!");
            return;
        }
        CodonCount mappy = new CodonCount();
        for (int i = start; i < dna.length()-3; i=i+3){
            String subby = dna.substring(i,i+2);
            mappy.codonCount.put(subby, mappy.codonCount.get(subby)+1);
        }
        for (String key : mappy.codonCount.keySet()){
            System.out.println(key + " was found: " + mappy.codonCount.get(key)+ " times");
        }
    }

    public static void testBuildCodonMap(){
        buildCodonMap(0, "AAABBBCCC");
    }

}
