import java.util.*;
class Solution {
    static int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcsLength = lcs(word1,word2,n-1,m-1);
        int delete_s1 = n - lcsLength;
        int delete_s2 = m - lcsLength;
        return delete_s1 + delete_s2;
    }
    public static int lcs(String word1, String word2,int i,int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = 1+lcs(word1,word2,i-1,j-1);
        }
        else{
            dp[i][j] = Math.max(lcs(word1,word2,i-1,j),lcs(word1,word2,i,j-1));
        }
        return dp[i][j];
    }
}