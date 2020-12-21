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
		//1、优先选择小的哈希表遍历，考虑的情况更少(实现左右交替双向执行)
		if(beginSet.size() > endSet.size()) {
			Set<TreeNode> tempSet = beginSet;
			beginSet = endSet;
			endSet = tempSet;
		}

		//2、遍历本层，判断是否与endSet相碰
		Set<TreeNode> nextLevelSet = new HashSet<>();
		for (TreeNode begin : beginSet) {
			//业务代码，判断begin是否在endSet出现
			if (endSet.contains(begin)) return step +1;
			//若未出现，添加下一层节点，下次继续遍历
			nextLevelSet.add(begin.children);
		}
		beginSet = nextLevelSet;
		step++;
	}
	return 0;	
}