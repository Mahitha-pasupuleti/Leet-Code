class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int maxWater = 0;
        while ( start < end ) {
            int minHeight = Math.min(height[start], height[end]);
            int width = end - start;
            maxWater = Math.max(maxWater, minHeight * width);
            if ( height[start] < height[end] ) start++;
            else end--;
        }
        return maxWater;
    }
}