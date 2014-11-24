package inst734.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class jsonReadMapper extends Mapper<Object, Text, Text, Text> {
	
	//private final static LongWritable one = new LongWritable();
	private static HashMap<String, Integer> myMap;
	private static Integer totalTweets = 0;
	public static Integer getTweets(){
		return totalTweets;
	}
	static{
		myMap = new HashMap<String, Integer>();
		myMap.put("!!",1); myMap.put("!!!!",1); myMap.put("!!!!!!",1); 
	}
	public void map(Object key, Text value, Context output) throws IOException, InterruptedException {
		try{
			if(value.equals(null) || value.getLength() == 0){
				System.out.println("No File to Read");
				return;
			}
			BufferedReader br = new BufferedReader(new StringReader(value.toString()));
			String line = "";
			String updId;
			
			while ((line = br.readLine()) != null) {
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = null;
				jsonObject = (JSONObject) jsonParser.parse(line);
				String text = (String) jsonObject.get("text");
				String lang = (String) jsonObject.get("lang");
				Long id = (Long) jsonObject.get("id");
				//converting Long to String
				updId = "";
				updId = updId+id;
				//end
				//Removing non-english tweets
				if(lang != "en"){
					continue;
				}
				totalTweets += 1;
				//end
				StringTokenizer itr = new StringTokenizer(text);
				while(itr.hasMoreTokens()){
					String token = itr.nextToken();
					//Removing stop words
					if (token.charAt(0) == '@' || token.charAt(0) == '!'){
						continue;
					}
					//end
					//Removing # from tokens
					if(token.charAt(0) == '#'){
						token = token.substring(1);
					}
					output.write(new Text(token.toLowerCase()), new Text(updId));
				}
			}
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
