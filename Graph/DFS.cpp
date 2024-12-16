#include <iostream>
#include <queue>
#include <stack>
#include <algorithm>
// #include <bits/stdc++>
using namespace std;

// Perform BFS on a graph represented by an adjacency matrix
void BFS(int adjMatrix[][5],int n, int start=0) {
    cout << n << endl;
    int visted[n] = {0};
    stack<int> q;
    q.push(start);
    visted[start] = true;
    while (!q.empty())
    {
        int current = q.top();
        q.pop();
        cout << current << " ";
        for(int i=0; i<n; i++){
            if(adjMatrix[current][i]==1 && visted[i] == 0){
                q.push(i);
                visted[i] = 1;
            }
        }
    }
    cout << endl;
}

int main() {
    // Example graph with 5 vertices (0 to 4)
    int adjMatrix[][5] = {
        {0, 1, 1, 0, 0},
        {1, 0, 1, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 1, 1, 0, 1},
        {0, 0, 1, 1, 0}
    };
    int size=5;
    int startVertex = 0;
    BFS(adjMatrix,size, startVertex);

    return 0;
}
