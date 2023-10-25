//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// Every close bracket has a corresponding open bracket of the same type. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
//
// Related Topics 栈 字符串 👍 4206 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        return sol1(s);
    }

    static boolean sol1(String s) {
        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i] + "")) {
                stack.push(chars[i] + "");
                continue;
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (!(chars[i] + "").equals(map.get(stack.pop()))) {
                    return false;
                }
            }

        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
