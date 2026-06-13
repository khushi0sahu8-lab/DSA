import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = 0, sumB = 0;

        for (int x : A) sumA += x;
        for (int y : B) sumB += y;

        int diff = (sumA - sumB) / 2;

        HashSet<Integer> setB = new HashSet<>();
        for (int y : B) setB.add(y);

        for (int x : A) {
            int target = x - diff;
            if (setB.contains(target)) {
                return new int[]{x, target};
            }
        }

        return new int[]{};
    }
}