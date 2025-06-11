/**
 * Problem: Given a sorted array `numbers`, return the indices (1-based) of the two numbers that add up to `target`.
 * 
 * Approach:
 * - Use a HashMap to store each number and its corresponding index as we iterate through the array.
 * - For each number, compute the difference between the target and the current number.
 * - If the difference exists in the map, return the pair of indices.
 * - The indices are returned as 1-based (i.e., add 1 to each zero-based index).
 * 
 * Time Complexity: O(n)
 * - Single pass through the array with O(1) average time operations for map lookups and insertions.
 * 
 * Space Complexity: O(n)
 * - In the worst case, all elements are stored in the map.
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Map to store the number and its index
        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i]; // Calculate the required complement

            // If complement is found in map, return the pair of indices (1-based)
            if (valueIndexMap.containsKey(diff)) {
                return new int[]{valueIndexMap.get(diff) + 1, i + 1};
            }

            // Store the current number with its index in the map
            valueIndexMap.put(numbers[i], i);
        }

        // Return empty array if no such pair is found (as a fallback)
        return new int[]{};
    }
}