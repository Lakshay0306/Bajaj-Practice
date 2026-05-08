class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int globalMax = nums[0];

        for (int num : nums) {
            runningSum = Math.max(num, runningSum + num);
            globalMax = Math.max(globalMax, runningSum);
        }

        return globalMax;
    }
}
