#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void line_up(vector<int>&inDegree, vector<vector<int>>&seq){
    int p;

    queue<int> que;
    for(int i = 1; i < inDegree.size(); ++i)
        if(inDegree[i] == 0)
            que.push(i);

    while(!que.empty()){
        p = que.front();
        que.pop();

        cout << p << " ";

        for(int i = 0; i < seq[p].size(); ++i){
            --inDegree[seq[p][i]];
            if(!inDegree[seq[p][i]])
                que.push(seq[p][i]);
        }
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    vector<int> inDegree(n+1);
    vector<vector<int>> seq(n+1);
    for(int i = 0; i < m; ++i){
        cin >> s >> e;

        ++inDegree[e];
        seq[s].push_back(e);
    }

    line_up(inDegree, seq);
    cout << "\n";
    return 0;
}
