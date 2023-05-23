#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void find(int n, int k, int&t, int&cnt){
    pair<int, int> curr(n, 0);
    queue<pair<int, int>> que;
    vector<bool> visited(100001);

    visited[n] = true;
    que.push(curr);
    t = 1234567891;
    cnt = 0;

    while(!que.empty()){
        curr = que.front();
        que.pop();

        visited[curr.first] = true;

        if(curr.first == k){
            if(t >= curr.second){
                t = curr.second;
                ++cnt;
            }
            else
                break;
        }

        if(curr.first-1 >= 0 && !visited[curr.first-1])
            que.push({curr.first-1, curr.second+1});

        if(curr.first < visited.size() && !visited[curr.first+1])
            que.push({curr.first+1, curr.second+1});
            
        if(curr.first*2 < visited.size() && !visited[curr.first*2])
            que.push({curr.first*2, curr.second+1});
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, time, cnt;
    cin >> n >> k;

    find(n, k, time, cnt);

    cout << time << "\n";
    cout << cnt << "\n";
    return 0;
}
