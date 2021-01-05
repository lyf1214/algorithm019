class Solution {
    //1����̬�滮 ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
    //˼·��dp[n] = min(dp[n-1] + cost[i-1], dp[n-2] + cost[i-2]),����dp[n]ֵ������ֻ��洢dp[n-1]��dp[n-2]ֵ����
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