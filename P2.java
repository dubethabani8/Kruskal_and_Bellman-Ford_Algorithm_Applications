/*
 * Thabani Dube
 * Run using cmd as java P2 <intputFileName>
 * Example: java P2 p2_in1
 * Output will be informative on the console and you can match this with the provided test files
 * java P2 p2_in1 will produce same result as given in p2_out1
 * java P2 p2_in2 will produce same result as given in p2_out2
 * */


	import java.io.*; 
	import java.util.*; 

	// This class represents a directed graph using adjacency list 
	// representation 
	public class P2 
	{ 
		private int V; // No. of vertices 
		private LinkedList<Integer> adj[]; //Adjacency Lists 
		int count[];
		int val[];
		
		// Constructor
		@SuppressWarnings("unchecked")
		P2(int v) 
		{ 
			V = v; 
			adj = new LinkedList[v]; 
			for (int i=0; i<v; ++i) 
				adj[i] = new LinkedList<Integer>(); 
		} 

		// Function to add an edge into the graph 
		void addEdge(int v,int w) 
		{ 
			adj[v].add(w);
			adj[w].add(v);
		} 

		// BFS traversal from a given source s 
		void BFS(int s) 
		{ 
			// Mark all the vertices as not visited(By default 
			// set as false) 
			boolean visited[] = new boolean[V]; 
			val = new int[V]; //Contains shortest distance from s to each vertex
			count = new int[V]; //contains number of shortest paths from s to each vertex
 			// Create a queue for BFS 
			LinkedList<Integer> queue = new LinkedList<Integer>(); 

			// Mark the current node as visited and enqueue it 
			visited[s]=true; 
			val[s] = count[s] = 1; // initialize the 
			queue.add(s); 

			while (queue.size() != 0) 
			{ 
				// Dequeue a vertex from queue
				s = queue.poll();  

				// Get all adjacent vertices of the dequeued vertex s 
				// If a adjacent has not been visited, then mark it 
				// visited and enqueue it 
				Iterator<Integer> i = adj[s].listIterator(); 
				while (i.hasNext()) 
				{ 
					int n = i.next(); 
					if (!visited[n]) 
					{ 
						val[n] = val[s] +1;
						count[n] = count[s];
						visited[n] = true; 
						queue.add(n); 
					}
					else { //if n is visited
						if(val[n] == val[s] + 1)
							count[n] = count[n] + count[s];
						else if(val[n] > val[s] + 1) {
							val[n] = val[s] + 1;
							count[n] = count [s];
						}
					}
				} 
			} 
		} 


		public static void main(String args[]) throws Exception
		{
			
			P2 graph = null;
			String inputFile = args[0];
			//read file
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
	
			//Read input lines and process accordingly
			String line = null;
			boolean line1Done = false;
			boolean line2Done = false;
			
			int s = 0, t = 0;
			
			while((line = br.readLine()) != null) {
				String[] strArr = line.split(" "); //Array with separated strings of numbers from line
				//Covert to ints and store in int array
				int[] arr = new int[strArr.length];
				for(int i=0; i< strArr.length; i++) {
					arr[i] = Integer.parseInt(strArr[i]);
				}
				if(!line1Done) {
					line1Done = true;
					graph = new P2(arr[1]);
				}
				else if(!line2Done) {
					line2Done = true;
					s = arr[0];
					t = arr[1];
				}
				else {
					graph.addEdge(arr[0], arr[1]);
				}
			}
			
			graph.BFS(s);
			System.out.println("The number of shortest paths from " + s + " to " + t + " is " + graph.count[t]);
		
		} 
	} 
