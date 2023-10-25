//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively?
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2565 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isSymmetric(TreeNode root) {
//        return sol1(root);
        return sol2(root);
    }

    public boolean sol2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.pop();
            TreeNode right = queue.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }


        return true;
    }

    public boolean sol1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recurseEquals(root.left, root.right);
    }

    //left 和 right 不等，或者 left 和 right 都为空
    //递归的比较 left.left 和 right.right，递归比较 left.right 和 right.left
    public boolean recurseEquals(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        // 或者两个节点中有一个为空
        // 或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        //这里可以直接比较两个节点的值
        if (left.val != right.val){
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        // 以及比较 左节点的右孩子 和 右节点的左孩子
        return recurseEquals(left.left, right.right) && recurseEquals(left.right, right.left);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
