package Course2.Week2.Part1;

import edu.duke.FileResource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique(){
        myFreqs.clear();
        myWords.clear();
        FileResource fileR = new FileResource("ReferenceData/Course2Week1CaesarCipher/CommonWordsData/caesar.txt");
        //FileResource fileR = new FileResource("ReferenceData/Course2Week1CaesarCipher/ProgrammingBreakingCaesarData/DavidsTestWords");
        for (String word : fileR.words()){
            String realWord = word.replaceAll("[!-?.\"]+$","").toLowerCase();
            realWord = realWord.replaceAll("^[!-?.\"]+","");
            System.out.println("original word: " + word);
            System.out.println("real word: " + realWord);
            int dex = myWords.indexOf(realWord);
            if (dex != -1){
                System.out.println("repeat word " + realWord);
                int value = myFreqs.get(dex);

                myFreqs.set(dex, value+1);
            } else {
                myWords.add(realWord.toLowerCase());
                myFreqs.add(1);
            }
        }
        for (int i = 0; i < myWords.size(); i++){
            System.out.println("Word: " + myWords.get(i) + " appears " + myFreqs.get(i) + " times");
        }
        for (String wordy : myWords) {

        }
    }

    public int findIndexOfMax(ArrayList<Integer> myFreqs){
        Iterator i = myFreqs.iterator();
        int max = 0;
        while (i.hasNext()){
            if (i.max =
        }
    }

    public static void tester(){
        WordFrequencies freqerz = new WordFrequencies();
        freqerz.findUnique();
    }

}
