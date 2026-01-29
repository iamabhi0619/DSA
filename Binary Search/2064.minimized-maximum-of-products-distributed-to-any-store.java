/*
 * @lc app=leetcode id=2064 lang=java
 *
 * [2064] Minimized Maximum of Products Distributed to Any Store
 */

// @lc code=start
class Solution {
    public int PossibleItems(int[] quantities, int numberOfItems){
        int items = 0;
        for(int quantity: quantities){
            items += (quantity+numberOfItems-1)/numberOfItems;
        }
        return items;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int minNumberOfProduct = 1;
        int maxNumberOfProduct = 0;
        for(int quantity : quantities){
            maxNumberOfProduct = Math.max(quantity, maxNumberOfProduct);
        }
        while(minNumberOfProduct < maxNumberOfProduct){
            int mid = minNumberOfProduct + (maxNumberOfProduct-minNumberOfProduct)/2;
            int numberOfItems = PossibleItems(quantities, mid);
            if( numberOfItems <= n ){
                maxNumberOfProduct = mid;
            }else{
                minNumberOfProduct = mid+1;
            }
        }
        return minNumberOfProduct;
    }
}
// @lc code=end

