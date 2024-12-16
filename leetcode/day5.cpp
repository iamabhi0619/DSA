#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution
{
public:
    int indexFind(vector<char> roman, char c)
    {
        for (int i = 0; i < roman.size(); i++)
        {
            if (roman[i] == c)
                return i;
        }
    }
    int romanToInt(string s)
    {
        vector<char> roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        vector<int> number = {1, 5, 10, 50, 100, 500, 1000};
        int num = 0;
        for (int i = s.size() - 1; i >= 0; i--)
        {
            int temp = number[indexFind(roman, s[i])];
            if (i<s.size()-1 && temp < number[indexFind(roman, s[i+1])])                
                num = num - temp;
            else
                num = num + temp;
        }
        return num;
    }
};
int main()
{
    string str = "MCMXCIV";
    Solution result;
    int num = result.romanToInt(str);
    cout << num << endl;
    return 0;
}