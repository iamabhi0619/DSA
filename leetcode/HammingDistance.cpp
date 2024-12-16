#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution
{
public:
    vector<int> toBinary(int x, int size = 0)
    {
        vector<int> binary(size, 0);
        while (x != 0)
        {
            binary.push_back(x % 2);
            x = x / 2;
        }
        reverse(binary.begin(), binary.end());
        return binary;
    }
    vector<int> padBinary(vector<int> binary, int length)
    {
        while (binary.size() < length)
        {
            binary.insert(binary.begin(), 0);
        }
        return binary;
    }
    int hammingDistance(int x, int y)
    {
        int count = 0;
        vector<int> xBinary = toBinary(x);
        vector<int> yBinary = toBinary(y);
        int maxLength = max(xBinary.size(), yBinary.size());
        xBinary = padBinary(xBinary, maxLength);
        yBinary = padBinary(yBinary, maxLength);
        for (int i = 0; i < xBinary.size(); i++)
        {
            cout << xBinary[i] << " ";
        }
        cout << endl ;
        for (int i = 0; i < yBinary.size(); i++)
        {
            cout << yBinary[i] <<" ";
        }
        cout << endl ;
        for (int i = 0; i < xBinary.size(); i++)
        {
            if (xBinary[i] != yBinary[i])
            {
                count++;
            }
        }

        return count;
    }
};
int main()
{
    int x = 1, y = 4;
    Solution result;
    int ch = result.hammingDistance(x, y);
    cout << ch << endl;
    return 0;
}