#include <iostream>
using namespace std;
int sumOfNumber(int n){
    if(n<=0) return 0;
    return n+sumOfNumber(n-1);
}
int main()
{
    int result = sumOfNumber(3);
    cout << result << endl;
    return 0;
}
