package com.app.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyAndSellStockTest {

    @Test
    void maxProfit() {
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        assertEquals(5, buyAndSellStock.maxStock(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
