#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        vector<int> pos = {-1, -1};
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] == target)
            {
                if (pos[0] == -1)
                {
                    pos[0] = i;
                }
                pos[1] = i;
            }
        }
        return pos;
    }
};
int main()
{
    vector<int> nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    Solution result;
    vector<int> s = result.searchRange(nums, target);
    cout << s[0] << " " << s[1] << endl;
    return 0;
}