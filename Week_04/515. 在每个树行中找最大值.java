class Solution {
    //BFS(�������У�������)
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
            //������ǰ�㣬��ȡ��ǰ������ֵ
            for (int i = 0; i < size; i++) {
                //��ȡ��ǰ������ֵ
                TreeNode node = nodes.poll();
                //currentLevelMaxValue = (i==0) ? node.val : Math.max(currentLevelMaxValue, node.val);
                currentLevelMaxValue = Math.max(currentLevelMaxValue, node.val);//��¼ÿ������ֵ
                //���뵱ǰ�����һ��(��ڵ㡢�ҽڵ�)
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

    //�������DFS(˼·�������㼶level�������Ƚ�ÿ������ֵ)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,0,result);//�㼶��0��ʼ,result����Ҫ���Ǽ�1����1�����
        return result;
    }

    public void dfs(TreeNode root, int level, List<Integer> result) {
        //�ݹ�DFS�ܽ�����
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