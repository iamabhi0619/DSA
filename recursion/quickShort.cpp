#include <iostream>
using namespace std;

int part(int arr[], int left, int right){
    int pivot = arr[right];
    int track = left-1;
    for (int i = left; i < right; i++)
    {
       if (arr[i] < pivot)
       {
        track++;
        //swap
        int temp = arr[i];
        arr[i] = arr[track];
        arr[track] = temp;
       }
    }
    track++;
    int temp = arr[track];
    arr[track] = pivot;
    arr[right] = temp;
    return track;
}

void quickShort(int arr[], int left, int right){
    if(left > right) return;
    int pidx = part(arr, left, right);
    quickShort(arr, left, pidx-1);
    quickShort(arr, pidx+1, right);
}


int main()
{
    int arr[] = {15, 98, 22, 10, 11, 23};
    int n = 6;
    quickShort(arr, 0, n-1);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
    return 0;
}
