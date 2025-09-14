
#include <vector>
using namespace std;
/*
 * @lc app=leetcode id=704 lang=cpp
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution
{
public:
    int help(vector<int> nums, int left, int right, int target)
    {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target)
            return mid;
        if (target > nums[mid])
            return help(nums, mid + 1, right, target);
        else
            return help(nums, left, mid - 1, target);
    }
    int search(vector<int> &nums, int target)
    {
        return help(nums, 0, nums.size() - 1, target);
    }
};
// @lc code=end
