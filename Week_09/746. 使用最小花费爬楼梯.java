class Solution {
    //1、动态规划 时间复杂度O(n) 空间复杂度O(1)
    //思路：dp[n] = min(dp[n-1] + cost[i-1], dp[n-2] + cost[i-2]),固求dp[n]值，我们只需存储dp[n-1]和dp[n-2]值即可
    public int minCostClimbingStairs(int[] cost) {
        int dp1 = 0, dp2 = 0, result = 0;
        for (int i = 2; i <= cost.length; i++) {
            result = Math.min(dp1 + cost[i-2], dp2 + cost[i-1]);
            dp1 = dp2;
            dp2 = result;
        }
        return result;
    }
}