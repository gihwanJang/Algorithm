#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct container{
    int value, originIdx, sortedIdx;
};

bool cmpWithValue(container a, container b){
    if(a.value != b.value)
        return a.value < b.value;
    return a.originIdx < b.originIdx;
}

bool cmpWithIdx(container a, container b){
    return a.originIdx < b.originIdx;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<container> containers(N);
    for(int i = 0; i < N; ++i){
        cin >> containers[i].value;
        containers[i].originIdx = i;
    }

    sort(containers.begin(), containers.end(), cmpWithValue);
    for(int i = 0; i < N; ++i)
        containers[i].sortedIdx = i;
    
    sort(containers.begin(), containers.end(), cmpWithIdx);

    for(int i = 0; i < N; ++i)
        cout << containers[i].sortedIdx << " ";
    return 0;
}
