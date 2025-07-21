#include <iostream>
#include <chrono>
#include <vector>

using namespace std;
using namespace std::chrono;

using namespace std;

int knapsack(vector<int> &wt, vector<int> &val, int w, int n)
{
    if (n == 0 || w == 0)
        return 0;
    if (wt[n - 1] > w)
        return knapsack(wt, val, w, n - 1);
    if (wt[n - 1] <= w)
        return max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n), knapsack(wt, val, w, n - 1));
    return 0; // This line is unreachable but added to avoid compiler warnings
}

int main()
{

    // Code Goes here
    int n = 10;
    int w = 100;
    vector<int> wt(n), val(n);
    for (int i = 0; i < n; i++)
    {
        wt[i] = i + 1;
        val[i] = n - i;
    }
    // Start measuring time
    auto start = high_resolution_clock::now();

    int result = knapsack(wt, val, w, n);
    cout << "Max Value: " << result << endl;

    // End measuring time
    auto end = high_resolution_clock::now();
    // Calculate the duration
    auto duration = duration_cast<microseconds>(end - start);
    // Print duration in microseconds and milliseconds
    cout << "Execution time: " << duration.count() << " microseconds" << endl;
    cout << "Execution time: " << duration.count() / 1000.0 << " milliseconds" << endl;

    return 0;
}
