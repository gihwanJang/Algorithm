# (1916) 최소비용 구하기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1916)
#
## 문제
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.
#
## 입력
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
#
## 출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하면 해결 할 수 있는 문제입니다.  

우선 입력 형식은 (출발지 목적지 가격)이므로 출발지에서 목적지로 가는 그래프를 만들어 줍니다.  
이때 목적지로의 가중치 또한 같이 나타내기 위해 edge라는 구조체를 만들어 그래프를 입력 받습니다.  

입력이 끝나면 출발지에서 목적지로의 경로를 다익스트라 알고리즘을 통해 구하고 출력해 줍니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891

using namespace std;

struct edge{
    int end, value;

    edge(int e, int v): end(e), value(v){}

    bool operator<(const edge e) const {
        return this->value > e.value;
    }
};

int Dijkstra(vector<vector<edge>>&graph, int s, int e){
    edge curr(s, 0);
    edge next (0, 0);
    vector<int> distance(graph.size(), INF);
    priority_queue<edge> pq;

    distance[s] = 0;
    pq.push(curr);

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        if(curr.end == e)
            return distance[e];

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.value = curr.value + graph[curr.end][i].value;

            if(distance[next.end] > next.value){
                distance[next.end] = next.value;
                pq.push(edge(next.end, next.value));
            }
        }
    }

    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v;
    cin >> n >> m;

    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e >> v;
        graph[s-1].push_back(edge(e-1, v));
    }

    cin >> s >> e;

    cout << Dijkstra(graph, s-1, e-1);
    return 0;
}
```