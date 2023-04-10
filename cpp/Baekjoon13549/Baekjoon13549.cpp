#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int hideAndSick(int n, int k){
    pair<int,int> curr;
    vector<bool> visited(100001);
    queue<pair<int,int>> que;
    que.push({n,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.first == k)
            return curr.second;

        if(curr.first*2 < visited.size() && !visited[curr.first*2]){
            que.push({curr.first*2, curr.second});
            visited[curr.first*2] = true;
        }
        if(curr.first > 0 && !visited[curr.first-1]){
            que.push({curr.first-1, curr.second+1});
            visited[curr.first-1] = true;
        }
        if(curr.first+1 < visited.size() && !visited[curr.first+1]){
            que.push({curr.first+1, curr.second+1});
            visited[curr.first+1] = true;
        }
    }
    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    cout << hideAndSick(n, k) << "\n";
    return 0;
}
