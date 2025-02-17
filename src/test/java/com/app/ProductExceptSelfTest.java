package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    ProductExceptSelf productExceptSelf = new ProductExceptSelf();

    @Test
    void testProductExceptSelf() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, productExceptSelf.productExceptSelf(nums));
    }

    @Test
    void testProductExceptSelf2() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {120, 60, 40, 30, 24};
        assertArrayEquals(expected, productExceptSelf.productExceptSelf(nums));
    }

    @Test
    void testProductExceptSelf3() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] expected = {720, 360, 240, 180, 144, 120};
        assertArrayEquals(expected, productExceptSelf.productExceptSelf(nums));
    }

    @Test
    void testProductExceptSelf4() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5040, 2520, 1680, 1260, 1008, 840, 720};
        assertArrayEquals(expected, productExceptSelf.productExceptSelf(nums));
    }

    @Test
    void testProductExceptSelf5() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {40320, 20160, 13440, 10080, 8064, 6720, 5760, 5040};
        assertArrayEquals(expected, productExceptSelf.productExceptSelf(nums));
    }

}