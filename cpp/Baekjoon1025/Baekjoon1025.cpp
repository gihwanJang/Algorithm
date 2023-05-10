#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void findSquareNumber(vector<string>&matrix, int r_s, int c_s, int&ans){
    int s_i;
    
    for(int curr_r = 0; curr_r < matrix.size(); ++curr_r){
        for(int curr_c = 0; curr_c < matrix[0].size(); ++curr_c){
            string s;
            string rev_s;
            int r = curr_r;
            int c = curr_c;

            while(r < matrix.size() && c < matrix[0].size() && c > -1){
                s += matrix[r][c];
                rev_s = s;

                s_i = stoi(s);
                if(abs(sqrt(s_i) - (int)sqrt(s_i)) < 0.000001)
                    ans = max(ans, s_i);

                reverse(rev_s.begin(), rev_s.end());
                s_i = stoi(rev_s);
                if(abs(sqrt(s_i) - (int)sqrt(s_i)) < 0.000001)
                    ans = max(ans, s_i);

                r += r_s;
                c += c_s;
            }
        }
    }
}

void initAns(vector<string>&matrix, int&ans){
    int s_i;

    ans = -1;
    for(int r = 0; r < matrix.size(); ++r)
        for(int c = 0; c < matrix[0].size(); ++c){
            s_i = matrix[r][c] - '0';

            if(abs(sqrt(s_i) - (int)sqrt(s_i)) < 0.000001)
                ans = max(ans, s_i);
        }
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans;
    cin >> n >> m;


    vector<string> matrix(n);
    for(int r = 0; r < n; ++r)
        cin >> matrix[r];

    initAns(matrix, ans);

    // 대각
    for(int r = 1; r < n; ++r){
        for(int c = 1; c < m; ++c)
            findSquareNumber(matrix, r, c, ans);
        for(int c = -1; -c < m; --c)
            findSquareNumber(matrix, r, c, ans);
    }
    // 수평
    for(int r = 1; r < n; ++r)
        findSquareNumber(matrix, r, 0, ans);
    // 수직
    for(int c = 1; c < m; ++c)
        findSquareNumber(matrix, 0, c, ans);

    cout << ans << "\n";
    return 0;
}
