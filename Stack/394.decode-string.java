
import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currString = "";
        int currNumber = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currNumber = currNumber * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(currNumber);
                stringStack.push(currString);
                currNumber = 0;
                currString = "";
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                String prevStr = stringStack.pop();

                StringBuilder temp = new StringBuilder(prevStr);
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currString);
                }
                currString = temp.toString();
            } else {
                currString += ch;
            }
        }

        return currString;
    }
}
// @lc code=end
