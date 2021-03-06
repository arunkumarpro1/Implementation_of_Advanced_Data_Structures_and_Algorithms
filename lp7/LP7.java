package cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.lp7;

import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph.Edge;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph.Vertex;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Timer;

public class LP7 {
	static int VERBOSE = 0;

	public static void main(String[] args) {
		if (args.length > 0) {
			VERBOSE = Integer.parseInt(args[0]);
		}
		java.util.Scanner in = new java.util.Scanner(System.in);
		Graph g = Graph.readDirectedGraph(in);
		Timer timer = new Timer();
		int s = in.nextInt();
		int t = in.nextInt();
		java.util.HashMap<Edge, Integer> capacity = new java.util.HashMap<>();
		int[] arr = new int[1 + g.edgeSize()];
		for (int i = 1; i <= g.edgeSize(); i++) {
			arr[i] = 1; // default capacity
		}
		while (in.hasNextInt()) {
			int i = in.nextInt();
			int cap = in.nextInt();
			arr[i] = cap;
		}
		for (Vertex u : g) {
			for (Edge e : u) {
				capacity.put(e, arr[e.getName()]);
			}
		}

		Flow f = new Flow(g, g.getVertex(s), g.getVertex(t), capacity);
		// f.setVerbose(VERBOSE);
		timer.start();
		int value = f.relabelToFront();
		System.out.println(timer.end());
		if (f.verify()) {
			System.out.println("Max flow is verified");
		} else {
			System.out.println("Algorithm is wrong. Verification failed.");
		}

		System.out.println(value);

		if (VERBOSE > 0) {
			for (Vertex u : g) {
				System.out.print(u + " : ");
				for (Edge e : u) {
					System.out.print(e + ":" + f.flow(e) + "/" + f.capacity(e) + " | ");
				}
				System.out.println();
			}
			System.out.println("Min cut: S = " + f.minCutS());
			System.out.println("Min cut: T = " + f.minCutT());
		}
	}
}
