/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] occurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            occurrence[ch - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(occurrence[ch-'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end
