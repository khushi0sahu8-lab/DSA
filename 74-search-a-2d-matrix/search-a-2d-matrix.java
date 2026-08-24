class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        return binarySearch(matrix, target, 0, m * n - 1, n);
    }

    static boolean binarySearch(int[][] matrix, int target, int low, int high, int n) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        int row = mid / n;
        int col = mid % n;

        if (matrix[row][col] == target) {
            return true;
        }
        if (target < matrix[row][col]) {
            return binarySearch(matrix, target, low, mid - 1, n);
        }
        return binarySearch(matrix, target, mid + 1, high, n);
    }
}