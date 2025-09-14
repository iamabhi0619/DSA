#include <vector>
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
    void help(vector<int> &nums, int target, int left, int right)
    {
        if (left > right)
            return;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target)
        {
            if (res[0] == -1 || mid < res[0])
                res[0] = mid;
            if (res[1] == -1 || mid > res[1])
                res[1] = mid;

            help(nums, target, left, mid - 1);
            help(nums, target, mid + 1, right);
        }
        if (target > nums[mid])
            help(nums, target, mid + 1, right);
        else
            help(nums, target, left, mid - 1);
    }
    vector<int> searchRange(vector<int> &nums, int target)
    {
        help(nums, target, 0, nums.size() - 1);
        return res;
    }
};
// @lc code=end
