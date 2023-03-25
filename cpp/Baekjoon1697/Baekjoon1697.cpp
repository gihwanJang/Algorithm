#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int seek(int n, int k){
    if(n >= k) return n - k;

    pair<int,int> curr;
    queue<pair<int,int>> que;
    vector<bool> visited(k+2);

    que.push({n,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        visited[curr.first] = true;

        if(curr.first+1 == k || curr.first-1 == k || curr.first*2 == k)
            return curr.second+1;

        if(!visited[curr.first+1])
            que.push({curr.first+1, curr.second+1});
        if(curr.first-1 > 0 && !visited[curr.first-1])
            que.push({curr.first-1, curr.second+1});
        if(curr.first*2 < k+2 && !visited[curr.first*2])
            que.push({curr.first*2, curr.second+1});
    }

    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, k;
    cin >> n >> k;

    cout << seek(n, k) << "\n";
    return 0;
}
