package com.app.array;

import java.util.List;

public class MinIndexOfDominantElement {
    public static int minIndexOfDominantElement(List<Integer> nums) {

        int candidate = findDominantCandidate(nums);

        int dominantCount = countOccurances(nums, candidate);

        if(dominantCount <= nums.size() / 2) {
            return -1;
        }

        int leftCount = 0;
        int rightCount = dominantCount;

        for (int i = 0; i < nums.size() - 1; i++) {
            // Update counts for the current element
            if (nums.get(i) == candidate) {
                leftCount++;
                rightCount--;
            }

            // Check if the current split satisfies the dominant element condition
            if (leftCount > (i + 1) / 2 && rightCount > (nums.size() - i - 1) / 2) {
                return i;
            }
        }

        return -1;

    }

    private static int countOccurances(List<Integer> nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count;
    }

    private static int findDominantCandidate(List<Integer> nums) {
        int candidate = nums.getFirst();
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
