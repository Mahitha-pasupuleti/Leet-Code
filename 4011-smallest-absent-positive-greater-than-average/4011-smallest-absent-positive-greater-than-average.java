class Solution {
    public int smallestAbsent(int[] nums) {
        double avg = -1;
        double sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            sum += num;
            set.add(num);
        }
        int n = nums.length;
        Arrays.sort(nums);
        avg = sum / n;
        // System.out.println(Math.ceil(avg));
        double j = avg < 0 ? 1 : Math.ceil(avg) == avg ? avg + 1 : Math.ceil(avg);
        for(int i = (int)j ; i <= 100 ; i++){
            if(!set.contains(i)) return i;
        }
        return nums[n-1]+1;
        
    }
}