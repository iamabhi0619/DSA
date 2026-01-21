#include <iostream>
#include <vector>
#include <iomanip>

using namespace std;

class UndirectedUnweightedMatrix
{
private:
    vector<vector<bool>> adjMatrix;

public:
    UndirectedUnweightedMatrix(int size);
    bool addEdge(int u, int v);
    void print();
};

UndirectedUnweightedMatrix::UndirectedUnweightedMatrix(int size)
{
    // size + 1 to accommodate 1-based indexing (indices 1 to size)
    adjMatrix.resize(size + 1, vector<bool>(size + 1, false));
}

bool UndirectedUnweightedMatrix::addEdge(int u, int v)
{
    int size = adjMatrix.size() - 1; // Actual number of vertices (excluding index 0)
    if (u > size || v > size || u < 1 || v < 1)
    {
        return false;
    }
    adjMatrix[u][v] = true;
    adjMatrix[v][u] = true;
    return true;
}
void UndirectedUnweightedMatrix::print()
{
    int rows = adjMatrix.size();
    if (rows == 0)
        return;
    int cols = adjMatrix[0].size();

    // Print column indexes (1-based, skip 0)
    cout << "     ";
    for (int j = 1; j < cols; j++)
        cout << setw(4) << j;
    cout << endl;

    // Print separator line
    cout << "     ";
    for (int j = 1; j < cols; j++)
        cout << "----";
    cout << endl;

    // Print rows with row index (1-based, skip 0)
    for (int i = 1; i < rows; i++)
    {
        cout << setw(3) << i << " |"; // Row index
        for (int j = 1; j < cols; j++)
            cout << setw(4) << adjMatrix[i][j];
        cout << endl;
    }
}