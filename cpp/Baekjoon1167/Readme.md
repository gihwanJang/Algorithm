# (1167) 트리의 지름
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1167)
#
## 문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.
#
## 입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.
#
## 출력
첫째 줄에 트리의 지름을 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하여 해결 할 수 있습니다.  

우선 원 위의 점중 어떠한 한점은 어떤 점에서 출발하여도 가장 먼점에 해당합니다.  
해당 점을 찾기위해 다익스트라 알고리즘을 실행하여 거리가 가장 먼점을 선택합니다.  

이제 원 위의 한점을 찾았고 해당 점에서 가장 먼점을 찾게 된다면 그 점까지의 거리가 지름이 됩니다.  
찾은 원에서 다익스트라 알고리즘을 실행후 가장 먼 거리를 출력합니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct edge{
    int e, v;
    edge(int E, int V): e(E), v(V){}
};

pair<int,int> dijkstra(vector<vector<edge>>&tree, int start){
    pair<int,int> curr, next;
    vector<int> distance(tree.size());
    priority_queue<pair<int,int>> pq;
    pq.push({0, start});
    distance[start] = 1234567891;

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < tree[curr.second].size(); ++i){
            next = {curr.first + tree[curr.second][i].v, tree[curr.second][i].e};

            if(!distance[next.second] && distance[next.second] < next.first){
                distance[next.second] = next.first;
                pq.push({next.first, next.second});
            }
        }
    }

    for(int i = 0; i < tree.size(); ++i)
        if(i != start)
            if(curr.second < distance[i])
                curr = {i, distance[i]};

    return curr;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s, e, v;
    cin >> n;
    vector<vector<edge>> tree(n);
    while(n--){
        cin >> s;

        while(true){
            cin >> e;
            if(e == -1)
                break;
            cin >> v;

            tree[s-1].push_back(edge(e-1,v));
        }
    }
    
    pair<int,int> ans = dijkstra(tree, 0);
    ans = dijkstra(tree, ans.first);
    cout << ans.second << "\n";
    return 0;
}
```