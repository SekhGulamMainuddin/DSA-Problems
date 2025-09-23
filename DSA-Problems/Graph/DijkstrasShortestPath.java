
// https://www.codingninjas.com/codestudio/problems/dijkstra-s-shortest-path_920469?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

import java.util.*;

public class DijkstrasShortestPath {
	
	public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
		// Step 1: Create adjacency list
		HashMap<Integer, List<Pair>> adj = new HashMap<>();

		for (ArrayList<Integer> edge : vec) {
			int u = edge.get(0);
			int v = edge.get(1);
			int w = edge.get(2);

			adj.putIfAbsent(u, new ArrayList<>());
			adj.putIfAbsent(v, new ArrayList<>());

			adj.get(u).add(new Pair(v, w));
			adj.get(v).add(new Pair(u, w));
		}

		// Step 2: Initialize distances
		int[] dist = new int[vertices];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;

		// Step 3: Priority Queue to simulate set
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(source, 0));

		while (!pq.isEmpty()) {
			Pair current = pq.poll();
			int u = current.node;
			int d = current.dist;

			if (!adj.containsKey(u)) continue;

			for (Pair neighbor : adj.get(u)) {
				int v = neighbor.node;
				int weight = neighbor.dist;

				if (d + weight < dist[v]) {
					dist[v] = d + weight;
					pq.offer(new Pair(v, dist[v]));
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int d : dist) result.add(d);
		return result;
	}
}

class Pair implements Comparable<Pair> {
	int node;
	int dist;

	Pair(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(Pair other) {
		return this.dist - other.dist;
	}
}
