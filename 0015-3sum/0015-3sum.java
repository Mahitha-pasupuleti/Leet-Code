class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to make it easier to handle duplicates
        Arrays.sort(nums);

        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>(); // To store unique triplets

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int currVal = nums[i];            // Current fixed value
            int target = 0 - currVal;         // We need two numbers that sum to -currVal
            Map<Integer, Integer> valueIndexMap = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int diff = target - nums[j];  // Difference needed to reach target
                if (valueIndexMap.containsKey(diff)) {
                    // Found a valid triplet
                    tripletSet.add(Arrays.asList(currVal, diff, nums[j]));
                }
                // Store the number for future checks
                valueIndexMap.put(nums[j], j);
            }
        }

        // Convert Set to List before returning
        return new ArrayList<>(tripletSet);
    }
}


/*
===============================================================
\U0001f4dd Short Notes:
===============================================================
Problem:
- Find all unique triplets (i, j, k) such that:
  nums[i] + nums[j] + nums[k] == 0 and i ≠ j ≠ k.

Approach:
- Sort the array to handle duplicates efficiently.
- For each index `i`, fix `nums[i]` and look for two numbers 
  in the remaining array that sum up to `-nums[i]`.
- Use a HashMap to track the difference between target and current element.
- Store valid triplets in a Set to avoid duplicates.

Deduplication:
- Skip duplicate values in outer loop.
- Set ensures triplets are unique, but relies on sorted input.

===============================================================
⏱ Time and Space Complexity:
===============================================================
Time Complexity:
- Sorting: O(n log n)
- Nested loop: O(n²)
- Overall: O(n²)

Space Complexity:
- HashMap: O(n) per outer loop
- Set of triplets: O(n²) in worst case
- Overall: O(n²)
===============================================================
*/
