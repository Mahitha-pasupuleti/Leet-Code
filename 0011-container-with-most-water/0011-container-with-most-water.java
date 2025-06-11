class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers at the ends of the array
        int left = 0;
        int right = height.length - 1;
        int maxContainer = 0;

        while (left < right) {
            // Height of the container is determined by the shorter line
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;

            // Calculate area and update max if needed
            maxContainer = Math.max(maxContainer, minHeight * width);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxContainer;
    }
}

/* ---------------------------------------------------------------
   Notes: Container With Most Water (LeetCode 11)
   ---------------------------------------------------------------
   Problem
   -------
   Given an array of heights, find the two lines that together with
   the x-axis form a container such that the container holds the most water.

   Approach
   --------
   - Use a two-pointer strategy:
     • Start with one pointer at the beginning (`left`)
     • Another at the end of the array (`right`)
   - At each step:
     • Calculate the area (minHeight × width)
     • Update the max area if current area is larger
     • Move the pointer pointing to the shorter line inward to try to
       find a taller line that might increase the area

   Time Complexity
   ---------------
   • O(n) — Each element is visited at most once

   Space Complexity
   ----------------
   • O(1) — Constant space used
----------------------------------------------------------------- */
