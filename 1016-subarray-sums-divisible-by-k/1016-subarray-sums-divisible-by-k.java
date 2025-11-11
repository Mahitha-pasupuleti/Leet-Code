class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // divisible by k;

        for ( int num : nums ) {
            prefixSum += num;
            int mod = ( ( prefixSum % k ) + k ) % k;
            count += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}