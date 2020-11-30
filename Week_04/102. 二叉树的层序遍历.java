class Solution {
    //BFS广度优先搜索(借助队列Queue实现)
    //时间复杂度O(n) 空间复杂度O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> results = new ArrayList<>();
            int size = nodes.size();//获取本层节点数
            //遍历本层节点，并添加本层节点的值到results中以及添加左右节点到队列nodes中
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                //若左右节点不为空，添加到队列nodes中
                if (node.left !=null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }
}