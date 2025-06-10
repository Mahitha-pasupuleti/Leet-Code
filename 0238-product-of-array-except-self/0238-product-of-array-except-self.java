/**
 * LeetCode 238  –  Product of Array Except Self  (division allowed version)
 *
 * Core idea
 * ----------
 * • totalProductWithZero      – includes every element; becomes 0 if ≥ 1 zero exists  
 * • totalProductWithoutZero   – product of all non-zero elements (needed when exactly one zero exists)  
 * • zeroCount                 – number of zeros in the input
 *
 * Output logic
 *  1) zeroCount == 0   →  result[i] = totalProductWithZero / nums[i]
 *  2) zeroCount == 1   →  only the zero position gets totalProductWithoutZero,
 *                         everyone else is 0
 *  3) zeroCount ≥ 2    →  every position is 0 (because at least two zeros make the
 *                         total product 0 no matter which index is removed)
 *
 * Time  :  O(n) — two passes
 * Space :  O(1) — output stored in-place (ignoring the returned array)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int totalProductWithZero    = 1; // becomes 0 if any zero encountered
        int totalProductWithoutZero = 1; // product of non-zero elements only
        int zeroCount               = 0;

        /* ---------- First pass: accumulate products & count zeros ---------- */
        for (int num : nums) {
            totalProductWithZero *= num;          // may turn 0
            if (num != 0) {
                totalProductWithoutZero *= num;   // skip zeros here
            } else {
                zeroCount++;
            }
        }

        /* ---------- Second pass: build the answer in-place ------------------ */
        for (int i = 0; i < nums.length; i++) {

            if (zeroCount == 0) {
                // No zeros: safe to divide totalProductWithZero by current value
                nums[i] = totalProductWithZero / nums[i];
            } else if (zeroCount == 1) {
                // Exactly one zero: only the zero position gets non-zero product
                nums[i] = (nums[i] == 0) ? totalProductWithoutZero : 0;
            } else {
                // Two or more zeros: every product except self is 0
                nums[i] = 0;
            }
        }

        return nums;
    }
}