class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int sum = 0;
        for (int stick : matchsticks) sum += stick;

        if (sum % 4 != 0) return false; // total length must be divisible by 4
        int target = sum / 4;

        // Sort in descending order to optimize backtracking (place larger sticks first)
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = new int[4]; // track length of each side
        return dfs(matchsticks, 0, sides, target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            // Check if all sides equal target
            return sides[0] == target && sides[1] == target 
                   && sides[2] == target && sides[3] == target;
        }

        int stick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= target) {
                sides[i] += stick;
                if (dfs(matchsticks, index + 1, sides, target)) return true;
                sides[i] -= stick; // backtrack
            }
        }
        return false; // cannot place stick in any side
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
