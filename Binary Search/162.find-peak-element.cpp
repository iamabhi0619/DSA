#include <vector>
using namespace std;
/*
 * @lc app=leetcode id=162 lang=cpp
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution
{
public:
    int findPeakElement(vector<int> &nums)
    {
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        while (start < end)
        {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
};
// @lc code=end
