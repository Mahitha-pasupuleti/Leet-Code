class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int index = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        for ( int i=0; i<n; i++ ) {
            if ( !queue.isEmpty() && queue.peek() == i-k ) queue.poll();
            while ( !queue.isEmpty() && nums[queue.peekLast()] < nums[i] ) queue.pollLast();
            queue.offer(i);
            if ( i >= k-1 ) {
                result[index++] = nums[queue.peek()];
            }
        }

        return result;
    }
}

/*
class Solution {
    public int getMax(int start, int end, int[] nums) {
        int max = Integer.MIN_VALUE;
        for ( int i=start; i<=end; i++ ) {
            if ( nums[i] > max ) max = nums[i];
        }
        return max;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start=0, end=0;
        List<Integer> result = new ArrayList();
        // int[] finalResult = new int[2];

        while ( end < nums.length ) {
            if ( end - start + 1 == k ) {
                result.add(getMax(start, end, nums));
                start++;
            }
            end++;
        }

        // for ( int i=0; i<result.size(); i++ ) {
        //     System.out.println(result.get(i));
        // }

        int[] finalResult = result.stream().mapToInt(Integer::intValue).toArray();
        return finalResult;
    }
}
*/