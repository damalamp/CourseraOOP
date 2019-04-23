package Course2.Week1.Part1_ImplCaesarCipher;

public class CaesarCipher {

    public static void testCaesarCipher() {
        //FileResource fileResource = new FileResource();
        //String message = fileResource.asString();
        //encrypt(message, 1);
        //encryptTwoKeys("First Legion!", 23, 17);
        encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 24, 6);
    }

    public static void encrypt(String input, int key) {
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String lowerShifted = lowerAlphabet.substring(key) + lowerAlphabet.substring(0, key);
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String upperShifted = upperAlphabet.substring(key) + upperAlphabet.substring(0, key);
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                System.out.println("entered lower for, i = " + i);
                encrypted.setCharAt(i, lowerShifted.charAt(lowerAlphabet.indexOf(input.charAt(i))));
            } else if (upperAlphabet.indexOf(input.charAt(i)) != -1) {
                System.out.println("entered upper for, i = " + i);
                encrypted.setCharAt(i, upperShifted.charAt(upperAlphabet.indexOf(input.charAt(i))));
            }
        }
        System.out.println("Solution = " + encrypted);
    }

    public static String encryptTwoKeys(String input, int key1, int key2) {
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("key1 in encryptTwoKeys: " + key1);
        System.out.println("key2 in encryptTwoKeys: " + key2);
        String lowerShifted1 = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0, key1);
        String lowerShifted2 = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0, key2);
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String upperShifted1 = upperAlphabet.substring(key1) + upperAlphabet.substring(0, key1);
        String upperShifted2 = upperAlphabet.substring(key2) + upperAlphabet.substring(0, key2);

        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                //even index, odd char (use key1)
                //System.out.println("using key1 and i = " + i);
                if (lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                    encrypted.setCharAt(i, lowerShifted1.charAt(lowerAlphabet.indexOf(input.charAt(i))));
                } else if (upperAlphabet.indexOf(input.charAt(i)) != -1) {
                    encrypted.setCharAt(i, upperShifted1.charAt(upperAlphabet.indexOf(input.charAt(i))));
                }
            } else {
                //System.out.println("using key2 and i = " + i);
                //odd index, even char (use key1)
                if (lowerAlphabet.indexOf(input.charAt(i)) != -1) {
                    encrypted.setCharAt(i, lowerShifted2.charAt(lowerAlphabet.indexOf(input.charAt(i))));
                } else if (upperAlphabet.indexOf(input.charAt(i)) != -1) {
                    encrypted.setCharAt(i, upperShifted2.charAt(upperAlphabet.indexOf(input.charAt(i))));
                }
            }
        }
        //System.out.println("Solution = " + encrypted);
        return encrypted.toString();
    }

}
