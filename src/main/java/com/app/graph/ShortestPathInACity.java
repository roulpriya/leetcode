package com.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 */
public class ShortestPathInACity {

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adjacencyList = createAdjacencyList(n, roads);
        return dijkstra(n, adjacencyList);

    }

    private ArrayList<ArrayList<Pair>> createAdjacencyList(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //Populate the adjacency list with wighted edges
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adjacencyList.get(u).add(new Pair(time, v));
            adjacencyList.get(v).add(new Pair(time, u));
        }
        return adjacencyList;
    }


    //Function to find the shortest dist of all the vertices from source
    static int dijkstra(int vertices, ArrayList<ArrayList<Pair>> adj) {

        //min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.distance, y.distance));

        long[] dist = new long[vertices];
        Arrays.fill(dist, Long.MAX_VALUE);

        //Arrays to store number of ways to reach a node
        int[] ways = new int[vertices];
        ways[0] = 1;

        //Add source to priority queue
        pq.add(new Pair(0, 0));

        // The Priority queue always gives us the smallest distance node first
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            long distance = p.distance;

            if (distance > dist[node]) {
                continue;
            }

            // Traverse the neighbours of the current node
            for (Pair neighbour : adj.get(node)) {
                int nextNode = neighbour.node;
                long nextDistance = neighbour.distance;

                // If found shorter path, update the distance and number of ways

                if (nextDistance < dist[nextNode]) {
                    dist[nextNode] = nextDistance;
                    ways[nextNode] = ways[node];
                    pq.add(new Pair(nextDistance, nextNode));
                } else if (nextDistance == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % 1000000007;
                }
            }
        }
        return ways[vertices - 1];

    }

}

class Pair {
    long distance;
    int node;

    public Pair(long distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
