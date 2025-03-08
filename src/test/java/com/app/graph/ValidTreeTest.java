package com.app.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidTreeTest {

    @Test
    void testValidTree() {
        ValidTree validTree = new ValidTree();
        assertTrue(validTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        assertFalse(validTree.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }

}