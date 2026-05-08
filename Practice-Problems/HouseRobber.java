class HouseRobber {
    public int rob(int[] nums) {
        int robPrev2 = 0;
        int robPrev1 = 0;

        for (int money : nums) {
            int current = Math.max(robPrev1, robPrev2 + money);
            robPrev2 = robPrev1;
            robPrev1 = current;
        }

        return robPrev1;
    }
}
