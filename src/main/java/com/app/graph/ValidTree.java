package com.app.graph;

import java.util.*;

/**
 * A Graph is a valid tree
 *  a. If the graph has no cycle
 *  b. If the graph is connected
 */

/**
 * Example n = 5, edges = [[0,1], [0,2], [0,3], [1,4]]
 */

public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {
            return false;
        }

        //Representation of a graph using adjacency list

        // Create a List of lists to represent the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();

        // Initialize the adjecencyList with the empty array
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Go through the edge list and populate the adjacency list
        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // Adjacency List:
        // 0 -> 1, 2, 3
        // 1 -> 4
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            //check for neighbours of this node
            for (int neighbour: adjacencyList.get(node)) {
                if(parent.get(node) == neighbour) {
                    continue;
                }
                if(parent.containsKey(neighbour)) {
                    return false;
                }
                queue.add(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == n;
    }
}
