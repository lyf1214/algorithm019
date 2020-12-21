class Solution {
    //1��DFS(�����������)
    //˼·����δ�����ʵĽڵ㿪ʼ������������ص�����Ȧ�ڵ㣬��������ѷ��ʵĽڵ㣻ÿ��ʼһ������������Ȧ����������count��1
    //ʱ�临�Ӷ�(N^2)  �ռ临�Ӷ�O(N)
    // public int findCircleNum(int[][] M) {
        // /**ʹ��һ������visited�����ж�ÿ���ڵ�
        //     �����δ���ʣ�����Ȧ������1���Ըýڵ����dfs����������з��ʵ��Ľڵ�
        //   */
    //     int[] visited = new int[M.length];
    //     int count= 0;
    //     for(int i = 0; i < M.length; i++) {
    //         if (visited[i] == 0) { //δ�����ʹ�
    //             dfs(M, visited, i);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private void dfs(int[][] M, int[] visited, int i) {
    //     for (int j = 0; j < M.length; j++) {
    //         if (M[i][j] == 1 && visited[j] == 0) {
    //             visited[j] = 1; //����ѷ���
    //             dfs(M, visited, j);
    //         }
    //     }
    // }

    //2�����鼯(union find)
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
}
//���鼯��UF
class UF {
    //��ͨ��������
    private int count;
    //�洢һ����
    private int[] parent;
    //��¼���ġ�����������ÿ�����Ľڵ���
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        
        //����----Ϊ��ƽ�⣬��С���ӵ���������
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }


    private int find(int x) {
        while (parent[x] != x) {
            //����·��ѹ��
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}