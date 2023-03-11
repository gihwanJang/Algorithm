#include <unordered_map>
#include <iostream>
#include <vector>

using namespace std;

long subSum(vector<int>&A, vector<int>&B, int T){
    long res = 0;
    unordered_map<int, long> map;

    for(int i  = 1; i < A.size(); ++i)
        for(int j = 0; j < i; ++j){
            if(map.count(A[i] - A[j]))
                ++map.find(A[i] - A[j])->second;
            else
                map.insert({A[i] - A[j], 1});
        }

    for(int i  = 1; i < B.size(); ++i)
        for(int j = 0; j < i; ++j)
            if(map.count(T - B[i] + B[j]))
                res += map.find(T - B[i] + B[j])->second;

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n ,m;
    cin >> T >> n;

    vector<int> A(n+1);
    for(int i = 1; i <= n; ++i){
        cin >> A[i];
        A[i] += A[i - 1];
    }

    cin >> m;
    vector<int> B(m + 1);
    for(int i = 1; i <= m; ++i){
        cin >> B[i];
        B[i] += B[i - 1];
    }

    cout << subSum(A, B, T) << "\n";
    return 0;
}
