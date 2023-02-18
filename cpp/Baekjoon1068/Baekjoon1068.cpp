#include <iostream>
#include <vector>
#include <list>

using namespace std;

int dfs(vector<list<int>>&tree, int root){
    int leafNode = 0;
    vector<int> stack;
    stack.push_back(root);

    while(!stack.empty()){
        int node = stack.back();
        if(tree[node].size() == 0) ++leafNode;
        stack.pop_back();
        for(int i : tree[node])
            stack.push_back(i);
    }
    return leafNode;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, root, p;
    cin >> N;
    
    vector<list<int>> tree(N);
    for(int i = 0; i < N; ++i){
        cin >> p;
        if(p == -1) root = i;
        else tree[p].push_back(i);
    }

    cin >> p;
    for(int i = 0; i < N; ++i)
        tree[i].remove(p);

    cout << (p == root ? 0 : dfs(tree, root)) << "\n";
    return 0;
}