import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int num : nums) {
            total = (total + num) % p;
        }
        
        // If total sum is already divisible by p, no need to remove anything
        if (total == 0) return 0;

        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);  // Helps to calculate subarray length correctly

        int currentSum = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int want = (currentSum - total + p) % p;  // Remainder we need to remove
            
            if (myMap.containsKey(want)) {
                minLen = Math.min(minLen, i - myMap.get(want));
            }
            myMap.put(currentSum, i);
        }

        return minLen < nums.length ? minLen : -1;
    }
}





// class Solution {
//     public int minSubarray(int[] nums, int p) {
//         int total = 0;
//         for ( int i=0; i<nums.length; i++ ) {
//             total = (total + nums[i]) % p;
//         }

//         // int findSum = total%p;
//         if ( total == 0 ) return 0;

//         int currentSum = 0, minLen = Integer.MAX_VALUE;

//         Map<Integer, Integer> myMap = new HashMap<>();
//         myMap.put(0, -1);

//         for ( int i=0; i<nums.length; i++ ) {
//             currentSum = (currentSum + nums[i]) % p;
//             int want = (currentSum - total + p) % p;
//             if ( myMap.containsKey( want )) {
//                 minLen = Math.min(minLen, i - myMap.get( want ));
//             } 
//             myMap.put(currentSum, i);
//         }

//         System.out.println(minLen);

//         // if ( minLen == nums.length ) return -1;
//         // if ( minLen == Integer.MAX_VALUE ) return -1;

//         return minLen < nums.length ? minLen : -1;
//     }
// }