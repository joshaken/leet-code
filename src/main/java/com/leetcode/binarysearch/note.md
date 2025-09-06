二分查找（Binary Search）是 LeetCode 上的经典考点，相关题目非常多，不仅仅是「标准二分」，还涉及「答案二分」「旋转数组」「二维矩阵」等扩展。下面我帮你整理一份常见、分层次的题单（含题号和题目名称）：

---

## 🟢 基础二分（模板题）

1. [704. Binary Search](https://leetcode.com/problems/binary-search/) - 标准二分查找
2. [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/) - 找插入位置
3. [69. Sqrt(x)](https://leetcode.com/problems/sqrtx/) - 用二分求平方根
4. [367. Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/) - 判断完全平方数

---

## 🟡 进阶二分（边界查找）

5. [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
6. [278. First Bad Version](https://leetcode.com/problems/first-bad-version/)
7. [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)
8. [852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

---

## 🔵 旋转数组 & 变种

9. [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
10. [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
11. [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
12. [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)

---

## 🟣 答案二分（Binary Search on Answer）

13. [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)
14. [240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)
15. [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
16. [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
17. [410. Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)
18. [378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
19. [668. Kth Smallest Number in Multiplication Table](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/)
20. [719. Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/)

---

## ⚫ 综合难题

21. [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) - 经典 hard
22. [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/) - 处理重复
23. [887. Super Egg Drop](https://leetcode.com/problems/super-egg-drop/) - DP + 二分优化
24. [1622. Fancy Sequence](https://leetcode.com/problems/fancy-sequence/) - 思维难度较大

---

📌 建议刷题顺序：

* 入门练习：704 → 35 → 69 → 367
* 边界查找：34 → 278 → 162
* 旋转数组：33 → 81 → 153 → 154
* 答案二分：875 → 1011 → 410
* 综合：4 → 378 → 719



二分查找的核心点
int mid = (left + right) / 2;
int mid = left + (right - left) / 2; //(这种写法是为了避免数值溢出)
保证左分区的数字一直在中位数里面
中位数等于 二分之后+左分区的范围
