class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans = 0;
        int maxGain = 0;

        int prevZero = Integer.MIN_VALUE;
        int i = 0;
        int n = s.length();

        while (i < n) {
            int j = i + 1;

            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ans += len;   
            } else {
 
                maxGain = Math.max(maxGain, prevZero + len);
                prevZero = len;
            }

            i = j;
        }

        return ans + maxGain;
    }
}