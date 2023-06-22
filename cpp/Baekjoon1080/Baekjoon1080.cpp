#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

#define INF 1234567891

using namespace std;

bool checkMatch(vector<vector<bool>>&a, vector<vector<bool>>&b, int n, int m){
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(a[r][c] != b[r][c])
                return false;
    
    return true;
}

void reverseSubMatrix(vector<vector<bool>>&a, int p_r, int p_c){
    for(int r = p_r; r < p_r+3; ++r)
        for(int c = p_c; c < p_c+3; ++c)
            a[r][c] = !a[r][c];
}

void convertMatrix(vector<vector<bool>>&a, vector<vector<bool>>&b, int n, int m, int p_r, int p_c, int depth, int&ans){
    if(checkMatch(a, b, n, m)){
        ans = min(ans, depth);
        return;
    }

    int c = p_c < m-3 ? p_c+1 : 0;
    int r = c <= p_c ? p_r+1 : p_r;

    if(r > n-3)
        return;

    reverseSubMatrix(a, r, c);
    convertMatrix(a, b, n, m, r, c, depth+1, ans);
    reverseSubMatrix(a, r, c);
    convertMatrix(a, b, n, m, r, c, depth, ans);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans = INF;
    cin >> n >> m;

    string s;
    vector<vector<bool>> a(n, vector<bool>(m));
    vector<vector<bool>> b(n, vector<bool>(m));

    for(int r = 0; r < n; ++r){
        cin >> s;

        for(int c = 0; c < m; ++c)
            a[r][c] = (s[c] == '1');
    }
    for(int r = 0; r < n; ++r){
        cin >> s;

        for(int c = 0; c < m; ++c)
            b[r][c] = (s[c] == '1');
    }

    if(n > 2 && m > 2)
        convertMatrix(a, b, n, m, 0, -1, 0, ans);

    cout  << (ans == INF ? -1 : ans) << "\n";
    return 0;
}
