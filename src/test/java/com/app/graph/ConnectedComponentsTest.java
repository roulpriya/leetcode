package com.app.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectedComponentsTest {

    @Test
    void test() {

        int n = 5;
        //[[0,1],[1,2],[3,4]]

        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        ConnectedComponents connectedComponents = new ConnectedComponents();
        int count = connectedComponents.countComponents(n, edges);
        assertEquals(2, count);
    }

}
