import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];

        for (int x : nums) {
            freq[x]++;
        }

        long[] gcdCount = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long count = 0;

            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
                gcdCount[g] -= gcdCount[multiple];
            }

            gcdCount[g] += count * (count - 1) / 2;
        }

        for (int i = 1; i <= max; i++) {
            gcdCount[i] += gcdCount[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];

            int low = 1, high = max;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (gcdCount[mid] > q) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = low;
        }

        return ans;
    }
}