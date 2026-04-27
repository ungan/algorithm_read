#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
#include<bits/stdc++.h>

using namespace std;

//const int MAX = 1000;
vector <int>* graph;
int* counts;
bool* visited;
int depth=1;
void dfs(int node){
    visited[node] = true;
    counts[node] = depth++;
    
    for(int next : graph[node]){
        if(!visited[next]){
            dfs(next);
        }
    }
}

int main()
{
    int n, m, start;
    scanf("%d %d %d", &n, &m, &start);

    graph = new vector<int>[n+1];
    counts = new int[n+1];
    visited = new bool[n+1]();
    fill(counts,counts +n+1,0);

    for(int i=0; i<m; i++){
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for(int i=1; i<=n; i++)
    {
        sort(graph[i].begin(),graph[i].end());
    }

    stack<int> s;
    s.push(start);

    while(!s.empty())
    {
        int node = s.top();
        s.pop();

        if(visited[node]) continue;

        visited[node] = true;
        counts[node] = depth++;

        for(int i=graph[node].size() - 1; i>= 0; i--){
            int next = graph[node][i];
            if(!visited[next]) s.push(next);
        }
    }

    for (int i = 1; i <= n; i++) {
        printf("%d\n", counts[i]); // 0 = 닿지 않은 노드
    }

    delete[] graph;
    delete[] counts;
    delete[] visited;

    return 0;
}