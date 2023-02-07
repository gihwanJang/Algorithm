#include <iostream>
#include <vector>

using namespace std;

int findRoot(vector<int>&finder, int v){
    if(finder[v] == v)
        return v;
    
    int parent = findRoot(finder, finder[v]);
    finder[v] = parent;
    
    return parent;
}

void merge(vector<int>&finder, int v1, int v2){
    int r1 = findRoot(finder, v1);
	int r2 = findRoot(finder, v2);

	if(r1 == r2) return;

	finder[r1] = r2;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, op, v1, v2;
    cin >> n >> m;

    vector<int> finder(n+1);
    for(int i = 0; i <= n; ++i)
        finder[i] = i;
    
    while(m--){
        cin >> op >> v1 >> v2;

        if(op == 0)
            merge(finder, v1, v2);
        else
            cout << (findRoot(finder, v1) == findRoot(finder, v2) ? "YES" : "NO") << "\n";
    }

    return 0;
}
