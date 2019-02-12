package PredicateExample;
//THis is a graph represented as
//adjaceny matrix
class Vertex {
	char label;
	boolean isVisited;
	Vertex(char ch) {
		label = ch;
		isVisited = false;
		
	}
}

public class GraphwithAM {
	private  final int MAX_VERTICES = 10;
	private Vertex[] vertices;
	int[][] adjMatrix;
	private int noOfVertices;

	GraphwithAM() {
		vertices = new Vertex[MAX_VERTICES];
		noOfVertices = 0;
		for (int i = 0; i < MAX_VERTICES; i++)
			for (int j = 0; j < MAX_VERTICES; j++) {
				adjMatrix[i][j] = 0;
			}
	}
	public void addVertex(char label) {
		vertices[noOfVertices++] =new Vertex(label);
		
	}
	public void addEdge(int start,int end) {
		adjMatrix[start][end] =1;
		adjMatrix[end][start] =1;
		
		
	}

}
