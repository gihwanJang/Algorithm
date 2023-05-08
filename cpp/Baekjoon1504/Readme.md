# (1504) 특정한 최단 경로
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1504)
#
## 문제
방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1) 임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.
#
## 출력
첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하면 해결 할 수 있는 문제입니다.  

우선 그래프를 입력받습니다.
이때 그래프의 간선은 양방향으로 연결 해야합니다.

이후 v1 과 v2를 거쳐가야 하지만 순서는 정해지지 않았으므로 아래의 2가지 경우를 고려해야합니다.  

1. start -> v1 -> v2 -> end  
2. start -> v2 -> v1 -> end

위의 사항을 고려하여 다익스트라 알고리즘을 아래와 같이 실행해 주면 됩니다.  

1. 시작 노드에서 다익스트라 알고리즘을 실행 후 v1으로 가는 최단거리와 v2로가는 최단거리를 각각 저장
2. v1에서 다익스트라 알고리즘을 실행 후 v2로 가는 최단 거리를 양쪽에 합산
3. 도착 노드에서 다익스트라 알고리즘을 실행 후 v1을 거쳐왔던 거리에 v2로가는 최단거리를 합산 v2를 거쳐왔던 거리에 v1으로가는 최단거리를 합산

위의 과정이 끝났다면 둘중 작은 것을 출력해 주시면 됩니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF (1234567891)

using namespace std;

struct edge{
    int end, val;

    edge(int e, int v): end(e), val(v){}

    bool operator<(const edge&e)const{
        return this->val > e.val;
    }
};

void dijkstra(vector<vector<edge>>&graph, vector<int>&distance, int s){
    edge curr(s, 0);
    edge next(0, 0);
    priority_queue<edge> pq;

    for(int i = 0; i < graph.size(); ++i)
        distance[i] = INF;

    distance[s] = 0;
    pq.push(curr);

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = curr.val + graph[curr.end][i].val;

            if(distance[next.end] > next.val){
                distance[next.end] = next.val;
                pq.push(edge(next.end, next.val));
            }
        }
    }
}

long shortestPath(vector<vector<edge>>&graph, int n1, int n2){
    vector<int> distance(graph.size());

    long res;
    long route_n1_n2;
    long route_n2_n1;

    dijkstra(graph, distance, 0);
    route_n1_n2 = distance[n1];
    route_n2_n1 = distance[n2];

    dijkstra(graph, distance, n1);
    route_n1_n2 += distance[n2];
    route_n2_n1 += distance[n2];

    dijkstra(graph, distance, graph.size()-1);
    route_n1_n2 += distance[n2];
    route_n2_n1 += distance[n1];

    res = min(route_n1_n2, route_n2_n1);
    return (res >= INF ? -1 : res);
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v, n1, n2;
    cin >> n >> m;

    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e>> v;
        graph[s-1].push_back(edge(e-1, v));
        graph[e-1].push_back(edge(s-1, v));
    }

    cin >> n1 >> n2;

    cout << shortestPath(graph, n1-1, n2-1) << "\n";
    return 0;
}
```