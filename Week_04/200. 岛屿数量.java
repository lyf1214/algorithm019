class Solution {
    //思路：DFS深度优先搜索，碰到1时，岛屿数量加1，然后遍历该点上下左右四周所有相邻节点，若为1，说明属于同一块岛屿，将其坐标标记为grid[i][j]标记为0（即grid[i][j]='0'）,防止重复计算1的数量，进而重复计算岛屿的数量
	//时间复杂度：O(MN)O(MN)，其中 MM 和 NN 分别为行数和列数。
	//空间复杂度：O(MN)O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M NMN
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        m = grid.length; //grid的长度
        if(m==0) return 0;
        n = grid[0].length; //grid的深度
        int count = 0; //岛屿数量
        //遍历相邻节点，若为1，说明为同一块岛屿，并作为标记后，将其坐标设置为grid[i][j]=0，防止重复计算
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    isBelongToTheIsland(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    //DFS递归：判断相邻节点是否属于该岛屿，若属于将其下标标记为0，防止重复计算1的数量
    public void isBelongToTheIsland(char[][] grid,int i, int j){
        //System.out.println(i+"--"+m+"---"+j+"---"+n);
        if ( (i < 0 || i >= m) || (j < 0 || j >= n) || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        //遍历上下左右4个位置
        isBelongToTheIsland(grid, i+1, j);
        isBelongToTheIsland(grid, i-1, j);
        isBelongToTheIsland(grid, i, j+1);
        isBelongToTheIsland(grid, i, j-1);
    }
}