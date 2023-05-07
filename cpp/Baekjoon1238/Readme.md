# (1238) 파티
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1238)
#
## 문제
N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.

어느 날 이 N명의 학생이 X (1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다. 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.

각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다. 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.

이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다. N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
#
## 입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000), X가 공백으로 구분되어 입력된다. 두 번째 줄부터 M+1번째 줄까지 i번째 도로의 시작점, 끝점, 그리고 이 도로를 지나는데 필요한 소요시간 Ti가 들어온다. 시작점과 끝점이 같은 도로는 없으며, 시작점과 한 도시 A에서 다른 도시 B로 가는 도로의 개수는 최대 1개이다.

모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.
#
## 출력
첫 번째 줄에 N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간을 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하면 해결 할 수 있는 문제입니다.  

우선 입력 형식인 (start, end, value)의 값으로 graph를 만듭니다.  
이때 다익스트라 알고리즘을 효율적으로 사용하기 위해 edge 구조체를 만들어 인접 리스트로 구현합니다.  

그래프가 완성되면 우선 파티장에서 각 마을로가는 최단거리를 다익스트라 알고리즘을 이용하여 구합니다.

이후 각 마을에서 파티장으로 가는 최단거리를 차례대로 구하며 위에서 구한 (각 마을로 가는 최단거리 + 현재 마을에서 파티장으로 가는 최단거리)값으로 최장거리를 갱신해줍니다.  

최종적으로 도출된 최장거리를 출력해줍니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF (1234567891)

using namespace std;

struct edge {
    int end, val;

    edge(int E, int V): end(E), val(V){}

    bool operator<(const edge&e)const{
        return this->val > e.val;
    }
};

void dijkstra(vector<vector<edge>>&graph, vector<int>&distance, int start){
    priority_queue<edge> pq;
    edge curr(start, 0);
    edge next(0, 0);

    pq.push(curr);
    distance[start] = 0;

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = curr.val + graph[curr.end][i].val;

            if(distance[next.end] > next.val){
                distance[next.end] = next.val;
                pq.push(next);
            }
        }
    }
}

int getLongestPath(vector<vector<edge>>&graph, int goal){
    int long_path = 0;
    vector<int> goal_to_home(graph.size(), INF);

    dijkstra(graph, goal_to_home, goal);
    for(int i = 0; i < graph.size(); ++i){
        vector<int> home_to_goal(graph.size(), INF);
        dijkstra(graph, home_to_goal, i);

        long_path = max(long_path, home_to_goal[goal] + goal_to_home[i]);
    }

    return long_path;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, x, s, e, v;
    cin >> n >> m >> x;

    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e >> v;
        graph[s-1].push_back(edge(e-1, v));
    }

    cout << getLongestPath(graph, x-1) << "\n";
    return 0;
}
```