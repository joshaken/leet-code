package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathSum437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return path(root, 0, targetSum, prefix);
    }

    private int path(TreeNode root, long cur, int targetSum, HashMap<Long, Integer> prefix) {

        if (root == null) {
            return 0;
        }
        cur = root.val + cur;
        //这里通过 cur - targetSum 的值如果在map中有值说明前面 有加入
        Integer count = prefix.getOrDefault(cur - targetSum, 0);

        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);

        count = count + path(root.left, cur, targetSum, prefix);
        count = count + path(root.right, cur, targetSum, prefix);

        prefix.put(cur, prefix.get(cur) - 1);

        return count;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        return pathHelper(root, new ArrayList<>(), targetSum);
    }

    private int pathHelper(TreeNode root, List<Long> list, int target) {
        if (root == null) {
            return 0;
        }
        long sum = 0;
        int count = 0;
        list.add((long) root.val);

        for (int i = list.size() - 1; i >= 0; i--) {
            sum = sum + list.get(i);
            if (sum == target) {
                count++;
            }
        }

        count = count + pathHelper(root.left, list, target);
        count = count + pathHelper(root.right, list, target);

        list.remove(list.size() - 1);

        return count;
    }
}
