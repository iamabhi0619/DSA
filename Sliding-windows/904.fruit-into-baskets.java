/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 0)
            return 0;
        if (fruits.length == 1)
            return 1;
        if (fruits.length == 2)
            return 2;

        int type1 = fruits[0], type2 = fruits[1];
        int count1 = 1, count2 = 1;

        int lastFruit = fruits[1];
        int lastCount = 0;

        int max = 0;

        for (int i = 2; i < fruits.length; i++) {
            int f = fruits[i];
            if (f == type1) {
                count1++;
            } else if (f == type2) {
                count2++;
            } else {
                if (lastFruit == type1) {
                    type2 = f;
                    count2 = 1;
                    count1 = lastCount;
                } else {
                    type1 = f;
                    count1 = 1;
                    count2 = lastCount;
                }
            }

            if (f == lastFruit) {
                lastCount++;
            } else {
                lastFruit = f;
                lastCount = 1;
            }

            max = Math.max(max, count1 + count2);
        }

        return max;
    }
}

// @lc code=end
