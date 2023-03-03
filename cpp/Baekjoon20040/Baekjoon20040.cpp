#include <iostream>
#include <vector>

using namespace std;

int find(vector<int>&parents, int x) {
    if(parents[x] == x) return x;
    return find(parents, parents[x]);
}
 
void union_set(vector<int>&parents, int x, int y) {
    parents[x] = y;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, n1, n2;
    cin >> n >> m;

    vector<int> parents(n);
    for(int i = 0; i < n; ++i)
        parents[i] = i;
    
    for(int i = 0; i < m; ++i){
        cin >> n1 >> n2;

        n1 = find(parents, n1);
        n2 = find(parents, n2);

        if(n1 == n2){
            cout << i + 1 << "\n";
            return 0;
        }

        union_set(parents, n2, n1);
    }
    
    cout << 0 << "\n";
    return 0;
}
