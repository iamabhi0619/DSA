#include <iostream>
using namespace std;

void conquer(int arr[], int left, int mid, int right)
{
    int flag = right - left + 1;
    int temp[flag];
    int arr1 = left;
    int arr2 = mid + 1;
    int count = 0;
    while (arr1<=mid && arr2<=right)
    {
        if (arr[arr1] < arr[arr2])
        {
            temp[count++] = arr[arr1++];
        }else{
            temp[count++] = arr[arr2++];
        }
    }
    while (arr1<=mid)
    {
        temp[count++] = arr[arr1++];
    }
    while (arr2<=right)
    {
        temp[count++] = arr[arr2++];
    }
    for (int i = 0; i < count; i++)
    {
        arr[left+i] = temp[i];
    }
    
}
void divide(int arr[], int left, int right)
{
    if (left >= right)
        return;
    int mid = (left + right) / 2;
    divide(arr, left, mid);
    divide(arr, mid + 1, right);
    conquer(arr, left, mid, right);
}

int main()
{
    int arr[] = {15, 98, 22, 10, 11, 23};
    int n = 6;
    divide(arr, 0, n-1);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
