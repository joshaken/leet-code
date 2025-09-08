package com.leetcode.dfs;

public class BinaryTreeMaxPathSum124 {

    private int maxSum = Integer.MIN_VALUE; // 全局最大路径和

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // 递归左、右子树单边最大路径和
        int left = Math.max(dfs(node.left), 0);   // <0的路径舍弃
        int right = Math.max(dfs(node.right), 0); // <0的路径舍弃

        // 当前节点跨左右子树的最大路径和
        int currentMax = node.val + left + right;

        // 更新全局最大值
        maxSum = Math.max(maxSum, currentMax);

        // 返回单边最大路径和给父节点
        return node.val + Math.max(left, right);
    }
}
