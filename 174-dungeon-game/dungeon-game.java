class Solution {
    static int dp[][] = new int [201][201];
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return calc(0, 0, n, m, dungeon);
    }
    public static int calc(int i, int j, int n, int m, int[][] dungeon) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if (i == n - 1 && j == m - 1) {
            return dp[i][j] = dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
        }
        int r = calc(i, j + 1, n, m, dungeon);
        int d = calc(i + 1, j, n, m, dungeon);
        int res = Math.min(r, d) - dungeon[i][j];

        return dp[i][j]=Math.max(1, res);
    }
}