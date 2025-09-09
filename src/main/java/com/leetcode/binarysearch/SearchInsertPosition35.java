package com.leetcode.binarysearch;



public class SearchInsertPosition35 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ints = new int[]{1,  3};
//        int[] ints = new int[]{1, 3, 5, 6};
        int i = solution.searchInsert(ints, 2);
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;
            //关键在退出的条件是 right < left
            //循环结束时，left 的取值范围是 0 到 nums.length
            //0：表示目标比数组中所有元素都小，应该插入最前面
            //nums.length：表示目标比数组中所有元素都大，应该插入最后面
            //中间的值：表示目标应该插入数组中间某个位置，
            //          因为在退出循环之前是 left == right,然后是right-1,
            //          正确的位置就应该在left所在的位置上，left及之后的数字应该后移
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;

        }
    }
}
