/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {


    int findMaxElement(int[] arr){
        int max = arr[0];
        for(int a: arr){
            if(a>max){
                max = a;
            }
        }
        return max;
    }

    boolean isTheTimePossible(int[] piles, int speed, int givenSpeed){
        int sum = 0;
        for(int pile: piles){
            sum += (pile+speed-1) / speed;
        }
        return sum <= givenSpeed;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lowSpeed = 1;
        int highSpeed = findMaxElement(piles);
        while (lowSpeed < highSpeed)
        {
            int mid = lowSpeed + (highSpeed - lowSpeed) / 2;
            if (isTheTimePossible(piles, mid, h))
                highSpeed = mid; // I have to find the minimum speed
            else
                lowSpeed = mid + 1; // Speed krna hoga eating
        }
        return lowSpeed;
    }
}
// @lc code=end

