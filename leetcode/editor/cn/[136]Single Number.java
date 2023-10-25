//Given a non-empty array of integers nums, every element appears twice except 
//for one. Find that single one. 
//
// You must implement a solution with a linear runtime complexity and use only 
//constant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// 
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// 
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
//
// Related Topics 位运算 数组 👍 3040 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        //异或运算有个重要的性质，两个相同数字异或为 000 ，即对于任意整数 aaa 有 a⊕a=0a \oplus a = 0a⊕a=0 。因此，若将 numsnumsnums 中所有数字执行异或运算，留下的结果则为 出现一次的数字 xxx
        //异或运算满足交换律 a⊕b=b⊕aa \oplus b = b \oplus aa⊕b=b⊕a ，即以上运算结果与 numsnumsnums 的元素顺序无关
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
