package Course2.Week1.Part1_ImplCaesarCipher;

public class WordPlay {

    public static void testCourse2Week1Part1(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
    public static Boolean isVowel(char ch){
        String vowels =  "aeiouAEIOU";
        if(vowels.indexOf(ch) != -1){
            return true;
        } else {
            return false;
        }
    }

    public static String replaceVowels(String input, char ch){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++){
            if (isVowel(input.charAt(i))){
                sb.setCharAt(i, ch);
            }
        }
        return sb.toString();
    }

    public static String emphasize(String input, char ch){
        StringBuilder sb = new StringBuilder(input);
        String lower = input.toLowerCase();
        String upper = input.toUpperCase();
        for (int i = 0; i < input.length(); i++){
            if ((lower.charAt(i) == ch || upper.charAt(i) == ch)){
                if (i%2 == 1){
                    //odd
                    sb.setCharAt(i,'+');
                } else{
                    sb.setCharAt(i,'*');
                }
            }
        }
        return sb.toString();
    }
}
