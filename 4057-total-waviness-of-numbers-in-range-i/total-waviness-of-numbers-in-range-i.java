class Solution {
    private int waviness(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        if (n < 3) return 0; 

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1)) ||
                (s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1))) {
                count++;
            }
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int x = num1; x <= num2; x++) {
            total += waviness(x);
        }
        return total;
    }
}