class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
            \U0001f4cc SHORT NOTES:
            - Problem: Each boat can carry at most 2 people without exceeding a weight limit.
            - Goal: Find the minimum number of boats required to carry everyone.
            - Strategy: Use a greedy two-pointer approach:
                1. Sort the array of weights.
                2. Try to pair the heaviest person with the lightest one (if within the limit).
                3. If they can't be paired, the heaviest person goes alone.
                4. Move pointers and count boats accordingly.

            ✅ Efficient and optimal strategy by prioritizing heaviest person first.

            ⏱️ TIME COMPLEXITY: O(n log n)
                - Sorting takes O(n log n), two-pointer pass is O(n)

            \U0001f4be SPACE COMPLEXITY: O(1)
                - Sorting in-place, using constant extra space
        */

        Arrays.sort(people); // Sort the array to facilitate pairing
        int n = people.length;
        int left = 0;         // Pointer to lightest person
        int right = n - 1;    // Pointer to heaviest person
        int count = 0;        // Count of boats used

        while (left <= right) {
            // Try to pair the lightest and heaviest person
            if (people[left] + people[right] <= limit) {
                left++; // Pair was successful, move left pointer
            }
            // Either paired or sent right person alone
            right--;     // Always move the right pointer (heaviest person is placed)
            count++;     // One boat used
        }

        return count;
    }
}