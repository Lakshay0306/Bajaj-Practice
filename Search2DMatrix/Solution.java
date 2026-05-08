class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lo = 0, hi = rows * cols - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int value = matrix[mid / cols][mid % cols];

            if (value == target) return true;
            else if (value < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return false;
    }
}
