

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null || src == null || dest == null) return -1;
		if (!graph.containsElement(src) && graph.containsElement(dest)) return -1;

		return new BreadthFirstSearch(graph).getDistance(graph.getNode(src), dest);
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null ||
				!graph.containsElement(src) || 
				distance < 1) {
			return null;
		}
		
		Set<String> result = new HashSet<String>();
		
		if (graph.getNumNodes() == 1) {
			return result;
		}
		
		
		Map<Node, Integer> distances = new HashMap<>();				
		Queue<Node> toExplore = new LinkedList<>();
		Set<Node> marked = new HashSet<>();
		
		marked.add(graph.getNode(src));		
		toExplore.add(graph.getNode(src));
		distances.put(graph.getNode(src), 0);

		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					distances.put(neighbor, distances.get(current) + 1);
					if (distances.get(neighbor) <= distance) { 
						result.add(neighbor.getElement());
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
				
		return result;
		
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		if (g == null || values == null || values.isEmpty()) {
			return false;
		}
		
		String src = values.get(0);
		Set<String> marked = new HashSet<>();
		marked.add(src);
		
		if (!src.equals(values.get(values.size() - 1))) 
			return false;
		
		for (int i = 1; i < values.size(); i++) {
			if (!g.containsElement(values.get(i)))  
				return false;
			
			if (marked.contains(values.get(i)) 
					&& i != (values.size() - 1))  
				return false;
			
			if (!g.getNodeNeighbors(g.getNode(values.get(i-1))).contains(g.getNode(values.get(i)))) { 
				return false;
			}
			marked.add(values.get(i));
		}
				
		
		return marked.size() == g.getNumNodes(); 
	}
	
}
