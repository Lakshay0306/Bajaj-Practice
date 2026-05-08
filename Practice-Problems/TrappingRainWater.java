class TrappingRainWater {
    public int trap(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int totalWater = 0;

        while (lo < hi) {
            if (height[lo] < height[hi]) {
                maxLeft = Math.max(maxLeft, height[lo]);
                totalWater += maxLeft - height[lo];
                lo++;
            } else {
                maxRight = Math.max(maxRight, height[hi]);
                totalWater += maxRight - height[hi];
                hi--;
            }
        }

        return totalWater;
    }
}
