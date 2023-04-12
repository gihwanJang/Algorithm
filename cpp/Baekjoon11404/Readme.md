# (11404) 플로이드
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/11404)
#
## 문제
n(2 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 각 버스는 한 번 사용할 때 필요한 비용이 있다.

모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 도시의 개수 n이 주어지고 둘째 줄에는 버스의 개수 m이 주어진다. 그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다. 시작 도시와 도착 도시가 같은 경우는 없다. 비용은 100,000보다 작거나 같은 자연수이다.

시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
#
## 출력
n개의 줄을 출력해야 한다. i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다. 만약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하면 해결 할 수 있습니다.  

다익스트라 알고리즘은 인접 행렬, 인접 리스트 그래프 모두 구현이 가능합니다.  
(인접 리스트 : nlogn, 인접 행렬 : n^2)

해당 문제에서는 한 노드에서 다른 노드로 가는 값이 여러개 있을 수 있음으로 인접 리스트로 구현하는 것이 더 편합니다.  

```cpp
#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891
using namespace std;

struct edge{
    int e, v;
    edge(int E, int V): e(E), v(V){}
};

void dijkstra(vector<vector<edge>>&matrix, vector<int>&distance, int start){
    pair<int, int> curr, next;
    priority_queue<pair<int, int>,vector<pair<int, int>>,greater<pair<int, int>>> pq;

    distance[start] = 0;
    pq.push({0, start});

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < matrix[curr.second].size(); ++i){
            next = {curr.first + matrix[curr.second][i].v, matrix[curr.second][i].e};

            if(next.first < distance[matrix[curr.second][i].e]){
                distance[matrix[curr.second][i].e] = next.first;
                pq.push({next.first, next.second});
            }
        }
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, v, s, e;
    cin >> n >> m;

    vector<vector<edge>> matrix(n);
    while(m--){
        cin >> s >> e >> v;
        matrix[s-1].push_back(edge(e-1,v));
    }

    for(int i = 0; i < n; ++i){
        vector<int> distance(n, INF);

        dijkstra(matrix, distance, i);

        for(int j = 0; j < n; ++j)
            cout << (distance[j] == INF ? 0 : distance[j]) << " ";
        cout << "\n";
    }
    return 0;
}

```
