package easy;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
    //1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] {i, numMap.get(complement)};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    //9. Palindrome Number
    public boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        String contrary = new StringBuilder(number).reverse().toString();
        return contrary.equals(number);
    }

    //136. Single Number
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    //27. Remove Element
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //1480. Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(i == 0) {
                runningSum[i] = nums[i];
            } else {
                runningSum[i] = nums[i] + runningSum[i - 1];
            }
        }
        return runningSum;
    }

    //1672. Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            if(maximumWealth < wealth) {
                maximumWealth = wealth;
            }
        }
        return maximumWealth;
    }
}