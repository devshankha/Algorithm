class Stack  {
	private int top = -1;
	private int[] arr;
	public Stack(int size){
		arr = new int[size];
	}
	public void push(int x){
		if (top == (arr.length-1))
			return;
		arr[++top]= x;
		//System.out.println(top);
	}
	public int  pop(){
		if (top == -1)
			return -1;
		return arr[top--];
	}
	public boolean isEmpty(){
		return top == -1;
	}
	
	public int peek() {
		
		return arr[top];
	}
}

class Vertex {
	Character ch;
	boolean isVisited;	
	public Vertex(Character c){
		ch = c;	
		isVisited = false;
	}
	public String toString(){
		return ch.toString();
	}
}
public class Graph {
	private final int MAX_VERTICES=20;
	private int adjMat[][];
	private Vertex vertexList[];
	//current number of vertices
	private int nVerts;
	Stack stack;
	public Graph(){
		vertexList = new Vertex[MAX_VERTICES];
		adjMat = new int[MAX_VERTICES][MAX_VERTICES];
		for (int i=0; i < MAX_VERTICES;i++)
			for (int j=0; j < MAX_VERTICES;j++){
				adjMat[i][j]=0;
			}
		nVerts = 0;
		stack = new Stack(20);
	}
	public void addEdge(int start,int end){
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	public void addVertex(char c){
		vertexList[nVerts++]= new Vertex(c);
		
	}
	public void displayVertex(int v){
		System.out.println(vertexList[v].toString());
		
	}
	
	public void dfs() {
		vertexList[0].isVisited = true;
		displayVertex(0);
		stack.push(0);
		System.out.println("Importnt");
		while (!stack.isEmpty()){
			//System.out.println("Is it coming here");
			int v = getUnvisitedVertex(stack.peek());
			if (v == -1)
				stack.pop();
			else {
				vertexList[v].isVisited = true;
				displayVertex(v);
				stack.push(v);				
			}
					
		}
		//stack is empty, reset the flags
		for (int i=0; i < nVerts;i++ )
			vertexList[i].isVisited = false;
	}
	public int getUnvisitedVertex(int n){
		for (int i=0; i < nVerts; i++){
			if (adjMat[n][i] == 1 && vertexList[i].isVisited == false )
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(0,3);
		graph.addEdge(3,4);
		graph.addEdge(0, 5);
		System.out.println("Visits");
		graph.dfs();
		
	}

}
