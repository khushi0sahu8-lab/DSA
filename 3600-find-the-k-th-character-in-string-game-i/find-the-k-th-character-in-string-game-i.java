class Solution {
    public char kthCharacter(int k) {
        return solve(k);
    }

    private char solve(int k) {
        if (k == 1) {
            return 'a';
        }

        int len = 1;
        while (len * 2 < k) {
            len *= 2;
        }

        if (k <= len) {
            return solve(k);
        } else {
            char c = solve(k - len);
            return (char)(c + 1);
        }
    }
}