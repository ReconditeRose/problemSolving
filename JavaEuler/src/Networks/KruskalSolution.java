package Networks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import supportObjects.Edge;

public class KruskalSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int weightRemoved(int[][] array){
		ArrayList<Edge> newList = new ArrayList<Edge>();
		HashSet<Integer> visited = new HashSet<Integer>();
		
		for(int i=0;i<array.length;i++)
			for(int j=i+1;j<array.length;j++)
				newList.add(new Edge(i,j,array[i][j]));
		Collections.sort(newList);
		int total = 0;
		for(Edge e: newList){
			if(!visited.contains(e.startEdge) && !visited.contains(e.endEdge)){
				visited.add(e.startEdge);
				visited.add(e.endEdge);
			}else{
				total+=e.weight;
				
			}
		}
		return total;
	}
	
}
