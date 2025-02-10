class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> (b-a)
        );
        for ( int i=0; i<nums.length; i++ ) {
            pq.add(nums[i]);
        }
        return (pq.poll()-1)*(pq.poll()-1);
    }
}