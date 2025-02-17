package com.app;

public class ProductExceptSelf {

    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]

    public int[] productExceptSelf(int[] nums) {

        //1st Step: store the product and zero count
        int product = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                zeroCount++;
            }
        }

        //2nd Step: calculate the product except self
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                result[i] = product / nums[i];
            } else if (zeroCount == 1) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}
