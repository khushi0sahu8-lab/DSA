class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int start = -1;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int lower = 0;
            int upper = 0;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (Character.isLowerCase(ch)) {
                    lower |= 1 << (ch - 'a');
                } else {
                    upper |= 1 << (ch - 'A');
                }

                if (lower == upper) {
                    int len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return start == -1 ? "" : s.substring(start, start + maxLen);
    }
}