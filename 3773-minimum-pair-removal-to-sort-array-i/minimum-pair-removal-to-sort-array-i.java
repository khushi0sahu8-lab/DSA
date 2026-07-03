class Solution {

    public int minimumPairRemoval(int[] nums) {
        int ops = 0;

        while (!isSorted(nums)) {

            int idx = 0;
            int minSum = nums[0] + nums[1];

            for (int i = 1; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];

                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            nums[idx] = minSum;

            int[] newArr = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i == idx + 1) continue;
                newArr[j++] = nums[i];
            }

            nums = newArr;
            ops++;
        }

        return ops;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }
}