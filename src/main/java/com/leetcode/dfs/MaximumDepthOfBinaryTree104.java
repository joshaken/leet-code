package com.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.Stack;

public class MaximumDepthOfBinaryTree104 {
    //DFS
    public int maxDepth(TreeNode root) {
//        Stack<Integer> integers = new Stack<>();
//        ArrayDeque<Object> deque = new ArrayDeque<>();

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    //BFS
    public int maxDepth2(TreeNode root) {
//        Stack<Integer> integers = new Stack<>();
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            depth++;
            int size = stack.size();

            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    stack.addLast(pop.left);
                }
                if (pop.right != null) {
                    stack.addLast(pop.right);
                }
            }
        }

        return depth;
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
