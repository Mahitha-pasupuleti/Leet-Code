class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] prefix = new int[n];
        prefix[0] = height[0];

        for ( int i=1; i<n; i++ ) {
            prefix[i] = Math.max(prefix[i-1], height[i]); // tallest wall to the left of or at i
        }

        int[] suffix = new int[n];
        suffix[n-1] = height[n-1];

        for ( int i=n-2; i>=0; i-- ) {
            suffix[i] = Math.max(suffix[i+1], height[i]); // tallest wall to the right of or at i
        }

        int totalWater = 0;
        for ( int i=0; i<n; i++ ) {
            totalWater += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return totalWater;
    }
}



/*
Let's make it very clear — leftMax / rightMax vs NGR / NGL are conceptually different,
and it's why for trapping rain water we use leftMax/rightMax instead of NGR/NGL.

1️⃣ Next Greater Left / Right (NGL / NGR)

    NGR[i] = index of the next bar to the right that is strictly taller than height[i].
    NGL[i] = index of the next bar to the left that is strictly taller than height[i].

    Example:
    height = [0,1,0,2]
    NGR: [-1,3,3,-1]  // next greater to the right for each index
    NGL: [-1,-1,1,1]  // next greater to the left for each index

Notice: it's the “next” taller bar, not the tallest bar in the whole range.
It can skip shorter bars in between.

2️⃣ LeftMax / RightMax

    leftMax[i] = tallest bar from index 0 up to i
    rightMax[i] = tallest bar from i to n-1

    Example:
    height = [0,1,0,2]
    leftMax:  [0,1,1,2]  // tallest bar from start to i
    rightMax: [2,2,2,2]  // tallest bar from i to end

Here, leftMax[i] / rightMax[i] gives the “highest wall” to the left and right —
exactly what we need to trap water. It does not tell the index of the next taller bar,
only the height of the tallest so far.

3️⃣ Why it matters for trapping water

    Water trapped at index i:
    water[i] = min(leftMax[i], rightMax[i]) - height[i]

    Using NGR/NGL alone won't always give the tallest walls, because the next taller bar
    might be too close.

    Example:
    height = [3, 0, 2, 0, 4]
    NGR[1] = 2      // next taller is at index 2
    leftMax[1] = 3  // tallest on left is 3
    rightMax[1] = 4 // tallest on right is 4

If you use NGR/NGL, you'd compute:
min(height[2], height[0]) = min(2,3) = 2  → wrong
Actual water trapped = min(leftMax, rightMax) - height[i] = min(3,4) - 0 = 3 ✅
*/