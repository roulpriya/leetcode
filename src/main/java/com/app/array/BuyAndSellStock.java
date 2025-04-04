package com.app.array;

public class BuyAndSellStock {

    public int maxStock(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int max = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            int currentProfit = prices[i] - min;
            if(currentProfit > max) {
                max = currentProfit;
            }
        }
        return max;
    }
}
