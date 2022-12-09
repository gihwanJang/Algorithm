#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct work{
    int runtime, deadline;
};

bool cmp(work a, work b){
    return a.deadline > b.deadline;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, lastWork, curr = 0;
    cin >> N;

    vector<work> schedul(N);
    for(int i = 0; i < N; ++i)
        cin >> schedul[i].runtime >> schedul[i].deadline;

    sort(schedul.begin(), schedul.end(), cmp);
    lastWork = schedul.front().deadline - schedul.front().runtime;

    for(int i = 1; i < N; ++i){
        if(lastWork > schedul[i].deadline)
            lastWork = schedul[i].deadline;
        lastWork -= schedul[i].runtime;
    }

    cout << (lastWork > 0 ?  lastWork : -1) << "\n";
    return 0;
}
