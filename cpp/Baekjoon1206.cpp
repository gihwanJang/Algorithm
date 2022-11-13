#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

bool checkError(double score, int k){
    double l = score * k, r = score * (k + 0.001);
    if(abs(l - round(l)) < 0.009 || (r != round(r) && round(r) != round(l)))
        return false;
    return true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, ans;
    cin >> N;

    vector<double> score(N);
    for(int i = 0; i < N; ++i)
        cin >> score[i];

    for(int i = 1; i < 1001; ++i){
        bool check = true;
        for(int j = 0; j < N; ++j)
            if(checkError(score[j],i)){
                check = false;
                break;
            }
        if(check){
            ans = i;
            break;
        }
    }

    cout << ans << "\n";
    return 0;
}
