class MaxSubarrayFixedWindow {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += arr[i];

        int best = windowSum;

        for (int end = k; end < arr.length; end++) {
            windowSum = windowSum + arr[end] - arr[end - k];
            best = Math.max(best, windowSum);
        }

        System.out.println("Maximum sum of window size " + k + ": " + best);
    }
}
