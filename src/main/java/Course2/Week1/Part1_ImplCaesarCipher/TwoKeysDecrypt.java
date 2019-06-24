package Course2.Week1.Part1_ImplCaesarCipher;

import edu.duke.FileResource;

import java.lang.reflect.Array;

public class TwoKeysDecrypt {
    public static void doubleDecryption(String input){
        StringBuilder stringBuilder1 = new StringBuilder((input.length()+1)/2);
        StringBuilder stringBuilder2 = new StringBuilder(input.length()/2);
        for (int i = 0; i<input.length(); i=i+2){
            stringBuilder1.append(input.charAt(i));
        }
        for (int i = 1; i<input.length(); i = i+2){
            stringBuilder2.append(input.charAt(i));
        }
        int key1 = decrypt(stringBuilder1.toString());
        int key2 = decrypt(stringBuilder2.toString());
        System.out.println("key1: " + key1);
        System.out.println("key2: " + key2);
        System.out.println("Decrypted Message: " + CaesarCipher.encryptTwoKeys(input,26-key1,26-key2));
    }

    public static int decrypt(String inputSubstring){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < inputSubstring.length(); i++){
            char ch = Character.toLowerCase(inputSubstring.charAt(i));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex]++;
            }
        }
        int maxDex = maxIndex(counts);
        if (maxDex > 3) {
            return maxDex - 4;
        } else {
            return maxDex + 22;
        }
    }

    public static int maxIndex(int[] counts){
        if (Array.getLength(counts)==0){
            return 0;
        }
        int maxDex = 0;
        for (int i = 1; i<Array.getLength(counts); i++){
            if (counts[i] > counts[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }

    public static void testDoubleDecrypt(){
        //doubleDecryption("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        FileResource fileR = new FileResource("ReferenceData/Course2Week1CaesarCipher/mysteryTwoKeysQuiz.txt");
        doubleDecryption(fileR.asString());
        //doubleDecryption("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
    }

}
