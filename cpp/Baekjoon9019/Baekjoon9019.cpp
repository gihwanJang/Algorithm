#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int D(int n){
    return 2*n > 9999 ? (2*n) % 10000 : 2*n;
}

int S(int n){
    return n == 0 ? 9999 : n-1;
}

int L(int n){
    int num[4];
    for(int i = 0; i < 4; ++i){
        num[i] = n % 10;
        n /= 10;
    }
    return num[2]*1000 + num[1]*100 + num[0]*10 + num[3];
}

int R(int n){
    int num[4];
    for(int i = 0; i < 4; ++i){
        num[i] = n % 10;
        n /= 10;
    }
    return num[0]*1000 + num[3]*100 + num[2]*10 + num[1];
}

string DSLR(int s, int e){
    int n;
    pair<int, string> curr;
    vector<bool> visited(10000);
    queue<pair<int, string>> que;
    que.push({s, ""});
    visited[s] = true;
    
    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.first == e)
            return curr.second;

        n = D(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"D"});
            visited[n] = true;
        }
        n = S(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"S"});
            visited[n] = true;
        }
        n = L(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"L"});
            visited[n] = true;
        }
        n = R(curr.first);
        if(!visited[n]){
            que.push({n, curr.second+"R"});
            visited[n] = true;
        }
    }
    return "";
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, s, e;
    cin >> T;
    while(T--){
        cin >> s >> e;

        cout << DSLR(s, e) << "\n";
    }
    return 0;
}
