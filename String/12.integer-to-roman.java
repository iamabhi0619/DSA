
import java.util.HashMap;

/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {

    public String intToRoman(int num) {

        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4,
                1
        };
        StringBuilder res = new StringBuilder();

        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1000, "M");
        mp.put(900, "CM");
        mp.put(500, "D");
        mp.put(400, "CD");
        mp.put(100, "C");
        mp.put(90, "XC");
        mp.put(50, "L");
        mp.put(40, "XL");
        mp.put(10, "X");
        mp.put(9, "IX");
        mp.put(5, "V");
        mp.put(4, "IV");
        mp.put(1, "I");

        for (int v : values) {
            while (num >= v) {
                num -= v;
                res.append(mp.get(v));
            }
        }

        return res.toString();
    }
}
// @lc code=end
