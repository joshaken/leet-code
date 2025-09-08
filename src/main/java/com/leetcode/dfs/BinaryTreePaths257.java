package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> result = new ArrayList<>();
        pathHelper(root, result, new ArrayList<>());
        return result;
    }

    private void pathHelper(TreeNode root, ArrayList<String> result, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            result.add(path.stream().map(String::valueOf).collect(Collectors.joining("->")));
        }

        pathHelper(root.left, result, path);
        pathHelper(root.right, result, path);

        path.remove(path.size() - 1);
    }
}
