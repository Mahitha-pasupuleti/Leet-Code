class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*

        Note : Rember the main confusion you are always getting confused here, 
               how will I use map in case of duplicate. The input array does have duplicates
               so how can i use map.
               The point is you can use map, because u check if diff already exists prior
               to adding, so they will never be an issue
               Eg: [3, 3] target = 6
                   - [3 : 0] diff => 6-3 = 3, 
                     does 3 exists in Map? false, push into map ( [3 -> 0] )
                   - [3 : 1] diff => 6-3 = 3,
                     does 3 exists in Map? true, get our result [0, 1]

            - Use a map to store the number and its index as you iterate.
            - For each number, calculate the difference needed to reach the target.
            - If the difference already exists in the map, return the index pair.
            - Else, store the current number with its index in the map.
        */

        Map<Integer, Integer> hasDiff = new HashMap<>(); // SC : O(n)

        for (int i = 0; i < nums.length; i++) { // TC : O(n)
            int diff = target - nums[i]; // TC : O(1)

            if (hasDiff.containsKey(diff)) { // TC : O(1)
                return new int[]{ hasDiff.get(diff), i }; // Pair found, TC: O(1)
            }

            hasDiff.put(nums[i], i); // Store number with index, TC : O(1)
        }

        return new int[]{0, 0}; // Should never be reached if input guarantees one solution

        // TC : O(n), SC : O(n)
    }
}
