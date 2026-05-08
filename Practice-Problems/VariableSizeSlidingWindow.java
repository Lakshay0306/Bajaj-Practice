class VariableSizeSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3};
        int targetSum = 7;

        int windowStart = 0;
        int currentSum = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentSum += arr[windowEnd];

            while (currentSum > targetSum) {
                currentSum -= arr[windowStart];
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        System.out.println("Max length subarray with sum <= " + targetSum + ": " + maxLength);
    }
}
