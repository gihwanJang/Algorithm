#include <algorithm>
#include <iostream>

#define INF 1000000000

using namespace std;

int makeB(long a, long b, int depth){
    if(a == b) return depth;

    int count = INF;
    if(a < b){
        count = min(count, makeB(a * 2, b, depth + 1));
        count = min(count, makeB(a * 10 + 1, b, depth + 1));
    }

    return count;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long a, b, ans;
    cin >> a >> b;
    
    ans = makeB(a, b, 1);

    cout << (ans == INF ? -1 : ans) << "\n";
    return 0;
}
