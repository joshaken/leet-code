package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, new ArrayList<Integer>(), new boolean[nums.length], result);

        return result;
    }

    private void dfs(int[] nums, ArrayList<Integer> tempList, boolean[] used, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;

            dfs(nums, tempList, used, result);

            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }

    }
}
