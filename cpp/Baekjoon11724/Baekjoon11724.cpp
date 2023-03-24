#include <iostream>
#include <vector>

using namespace std;

int find(vector<int>&parents, int n){
    if(parents[n] == n) return n;
    return parents[n] = find(parents, parents[n]);
}

void union_node(vector<int>&parents, int n1, int n2){
    parents[n1] = n2;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, n1, n2, ans = 0;
    cin >> n >> m;

    vector<int> parents(n + 1);
    for(int i = 1; i <= n; ++i)
        parents[i] = i;

    while(m--){
        cin >> n1 >> n2;

        n1 = find(parents, n1);
        n2 = find(parents, n2);

        if(n1 != n2)
            union_node(parents, n1, n2);
    }

    for(int i = 1; i <=n; ++i)
        if(parents[i] == i)
            ++ans;

    cout << ans << "\n";
    return 0;
}
