#include <iostream>
#include <vector>
#include <queue>
using namespace std;

/*
 * @lc app=leetcode id=547 lang=cpp
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution
{
public:
    int findCircleNum(vector<vector<int>> &isConnected)
    {
        int n = isConnected.size();
        if (n == 0)
            return 0;
        vector<int> visited(n, false);
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                res++;
                queue<int> q;
                visited[i] = true;
                q.push(i);
                while (!q.empty())
                {
                    int node = q.front();
                    q.pop();
                    for (int j = 0; j < n; j++)
                    {
                        if (!isConnected[node][j] == 1 && !visited[j])
                        {
                            q.push(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
};
// @lc code=end
