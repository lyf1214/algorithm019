class Solution {
    //1、动态规划  空间复杂度O(n^2) 时间复杂度O(n)
    // public int lengthOfLIS(int[] nums) {
    //     if (nums.length == 0) return 0;
    //     //dp数组记录当前位置最大子序列的长度
    //     int[] dp = new int[nums.length];
    //     dp[0] = 1;
    //     int maxans = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         dp[i] = 1;
    //         for (int j = 0; j < i; j++) {
    //             if (nums[i] > nums[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         maxans = Math.max(maxans, dp[i]);
    //     }
    //     return maxans;
    // }

    //动态规划 + 二分查找
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            //System.out.println("i=" + i + ", j=" + j + ", tails[i]=" + tails[i]);
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}