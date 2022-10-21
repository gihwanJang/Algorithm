#include<iostream>
#include<utility>
using namespace std;

void solution(int n, pair<int, int> datas[]){
    for(int i = 0; i < n; ++i){
        int count = 1;
        for(int j = 0; j < n; ++j){
            if(i == j) continue;
            if(datas[i].first<datas[j].first && datas[i].second<datas[j].second)
                ++count;
        }
        printf("%d ", count);
    }
}

int main(){
    int n;
    scanf("%d", &n);
    pair<int, int> datas[n];
    for(int i = 0; i < n; ++i){
        int w, h;
        scanf("%d %d", &w, &h);
        datas[i] = make_pair(w, h);
    }

    solution(n, datas);
    printf("\n");
    return 0;
}