#include <iostream>
#include <string>
using namespace std;
class Solution
{
public:
    int getLucky(string s, int k)
    {
        // int c = s[0];
        int sum = 0;
        string num = "";
        for (int i = 0; i < s.size(); i++)
        {
            num = num + to_string(s[i] - 'a' + 1);
        }
        cout << num << endl;

        while (k != 0)
        {
            for (int i = 0; i < num.size(); i++)
            {
                cout << sum << " + " << (num[i] - '0') << sum + (num[i] - '0') << endl ;
                sum = sum + (num[i] - '0');
            }
            num = to_string(sum);
            cout << num << endl;
            sum = 0;
            k--;
        }
        cout << num << endl;
        // cout << s << " " << k << endl;
    }
};
int main()
{
    string s = "leetcode";
    Solution sol;
    sol.getLucky(s, 2);
    return 0;
}