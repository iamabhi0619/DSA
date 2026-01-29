/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if((int)s.charAt(i) >=97 || (int)s.charAt(i) <= 114) str.append(s.charAt(i));
        }
        System.out.println(str);
        return true;
    }
}
// @lc code=end