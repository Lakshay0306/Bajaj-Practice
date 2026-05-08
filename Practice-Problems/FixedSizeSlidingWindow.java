class FixedSizeSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxWindowSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxWindowSum = Math.max(maxWindowSum, windowSum);
        }

        double maxAvg = (double) maxWindowSum / k;
        System.out.println("Max average of window size " + k + ": " + maxAvg);
    }
}
