#include <iostream>
#include <vector>

using namespace std;

void getMaxScore(vector<int>&dice, int&ans){
    int cnt = 0, score = 0, num;

    for(int i = 0; i < 6; ++i){
        if(cnt <= dice[i]){
            cnt = dice[i];
            num = i + 1;
        }
    }

    if(cnt == 3){
        score = 10000 + num * 1000;
    }else if(cnt == 2){
        score = 1000 + num * 100;
    }else{
        score = num * 100;
    }

    ans = max(ans, score);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, num, ans = 0;
    cin >> n;

    while(n--){
        vector<int> dice(6, 0);

        for(int i = 0; i < 3; ++i){
            cin >> num;
            ++dice[num-1];
        }

        getMaxScore(dice, ans);
    }

    cout << ans << "\n";
    return 0;
}
