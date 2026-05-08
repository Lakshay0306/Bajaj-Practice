class FindPairWithKSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;

        int lo = 0, hi = arr.length - 1;
        boolean pairFound = false;

        while (lo < hi) {
            int currentSum = arr[lo] + arr[hi];

            if (currentSum == target) {
                pairFound = true;
                System.out.println("Pair found: (" + arr[lo] + ", " + arr[hi] + ")");
                break;
            } else if (currentSum < target) {
                lo++;
            } else {
                hi--;
            }
        }

        if (!pairFound) System.out.println("No pair found");
    }
}
