package Course2.Week1.Part3_ObjCaesarCipher;

import static Course2.Week1.Part1_ImplCaesarCipher.TwoKeysDecrypt.maxIndex;

public class CaesarCipherObj2 {
    private String upperAlphabet;
    private String lowerAlphabet;
    private String shiftedUpperAlphabet0;
    private String shiftedLowerAlphabet0;
    private String shiftedUpperAlphabet1;
    private String shiftedLowerAlphabet1;
    private String unshiftedUpperAlphabet0;
    private String unshiftedLowerAlphabet0;
    private String unshiftedUpperAlphabet1;
    private String unshiftedLowerAlphabet1;

    public CaesarCipherObj2(int key1, int key2){ //constructor
        upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = upperAlphabet.toLowerCase();
        shiftedUpperAlphabet0 = upperAlphabet.substring(key1) + upperAlphabet.substring(0,key1);
        shiftedLowerAlphabet0 = shiftedUpperAlphabet0.toLowerCase();
        shiftedUpperAlphabet1 = upperAlphabet.substring(key2) + upperAlphabet.substring(0,key2);
        shiftedLowerAlphabet1 = shiftedUpperAlphabet1.toLowerCase();
        unshiftedUpperAlphabet0 = upperAlphabet.substring(26-key1) + upperAlphabet.substring(0,26-key1);
        unshiftedLowerAlphabet0 = unshiftedUpperAlphabet0.toLowerCase();
        unshiftedUpperAlphabet1 = upperAlphabet.substring(26-key2) + upperAlphabet.substring(0,26-key2);
        unshiftedLowerAlphabet1 = unshiftedUpperAlphabet1.toLowerCase();

        System.out.println("unshiftedLowerAlphabet0: " + unshiftedLowerAlphabet0);
        System.out.println("unshiftedLowerAlphabet1: " + unshiftedLowerAlphabet1);
        System.out.println("unshiftedUpperAlphabet0: " + unshiftedUpperAlphabet0);
        System.out.println("unshiftedUpperAlphabet1: " + unshiftedUpperAlphabet1);

    }

    public String encrypt2(String input){ //largely same as Course2.Week1.Part1_ImplCaesarCipher.CaesarCipher.encrypt
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i = i+2) {
            if (this.lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, this.shiftedLowerAlphabet0.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (this.upperAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i,this.shiftedUpperAlphabet0.charAt(this.upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        for (int i = 1; i < input.length(); i = i+2) {
            if (this.lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, this.shiftedLowerAlphabet1.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (this.upperAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i,this.shiftedUpperAlphabet1.charAt(this.upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        return encrypted.toString();
    }

    public String decrypt2(String input){ //largely same as Course2.Week1.Part1_ImplCaesarCipher.CaesarCipher.encrypt
        StringBuilder encrypted = new StringBuilder(input);
        //System.out.println("Input for decryption: " + input);
        //System.out.println("Length of input: " + input.length());

        for (int i = 0; i < input.length(); i = i+2) {
            if (this.lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, this.unshiftedLowerAlphabet0.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (this.upperAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i,this.unshiftedUpperAlphabet0.charAt(this.upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        for (int i = 1; i < input.length(); i = i+2) {
            if (this.lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, this.unshiftedLowerAlphabet1.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (this.upperAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i,this.unshiftedUpperAlphabet1.charAt(this.upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        return encrypted.toString();
    }
}
