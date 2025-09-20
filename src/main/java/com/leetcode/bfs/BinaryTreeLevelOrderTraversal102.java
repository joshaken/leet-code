package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> line = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();

                line.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(line);

        }
        return res;
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();


        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            ArrayList<Integer> line = new ArrayList<>();
            list.forEach(n -> {
                line.add(n.val);
                queue.addLast(n);
            });
            res.add(line);
            list.clear();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    list.add(node.left);
                }
                if (node != null && node.right != null) {
                    list.add(node.right);
                }
            }
        }

        return res;
    }
}
