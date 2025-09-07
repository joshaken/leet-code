package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        ArrayList<List<Integer>> lists = new ArrayList<>();

        getPaths(lists, new ArrayList<>(), root, targetSum);
        return lists;
    }

    private void getPaths(ArrayList<List<Integer>> output, List<Integer> currentPath, TreeNode root, int targetSum) {

        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                output.add(new ArrayList<>(currentPath));
            }
//            return;
        }

        getPaths(output, currentPath, root.left, targetSum);
        getPaths(output, currentPath, root.right, targetSum);

        currentPath.remove(currentPath.size() - 1);
    }
}
