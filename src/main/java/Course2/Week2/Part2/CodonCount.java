package Course2.Week2.Part2;

import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer> codonCount;

    public CodonCount(){
        codonCount = new HashMap<String, Integer>();
    }

    public static CodonCount buildCodonMap(int start, String dna){
        if (start > 2){
            System.out.println("Nah, bad input!");
            return null;
        }
        CodonCount mappy = new CodonCount();
        for (int i = start; i < dna.length()-2; i=i+3){
            String subby = dna.substring(i,i+3);
            if (mappy.codonCount.keySet().contains(subby)){
                mappy.codonCount.put(subby, mappy.codonCount.get(subby)+1);
            }
            else {
                mappy.codonCount.put(subby, 1);
            }
        }
        for (String key : mappy.codonCount.keySet()){
            System.out.println(key + " was found: " + mappy.codonCount.get(key)+ " times");
        }
        return mappy;
    }

    public String getMostCommonCodon(){
        int max = 0;
        String bestKey = "";
        for (String key : this.codonCount.keySet()){
            if (this.codonCount.get(key) > max){
                max = this.codonCount.get(key);
                bestKey = key;
            }
        }
        return bestKey;
    }

    public void printCodonCounts(int start, int end){
        for (String key : this.codonCount.keySet()){
            int count = this.codonCount.get(key);
            if ((count >= start) && (count <= end)){
                System.out.println("Codon " + key + " was found " + count + " times");
            }
            }

        }

    public static void testBuildCodonMap(){
        FileResource resource = new FileResource("ReferenceData/Course2Week2MadLibs/ProgrammingImprovingGladLibsData/smalldna.txt");
        CodonCount mappy = buildCodonMap(2, resource.asString().trim().toUpperCase());
        System.out.println("Most common codon: " + mappy.getMostCommonCodon());
        mappy.printCodonCounts(1,5);
    }

}
