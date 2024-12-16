#include <iostream>
#include <vector>
using namespace std;


int main() {
    int n;
    cin >> n;
    vector<int> v;

    // Insert elements and maintain the min-heap property
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
        int index = v.size() - 1;
        
        // After insertion, call heapify to ensure the min-heap property
        while (index > 0 && v[(index - 1) / 2] > v[index]) {
            swap(v[index], v[(index - 1) / 2]);
            index = (index - 1) / 2;
        }
    }

    // Print the min-heap
    for (auto x : v) {
        cout << x << " ";
    }

    return 0;
}
