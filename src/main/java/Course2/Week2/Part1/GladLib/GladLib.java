package Course2.Week2.Part1.GladLib;

import edu.duke.*;
import java.util.*;

public class GladLib {
	private ArrayList<String> adjectiveList;
	private ArrayList<String> nounList;
	private ArrayList<String> colorList;
	private ArrayList<String> countryList;
	private ArrayList<String> nameList;
	private ArrayList<String> animalList;
	private ArrayList<String> timeList;
	private ArrayList<String> verbList;
	private ArrayList<String> fruitList;
	private ArrayList<String> usedWords = new ArrayList<>();

	public int count;
	public int loopCount;
	String selectedWord;
	private Random myRandom;
	
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "/Users/david.lamp/Documents/Developer/Coursera Intro to Java/IntelliJProjects/CourseraJava/src/main/java/Course2/Week2/Part1/GladLib/data";


	public GladLib(){
		count = 0;
		//usedWords.clear();
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
	}
	
	public GladLib(String source){
		count = 0;
		//usedWords.clear();
		initializeFromSource(source);
		myRandom = new Random();
	}
	
	private void initializeFromSource(String source) {
		adjectiveList= readIt(source+"/adjective.txt");	
		nounList = readIt(source+"/noun.txt");
		colorList = readIt(source+"/color.txt");
		countryList = readIt(source+"/country.txt");
		nameList = readIt(source+"/name.txt");		
		animalList = readIt(source+"/animal.txt");
		timeList = readIt(source+"/timeframe.txt");
		verbList = readIt(source+"/verb.txt");
		fruitList = readIt(source+"/fruit.txt");
	}
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}
	
	private String getSubstitute(String label) {
		count++;
		if (label.equals("country")) {
			selectedWord = randomFrom(countryList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(countryList);
			}
			if (loopCount < 10){
				loopCount = 0;
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				loopCount = 0;
				return "**UNKNOWN**";
			}
		}
		if (label.equals("color")) {
			selectedWord = randomFrom(colorList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(colorList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("noun")) {
			selectedWord = randomFrom(nounList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(nounList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("name")) {
			selectedWord = randomFrom(nameList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(nameList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("adjective")) {
			selectedWord = randomFrom(adjectiveList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(adjectiveList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("animal")) {
			selectedWord = randomFrom(animalList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(animalList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("timeframe")) {
			selectedWord = randomFrom(timeList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(timeList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("number")) {
			selectedWord = ""+myRandom.nextInt(50)+5;
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = ""+myRandom.nextInt(50)+5;;
			}
			if (loopCount < 10){
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("verb")) {
			selectedWord = randomFrom(verbList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(verbList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("fruit")) {
			selectedWord = randomFrom(fruitList);
			while(usedWords.contains(selectedWord) && loopCount < 10){
				loopCount++;
				selectedWord = randomFrom(fruitList);
			}
			if (loopCount < 10){
				usedWords.add(selectedWord);
				return selectedWord;
			} else {
				return "**UNKNOWN**";
			}
		}
		if (label.equals("fruit")){
			return randomFrom(fruitList);
		}
		return "**UNKNOWN**";
	}
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
			return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		String sub = getSubstitute(w.substring(first+1,last));
		return prefix+sub+suffix;
	}
	
	private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source){
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	public void makeStory(){
	    System.out.println("\n");
		String story = fromTemplate(dataSourceDirectory + "/madtemplate2.txt");
		printOut(story, 60);
		System.out.println("\nReplaced this many words: ");
		printOut(Integer.toString(usedWords.size()),60);
	}
}
