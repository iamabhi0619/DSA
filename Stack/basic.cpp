#include <iostream>
#include <vector>
using namespace std;
class stack
{
public:
    int stackSize;
    vector<int> arr = {};
    int curr = 0;
    stack(int n)
    {
        stackSize = n;
        arr.resize(n);
    }
    void push(int n)
    {
        if (!isFull())
        {
            arr[curr] = n;
            curr++;
        }
        else
        {
            cout << "Stack is full" << endl;
        }
    }
    void pop(){
        if (isEmpty())
        {
            cout << "No element in Stack..!!";
        }else{
            arr.pop_back();
            curr--;
        }
        
    }
    bool isFull()
    {
        return curr == stackSize;
    }
    bool isEmpty()
    {
        return curr == 0;
    }
    void print()
    {
        cout << "Stack Element:- ";
        for (int i = 0; i < curr; i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};
int main()
{
    stack s1(4);
    for (int i = 0; i < 6; i++)
    {
        int temp;
        cin >> temp;
        s1.push(temp);
    }
    s1.print();
    s1.pop();
    s1.print();
    return 0;
}
