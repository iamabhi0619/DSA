#include <vector>
#include <iomanip>
#include <iostream>
using namespace std;

class AdjencyListGraph
{
private:
    int V;
    vector<vector<int>> adjList;

public:
    AdjencyListGraph(int vertices);
    bool addEdge(int u, int v, bool directed = false);
    void printList() const;
    void printMatrix(bool directed = false) const;
};

AdjencyListGraph::AdjencyListGraph(int vertices)
    : V(vertices), adjList(vertices)
{
    // V initialized, adjList resized to V empty vectors
}

bool AdjencyListGraph::addEdge(int u, int v, bool directed)
{
    // Validate indices: valid range is 0 .. V-1 (zero-based indexing)
    if (u < 0 || v < 0 || u >= V || v >= V)
        return false;

    adjList[u].push_back(v);
    if (!directed)
    {
        adjList[v].push_back(u);
    }
    return true;
}

void AdjencyListGraph::printList() const
{
    int n = adjList.size();
    for (int i = 0; i < n; i++)
    {
        cout << "Vertex " << i << " -> { ";
        for (auto x : adjList[i])
            cout << x << " ";
        cout << "}\n";
    }
}

void AdjencyListGraph::printMatrix(bool directed) const
{
    // Create V x V zero-initialized matrix
    vector<vector<int>> mat(V, vector<int>(V, 0));

    // Fill matrix from adjacency list
    for (int u = 0; u < V; ++u)
    {
        for (int v : adjList[u])
        {
            mat[u][v] = 1;
            if (!directed)
                mat[v][u] = 1; // ensure symmetric for undirected graphs
        }
    }

    int rows = V, cols = V;
    if (rows == 0)
        return;

    // Print column indexes (zero-based)
    cout << "     ";
    for (int j = 0; j < cols; j++)
        cout << setw(4) << j;
    cout << endl;

    // Print separator line
    cout << "     ";
    for (int j = 0; j < cols; j++)
        cout << "----";
    cout << endl;

    // Print rows with row index
    for (int i = 0; i < rows; i++)
    {
        cout << setw(3) << i << " |";
        for (int j = 0; j < cols; j++)
            cout << setw(4) << mat[i][j];
        cout << endl;
    }
}
