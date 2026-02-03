class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                Map<Integer, Integer> map = new HashMap<>();

                for (int k = j + 1; k < n; k++) {
                    int sum3 = nums[i] + nums[j] + nums[k];
                    int diff = target - sum3;

                    if (map.containsKey(diff)) {
                        result.add(Arrays.asList(
                            nums[i], nums[j], diff, nums[k]
                        ));

                        // skip duplicates
                        while (k + 1 < n && nums[k] == nums[k + 1]) k++;
                    }

                    map.put(nums[k], k);
                }
            }
        }
        return result;
    }
}
