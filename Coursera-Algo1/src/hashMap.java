import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.ListMultimap;

public class hashMap {
	ArrayList<String> words = new ArrayList<String>();
	String[] word = {"hello","elloh","lolhe"};
	//static ListMultimap<String, String> directory = ArrayListMultimap.create();
	HashMap<String, ArrayList<String>> directory = new HashMap<String,ArrayList<String>>();
	public void createDictionary(){
		words.add("god");
		words.add("car");
		words.add("listen");
		words.add("dog");
		words.add("arc");
		words.add("silent");
		//System.out.println(words);
	}
	public void addHashMap(){
		for(int i=0;i<words.size();i++){
			char[] word = words.get(i).toCharArray(); 
			Arrays.sort(word);
			String sorted = new String(word);
			//directory.put(sorted,words.get(i));
			if(directory.get(sorted) == null){
				ArrayList<String> anagrams = new ArrayList<String>();
				anagrams.add(words.get(i));
				directory.put(sorted, anagrams);
			}
			else{
				 ArrayList<String> anagram = directory.get(sorted);
				 anagram.add(words.get(i));
				 directory.put(sorted, anagram);
			}
		}
		System.out.println(directory);
/*		System.out.println("Sorted: ");
		for(String s:words){
			
		}
		System.out.println(directory);
		System.out.println("while-iterator");
		while(words.iterator().hasNext()){
			System.out.println(words.iterator().next());
		}*/
	}
}
