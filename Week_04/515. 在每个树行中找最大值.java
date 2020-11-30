class Solution {
    //BFS(借助队列，层层遍历)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null ){
           return result; 
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Integer currentLevelMaxValue= Integer.MIN_VALUE;
            int size = nodes.size();
            //遍历当前层，获取当前层的最大值
            for (int i = 0; i < size; i++) {
                //获取当前层的最大值
                TreeNode node = nodes.poll();
                //currentLevelMaxValue = (i==0) ? node.val : Math.max(currentLevelMaxValue, node.val);
                currentLevelMaxValue = Math.max(currentLevelMaxValue, node.val);//记录每层的最大值
                //加入当前层的下一层(左节点、右节点)
                if(node.left != null) {
                    nodes.add(node.left);
                }
                if(node.right != null) {
                    nodes.add(node.right);
                }
            }
            result.add(currentLevelMaxValue);
        }
        return result;
    }
}


class Solution {

    //深度优先DFS(思路：借助层级level参数，比较每层的最大值)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,0,result);//层级从0开始,result不需要考虑加1，减1的情况
        return result;
    }

    public void dfs(TreeNode root, int level, List<Integer> result) {
        //递归DFS总结条件
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(level , root.val);
        }
        int max = Math.max(result.get(level), root.val);
        result.set(level , max);
       
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}