class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String num;
    private Pair[][][][] memo;
    private boolean[][][][] vis;

    private Pair dfs(int pos, int prev2, int prev1, int started, boolean tight) {

        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (!tight && vis[pos][prev2][prev1][started]) {
            return memo[pos][prev2][prev1][started];
        }

        int limit = tight ? num.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= limit; digit++) {

            boolean nextTight = tight && (digit == limit);

            if (started == 0 && digit == 0) {

                Pair next = dfs(pos + 1, 10, 10, 0, nextTight);

                totalCount += next.count;
                totalWaviness += next.waviness;
            }
            else if (started == 0) {

                Pair next = dfs(pos + 1, 10, digit, 1, nextTight);

                totalCount += next.count;
                totalWaviness += next.waviness;
            }
            else {

                int add = 0;

                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > digit) ||
                        (prev1 < prev2 && prev1 < digit)) {
                        add = 1;
                    }
                }

                Pair next = dfs(pos + 1, prev1, digit, 1, nextTight);

                totalCount += next.count;
                totalWaviness += next.waviness + add * next.count;
            }
        }

        Pair result = new Pair(totalCount, totalWaviness);

        if (!tight) {
            vis[pos][prev2][prev1][started] = true;
            memo[pos][prev2][prev1][started] = result;
        }

        return result;
    }

    private long solve(long x) {

        if (x < 0) {
            return 0;
        }

        num = String.valueOf(x);

        int n = num.length();

        memo = new Pair[n + 1][11][11][2];
        vis = new boolean[n + 1][11][11][2];

        return dfs(0, 10, 10, 0, true).waviness;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}