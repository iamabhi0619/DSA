#include <vector>;
using namespace std;
/*
 * @lc app=leetcode id=34 lang=cpp
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution
{
public:
    vector<int> res = {-1, -1};
    void binarySearch(vector<int> &nums, int start, int end, int target)
    {
        if (start > end)
            return;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
        {
            if (res[0] == -1 || mid < res[0])
                res[0] = mid;
            if (res[1] == -1 || mid > res[1])
                res[1] = mid;
            binarySearch(nums, start, mid - 1, target);
            binarySearch(nums, mid + 1, end, target);
        }
        else if (target > nums[mid])
            binarySearch(nums, mid + 1, end, target);
        else
            binarySearch(nums, start, mid - 1, target);
    }
    vector<int> searchRange(vector<int> &nums, int target)
    {
        binarySearch(nums, 0, nums.size() - 1, target);
        return res;
    }
};
// @lc code=end
