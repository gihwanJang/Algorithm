#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

struct crane{
    int craneLimitWeight;
    queue<int> container;
};

bool cmp(crane a, crane b){
    return a.craneLimitWeight < b.craneLimitWeight;
}

int checkUpper(vector<crane>&cranes){
    int index = -1;
    for(int i = 1; i < cranes.size(); ++i)
        if(cranes[i - 1].container.size() > cranes[i].container.size())
            return i - 1;
    return index;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, weight, checkNum, answer = 0;
    cin >> N;

    vector<crane> cranes(N);
    for(int i = 0; i < N; ++i)
        cin >> cranes[i].craneLimitWeight;
    
    sort(cranes.begin(), cranes.end(), cmp);
    
    bool check = false;
    cin >> M;
    while(M--){
        cin >> weight;
        for(int i = 0; i < N; ++i){
            if(weight <= cranes[i].craneLimitWeight){
                cranes[i].container.push(weight);
                break;
            }
            else if(i == N - 1)
                check = true;
        }
    }

    if(check){
        cout << -1 << "\n";
        return 0;
    }

    while(true){
        checkNum = checkUpper(cranes);
        if(checkNum == -1) break;

        while(cranes[checkNum].container.size() > cranes[checkNum + 1].container.size()){
            weight = cranes[checkNum].container.front();
            cranes[checkNum].container.pop();
            cranes[checkNum + 1].container.push(weight);
        }
    }

    for(int i = 0; i < N; ++i)
        answer = max(answer, (int)cranes[i].container.size());
    
    cout << answer << "\n";
    return 0;
}
