
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                stack.push(ch);
            } else if (ch == '(' || ch == '{' || ch == '[') {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if ((ch == '(' && top == ')') ||
                        (ch == '{' && top == '}') ||
                        (ch == '[' && top == ']')) {
                    stack.pop();
                } else
                    return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
