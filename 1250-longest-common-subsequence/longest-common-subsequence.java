import java.util.*;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return Memo(text1, text2, m - 1, n - 1, dp);
    }

    private static int Memo(String text1, String text2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {

            dp[i][j] = 1 + Memo(text1, text2, i - 1, j - 1, dp);

        } 
        else {

            dp[i][j] = Math.max(
                Memo(text1, text2, i - 1, j, dp),
                Memo(text1, text2, i, j - 1, dp)
            );
        }

        return dp[i][j];
    }
}