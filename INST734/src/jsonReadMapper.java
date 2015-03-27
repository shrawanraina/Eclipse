

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReadMapper extends Mapper<Object, Text, Text, Text> {

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
				//parsing each line in file
				JSONObject jsonObject = (JSONObject) jsonParser.parse(line);
				String text = (String) jsonObject.get("text");
				Long id = (Long) jsonObject.get("id");
				JSONObject userObject = (JSONObject) jsonObject.get("user");
				//parsing user as a json object
				String lang = (String) userObject.get("lang");
				//converting Long to String
				updId = "";
				updId = updId+id;
				//Using only non-english tweets
				if(lang.equals("en")){
					StringTokenizer itr = new StringTokenizer(text);
					while(itr.hasMoreTokens()){
						String token = itr.nextToken();
						token = token.toLowerCase();
						token = token.replaceAll("[^a-z@]", "");
						//Removing empty words
						if(token.isEmpty() || token == null || token == ""){
							continue;
						}
						//Removing user names
						else if (token.charAt(0) == '@'){
							continue;
						}
						//Removing words that are in set
						if(stopWords.stopSet.contains(token) ){
							continue;
						}
						output.write(new Text(token), new Text(updId));
					}
				}
			}
		}
		catch (ParseException e) {
			// TODO Auto-generated match block
			e.printStackTrace();
		}
	}
}