#include "../implement/undirected-weighted-mat.h"
#include <iostream>
using namespace std;

int main()
{
    int n;
    cout << "Enter the number of vertices: " << endl;
    cin >> n;
    const auto graph = new UndirectedWeightedMatrix(n);
    while (true)
    {
        int u, v, weight;
        cout << "Enter edge (u v weight) or -1 -1 -1 to stop: " << endl;
        cin >> u >> v >> weight;
        if (u == -1 && v == -1 && weight == -1)
        {
            break;
        }
        if (!graph->addEdge(u, v, weight))
        {
            cout << "Invalid edge. Please try again." << endl;
        }
    }

    cout << "Adjacency Matrix:" << endl;
    graph->print();
    return 0;
}