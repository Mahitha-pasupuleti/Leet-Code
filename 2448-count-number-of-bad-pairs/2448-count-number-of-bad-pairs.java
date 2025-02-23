class Solution {
    public long countBadPairs(int[] nums) {
        
        Map<Long, Long> mapForGoodPairs = new HashMap<>();
        for ( int i=0; i<nums.length; i++ ) {
            long key = i - nums[i];
            mapForGoodPairs.put( key, mapForGoodPairs.getOrDefault(key, 0L) + 1 );
        }

        // long goodPairs = 0;
        // long goodCount = 0;
        // for (Map.Entry<Long, Long> entry : mapForGoodPairs.entrySet()) {
        //     if ( entry.getValue() > 1 ) {
        //         goodCount = entry.getValue();
        //         goodPairs += goodCount * (goodCount - 1)/2;
        //     }
        // }

        long goodPairs = 0;
        for ( long goodCount : mapForGoodPairs.values() ) {
            goodPairs += goodCount * (goodCount - 1)/2;
        }

        long totalPairs = (long) nums.length * (nums.length - 1)/2;

        return totalPairs - goodPairs;
    }
}