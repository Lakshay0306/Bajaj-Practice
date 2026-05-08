class SplitArrayThreeParts {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, -1, -5, 2, 6, 0};

        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (totalSum % 3 != 0) {
            System.out.println(false);
            return;
        }

        int targetPart = totalSum / 3;
        int runningSum = 0;
        int partitions = 0;

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (runningSum == targetPart) {
                partitions++;
                runningSum = 0;
            }
        }

        System.out.println(partitions >= 3);
    }
}
