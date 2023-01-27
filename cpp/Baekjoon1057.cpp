#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, ans = 1;
    vector<int> players(2);
    cin >> N >> players[0] >> players[1];

    sort(players.begin(), players.end());

    while(players[0] < players[1] && (players[0]%2 != 1 || players[0]+1 != players[1])){
        for(int i = 0; i < 2; ++i){
            if(players[i]%2 == 1)
                ++players[i];
            players[i] /= 2;
        }
        ++ans;
    }

    cout << (players[0] < players[1] ? ans : -1) << "\n";
    return 0;
}
