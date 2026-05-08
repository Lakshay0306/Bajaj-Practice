class CountOddSumSubarrays {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        int oddPrefixes = 0;
        int evenPrefixes = 1;
        int prefixSum = 0;
        int result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result = (result + oddPrefixes) % MOD;
                evenPrefixes++;
            } else {
                result = (result + evenPrefixes) % MOD;
                oddPrefixes++;
            }
        }

        return result;
    }
}
