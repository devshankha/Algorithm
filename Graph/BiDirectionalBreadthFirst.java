//This is a bidirectional breadth first search, code is inspired from --
//https://www.geeksforgeeks.org/bidirectional-search/
//was written in C++, but I modified it for Java

//first see how simple BFS is implemented


import java.util.Iterator;
import java.util.LinkedList;

public class BiDirectionalBreadthFirst {
	int noOfVertices;
	LinkedList<Integer> list[];

	BiDirectionalBreadthFirst(int v) {
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

	void BBFS(LinkedList<Integer> queue, boolean[] bool, int[] pred) {
		int s = queue.poll();
		Iterator<Integer> i = list[s].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!bool[n]) {
				bool[n] = true;
				pred[n] = s;
				queue.add(n);

			}
		}

	}

	int isInterSecting(boolean[] s, boolean[] d) {
		for (int i = 0; i < s.length; i++) {
			// if a vertex is visited by both front
			// and back BFS search return that node
			// else return -1
			if (s[i] == true && d[i] == true)
				return i;
		}
		return -1;

	}
	
	void printPath(int[] predS, int[] predD, int s, int d, int intersectNode) {
		//we have now found the intersecting node between s and d
		//so now just construct the path from s to d via the intersectNode
		LinkedList<Integer> path = new LinkedList<Integer>();
		LinkedList<Integer> path1 = new LinkedList<Integer>();
		path.add(intersectNode);
		int i = intersectNode;
		while (i != s) {
			path.add(predS[i]);
			i = predS[i];
		}
		System.out.println(path);
		for (int j= path.size()-1;j >=0;j--) 
			path1.add(path.get(j));
		System.out.println(path1);
		int l = intersectNode;
		    while(l != d)
		    {
		        path1.add(predD[l]);
		        l = predD[l];
		    }
		System.out.println(path1);
		
			
		

	}

	void BiDirectionalSearch(int src, int dst) {
		boolean visitedSource[] = new boolean[noOfVertices];
		boolean visitedDest[] = new boolean[noOfVertices];
		LinkedList<Integer> queueSource = new LinkedList<Integer>();
		LinkedList<Integer> queueDest = new LinkedList<Integer>();
		int predSource[] = new int[noOfVertices];
		int predDest[] = new int[noOfVertices];

		queueSource.add(src);
		visitedSource[src] = true;
		predSource[src] = -1;

		queueDest.add(dst);
		visitedDest[dst] = true;
		predDest[dst] = -1;

		while (!queueSource.isEmpty() && !queueDest.isEmpty()) {
			BBFS(queueSource, visitedSource, predSource);
			BBFS(queueDest, visitedDest, predDest);
			int intersectNode = isInterSecting(visitedSource, visitedDest);
			if (intersectNode != -1) {
				System.out.println("Intersecting node is " + intersectNode);
				printPath(predSource, predDest, src, dst, intersectNode);
				return;

			}

		}

	}
	
	public static void main(String[] args) {
		BiDirectionalBreadthFirst grh = new BiDirectionalBreadthFirst(10);
		grh.addEdge(0, 1);
		
		grh.addEdge(0, 2);
		grh.addEdge(1, 3);
		grh.addEdge(1, 4);
		grh.addEdge(4,5);
		grh.addEdge(2,6);
		grh.addEdge(6,7);
		grh.addEdge(0,8);
		grh.addEdge(8,9);
		
		
		

		// grh.printGraph();
		//grh.BFS(0, 3);
		grh.BiDirectionalSearch(0,9);
	}

}
