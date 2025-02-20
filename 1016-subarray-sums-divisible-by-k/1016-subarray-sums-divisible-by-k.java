class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, 1);
        int sum = 0, count = 0;
        for ( int i=0; i<nums.length; i++ ) {
            sum += nums[i];
            int remainder = sum%k;
            if ( remainder < 0 ) remainder += k;
            if ( myMap.containsKey(remainder) ) {
                count += myMap.get(remainder);
            }
            myMap.put( remainder, myMap.getOrDefault(remainder, 0) + 1 );
        }
        return count;
    }
}