/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //1¡¢µÝ¹é
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     inorder(root, result);
    //     return result;
    // }

    // public void inorder(TreeNode root, List<Integer> result){
    //     if (root == null){
    //         return;
    //     }
    //     inorder(root.left, result);
    //     result.add(root.val);
    //     inorder(root.right, result);
    // }

    //2¡¢Õ»
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}