#include "implement/undirected-unweighted-mat.h"
#include <iostream>
using namespace std;

int main()
{
    int n;
    cout << "Enter the number of vertices: " << endl;
    cin >> n;
    const auto graph = new UndirectedUnweightedMatrix(n);
    while (true)
    {
        int u, v;
        cout << "Enter edge (u v) or -1 -1 to stop: " << endl;
        cin >> u >> v;
        if (u == -1 && v == -1)
        {
            break;
        }
        if (!graph->addEdge(u, v))
        {
            cout << "Invalid edge. Please try again." << endl;
        }
    }

    cout << "Adjacency Matrix:" << endl;
    graph->print();
    return 0;
}