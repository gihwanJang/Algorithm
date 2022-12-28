#include <iostream>
#include <queue>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, val;
    cin >> N;

    priority_queue<int> pq;
    for(int i = 0; i < N*N; ++i){
        cin >> val;
        if(pq.size() < N)
            pq.push(-val);
        else
            if(-pq.top() < val){
                pq.pop();
                pq.push(-val);
            }
    }

    cout << -pq.top() << "\n";
    return 0;
}
