package supportObjects;

public class Edge implements Comparable<Edge> {
	
	public int startEdge,endEdge,weight;

	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}


	public Edge(int s,int e,int w){
		startEdge = s;
		endEdge = e;
		weight = w;
	}
	
}
