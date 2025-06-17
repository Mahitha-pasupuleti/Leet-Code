class Solution {

    // Merges two sorted arrays into nums1 in-place
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // Last valid element index in nums1
        int j = n - 1;        // Last element index in nums2
        int k = m + n - 1;    // Last position in nums1 (final merged array)

        // Merge in reverse order to avoid overwriting nums1's valid data
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]; // Place larger element at the end
            } else {
                nums1[k--] = nums2[j--]; // Place nums2[j] into correct position
            }
        }
    }
}


/* -------------------------------------------------------------------
   Notes: Leetcode 88 – Merge Sorted Array
   -------------------------------------------------------------------
   Problem:
   --------
   Merge two sorted integer arrays `nums1` and `nums2` into `nums1` as one sorted array.
   `nums1` has extra space to accommodate elements from `nums2`.

   Approach:
   ---------
   1. Use three pointers:
      - `i`: points to last valid element in `nums1` (index m-1)
      - `j`: points to last element in `nums2` (index n-1)
      - `k`: points to last index of the combined array (m+n-1)
   2. Traverse from the end:
      - Compare `nums1[i]` and `nums2[j]`, and place the larger one at position `k`
      - Decrease pointers accordingly
   3. Only loop while `j >= 0` since remaining `nums1` elements are already in place if `j < 0`.

   Why Reverse Merge?
   ------------------
   - Forward merging would overwrite elements in `nums1`.
   - Reverse merging avoids using extra space and respects in-place constraint.

   Time Complexity:
   ----------------
   • O(m + n) — We iterate through each element from the back once.

   Space Complexity:
   -----------------
   • O(1) — Constant extra space; done entirely in-place.

--------------------------------------------------------------------- */
