class Solution {
    
    /*
        Short Notes:
        - Use a HashSet for fast lookup of numbers.
        - Only start counting a consecutive sequence from numbers that don't have a predecessor (val - 1 not in set).
        - Count consecutive integers by checking if val + 1 exists.
        - Keep track of the longest consecutive sequence length found.

        Time Complexity: O(n), since each number is processed at most twice.
        Space Complexity: O(n), for storing the numbers in the set.
    */

    public int longestConsecutive(int[] nums) {
        // Return 0 for empty input
        if (nums.length == 0) return 0;

        // Store all unique numbers in a HashSet for O(1) lookups
        Set<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            mySet.add(num);
        }

        int maxLen = 1; // To keep track of the max consecutive sequence length

        // Iterate through each unique number
        for (int val : mySet) {
            // Check if 'val' is the start of a sequence
            // If 'val - 1' doesn't exist, 'val' could be sequence start
            if (!mySet.contains(val - 1)) {
                int currLen = 1;
                // Count consecutive numbers starting from 'val'
                while (mySet.contains(val + 1)) {
                    currLen++;
                    val++;
                }
                // Update max length if current sequence is longer
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}