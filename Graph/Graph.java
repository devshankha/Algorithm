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
	
		void BFS(int s) 
    { 
		 // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[noOfVertices]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = list[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
      
        } 
		
		
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
