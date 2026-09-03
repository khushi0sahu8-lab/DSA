class Solution {
    static int dp[][] ;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] ,-1);
        }

        return path(0, 0, obstacleGrid, n, m);
    }
    static int path(int i, int j, int[][] grid, int n, int m) {
        if (i >= n || j >= m) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == n - 1 && j == m - 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int right = path(i, j + 1, grid, n, m);
        int down = path(i + 1, j, grid, n, m);
    
        return dp[i][j]=down + right;
    }
}