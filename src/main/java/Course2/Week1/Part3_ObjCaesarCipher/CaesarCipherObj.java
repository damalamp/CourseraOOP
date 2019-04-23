package Course2.Week1.Part3_ObjCaesarCipher;

import Course2.Week1.Part1_ImplCaesarCipher.CaesarCipher;

public class CaesarCipherObj {
    private String upperAlphabet;
    private String shiftedUpperAlphabet;
    private String lowerAlphabet;
    private String shiftedLowerAlphabet;

    public CaesarCipherObj(int key){ //constructor
        upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = upperAlphabet.toLowerCase();
        shiftedUpperAlphabet = upperAlphabet.substring(key) + upperAlphabet.substring(0,key);
        shiftedLowerAlphabet = shiftedUpperAlphabet.toLowerCase();
    }

    public String encrypt(String input){ //largely same as Course2.Week1.Part1_ImplCaesarCipher.CaesarCipher.encrypt
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (this.lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, this.shiftedLowerAlphabet.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (this.upperAlphabet.indexOf(input.charAt(i)) != -1) {
                System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i,this.shiftedUpperAlphabet.charAt(this.upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        return encrypted.toString();
    }

    public static void testCaesarCipherObj(){
        CaesarCipherObj seesee = new CaesarCipherObj(2);
        String answer = seesee.encrypt("ABC How bout dat!");
        System.out.println("encrypted: " + answer);
    }
}