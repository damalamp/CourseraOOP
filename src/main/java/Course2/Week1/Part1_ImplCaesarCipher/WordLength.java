package Course2.Week1.Part1_ImplCaesarCipher;

import edu.duke.FileResource;

import java.util.Arrays;

public class WordLength {
    public static int[] countWordLengths(FileResource resource, int[] counts){
        int wordLength = 0;
        boolean lastWasLetter = true;
        int offset = 0;
        for(String word:resource.words()){
            System.out.println("word: " + word);
            if (Character.isLetter(word.charAt(word.length()-1))) {
                counts[word.length()]++;
            } else {
                counts[word.length()-1]++;
            }
            /*
            for(int i = 0; i<word.length(); i++){
                if((Character.isLetter(word.charAt(i)) && (wordLength < 31))){
                    wordLength++;
                    lastWasLetter = true;
                    System.out.println("entered first if");
                } else if (wordLength == 31){
                    counts[wordLength]++;
                    wordLength = 0;
                    System.out.println("entered first else");
                    break;
                } else if (!(Character.isLetter(word.charAt(i)) && lastWasLetter && i < word.length()-1)){
                    lastWasLetter = false;
                    wordLength++;
                    System.out.println("entered second else");
                } else {
                    System.out.println("entered last else");
                    if (!lastWasLetter){
                        offset = 1;
                    }
                    counts[wordLength-offset]++;
                    offset = 0;
                    wordLength = 0;
                    break;
                }
                */
        }
        return counts;
    }

    public static void testCountWordLengths(){
        FileResource fileR = new FileResource("ReferenceData/Course2Week1CesarCypher/PracticeBreakingCaesarData/lotsOfWords.txt");
        int[] counts = new int[31];
        System.out.println(Arrays.toString(countWordLengths(fileR, counts)));
    }
}

