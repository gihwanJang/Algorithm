#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    priority_queue<int> pq;
    int N, commend;
    cin >> N;

    while(N--){
        cin >> commend;
        if(commend)
            pq.push(-commend);
        else{
            if(pq.empty())
                cout << "0\n";
            else{ 
                cout << -pq.top() << "\n";
                pq.pop();
            }
        }
    }
    return 0;
}
