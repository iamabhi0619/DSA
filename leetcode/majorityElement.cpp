#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution
{
public:
    int majorityElement(vector<int> &nums)
    {
        int target = 3;
        int start_index = 4;
        if (start_index >= 0 && start_index < nums.size())
        {
            auto it = find(nums.begin() + start_index, nums.end(), target);
            if (it != nums.end())
            {
                int index = distance(nums.begin(), it);
                cout << "Element found at index: " << index << endl;
            }
            else
            {
                cout << "Element not found after index " << start_index << endl;
            }
        }
        else
        {
            cout << "Invalid start index" << endl;
        }
        auto num = nums.begin();
        cout << 1 << endl;
        return 0;
    }
};
int main()
{
    vector<int> arr = {1, 2, 3, 4, 5};
    Solution result;
    result.majorityElement(arr);
    return 0;
}