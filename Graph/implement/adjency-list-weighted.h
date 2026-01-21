#include <vector>
#include <iomanip>
#include <iostream>
#include <algorithm>
#include <string>
#include <sstream>
#include <set>
#include <climits>

using namespace std;

class AdjencyListGraph
{
private:
    int V;
    vector<vector<pair<int, int>>> adjList;

    // helper to compute number of digits
    static int numWidth(int x)
    {
        if (x == 0)
            return 1;
        if (x < 0)
            x = -x;
        int w = 0;
        while (x)
        {
            w++;
            x /= 10;
        }
        return w;
    }

public:
    AdjencyListGraph(int vertices);
    bool addEdge(int u, int v, int w, bool directed = false);
    void printList() const;
    void printMatrix(bool directed = false) const;

    // new helpers
    void printEdgeList(bool directed = false) const;
    void printAsciiEdges(bool directed = false) const; // small graphs only
    string exportDOT(bool directed = false, const string &graphName = "G") const;
};

AdjencyListGraph::AdjencyListGraph(int vertices)
    : V(vertices), adjList(vertices)
{
}

bool AdjencyListGraph::addEdge(int u, int v, int w, bool directed)
{
    if (u < 0 || v < 0 || u >= V || v >= V)
        return false;
    // Store only forward edge regardless of directed flag.
    // Undirected representation is synthesized when printing (mirrored in printMatrix(false)).
    adjList[u].push_back({v, w});
    return true;
}

void AdjencyListGraph::printList() const
{
    // compute widths for alignment
    int maxNodeWidth = numWidth(max(0, V - 1));
    int maxWeight = 0;
    for (int u = 0; u < V; ++u)
        for (auto &e : adjList[u])
            maxWeight = max(maxWeight, e.second);
    int maxWeightWidth = numWidth(maxWeight);

    for (int i = 0; i < V; ++i)
    {
        int deg = (int)adjList[i].size();
        // Row header
        cout << left << setw(maxNodeWidth + 3) << ("v" + to_string(i)) << " ";
        cout << "(deg=" << setw(2) << deg << ") : ";

        // print neighbors in form -> v(weight)
        bool first = true;
        for (auto &p : adjList[i])
        {
            if (!first)
                cout << ", ";
            first = false;
            // neighbor aligned
            stringstream ss;
            ss << "-> " << "v" << p.first << "(" << p.second << ")";
            cout << ss.str();
        }
        if (deg == 0)
            cout << "empty";
        cout << "\n";
    }
}

void AdjencyListGraph::printMatrix(bool directed) const
{
    // Build matrix with sentinel for no-edge
    const int NO_EDGE = INT_MIN; // sentinel
    vector<vector<int>> mat(V, vector<int>(V, NO_EDGE));

    int maxWeight = 0;
    for (int u = 0; u < V; ++u)
    {
        for (const auto &edge : adjList[u])
        {
            mat[u][edge.first] = edge.second;
            maxWeight = max(maxWeight, edge.second);
            if (!directed)
                mat[edge.first][u] = edge.second;
        }
    }

    int cols = V;
    if (V == 0)
        return;

    // column width
    int colW = max(3, numWidth(maxWeight));
    // header spacing for row labels
    int rowLabelW = max(4, numWidth(max(0, V - 1)) + 3);

    // Print column indexes
    cout << string(rowLabelW, ' ');
    for (int j = 0; j < cols; ++j)
        cout << setw(colW + 1) << j;
    cout << "\n";

    // separator
    cout << string(rowLabelW, ' ');
    cout << string((colW + 1) * cols, '-') << "\n";

    // rows
    for (int i = 0; i < V; ++i)
    {
        cout << "v" << setw(rowLabelW - 1) << i << "|";
        for (int j = 0; j < cols; ++j)
        {
            if (mat[i][j] == NO_EDGE)
            {
                cout << setw(colW + 1) << ".";
            }
            else
            {
                cout << setw(colW + 1) << mat[i][j];
            }
        }
        cout << "\n";
    }
}

void AdjencyListGraph::printEdgeList(bool directed) const
{
    cout << "Edges:\n";
    if (!directed)
    {
        // avoid duplicate prints for undirected
        set<pair<int, int>> seen;
        for (int u = 0; u < V; ++u)
        {
            for (auto &e : adjList[u])
            {
                int v = e.first, w = e.second;
                int a = min(u, v), b = max(u, v);
                if (seen.insert({a, b}).second)
                {
                    cout << "[" << a << "] --" << w << "--> [" << b << "]\n";
                }
            }
        }
    }
    else
    {
        for (int u = 0; u < V; ++u)
        {
            for (auto &e : adjList[u])
            {
                cout << "[" << u << "] --" << e.second << "--> [" << e.first << "]\n";
            }
        }
    }
}

// Simple ascii lines for small graphs (best when V <= ~12)
void AdjencyListGraph::printAsciiEdges(bool directed) const
{
    for (int u = 0; u < V; ++u)
    {
        cout << "[" << u << "]";
        bool first = true;
        for (auto &e : adjList[u])
        {
            if (!first)
                cout << "   ";
            first = false;
            cout << " --" << e.second << "--> [" << e.first << "]";
        }
        cout << "\n";
    }
}

// Export DOT for Graphviz (save to file and render with `dot -Tpng file.dot -o out.png`)
string AdjencyListGraph::exportDOT(bool directed, const string &graphName) const
{
    stringstream ss;
    ss << (directed ? "digraph " : "graph ") << graphName << " {\n";
    ss << "  node [shape=circle];\n";
    // For undirected use --, for directed use ->
    string op = directed ? " -> " : " -- ";
    set<tuple<int, int, int>> edgeset; // avoid duplicates for undirected
    for (int u = 0; u < V; ++u)
    {
        for (auto &e : adjList[u])
        {
            int v = e.first, w = e.second;
            if (!directed)
            {
                int a = min(u, v), b = max(u, v);
                auto t = make_tuple(a, b, w);
                if (edgeset.insert(t).second)
                {
                    ss << "  " << a << op << b << " [label=\"" << w << "\"];\n";
                }
            }
            else
            {
                ss << "  " << u << op << v << " [label=\"" << w << "\"];\n";
            }
        }
    }
    ss << "}\n";
    return ss.str();
}
