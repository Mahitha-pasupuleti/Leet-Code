class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int sum = 0, count = 0;

        myMap.put(0, 1);
        for ( int i=0; i<nums.length; i++ ) {
            sum += nums[i];
            if ( myMap.containsKey(sum-k) ) {
                count += myMap.get(sum-k);
            }
            myMap.put(sum, myMap.getOrDefault(sum, 0) + 1);
        }

        // System.out.println(myMap);

        return count;
    }
}

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int[] prefix_sum = new int[nums.length+1];
//         prefix_sum[0] = 0;
//         for ( int i=1; i<=nums.length; i++ ) {
//             prefix_sum[i] = prefix_sum[i-1] + nums[i-1];
//         }

//         int count = 0;
//         for ( int start=0; start<prefix_sum.length; start++ ) {
//             for ( int end=start+1; end<prefix_sum.length; end++ ) {
//                 if ( prefix_sum[end] - prefix_sum[start] == k ) count++;
//             }
//         }

//         return count;
//     }
// }