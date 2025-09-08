package com.leetcode.dfs;


//找出最小公共父类 LCA

public class LCAofBinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //1.如果当前节点是空，返回null
        // 2.如果找到了这个节点，就返回这个节点
        // 就上面这两个条件 可以保证至少会有一个节点被找到
        if (root == null || root == p || root == q) {
            return root;
        }

        //这里可以拿到当前节点的左右子树中是否有目标值
        //那么就会出现两种情况
        //1.是左右其中一个有值，那么有值的这个就是LCA
        //2.左右都有值，那个当前节点就是LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }


}
