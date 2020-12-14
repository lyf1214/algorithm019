class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //��̬�滮 ʱ�临�Ӷ�O(mn) �ռ临�Ӷ�O(n) 
        //���������Ż�
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0) {
                    f[j] += f[j-1];
                }
            }
        }
        return f[n-1];
    }
}