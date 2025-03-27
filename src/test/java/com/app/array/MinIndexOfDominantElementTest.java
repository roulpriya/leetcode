package com.app.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinIndexOfDominantElementTest {

    @Test
    void TestMinIndexOfDominantElement() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(2);

        assertEquals(2, MinIndexOfDominantElement.minIndexOfDominantElement(nums));
    }

}
