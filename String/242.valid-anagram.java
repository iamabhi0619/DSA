/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[27];
        for(int i=0; i<s.length(); i++){
            frequency[(int)s.charAt(i) - 97]++;
        }
        for(int i=0; i<t.length(); i++){
            frequency[(int)t.charAt(i) - 97]--;
        }
        for(int i=0; i<24; i++){
            if(frequency[i]!=0) return false;
        }
        return true;
    }
}
// @lc code=end

