#include <iostream>
#include <unordered_set>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    unordered_set<int> rowSet(N);
    unordered_set<int> colSet(M);

    string s;
    for(int r = 0; r < N; ++r){
        cin >> s;
        for(int c = 0; c < M; ++c)
            if(s[c] == 'X'){
                rowSet.insert(r);
                colSet.insert(c);
            }
    }

    cout << (N - rowSet.size() > M - colSet.size() ?  N - rowSet.size() : M - colSet.size());
    return 0;
}
