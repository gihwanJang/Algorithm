#include <iostream>
#include <algorithm>

using namespace std;

int findMin(int a, int b, int c){
    if(a < b){
        if(c < a) return c;
        else return a;
    }
    else{
        if(c < b) return c;
        else return b;
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, answer, pMin = 1000, eMin = 1000;
    cin >> N >> M;

    for(int i = 0, p ,e; i < M; ++i){
        cin >> p >> e;
        pMin = min(pMin, p);
        eMin = min(eMin, e);
    }

    answer = findMin((N / 6 * pMin + N % 6 * eMin), (N / 6 + 1) * pMin, N * eMin);

    cout << answer << "\n";
    return 0;
}
