class RangeSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int left = 1, right = 3;
        int rangeSum = (left == 0) ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];

        System.out.println("Sum of range [" + left + ", " + right + "] = " + rangeSum);
    }
}
