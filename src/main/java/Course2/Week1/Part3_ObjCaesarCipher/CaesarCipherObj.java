package Course2.Week1.Part3_ObjCaesarCipher;

import Course2.Week1.Part1_ImplCaesarCipher.CaesarCipher;
import edu.duke.FileResource;

import static Course2.Week1.Part1_ImplCaesarCipher.TwoKeysDecrypt.maxIndex;

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

    public CaesarCipherObj(String upperAlphabet, String shiftedUpperAlphabet, String lowerAlphabet, String shiftedLowerAlphabet) {//with all initial values
        this.upperAlphabet = upperAlphabet;
        this.shiftedUpperAlphabet = shiftedUpperAlphabet;
        this.lowerAlphabet = lowerAlphabet;
        this.shiftedLowerAlphabet = shiftedLowerAlphabet;
    }

    public String encrypt(String input){ //largely same as Course2.Week1.Part1_ImplCaesarCipher.CaesarCipher.encrypt
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (this.lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, this.shiftedLowerAlphabet.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (this.upperAlphabet.indexOf(input.charAt(i)) != -1) {
                //System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i,this.shiftedUpperAlphabet.charAt(this.upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        return encrypted.toString();
    }

    public int[] oneKeyCharCount(String input){ //non-static method for decrypting single cipher shift
        int[] counts = new int[26];
        for (int i = 0; i < input.length(); i++){
            char ch = Character.toLowerCase(input.charAt(i));
            int dex = this.lowerAlphabet.indexOf(ch);
            if (dex != -1){
                counts[dex]++;
            }
        }
        return counts;
    }


    public String getUpperAlphabet() {
        return upperAlphabet;
    }

    public void setUpperAlphabet(String upperAlphabet) {
        this.upperAlphabet = upperAlphabet;
    }

    public String getShiftedUpperAlphabet() {
        return shiftedUpperAlphabet;
    }

    public void setShiftedUpperAlphabet(String shiftedUpperAlphabet) {
        this.shiftedUpperAlphabet = shiftedUpperAlphabet;
    }

    public String getLowerAlphabet() {
        return lowerAlphabet;
    }

    public void setLowerAlphabet(String lowerAlphabet) {
        this.lowerAlphabet = lowerAlphabet;
    }

    public String getShiftedLowerAlphabet() {
        return shiftedLowerAlphabet;
    }

    public void setShiftedLowerAlphabet(String shiftedLowerAlphabet) {
        this.shiftedLowerAlphabet = shiftedLowerAlphabet;
    }
}
