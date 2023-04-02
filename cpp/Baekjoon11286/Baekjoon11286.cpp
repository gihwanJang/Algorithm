#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

struct compare{
    bool operator()(int a, int b){
        if(abs(a) == abs(b))
            return a > b;
        return abs(a) > abs(b);
    }
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    priority_queue<int, vector<int>, compare> que;
    cin >> n;

    while(n--){
        cin >> x;

        if(x)
            que.push(x);
        else{
            if(que.empty())
                cout << 0 << "\n";
            else{
                cout << que.top() << "\n";
                que.pop();
            }
        }
    }
    return 0;
}
