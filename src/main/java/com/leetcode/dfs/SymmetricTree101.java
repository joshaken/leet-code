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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
