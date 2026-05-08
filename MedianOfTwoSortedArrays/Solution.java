class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);

        int totalLen = a.length + b.length;
        int halfLen = (totalLen + 1) / 2;

        int lo = 0, hi = a.length;

        while (lo <= hi) {
            int cutA = lo + (hi - lo) / 2;
            int cutB = halfLen - cutA;

            int leftA  = (cutA > 0) ? a[cutA - 1] : Integer.MIN_VALUE;
            int rightA = (cutA < a.length) ? a[cutA] : Integer.MAX_VALUE;
            int leftB  = (cutB > 0) ? b[cutB - 1] : Integer.MIN_VALUE;
            int rightB = (cutB < b.length) ? b[cutB] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if (totalLen % 2 == 1) {
                    return Math.max(leftA, leftB);
                }
                return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            } else if (leftA > rightB) {
                hi = cutA - 1;
            } else {
                lo = cutA + 1;
            }
        }

        return 0.0;
    }
}
