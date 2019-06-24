package Course2.Week1.Part3_ObjCaesarCipher;

import edu.duke.FileResource;

public class TestCaesarCipherObj2 {

    public static void simpleTest(){
        CaesarCipherObj2 seesee2 = new CaesarCipherObj2(21,8);
        //FileResource fileR = new FileResource("ReferenceData/Course2Week1CaesarCipher/ProgrammingBreakingCaesarData/smallHamlet.txt");
        //System.out.println("Original: " + fileR.asString());
        //String encryptedMsg = seesee2.encrypt2(fileR.asString());
        String encryptedMsg = seesee2.encrypt2("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("Encrypted: " + encryptedMsg);
        String decryptedMsg = seesee2.decrypt2(encryptedMsg);
        System.out.println("Unencrypted = " + decryptedMsg);
    }

}
