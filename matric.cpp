#include <iostream>
using namespace std;

int main()
{
    int row, col;
    cin >> row >> col;
    if (row >= col)
    {
        if (row % 2 == 0)
        {
            cout << (row * row) + (col - 1) << endl;
        }
        else
        {
            cout << (((row-1) * (row-1))+1) + (col-1) << endl;
        }
    }
    else
    {
        if (col % 2 == 0)
        {
            cout << (((col-1) * (col-1))+1) + (row-1) << endl;
        }
        else
        {
            cout << (col * col) - (row - 1) << endl;
        }
    }

    return 0;
}