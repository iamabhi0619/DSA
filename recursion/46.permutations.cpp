#include <vector>
using namespace std;
/*
 * @lc app=leetcode id=46 lang=cpp
 *
 * [46] Permutations
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> res;
    void backtrack(vector<int> &nums, vector<int> &curr, vector<bool> &used)
    {
        if (curr.size() == nums.size())
        {
            res.push_back(curr);
            return;
        }

        for (int i = 0; i < nums.size(); i++)
        {
            if (used[i])
                continue;
            curr.push_back(nums[i]);
            used[i] = true;

            backtrack(nums, curr, used);

            curr.pop_back();
            used[i] = false;
        }
    }
    vector<vector<int>> permute(vector<int> &nums)
    {
        vector<int> curr;
        vector<bool> used(nums.size(), false);

        backtrack(nums, curr, used);

        return res;
    }
};
// @lc code=end
