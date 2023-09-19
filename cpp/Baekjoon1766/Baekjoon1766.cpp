#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> getSolveSeq(vector<vector<int>>&graph, vector<int>&entries) {
    int curr;
    int size = entries.size();
    vector<int> solveSeq(size);
    priority_queue<int> pq;

    for(int i = 0 ; i < size; ++i)
        if(!entries[i])
            pq.push(i * -1);

    for(int i = 0; i < size; ++i) { 
        curr = pq.top();
        curr *= -1;
        pq.pop();

        solveSeq[i] = curr+1;

        for(int j = 0; j < graph[curr].size(); ++j) {
            --entries[graph[curr][j]];
            if(!entries[graph[curr][j]]) 
                pq.push(graph[curr][j] * -1);
        }
    }

    return solveSeq;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    vector<int> entries(n);
    vector<vector<int>> graph(n);
    for(int i = 0; i < m; ++i) {
        cin >> s >> e;
        graph[s-1].push_back(e-1);
        ++entries[e-1];
    }
    
    for(int i : getSolveSeq(graph, entries))
        cout << i << " ";
    return 0;
}
