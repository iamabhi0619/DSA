#include <iostream>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    int graph[n+1][n+1];
    for (int i = 0; i < m; i++)
    {
        int x,y;
        cin >> x >> y;
        graph[x][y] = 1;
        graph[y][x] = 1;
    }
    

}