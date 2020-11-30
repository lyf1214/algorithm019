class Solution {
    //BFS�����������(��������Queueʵ��)
    //ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> results = new ArrayList<>();
            int size = nodes.size();//��ȡ����ڵ���
            //��������ڵ㣬����ӱ���ڵ��ֵ��results���Լ�������ҽڵ㵽����nodes��
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                //�����ҽڵ㲻Ϊ�գ���ӵ�����nodes��
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