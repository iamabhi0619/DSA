#include <vector>
#include <string>
using namespace std;
/*
 * @lc app=leetcode id=22 lang=cpp
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution
{
public:
    vector<string> res;
    void backtrack(string s, int n, int open, int close)
    {
        if (s.length() == 2 * n)
        {
            res.push_back(s);
            return;
        }

        if (open < n)
            backtrack(s + '(', n, open + 1, close);
        if (close < open)
            backtrack(s + ')', n, open, close + 1);
    }
    vector<string> generateParenthesis(int n)
    {
        backtrack("", n, 0, 0);
        return res;
    }
};
// @lc code=end
