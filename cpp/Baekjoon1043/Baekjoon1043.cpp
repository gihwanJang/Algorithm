#include <iostream>
#include <vector>

using namespace std;

int find(vector<int>&parents, int x) {
    if(parents[x] == x) return x;
    return find(parents, parents[x]);
}
 
void union_set(vector<int>&parents, int x, int y) {
    x = find(parents, x);
    y = find(parents, y);
    parents[x] = y;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k;
    cin >> n >> m >> k;
    // 진실을 알고 있는 사람들 초기화
    vector<int> knowns(k);
    for(int i = 0, p; i < k; ++i){
        cin >> p;
        knowns[i] = p - 1;
    }
    // 해당 인원들의 부모노드 초기화
    vector<int> parents(n);
    for(int i = 0; i < n; ++i)
        parents[i] = i;
    //참석 명부 작성
    vector<vector<int>> roster(m);
    for(int i = 0, c; i < m; ++i){
        cin >> c;
        int p;
        int prev;
        for(int j = 0; j < c; ++j){
            prev = p;
            cin >> p;
            --p;
            // 같은 파티에 참석한 인원을 같은 집합으로 추가
            if(j > 0)
                union_set(parents, prev, p);
            
            roster[i].push_back(p);
        }
    }
    // 진실을 알고 있는 자와 같은 집합에 있다면 해당 파티 제외
    for(auto& list : roster){
        bool hasKnown = false;
        for(auto& person : list){
            if(hasKnown) break;
            for(auto& known : knowns){
                if(find(parents, person) == find(parents, known)){
                    hasKnown = true;
                    break;
                }
            }
        }
        if(hasKnown)
            m--;
    }

    cout << m << "\n";
    return 0;
}
