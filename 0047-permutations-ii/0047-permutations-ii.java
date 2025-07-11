/**
 * We want to avoid generating duplicate permutations when the input has repeated characters.
 *
 * Here's the key idea:
 * - If nums[i] == nums[i - 1], it means we have a duplicate character.
 * - To avoid duplicates, we **only allow using nums[i]** if the previous identical character (nums[i - 1]) 
 *   has already been used in the current path.
 *
 * Why?
 * - If nums[i - 1] is marked as visited, it means we're currently building a permutation
 *   that already includes the first occurrence — so it's valid to include this one.
 * - But if nums[i - 1] is **not** visited, it means we're trying to start a new path using a duplicate
 *   before using the original one — which would lead to the same permutation structure and thus a duplicate.
 *
 * So, we skip this element to avoid generating the same permutation again.
 */


class Solution {
    private void generatePermutations(int[] nums, List<List<Integer>> result, List<Integer> subResult, boolean[] visited) {
        if ( subResult.size() == nums.length ) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for ( int i=0; i<nums.length; i++ ) {
            if ( visited[i] || i>0 && nums[i] == nums[i-1] && !visited[i-1] ) continue;
            visited[i] = true;
            subResult.add(nums[i]);
            generatePermutations(nums, result, subResult, visited);
            visited[i] = false;
            subResult.remove(subResult.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        generatePermutations(nums, result, subResult, visited);
        return result;
    }
}