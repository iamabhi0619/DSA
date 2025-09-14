#include <vector>;
using namespace std;
/*
 * @lc app=leetcode id=39 lang=cpp
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
public:
    void backtrack(int index, vector<int>& can, vector<int>& path, int target,
                   vector<vector<int>>& res) {
        if (target == 0) {
            res.push_back(path);
            return;
        }

        if (target < 0 || index >= can.size())
            return;

        path.push_back(can[index]);
        backtrack(index, can, path, target-can[index], res);
        path.pop_back();

        backtrack(index + 1, can, path, target, res);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> path;

        backtrack(0, candidates, path, target, res);

        return res;
    }
};
// @lc code=end
