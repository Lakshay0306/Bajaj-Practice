class CircularSubarraySum {
    public static void main(String[] args) {
        int[] arr = {8, -1, 3, 4};

        int normalMax = kadaneMax(arr);

        int totalSum = 0;
        for (int num : arr) totalSum += num;

        int minSubSum = kadaneMin(arr);
        int circularMax = totalSum - minSubSum;

        int answer = (circularMax == 0) ? normalMax : Math.max(normalMax, circularMax);
        System.out.println("Maximum circular subarray sum: " + answer);
    }

    static int kadaneMax(int[] arr) {
        int currMax = arr[0], globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            globalMax = Math.max(globalMax, currMax);
        }
        return globalMax;
    }

    static int kadaneMin(int[] arr) {
        int currMin = arr[0], globalMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMin = Math.min(arr[i], currMin + arr[i]);
            globalMin = Math.min(globalMin, currMin);
        }
        return globalMin;
    }
}
