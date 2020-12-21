class Solution {
    //1、DFS(深度优先搜索)
    //思路：从未被访问的节点开始搜索，搜索相关的朋友圈节点，并将标记已访问的节点；每开始一次搜索，朋友圈数量计数器count加1
    //时间复杂度(N^2)  空间复杂度O(N)
    // public int findCircleNum(int[][] M) {
        // /**使用一个数组visited依次判断每个节点
        //     如果其未访问，朋友圈数量加1并对该节点进行dfs搜索标记所有访问到的节点
        //   */
    //     int[] visited = new int[M.length];
    //     int count= 0;
    //     for(int i = 0; i < M.length; i++) {
    //         if (visited[i] == 0) { //未被访问过
    //             dfs(M, visited, i);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private void dfs(int[][] M, int[] visited, int i) {
    //     for (int j = 0; j < M.length; j++) {
    //         if (M[i][j] == 1 && visited[j] == 0) {
    //             visited[j] = 1; //标记已访问
    //             dfs(M, visited, j);
    //         }
    //     }
    // }

    //2、并查集(union find)
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
//并查集类UF
class UF {
    //连通分量个数
    private int count;
    //存储一棵树
    private int[] parent;
    //记录数的“重量”，即每个树的节点数
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
        
        //并集----为了平衡，将小树接到大树下面
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
            //进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}