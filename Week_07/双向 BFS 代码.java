public class TreeNode {
    int val;
    LinkedList<TreeNode> children;

    TreeNode(int x) {
        val = x;
    }
}

public int shortPath(TreeNode beginRoot, TreeNode endRoot) {
    int step = 1;
	if (beginRoot == null || endRoot == null) {
		return 0;
	}
	Set<TreeNode> beginSet = new HashSet<>({add(beginRoot)});
	Set<TreeNode> endSet = new HashSet<>({add(endRoot)});
	while (!beginSet.isEmpty() && !endSet.isEmpty()) {
		//1������ѡ��С�Ĺ�ϣ����������ǵ��������(ʵ�����ҽ���˫��ִ��)
		if(beginSet.size() > endSet.size()) {
			Set<TreeNode> tempSet = beginSet;
			beginSet = endSet;
			endSet = tempSet;
		}

		//2���������㣬�ж��Ƿ���endSet����
		Set<TreeNode> nextLevelSet = new HashSet<>();
		for (TreeNode begin : beginSet) {
			//ҵ����룬�ж�begin�Ƿ���endSet����
			if (endSet.contains(begin)) return step +1;
			//��δ���֣������һ��ڵ㣬�´μ�������
			nextLevelSet.add(begin.children);
		}
		beginSet = nextLevelSet;
		step++;
	}
	return 0;	
}