package com.app.graph;

/**
 * Question: We are given n cities, some of which are connected to other cities given by an n x n matrix isConnected. The connectivity is transitive,
 * which means that if city an is directly connected with city b and city b is directly connected with city c, then city a is indirectly connected with city c.
 * A province is defined as a group of directly or indirectly connected cities with no other cities outside the group.
 * Our task is to return the total number of provinces.
 */
public class NumberOfProvinces {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visit = new boolean[n];
            int numberOfComponents = 0;

            for(int i = 0; i < n; i++) {
                if(!visit[i]) {
                    numberOfComponents++;

                    //dfs traversal
                    dfs(i, isConnected, visit);
                }
            }
            return numberOfComponents;

        }

    /**
     * The method dfs takes three parameters:
     * node: The current node being visited
     * isConnected: An n×n matrix where isConnected[i][j] = 1 means cities i and j are connected
     * visit: A boolean array tracking visited nodes
     * The DFS traversal:
     * Marks the current node as visited by setting visit[node] = true
     * Iterates through all possible connections (0 to n-1)
     * For each node i, checks two conditions:
     * isConnected[node][i] == 1: There exists a connection between current node and node i
     * !visit[i]: Node i hasn't been visited yet
     * If both conditions are true, recursively calls DFS on node i
     * @param node
     * @param isConnected
     * @param visit
     */
        public void dfs(int node, int[][] isConnected, boolean[] visit) {
            visit[node] = true;
            for(int i = 0; i < isConnected.length; i++) {
                if(isConnected[node][i] == 1 && !visit[i]) {
                    dfs(i, isConnected, visit);
                }
            }
        }
}
