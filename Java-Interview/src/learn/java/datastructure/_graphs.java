package learn.java.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class graph {
    private String vertex;
    private int edge;
    graph(String vertex, int edge){
    	this.vertex = vertex;
    	this.edge = edge;
    }
    
    public String getVertex(){
    	return vertex;
    }
    
    public int getEdge(){
    	return edge;
    }
}

public class _graphs {
	static Map<String, ArrayList<graph>> myGraph = new HashMap<String, ArrayList<graph>>();
	static Map<String, Integer> distMap = new HashMap<String, Integer>();
	
	public static void _addVertex(String name){
		if(myGraph.containsKey(name)){
			System.out.println("Vertex already exists");
		}
		else{
			myGraph.put(name, new ArrayList<graph>());
		}
	}
	
	public static void _addEdge(String vertex, String edge, int weight){
		final graph adjEdge = new graph(edge, weight);
		if(myGraph.containsKey(vertex)){
			ArrayList<graph> adjList = myGraph.get(vertex);
			adjList.add(adjEdge);
			myGraph.put(vertex, adjList);
		}
		else{
			myGraph.put(vertex, new ArrayList<graph>(){{add(adjEdge);}});
		}
	}
	
	//Djikstra
	public static int _minimumDist(String start){
		for(String key : myGraph.keySet()){
			if(key == start){
				distMap.put(key, 0);
			}
			else{
				distMap.put(key, Integer.MAX_VALUE);
			}
		}
		PriorityQueue<String> visited = new PriorityQueue<String>();
		visited.add(start);
		while(!visited.isEmpty()){
			String current = visited.poll();
			System.out.println("Current: "+current);
			ArrayList<graph> adjList = myGraph.get(current);
			for(graph node : adjList){
				String next = node.getVertex();
				if((distMap.get(current) + node.getEdge()) < (distMap.get(next))){
					visited.remove(next);
					System.out.println("Node: "+next+", Weight: "+(node.getEdge()+distMap.get(current)));
					distMap.put(next, node.getEdge() + distMap.get(current));
					visited.add(next);
				}
			}
		}
		return 0;
		
	}
	
}
