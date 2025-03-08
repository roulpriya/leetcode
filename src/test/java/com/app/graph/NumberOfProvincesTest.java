package com.app.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NumberOfProvincesTest {

    NumberOfProvinces numberOfProvinces = new NumberOfProvinces();

    @Test
    void testNumberOfProvinces() {
        assertEquals(2, numberOfProvinces.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }


}