package com.app.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathInACityTest {

    @Test
    void testShortestPath() {

        //[[1,0,10]]
        int n = 2;
        int[][] roads = {{1, 0, 10}};

        ShortestPathInACity shortestPathInACity = new ShortestPathInACity();
        int dist = shortestPathInACity.countPaths(n, roads);
        assertEquals(2, dist);
    }

}
