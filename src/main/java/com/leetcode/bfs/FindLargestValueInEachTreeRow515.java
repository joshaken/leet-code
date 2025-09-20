package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindLargestValueInEachTreeRow515 {


    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        bfs(root, res, 0);
        return res;
    }

    private void bfs(TreeNode node, ArrayList<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));
        }

        bfs(node.left, res, level + 1);
        bfs(node.right, res, level + 1);


    }
    public List<Integer> largestValues1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(max);
        }
        return res;

    }
}
