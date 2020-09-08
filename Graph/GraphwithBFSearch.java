/**
 * This is a graph implementation, along with this, there is a modified version of
 * BFS, which can be used to find the shortest path between two nodes
 * Code is inspired from ==https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
 * In addition to the usual BFS, maintain two arrays dist and pred, where
 *dist[i] stores the distance of vertex i from the source vertex and array 
 *pred[0, 1, ….., v-1] such that pred[i] represents the immediate predecessor of the vertex i 
 *in the breadth first search starting from the source.
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphwithBFSearch {
	int noOfVertices;
	LinkedList<Integer> list[];

	GraphwithBFSearch(int v) {
		noOfVertices = v;
		list = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			list[i] = new LinkedList<Integer>();
		}

	}

	void addEdge(int src, int dst) {
		list[src].add(dst);
		list[dst].add(src);

	}

	void BFS(int src, int dst) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[noOfVertices];

		int dist[] = new int[noOfVertices];

		int pred[] = new int[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {

			pred[i] = -1;
		}

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[src] = true;
		dist[src] = 0;
		queue.add(src);
		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			int s = queue.poll();
			 System.out.print(s+" ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = list[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					dist[n] = dist[s] + 1;
					pred[n] = s;
					queue.add(n);
					if (n == dst) {
						System.out.println(Arrays.toString(dist));
						System.out.println(Arrays.toString(pred));
						LinkedList<Integer> path = new LinkedList<Integer>();
						int crawl = dst;
						path.add(crawl);
						while (pred[crawl] != -1) {
							path.add(pred[crawl]);
							crawl = pred[crawl];
						}

						// Print distance
						System.out.println("Shortest path length is: " + dist[dst]);

						// Print path
						System.out.println("Path is ::");
						for (int j = path.size() - 1; j >= 0; j--) {
							System.out.print(path.get(j) + " ");
						}
						return;

					}
				}
			}

		}

	}

	void printGraph() {

		for (int i = 0; i < list.length; i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("head");
			for (int k = 0; k < list[i].size(); k++) {
				System.out.print(" -> " + list[i].get(k));

			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		GraphwithBFSearch grh = new GraphwithBFSearch(4);
		grh.addEdge(0, 1);
		
		grh.addEdge(0, 2);
		grh.addEdge(2, 3);
		grh.addEdge(0,3);
		

		// grh.printGraph();
		grh.BFS(0, 3);

	}

}
