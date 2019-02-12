import java.util.LinkedList;

public class Graph {
	int noOfVertices;
	LinkedList<Integer> list[];

	Graph(int v) {
		noOfVertices = v;
		list = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			list[i] = new LinkedList<Integer>();
		}

	}
	void addEdge(int src,int dst) {
		list[src].add(dst);
		list[dst].add(src);
		
	}
	void printGraph( ) {
		
		for (int i=0; i < list.length;i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("head");
			for (int k=0; k < list[i].size();k++) {
				System.out.print(" -> "+list[i].get(k)); 
				
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		Graph grh = new Graph(4);
		grh.addEdge(0, 1);
		grh.addEdge(1,2);
		grh.addEdge(2,3);
		grh.addEdge(3,1);
		grh.printGraph();
		
	}

}
