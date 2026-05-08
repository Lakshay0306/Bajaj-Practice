class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == target) {
                int dist = Math.abs(idx - start);
                minDist = Math.min(minDist, dist);

                if (minDist == 0) return 0;
            }
        }

        return minDist;
    }
}
