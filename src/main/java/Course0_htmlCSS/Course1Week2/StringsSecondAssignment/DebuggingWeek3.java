
/**
 * Write a description of DebuggingWeek3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DebuggingWeek3 {
    /*
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1) {
            break;
        }
        System.out.println("length of input = " + input.length());
        System.out.println("index = " + index);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+4);
    }
}
   public void test() {
     //findAbc("abcd");
     //findAbc("abcdabc"); 
     findAbc("aaaaabc");
}
*/

public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           //System.out.println("index = " + index);
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);           
           //System.out.println("post update index = " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }
}
