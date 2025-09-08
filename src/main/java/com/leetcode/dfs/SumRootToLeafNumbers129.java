package com.leetcode.dfs;

import java.util.ArrayList;

public class SumRootToLeafNumbers129 {
    public int sumNumbers(TreeNode root) {
        return sum2(root, 0);
    }

    private int sum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return sum2(root.left, sum) + sum2(root.right, sum);
    }


    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        sumHelper(root, new StringBuilder(), arrayList);
        return arrayList.stream().mapToInt(Long::intValue).sum();
    }

    private void sumHelper(TreeNode root, StringBuilder sb, ArrayList<Long> arrayList) {

        if (root == null) {
            return;
        }
        int sbLen = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            arrayList.add(Long.valueOf(sb.toString()));
        }

        sumHelper(root.left, sb, arrayList);
        sumHelper(root.right, sb, arrayList);

        sb.setLength(sbLen);
    }
}
