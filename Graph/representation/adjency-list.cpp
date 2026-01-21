#include "../implement/adjency-list.h"
#include <iostream>
using namespace std;

int main()
{
    int n;
    cout << "Enter the number of vertices: " << endl;
    cin >> n;
    const auto graph = new AdjencyListGraph(n);
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
    graph->printList();

    cout << endl;
    cout << endl;
    cout << endl;
    cout << endl;
    cout << endl;
    cout << endl;

    graph->printMatrix();
}