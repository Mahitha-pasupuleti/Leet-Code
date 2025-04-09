class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList();
        for ( int x : nums ) {
            if ( result.isEmpty() || result.get(result.size()-1) < x ) {
                result.add(x);
            } else {
                int start=0, end=result.size()-1;
                int swapIndex = 0;
                while ( start < end ) {
                    int mid = (start + end)/2;
                    if ( result.get(mid) < x ) start = mid+1;
                    else end = mid;
                }
                result.set(start, x);
            }
        }
        return result.size();
    }
}

// class Solution {
//     // difficult problem
//     public int lengthOfLIS(int[] nums) {
//         int[] tails = new int[nums.length];
//         int size = 0;

//         for ( int x: nums ) {
//             int i=0, j=size;

//             while ( i != j ) {
//                 int m = ( i + j ) / 2;
//                 if ( tails[m] < x ) {
//                     i = m+1;
//                 } else {
//                     j = m;
//                 }
//             }

//             tails[i] = x;
//             if ( i == size ) ++size;
//         }

//         return size;
//     }
// }