class Solution {
    public boolean isPalindrome(int x) {
        int revNum=0;
        int dup = x;
        while(x>0){
            int lastDigit = x%10;
            revNum = (revNum *10)+lastDigit;
            x = x/10;
        }
        if(revNum==dup) return true;
        else return false;
    }
}