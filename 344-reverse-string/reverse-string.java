class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0);
    }
    static void reverse(char[] s, int index) {
        if (index == s.length) return;
        char ch = s[index];
        reverse(s, index + 1);

        s[s.length - index - 1] = ch;
    }
}