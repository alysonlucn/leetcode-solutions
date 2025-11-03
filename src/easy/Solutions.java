package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    //1342. Number of Steps to Reduce a Number to Zero
    public int numberOfSteps(int num) {
        int count = 0;

        while(num != 0) {
            if(num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            count++;
        }

        return count;
    }


    //412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                strings.add("FizzBuzz");
            } else if (i % 5 == 0) {
                strings.add("Buzz");
            } else if (i % 3 == 0) {
                strings.add("Fizz");
            } else {
                strings.add(Integer.toString(i));
            }
        }

        return strings;
    }

    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    //1523. Count Odd Numbers in an Interval Range
    public int countOdds(int low, int high) {
        int count = 0;

        for(int i = low; i <= high; i ++) {
            if(i % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    //191. Number of 1 Bits
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0) {
            if(n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }

        return count;
    }
}