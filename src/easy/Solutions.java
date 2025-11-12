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

    //1281. Subtract the Product and Sum of Digits of an Integer
    public int subtractProductAndSum(int n) {
        int sumOfDigits = 0;
        int digitsMultiplication = 1;

        while (n != 0) {
            int lastDigit = n % 10;

            sumOfDigits += lastDigit;
            digitsMultiplication *= lastDigit;

            n /= 10;
        }

        return digitsMultiplication - sumOfDigits;
    }

    //1732. Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for(int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];

            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }

    //771. Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        for(int j = 0; j < jewels.length(); j++) {
            for(int i = 0; i < stones.length(); i++) {
                if(jewels.charAt(j) == stones.charAt(i)) {
                    count++;
                }
            }
        }

        return count;
    }

    //2114. Maximum Number of Words Found in Sentences
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (int i = 0; i < sentences.length; i++) {
            int count = sentences[i].split(" ").length;
            if (count > maxWords) {
                maxWords = count;
            }
        }

        return maxWords;
    }

    //1512. Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    //1684. Count the Number of Consistent Strings
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < words[i].length(); j++) {
                char letter = words[i].charAt(j);
                if (!allowed.contains("" + letter)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }

        return count;
    }


    //1365. Smaller Numbers Than Current
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smallerNumbers = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    count++;
                }
            }
            smallerNumbers[i] = count;
        }

        return smallerNumbers;
    }

    //1470. Shuffle the Array
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        for(int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }

        return result;
    }

    //1678. Goal Parser Interpretation
    public String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");

        return command;
    }

    //1678. Goal Parser Interpretation
    public String defangIPaddr(String address) {
        StringBuilder defanged = new StringBuilder();

        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                defanged.append("[.]");
            } else {
                defanged.append(address.charAt(i));
            }
        }

        return defanged.toString();
    }

    //1431. Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = candies[0];

        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    //1662. Check if Two String Arrays are Equivalent
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder concatenationWord1 = new StringBuilder();
        StringBuilder concatenationWord2 = new StringBuilder();

        for (String word : word1) {
            concatenationWord1.append(word);
        }
        for (String word : word2) {
            concatenationWord2.append(word);
        }

        return concatenationWord1.toString().equals(concatenationWord2.toString());
    }

    //1952. Three Divisors
    public boolean isThree(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count == 3;
    }

    //709. To Lower Case
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    //1502. Can Make Arithmetic Progression From Sequence
    public boolean canMakeArithmeticProgression(int[] arr) {
        int assistant = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    assistant = arr[i];
                    arr[i] = arr[j];
                    arr[j] = assistant;
                }
            }
        }

        int difference = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }

        return true;
    }
}