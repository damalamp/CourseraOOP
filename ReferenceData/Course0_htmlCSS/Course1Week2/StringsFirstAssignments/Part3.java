
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    Boolean twoOccurrences(String stringa, String stringb){
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex == -1){
            return false;        
        }
        int secondIndex = stringb.indexOf(stringa,firstIndex+1);
        if (secondIndex == -1){
            return false;        
        }
        return true;
    }
    
    String lastPart(String stringa, String stringb){
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex == -1){
            return stringb;        
        }else {
            return stringb.substring(firstIndex+stringa.length(), stringb.length()-1);
        }
    }
    
    public void testing(){
        /*
        String string1 = "one"; // good dube
        String string2 = "onetwone";
        System.out.println("Stirng1 string is: " + string1);
        System.out.println("Stirng2 string is (true): " + string2);
        Boolean isDupe = twoOccurrences(string1, string2);
        System.out.println("Found twice? " + isDupe); 
        
        string1 = "stinker"; // good dube
        string2 = "stinker-alinker-stinkergerstrinker";
        System.out.println("Stirng1 string is: " + string1);
        System.out.println("Stirng2 string is (true): " + string2);
        isDupe = twoOccurrences(string1, string2);
        System.out.println("Found twice? " + isDupe);
        
        string1 = "one"; // good dube
        string2 = "onetwsane";
        System.out.println("String1 string is: " + string1);
        System.out.println("String2 string is (false): " + string2);
        isDupe = twoOccurrences(string1, string2);
        System.out.println("Found twice? " + isDupe); 
        */
        
        String string1 = "one"; // good dube
        String string2 = "onetwone";
        System.out.println("Stirng1 string is: " + string1);
        System.out.println("Stirng2 string is: " + string2);
        String lastPart = lastPart(string1, string2);
        System.out.println("Last part of string: " + lastPart);
        
        string1 = "happy"; // good dube
        string2 = "I happy to be sad once, but no more, lol?";
        System.out.println("Stirng1 string is: " + string1);
        System.out.println("Stirng2 string is: " + string2);
        lastPart = lastPart(string1, string2);
        System.out.println("Last part of string: " + lastPart);
        
        string1 = "yes"; // good dube
        string2 = "no match found, return all";
        System.out.println("Stirng1 string is: " + string1);
        System.out.println("Stirng2 string is: " + string2);
        lastPart = lastPart(string1, string2);
        System.out.println("Last part of string: " + lastPart);        
    }
}
