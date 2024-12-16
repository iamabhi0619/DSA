#include <bits/stdc++.h>
#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int min=prices[1], max=prices[1];
        for (int i = 1; i < prices.size(); i++)
        {
            if(prices[i]<min){
                min = prices[i];
            }
            else if (max<prices[i+1])
            {
                max= prices[i+1];
            }
            else{
                continue;
            }
        }
        return max-min;
    }
};
int main()
{
    vector<int> p = {7,1,5,3,6,4};
    Solution result;
    int ch = result.maxProfit(p);
    cout << ch << endl;
    return 0;
}