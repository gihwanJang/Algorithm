# (1967) 트리의 지름
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1697)

## 문제
트리(tree)는 사이클이 없는 무방향 그래프이다. 트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다. 트리에서 어떤 두 노드를 선택해서 양쪽으로 쫙 당길 때, 가장 길게 늘어나는 경우가 있을 것이다. 이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.

![Baekjoon1967_img_1](https://www.acmicpc.net/JudgeOnline/upload/201007/ttrrtrtr.png)

이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다. 정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.

입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 구해서 출력하는 프로그램을 작성하시오. 아래와 같은 트리가 주어진다면 트리의 지름은 45가 된다.

![Baekjoon1967_img_2](https://www.acmicpc.net/JudgeOnline/upload/201007/tttttt.png)

트리의 노드는 1부터 n까지 번호가 매겨져 있다.

## 입력
파일의 첫 번째 줄은 노드의 개수 n(1 ≤ n ≤ 10,000)이다. 둘째 줄부터 n-1개의 줄에 각 간선에 대한 정보가 들어온다. 간선에 대한 정보는 세 개의 정수로 이루어져 있다. 첫 번째 정수는 간선이 연결하는 두 노드 중 부모 노드의 번호를 나타내고, 두 번째 정수는 자식 노드를, 세 번째 정수는 간선의 가중치를 나타낸다. 간선에 대한 정보는 부모 노드의 번호가 작은 것이 먼저 입력되고, 부모 노드의 번호가 같으면 자식 노드의 번호가 작은 것이 먼저 입력된다. 루트 노드의 번호는 항상 1이라고 가정하며, 간선의 가중치는 100보다 크지 않은 양의 정수이다.

## 출력
첫째 줄에 트리의 지름을 출력한다.

## 풀이
해당 문제는 다익스트라 알고리즘을 이용하여 해결 할 수 있습니다.  

우선 원 위의 점중 어떠한 한점은 어떤 점에서 출발하여도 가장 먼점에 해당합니다.  
해당 점을 찾기위해 다익스트라 알고리즘을 실행하여 거리가 가장 먼점을 선택합니다.  

이제 원 위의 한점을 찾았고 해당 점에서 가장 먼점을 찾게 된다면 그 점까지의 거리가 지름이 됩니다.  
찾은 원에서 다익스트라 알고리즘을 실행후 가장 먼 거리를 출력합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891

using namespace std;

struct edge{
    int e, v;
    edge(int E, int V): e(E), v(V){}
};

pair<int,int> dijkstra(vector<vector<edge>>&tree, int start){
    pair<int,int> res = {start,0};
    pair<int,int> curr, next;
    vector<int> distance(tree.size());
    priority_queue<pair<int,int>> pq;
    pq.push({0, start});
    distance[start] = INF;

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < tree[curr.second].size(); ++i){
            next = {curr.first+tree[curr.second][i].v, tree[curr.second][i].e};

            if(!distance[next.second] && next.first > distance[next.second]){
                distance[next.second] = next.first;
                pq.push({next.first, next.second});
            }
        }
    }

    for(int i = 0; i < tree.size(); ++i)
        if(i != start)
            if(res.second < distance[i])
                res = {i, distance[i]};

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s, e, v, ans = 0;
    cin >> n;

    vector<vector<edge>> tree(n);
    while(--n){
        cin >> s >> e >> v;
        tree[s-1].push_back(edge(e-1,v));
        tree[e-1].push_back(edge(s-1,v));
    }

    ans = dijkstra(tree, dijkstra(tree, 0).first).second;
    
    cout << ans << "\n";
    return 0;
}
```
