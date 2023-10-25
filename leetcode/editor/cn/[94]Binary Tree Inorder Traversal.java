//Given the root of a binary tree, return the inorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1941 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {


//        return sol1(root);

        return sol2(root);

    }

    public static List<Integer> sol2(TreeNode root) {

        //使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
        //如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
        List<Integer> list = new ArrayList<>();
        //如果遇到的节点为灰色，则将节点的值输出。
        if (root == null) {
            return list;
        }
        int white = 0;
        int grey = 1;
        StackNode stackNode = new StackNode(white, root);
        Stack<StackNode> stack = new Stack<>();
        stack.push(stackNode);

        while (!stack.empty()) {
            StackNode cur = stack.pop();
            if (cur.node == null) {
                continue;
            }
            if (cur.color == white) {
                stack.push(new StackNode(white, cur.node.right));
                cur.color = grey;
                stack.push(cur);
                stack.push(new StackNode(white, cur.node.left));
            } else {
                list.add(cur.node.val);
            }
        }
        return list;
    }

    static class StackNode {
        int color;
        TreeNode node;

        public StackNode() {
        }

        public StackNode(int color, TreeNode node) {
            this.color = color;
            this.node = node;
        }
    }

    public static List<Integer> sol1(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(list, root);
        return list;
    }

    //中序遍历二叉树: 左,根,右
    public static void inOrder(List<Integer> list, TreeNode node) {

        if (node == null) return;
        inOrder(list, node.left);
        list.add(node.val);
        inOrder(list, node.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
