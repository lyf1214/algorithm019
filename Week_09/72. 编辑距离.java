class Solution {
    //��̬�滮
    // public int minDistance(String word1, String word2) {
    //     int n = word1.length();
    //     int m = word2.length();

    //     //��һ���ַ���Ϊ��
    //     if (n * m == 0) return n + m;

    //     //DP���飨���棬��ֹ�ظ����㣩
    //     int[][] dp = new int[n+1][m+1];

    //     //�߽�״̬��ʼ��
    //     for (int i = 0; i < n + 1; i++) {
    //         dp[i][0] = i;
    //     }
    //     for (int j = 0; j < m + 1; j++) {
    //         dp[0][j] = j;
    //     }

    //     //��������dpֵ
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
        //DP���飨���棬��ֹ�ظ����㣩
        int[][] dp = new int[n+1][m+1];
        //�߽�ֵ��ʼ��(��һ��)
        for (int i = 0; i < n + 1; i++)  dp[i][0] = i;
        //�߽�ֵ��ʼ��(��һ��)
        for (int j = 0; j < m + 1; j++)  dp[0][j] = j;

        //��������dpֵ
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