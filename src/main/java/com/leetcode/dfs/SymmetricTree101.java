package com.leetcode.dfs;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left);
        }
        return false;
    }


}
