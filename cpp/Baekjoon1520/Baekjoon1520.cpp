#include <iostream>
#include <vector>
#include <unordered_map>
#include <utility>

using namespace std;

struct hashFunction{
  size_t operator()(const pair<int,int> &x) const{
    return x.first ^ x.second;
  }
};

int M, N, map[500][500];
unordered_map<pair<int,int>, int, hashFunction> set;

bool checkRange(int r, int c){
    if(r < 0 || r >= M || c < 0 || c >= N)
        return false;
    return true;
}

int solution(int r, int c){
    if(r + 1 == M && c + 1 == N) return 1;

    int route = 0;
    if(checkRange(r - 1, c) && map[r][c] > map[r - 1][c]){
        int up = 0;
        pair<int, int> p = make_pair(r - 1, c);
        if(set.count(p))
            up += set.at(p);
        else{
            up += solution(r - 1, c);
            set.insert({p, up});
        }
        route += up;
    }
    if(checkRange(r + 1, c) && map[r][c] > map[r + 1][c]){
        int down = 0;
        pair<int, int> p = make_pair(r + 1, c);
        if(set.count(p))
            down += set.at(p);
        else{
            down += solution(r + 1, c);
            set.insert({p, down});
        }
        route += down;
    }
    if(checkRange(r, c - 1) && map[r][c] > map[r][c - 1]){
        int left = 0;
        pair<int, int> p = make_pair(r, c - 1);
        if(set.count(p))
            left += set.at(p);
        else{
            left += solution(r, c - 1);
            set.insert({p, left});
        }
        route += left;
    }
    if(checkRange(r, c + 1) && map[r][c] > map[r][c + 1]){
        int right = 0;
        pair<int, int> p = make_pair(r, c + 1);
        if(set.count(p))
            right += set.at(p);
        else{
            right += solution(r, c + 1);
            set.insert({p, right});
        }
        route += right;
    }

    return route;
}

int main() {
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    cin >> M >> N;
    for(int r = 0; r < M; ++r)
        for(int c = 0; c < N; ++c)
            cin >> map[r][c];

    cout << solution(0, 0) << "\n";
    return 0;
}