package inst734.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class jsonReadMapper extends Mapper<Object, Text, Text, Text> {
	
	//private final static LongWritable one = new LongWritable();
	
	public void map(Object key, Text value, Context output) throws IOException, InterruptedException {
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
			try {
				jsonObject = (JSONObject) jsonParser.parse(line);
				String text = (String) jsonObject.get("text");
				Long id = (Long) jsonObject.get("id");
				updId = "";
				updId = updId+id; 
				//one.set(id);
				StringTokenizer itr = new StringTokenizer(text);
				while(itr.hasMoreTokens()){
					String token = itr.nextToken();
					output.write(new Text(token.toLowerCase()), new Text(updId));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
