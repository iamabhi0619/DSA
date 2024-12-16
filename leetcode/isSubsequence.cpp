#include <iostream>
#include <string>
using namespace std;
class Solution
{
public:
    // bool isPresent(string &t, char c){
    //     for (int i = 0; i < t.size(); i++)
    //     {
    //         cout << t << endl;
    //         if (t[i] == c)
    //         {
    //             t=t.substr(0,i);
    //             cout << t << endl;
    //             return true;
    //         }
    //     }
    //     return false;
        
    // }
    bool isSubsequence(string s, string t){
        int sindex=0, tindex=0;
        while (sindex<s.size() && tindex<t.size())
        {
            if (s[sindex]==t[tindex])
            {
                sindex++;
            }
            tindex++;
        }
        return sindex==s.size();
    }
};
int main()
{
    string s="abc";
    string t="ahbgdc";
    Solution result;
    bool check = result.isSubsequence(s,t);
    cout << check << endl;
    return 0;
}