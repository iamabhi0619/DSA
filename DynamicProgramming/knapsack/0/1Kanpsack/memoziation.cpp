#include <iostream>
#include <chrono>
#include <cstring>
#include <vector>

using namespace std;
using namespace std::chrono;

const int MAX_N = 100;  // Maximum number of items
const int MAX_W = 1000; // Maximum weight capacity
int dp[MAX_N][MAX_W];

int knapsack(vector<int> &wt, vector<int> &val, int w, int n)
{
    if (n == 0 || w == 0)
        return 0;
    if (dp[n][w] != -1)
        return dp[n][w];

    if (wt[n - 1] <= w)
    {
        dp[n][w] = max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
    }
    if (wt[n - 1] > w)
    {
        dp[n][w] = knapsack(wt, val, w, n - 1);
    }
    return dp[n][w];
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
    memset(dp, -1, sizeof(dp));
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
