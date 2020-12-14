class Solution {
    // public int uniquePaths(int m, int n) {
    //     //1、动态规划((自顶向下))
    //     //时间复杂度O(mn) 空间复杂度O(mn)
    //     int[][] dp = new int[m][n];
    //     //第一行、第一列路径均为1
    //     for(int i=0; i<m; i++) {
    //         dp[i][0] = 1;
    //     }
    //     for(int j=0; j<n; j++) {
    //         dp[0][j] = 1;
    //     }

    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[i][j] = dp[i-1][j] + dp[i][j-1];
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

    //2、动态规划((自顶向下))--优化【时间复杂度O(mn) 空间复杂度O(min(m,n))】
    //因为dp[i][j] = dp[i-1][j] + dp[i][j-1],f(i,j) 仅与第 i 行和第 i−1 行的状态有关，因此可以使用滚动数组代替代码中的二维数组，使空间复杂度降低为 O(n)，此外，由于我们交换行列的值并不会对答案产生影响，因此我们总可以通过交换 m和n使得m≤n，这样空间复杂度降低至O(min(m,n))
    // public int uniquePaths(int m, int n) {
    //     int minValue = Math.min(m,n), maxValue = Math.max(m,n);
    //     int[] dp = new int[minValue]; //若行最小，存储上一行的所有值；若列最小，存储上一列的所有值；
    //     int result = 1;
    //     for (int i = 0; i < maxValue; i++) {
    //         for (int j = 0; j < minValue; j++) {
    //             result = (i == 0 || j == 0) ? 1 : result + dp[j];
    //             dp[j] = result;
    //         }
    //     }
    //     return result;
    // }

    //3、动态规划((自顶向下))--优化【时间复杂度O(mn) 空间复杂度O(min(m,n))】
    public int uniquePaths(int m, int n) {
        int minValue = Math.min(m,n), maxValue = Math.max(m,n);
        int[] cur = new int[minValue];
        Arrays.fill(cur,1);
        for (int i = 1; i < maxValue; i++) {
            for (int j = 1; j < minValue; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[cur.length - 1];
    }

	//4、动态规划【时间复杂度O(mn) 空间复杂度O(n)】
	 public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}