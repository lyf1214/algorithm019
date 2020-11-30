class Solution {
    //˼·��DFS�����������������1ʱ������������1��Ȼ������õ��������������������ڽڵ㣬��Ϊ1��˵������ͬһ�鵺�죬����������Ϊgrid[i][j]���Ϊ0����grid[i][j]='0'��,��ֹ�ظ�����1�������������ظ����㵺�������
	//ʱ�临�Ӷȣ�O(MN)O(MN)������ MM �� NN �ֱ�Ϊ������������
	//�ռ临�Ӷȣ�O(MN)O(MN)���������£����������Ϊ½�أ����������������ȴﵽ M NMN
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        m = grid.length; //grid�ĳ���
        if(m==0) return 0;
        n = grid[0].length; //grid�����
        int count = 0; //��������
        //�������ڽڵ㣬��Ϊ1��˵��Ϊͬһ�鵺�죬����Ϊ��Ǻ󣬽�����������Ϊgrid[i][j]=0����ֹ�ظ�����
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

    //DFS�ݹ飺�ж����ڽڵ��Ƿ����ڸõ��죬�����ڽ����±���Ϊ0����ֹ�ظ�����1������
    public void isBelongToTheIsland(char[][] grid,int i, int j){
        //System.out.println(i+"--"+m+"---"+j+"---"+n);
        if ( (i < 0 || i >= m) || (j < 0 || j >= n) || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        //������������4��λ��
        isBelongToTheIsland(grid, i+1, j);
        isBelongToTheIsland(grid, i-1, j);
        isBelongToTheIsland(grid, i, j+1);
        isBelongToTheIsland(grid, i, j-1);
    }
}