class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = getMax(piles);
        int answer = hi;

        while (lo <= hi) {
            int speed = lo + (hi - lo) / 2;
            long hoursNeeded = calculateHours(piles, speed);

            if (hoursNeeded <= h) {
                answer = speed;
                hi = speed - 1;
            } else {
                lo = speed + 1;
            }
        }

        return answer;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            max = Math.max(max, val);
        }
        return max;
    }

    private long calculateHours(int[] piles, int speed) {
        long total = 0;
        for (int pile : piles) {
            total += (pile + speed - 1) / speed;
        }
        return total;
    }
}
