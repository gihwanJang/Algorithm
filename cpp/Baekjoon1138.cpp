#include <iostream>
#include <vector>
#include <utility>

using namespace std;

void swap(vector<pair<int,int>>&seq, int a, int b){
    pair<int, int> tmp = seq[a];
    seq[a] = seq[b];
    seq[b] = tmp;
}

void lineSort(vector<pair<int,int>>&seq, int idx){
    for(int i = idx + 1; seq[idx].second > 0; ++i)
        if(seq[i] > seq[idx]){
            swap(seq, idx, i);
            idx = i;
            --seq[idx].second;
        }
}

int main(int argc, char const *argv[]){
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, count = 0;
    cin >> N;

    vector<pair<int, int>> seq(N);
    for(int i = 0; i < N; ++i){
        cin >> seq[i].second;
        seq[i].first = i + 1;
        if(seq[i].second != 0)
            ++count;
    }

    while(count){
        for(int i = 0; i < N; ++i)
            if(seq[i].second != 0){
                lineSort(seq, i);
                --count;
                break;
            }
    }

    for(int i = 0; i < N; ++i)
        cout << seq[i].first << " ";
    return 0;
}
