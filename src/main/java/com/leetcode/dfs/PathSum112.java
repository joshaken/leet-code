package com.leetcode.dfs;

import java.util.ArrayDeque;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        //叶子节点
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    }


}
