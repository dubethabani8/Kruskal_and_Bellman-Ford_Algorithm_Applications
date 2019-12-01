/*
 * Thabani Dube
 * Run using cmd as java P4 <intputFileName>
 * Example: java P4 p4_in1
 * Output will be informative on the console and you can match this with the provided test files
 * java P4 p4_in1 will produce same result as given in p4_out1
 * java P4 p4_in2 will produce same result as given in p4_out2
 * */

import java.io.*; 
import java.util.*; 

	// This class represents a directed graph using adjacency list 
	// representation 
	public class P4 
	{ 
		private int V; // No. of cities 
		private LinkedList<Integer> adj[]; //Adjacency Lists 
		int count[];
		int val[];
		int time[]; //array with times to get from capital to city i
		int times[][]; //array with distances from city i to city j 
		int T; //time for which capital gate will be open
		int E; //number of roads;
		
		// Constructor with number of cities V, number of roads E and time for which 
		//capital gate will be open T
		@SuppressWarnings("unchecked")
		P4(int V, int E, int T) 
		{
			this.V = V;
			this.E = E;
			this.T = T;
			
			adj = new LinkedList[V]; 
			for (int i=0; i<V; ++i) 
				adj[i] = new LinkedList<Integer>(); 
			
			times = new int[E][E];
			time = new int[V];
		} 

		// Function to add a road into the graph and the distance there
		void addRoad(int i,int j, int t) 
		{ 
			adj[i].add(j);
			adj[j].add(i);
			times[i][j] = t;
			times[j][i] = t;
		}
		
		

		// BFS traversal from a given city, in this case we will call this function to start from capital
		void BFS(int cityA) 
		{ 
			// Mark all the cities as not visited(By default 
			// set as false) 
			boolean visited[] = new boolean[V]; 
 			// Create a queue for BFS 
			LinkedList<Integer> queue = new LinkedList<Integer>(); 

			// Mark the current city as visited and enqueue it 
			visited[cityA]=true; 
			time[cityA] = 0; //Time to get to capital from capital is 0
			
			queue.add(cityA); 


			while (queue.size() != 0) 
			{ 
				// Dequeue a city cityA from queue
				cityA = queue.poll(); 

				// Get all adjacent cities of the dequeued cityA 
				// If a adjacent has not been visited, then mark it 
				// visited and enqueue it 
				Iterator<Integer> i = adj[cityA].listIterator(); 
				while (i.hasNext()) 
				{
					int cityB = i.next(); 
					if (!visited[cityB]) 
					{ 
						time[cityB] = time[cityA] + times[cityA][cityB]; //time from capital to n is updated
						visited[cityB] = true; 
						queue.add(cityB); 
					}
					else if(visited[cityB] && time[cityB] > time[cityA]+times[cityA][cityB]) { //if city is visited
						  //shorter distance found so replace
							time[cityB] = time[cityA] +  times[cityA][cityB];
					}
				} 
			} 
		} 
 
		public static void main(String args[]) throws Exception
		{ 
			P4 graph = null;
			String inputFile = args[0];
			//read file
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			
			//Read input lines and process accordingly
			String line;
			boolean firstLineDone = false;
			while((line = br.readLine()) != null) {
				String[] strArr = line.split(" "); //Array with separated strings of numbers from line
				//Covert to ints and store in int array
				int[] arr = new int[strArr.length];
				for(int i=0; i< strArr.length; i++) {
					arr[i] = Integer.parseInt(strArr[i]);
				}
				if(!firstLineDone) {
					firstLineDone = true;
					graph = new P4(arr[0], arr[1], arr[2]); //Create the graph with variables
				}
				else { //add roads and distances
					graph.addRoad(arr[0], arr[1], arr[2]); //add road
				}
			}
			
			//COMPLETED CREATING THE MAP WITH ROADS, CITIES AND DISTANCES
			//NOW run BSF algorithm that updates time to get from each city to capital
	
			int capital = 0;
			graph.BFS(capital);
			//Check for competitors from each city that can make it to capital
			int count = 0;
			for(int i=0; i < graph.time.length; i++) {
				System.out.println("Shortest possible time from capital to city number " + i + " is " + graph.time[i]);
				
				if(graph.time[i] <= graph.T) {
					if(i!=0 && graph.time[i] == 0) continue; 
					count++;
				}
			}
			System.out.println();
			System.out.println("Gate is open for time " + graph.T + ", so the number that will make it is: " + count);
		} 
	} 

