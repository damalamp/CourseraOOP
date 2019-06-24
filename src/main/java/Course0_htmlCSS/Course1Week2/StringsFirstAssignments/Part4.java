import edu.duke.URLResource;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void allYoutubeLinks(){
        URLResource thingie = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String lineText : thingie.lines()){
            //System.out.println(lineText);
            lineText = lineText.toLowerCase();
            int indexOfYoutube = lineText.indexOf("youtube.com");
            if (indexOfYoutube != -1){
                int startOfLink = lineText.indexOf("http");
                int endOfLink = lineText.indexOf("\"",indexOfYoutube);
                //System.out.println("youtube link: ");
                System.out.println(lineText.substring(startOfLink, endOfLink));
            }
        }
    }
}
