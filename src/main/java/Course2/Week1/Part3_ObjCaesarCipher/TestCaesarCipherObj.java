package Course2.Week1.Part3_ObjCaesarCipher;

import edu.duke.FileResource;

import static Course2.Week1.Part1_ImplCaesarCipher.TwoKeysDecrypt.maxIndex;

public class TestCaesarCipherObj {

    private String upperAlphabet;
    private String shiftedUpperAlphabet;
    private String lowerAlphabet;
    private String shiftedLowerAlphabet;



    public static int decryptShiftValue(int[] charCounts){
        int maxDex = maxIndex(charCounts);
        if (maxDex > 3) {
            return maxDex - 4;
        } else {
            return maxDex + 22;
        }
    }


    public static void testCaesarCipherObj(){
        CaesarCipherObj seesee = new CaesarCipherObj(15);
        //String encryptedString = seesee.encrypt("ABC How bout dat!");
        //FileResource fileR = new FileResource("ReferenceData/Course2Week1CaesarCipher/ProgrammingBreakingCaesarData/smallHamlet.txt");
        //System.out.println(fileR.asString());
        //String encryptedString = seesee.encrypt(fileR.asString());
        String encryptedString = seesee.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("encrypted: " + encryptedString);
        CaesarCipherObj plain = new CaesarCipherObj(0);
        int[] decryptArray = plain.oneKeyCharCount(encryptedString);
        int decryptShift = decryptShiftValue(decryptArray);
        CaesarCipherObj unseesee = new CaesarCipherObj(26-decryptShift);
        String decryptedString = unseesee.encrypt(encryptedString);
        System.out.println("decrypted: " + decryptedString);
    }


}
