#include <iostream>
using namespace std;
int xn(int x, int n)
{
    if (n <= 0)
    {
        return 1;
    }
    if (x == 0)
    {
        return 0;
    }

    return x * xn(x, n - 1);
}

long int xn2(int x, int n)
{
    if (n == 0)
    {
        return 1;
    }
    if (x == 0)
    {
        return 0;
    }
    if (n%2==0)
    {
        return xn2(x, n/2) * xn2(x, n/2);
    }else{
         return xn2(x, n/2) * xn2(x, n/2) * x;
    }
    
}

int main()
{
    long int result = xn2(16, 7);
    cout << result << endl;
    return 0;
}
