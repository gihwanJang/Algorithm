#include <iostream>
#include <vector>
#include <unordered_set>
#include <utility>

using namespace std;

int N, M;

struct hashFunction{
  size_t operator()(const pair<int, int> &x) const{
    return x.first*31 + x.second;
  }
};

void findSubMatrix(vector<string>&A, vector<string>&B, unordered_set<pair<int,int>, hashFunction>&visited, int r, int c){
    visited.insert(make_pair(r,c));
    if(r + 1 < N && A[r + 1][c] != B[r + 1][c])
        findSubMatrix(A, B, visited, r+1, c);
    if(c + 1 < M && A[r][c + 1] != B[r][c + 1])
        findSubMatrix(A, B, visited, r, c+1);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int answer = 0;
    cin >> N >> M;
    vector<string> A(N);
    vector<string> B(N);
    unordered_set<pair<int,int>, hashFunction> visited;

    for(int r = 0; r < N; ++r)
        cin >> A[r];
    for(int r = 0; r < N; ++r)
        cin >> B[r];

    for(int r = 0; r < N; ++r)
        for(int c = 0; c < M; ++c)
            if(!visited.count(make_pair(r,c)) && A[r][c] != B[r][c]){
                answer += 1;
                findSubMatrix(A, B, visited, r, c);
            }

    cout << (visited.size() == N*M ? -1 : answer) << "\n";
    return 0;
}
