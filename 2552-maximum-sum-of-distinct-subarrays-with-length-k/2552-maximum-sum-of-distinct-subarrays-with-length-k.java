class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int start=0, end=0;
        long currSum=0, maxSum=0;
        Set<Integer> mySet = new HashSet<>();

        while ( end < nums.length ) {
            while ( mySet.contains(nums[end]) ) {
                mySet.remove(nums[start]);
                currSum -= nums[start];
                start++;
            }
            currSum += nums[end];
            mySet.add(nums[end]);
            if ( end - start + 1 == k ) {
                maxSum = Math.max(maxSum, currSum);
                mySet.remove(nums[start]);
                currSum -= nums[start];
                start++;
            }
            end++;
        }
        return maxSum;
    }
}




// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         int start = 0, end = k-1;
//         long currSum = 0, maxSum = 0;
//         Map<Integer, Integer> myMap = new HashMap<>();
//         for ( int i=start; i<=end; i++ ) {
//             myMap.put(nums[i], myMap.getOrDefault(nums[i], 0) + 1);
//             currSum += nums[i];
//         }

//         while ( end < nums.length ) {
//             if ( myMap.size() == k ) {
//                 maxSum = Math.max(maxSum, currSum);
//             }


//             if ( myMap.get(nums[start]) > 1 ) {
//                 int value = myMap.get(nums[start]);
//                 myMap.put(nums[start], --value);
//             } else {
//                 myMap.remove(nums[start]);
//             }
//             currSum -= nums[start];
//             start++;

//             if ( end == nums.length - 1 ) break;
//             end++;
//             currSum += nums[end];
//             myMap.put(nums[end], myMap.getOrDefault(nums[end], 0) + 1);
            
//         }

//         if ( myMap.size() == k ) {
//                 maxSum = Math.max(maxSum, currSum);
//             }

//         return maxSum;
//     }
// }


// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         int start = 0, end = 0;
//         long currSum = 0, maxSum = 0;
//         Map<Integer, Integer> myMap = new HashMap<>();
        
//         // Initialize the first window
//         while (end < k) {
//             myMap.put(nums[end], myMap.getOrDefault(nums[end], 0) + 1);
//             currSum += nums[end];
//             end++;
//         }

//         // Sliding window from k to the end of the array
//         while (end < nums.length) {
//             // If the window has exactly k distinct elements, update the maxSum
//             if (myMap.size() == k) {
//                 maxSum = Math.max(maxSum, currSum);
//             }
            
//             // Remove the start element from the map and reduce the current sum
//             myMap.put(nums[start], myMap.get(nums[start]) - 1);
//             if (myMap.get(nums[start]) == 0) {
//                 myMap.remove(nums[start]);
//             }
//             currSum -= nums[start];
//             start++;
            
//             // Add the end element to the map and increase the current sum
//             myMap.put(nums[end], myMap.getOrDefault(nums[end], 0) + 1);
//             currSum += nums[end];
//             end++;
//         }

//         // Handle the last window (if it's of size k)
//         if (myMap.size() == k) {
//             maxSum = Math.max(maxSum, currSum);
//         }

//         return maxSum;
//     }
// }
