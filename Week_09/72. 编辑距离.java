class Solution {
    //动态规划
    // public int minDistance(String word1, String word2) {
    //     int n = word1.length();
    //     int m = word2.length();

    //     //有一个字符串为空
    //     if (n * m == 0) return n + m;

    //     //DP数组（缓存，防止重复计算）
    //     int[][] dp = new int[n+1][m+1];

    //     //边界状态初始化
    //     for (int i = 0; i < n + 1; i++) {
    //         dp[i][0] = i;
    //     }
    //     for (int j = 0; j < m + 1; j++) {
    //         dp[0][j] = j;
    //     }

    //     //计算所有dp值
    //     for (int i = 1; i < n + 1; i++) {
    //         for (int j = 1; j < m + 1; j++) {
    //             int left = dp[i-1][j] + 1;
    //             int down= dp[i][j-1] + 1;
    //             int left_down = dp[i-1][j-1];
    //             if (word1.charAt(i-1) != word2.charAt(j-1)) {
    //                 left_down += 1;
    //             }
    //             dp[i][j] = Math.min(left, Math.min(down, left_down));
    //         }
    //     }
    //    // System.out.println(dp[3][1]+","+dp[3][2]+","+dp[3][3]);
    //     return dp[n][m];
    // }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //DP数组（缓存，防止重复计算）
        int[][] dp = new int[n+1][m+1];
        //边界值初始化(第一列)
        for (int i = 0; i < n + 1; i++)  dp[i][0] = i;
        //边界值初始化(第一列)
        for (int j = 0; j < m + 1; j++)  dp[0][j] = j;

        //计算所有dp值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]), dp[i-1][j]) +1;
                }

            }
        }
        return dp[n][m];
    }

} 