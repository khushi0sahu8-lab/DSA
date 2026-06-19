class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0;
        int ans = 0;

        for (int g : gain) {
            curr += g;
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}