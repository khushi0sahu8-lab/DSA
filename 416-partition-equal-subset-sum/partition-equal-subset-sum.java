class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 != 0){
            return false;
        } 
        int target = sum/2;
        dp = new Boolean[nums.length][target+1];

        return fun(nums,0,target);
    }
    public boolean fun(int[] nums ,int idx, int target){
        if(target == 0){
            return true;
        }
        if(idx == nums.length || target < 0) return false;
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        boolean t = fun(nums,idx+1,target-nums[idx]);
        boolean nt = fun(nums,idx+1,target);

        dp[idx][target] = t || nt;
        return dp[idx][target];
    }
}