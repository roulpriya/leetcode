package com.app.graph;

import java.util.ArrayList;

public class ConnectedComponents {

    public int countComponents(int n, int[][] edges) {

        // Initialize the graph
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int connectedComponents = 0;

        // Process each vertex
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // If not visited, this is a new connected component
                connectedComponents++;

                // Traverse the entire connected component using DFS
                dfs(adjacencyList, i, visited);
            }
        }

        return connectedComponents;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, neighbor, visited);
            }
        }
    }
}
