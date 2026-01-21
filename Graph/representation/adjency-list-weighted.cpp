#include "../implement/adjency-list-weighted.h"
#include <iostream>
using namespace std;

int main()
{
    AdjencyListGraph g(6);
    g.addEdge(0, 1, 2, true);
    g.addEdge(0, 2, 4, true);
    g.addEdge(1, 3, 7, true);
    g.addEdge(2, 4, 1, true);
    g.addEdge(2, 5, 3, true);

    g.printList();
    cout << "\nDirected Matrix:\n";
    g.printMatrix(true);
    cout << "\nUndirected View Matrix (mirrored):\n";
    g.printMatrix(false);
    cout << "\nDirected Edge list:\n";
    g.printEdgeList(true);
    cout << "\nDirected Ascii Edges:\n";
    g.printAsciiEdges(true);
    return 0;
}