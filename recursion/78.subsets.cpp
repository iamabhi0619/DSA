#include <vector>
using namespace std;
/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> res;
    void backtrack(int index, vector<int> &nums, vector<int> &subSet)
    {
        if (index == nums.size())
        {
            res.push_back(subSet);
            return;
        }
        subSet.push_back(nums[index]);
        backtrack(index + 1, nums, subSet);
        subSet.pop_back();

        backtrack(index + 1, nums, subSet);
    }
    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<int> subSet;
        backtrack(0, nums, subSet);
        return res;
    }
};
// @lc code=end
