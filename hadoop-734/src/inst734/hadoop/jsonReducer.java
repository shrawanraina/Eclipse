package inst734.hadoop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import inst734.hadoop.jsonReadMapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class jsonReducer extends Reducer<Text, Text, Text, Text> {
	private static HashMap<String, Map<String,Integer>> parentMap = new HashMap<String, Map<String,Integer>>( );
	private static Integer totalDoc;
	private static Integer totalTweets = jsonReadMapper.getTweets();
	
	public void reduce(Text key, Iterable<Text> values, Context output) throws IOException, InterruptedException {
		try{
			for(Text v : values){
				if(parentMap.get(key.toString()) == null){
					HashMap<String, Integer> documentMap = new HashMap<String, Integer>();
					documentMap.put(v.toString(), 1);
					parentMap.put(key.toString(), documentMap);
				}
				else{
					Map<String, Integer> documentMap = parentMap.get(key.toString());
					if(documentMap.get(v.toString()) == null){
						documentMap.put(v.toString(), 1);
					}
					else{
						int count = (int) documentMap.get(v.toString());
						documentMap.put(v.toString(), ++count);
					}
				}
			}
			Iterator<Map.Entry<String, Map<String, Integer>>> iteratorWrd = parentMap.entrySet().iterator();
			while(iteratorWrd.hasNext()){
				Map.Entry<String, Map<String, Integer>> entryWrd = iteratorWrd.next();
				String word = entryWrd.getKey();
				Map<String, Integer> wrdMap =  entryWrd.getValue();
				totalDoc = wrdMap.size();
				Iterator<Map.Entry<String, Integer>> iteratorDoc = wrdMap.entrySet().iterator();
				String finalDoc = "";
				boolean first = true;
				while(iteratorDoc.hasNext()){
					Map.Entry<String, Integer> entryDoc = iteratorDoc.next();
					String doc = entryDoc.getKey();
					Integer docCount = entryDoc.getValue();
					if(!first){
						finalDoc = finalDoc + ", ";
					}
					first = false;
					finalDoc = finalDoc + doc + "(" + docCount + ")";
					iteratorDoc.remove();
				}
				output.write(new Text(word + "\t" + totalTweets.toString() + "\t" + "(" + totalDoc.toString() + ")"), new Text(finalDoc));
				iteratorWrd.remove();
			}
		}
		catch(Exception e){
			throw e;
		}
    }
}
