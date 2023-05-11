# (11779) 최소비용 구하기 2
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/11779)
#
## 문제
n(1≤n≤1,000)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1≤m≤100,000)개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용과 경로를 출력하여라. 항상 시작점에서 도착점으로의 경로가 존재한다.
#
## 입력
첫째 줄에 도시의 개수 n(1≤n≤1,000)이 주어지고 둘째 줄에는 버스의 개수 m(1≤m≤100,000)이 주어진다. 그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 m+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.
#
## 출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

둘째 줄에는 그러한 최소 비용을 갖는 경로에 포함되어있는 도시의 개수를 출력한다. 출발 도시와 도착 도시도 포함한다.

셋째 줄에는 최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하면 해결 할 수 있는 문제입니다.  

우선 그래프를 입력받습니다.
이때 그래프는 다익스트라 알고리즘에 유리한 인접 리스트의 형태로 구현하였으며 이에 따라 edge의 자료구조를 별도로 만들어 주었습니다.  

해당 입력이 끝나면 출발 노드에서 부터 도착 노드까지의 다익스트라 알고리즘을 실행합니다.  
이때 기존의 다익스트라는 최단거리를 구하지만 해당 문제에서는 경로또한 출력하여야 하므로 거리 배열에 이전 경로를 입력 받도록 pair의 리스트로 만들어 주었습니다.  

해당 다익스트라가 끝나면 도착 최단경로를 출력후 
스택에 도착 노드부터 거꾸로 올라가며 출발 노드까지의 노드들을 담아줍니다.  
스택의 크기를 출력하고 스택에서 하나씩 꺼내어 출력하면 끝이납니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF (1234567891)

using namespace std;

struct edge {
    int end, val;

    edge(int e, int v): end(e), val(v){}

    bool operator<(const edge&e)const{
        return this->val > e.val;
    }
};

void dijkstra(vector<pair<int,int>>&distance, vector<vector<edge>>&graph, int s, int e){
    edge curr(s,0), next(0,0);
    priority_queue<edge> pq;

    for(int i = 0; i < graph.size(); ++i){
        distance[i].first = i;
        distance[i].second = INF;
    }

    distance[s].second = 0;
    pq.push(curr);

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        if(curr.end == e)
            return;

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = graph[curr.end][i].val + curr.val;

            if(distance[next.end].second > next.val){
                distance[next.end].first = curr.end;
                distance[next.end].second = next.val;

                pq.push(next);
            }
        }
    }
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v;
    cin >> n >> m;

    vector<int> stack;
    vector<pair<int,int>> distance(n);
    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e >> v;
        graph[s-1].push_back(edge(e-1, v));
    }

    cin >> s >> e;

    dijkstra(distance, graph, s-1, e-1);

    stack.push_back(e-1);
    while(stack.back() != distance[stack.back()].first)
        stack.push_back(distance[stack.back()].first);

    cout << distance[e-1].second << "\n";
    cout << stack.size() << "\n";
    while(!stack.empty()){
        cout << stack.back()+1 << " ";
        stack.pop_back();
    }
    cout << "\n";
    return 0;
}
```