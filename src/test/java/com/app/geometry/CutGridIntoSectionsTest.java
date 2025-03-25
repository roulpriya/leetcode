package com.app.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutGridIntoSectionsTest {

    @Test
    void cutGridIntoSections() {
        //[[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
        int n = 5;
        int[][] rect = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};

        CutGridIntoSections cutGridIntoSections = new CutGridIntoSections();
        assertTrue(cutGridIntoSections.checkValidCuts(n, rect));

    }

}
