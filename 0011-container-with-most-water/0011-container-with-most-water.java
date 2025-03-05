class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start=0, end=height.length-1;

        while ( start < end ) {
            int min = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, (end-start) * min);
            if ( height[start] < height[end] ) start++;
            else if ( height[start] > height[end] ) end--;
            else {
                if ( height[start+1] > height[end-1] ) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return maxArea;
    }
}