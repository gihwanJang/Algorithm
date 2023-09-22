#include <iostream>
#include <vector>

using namespace std;

int getNums(vector<string>&strings, int&n) {
    int cnt = 0;

    for(int i = 0; i < n; ++i)
        for(int j = 0; j+1 < strings[i].size(); ++j) {
            if(strings[i][j] == '0' && strings[i][j+1] =='1') {
                ++cnt;
                break;
            }
            if(strings[i][j] == 'O' && strings[i][j+1] =='I') {
                ++cnt;
                break;
            }
        }
    
    return cnt;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<string> strings(n);
    for(int i = 0; i < n; ++i)
        cin >> strings[i];

    cout << getNums(strings, n) << "\n";
    return 0;
}
