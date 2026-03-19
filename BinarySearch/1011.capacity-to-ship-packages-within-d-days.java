/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {

  public int noOfDaysRequired(int[] weights, int capacity) {
    int days = 1;
    int currentLoad = 0;

    for (int weight : weights) {
        if (currentLoad + weight > capacity) {
            days++;
            currentLoad = 0;
        }
        currentLoad += weight;
    }
    return days;
}



    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }
        while (minCapacity < maxCapacity) {
            int mid = minCapacity + (maxCapacity - minCapacity) / 2;
            int daysRequired = noOfDaysRequired(weights, mid);

            if (daysRequired > days) {
                minCapacity = mid + 1;
            } else {
                maxCapacity = mid;
            }
        }
        return minCapacity;
    }
}
// @lc code=end

