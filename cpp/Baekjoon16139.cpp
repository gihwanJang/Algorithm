#include<iostream>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    char alpa;
    int t, start, end, alpas[2000000][26];

    cin >> s >> t;
    fill(alpas[0], alpas[0]+26, 0);
    for(int i = 1; i <= s.length(); ++i){
        for(int j = 0; j < 26; ++j)
            alpas[i][j] = alpas[i - 1][j];
        ++alpas[i][s[i-1] - 97];
    }

    for(; t > 0; --t){
        cin >> alpa >> start >> end;
        cout << alpas[end + 1][alpa - 97] - alpas[start][alpa - 97] << "\n";
    }
    return 0;
}