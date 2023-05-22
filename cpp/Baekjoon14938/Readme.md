# (14938) 서강그라운드
[문제 바로가기](https://www.acmicpc.net/problem/14938)
## :100: Algorithm
## 문제
예은이는 요즘 가장 인기가 있는 게임 서강그라운드를 즐기고 있다. 서강그라운드는 여러 지역중 하나의 지역에 낙하산을 타고 낙하하여, 그 지역에 떨어져 있는 아이템들을 이용해 서바이벌을 하는 게임이다. 서강그라운드에서 1등을 하면 보상으로 치킨을 주는데, 예은이는 단 한번도 치킨을 먹을 수가 없었다. 자신이 치킨을 못 먹는 이유는 실력 때문이 아니라 아이템 운이 없어서라고 생각한 예은이는 낙하산에서 떨어질 때 각 지역에 아이템 들이 몇 개 있는지 알려주는 프로그램을 개발을 하였지만 어디로 낙하해야 자신의 수색 범위 내에서 가장 많은 아이템을 얻을 수 있는지 알 수 없었다.

각 지역은 일정한 길이 l (1 ≤ l ≤ 15)의 길로 다른 지역과 연결되어 있고 이 길은 양방향 통행이 가능하다. 예은이는 낙하한 지역을 중심으로 거리가 수색 범위 m (1 ≤ m ≤ 15) 이내의 모든 지역의 아이템을 습득 가능하다고 할 때, 예은이가 얻을 수 있는 아이템의 최대 개수를 알려주자.

![img](https://upload.acmicpc.net/ef3a5124-833a-42ef-a092-fd658bc8e662/-/preview/)

주어진 필드가 위의 그림과 같고, 예은이의 수색범위가 4라고 하자. ( 원 밖의 숫자는 지역 번호, 안의 숫자는 아이템 수, 선 위의 숫자는 거리를 의미한다) 예은이가 2번 지역에 떨어지게 되면 1번,2번(자기 지역), 3번, 5번 지역에 도달할 수 있다. (4번 지역의 경우 가는 거리가 3 + 5 = 8 > 4(수색범위) 이므로 4번 지역의 아이템을 얻을 수 없다.) 이렇게 되면 예은이는 23개의 아이템을 얻을 수 있고, 이는 위의 필드에서 예은이가 얻을 수 있는 아이템의 최대 개수이다.
## 입력
첫째 줄에는 지역의 개수 n (1 ≤ n ≤ 100)과 예은이의 수색범위 m (1 ≤ m ≤ 15), 길의 개수 r (1 ≤ r ≤ 100)이 주어진다.

둘째 줄에는 n개의 숫자가 차례대로  각 구역에 있는 아이템의 수 t (1 ≤ t ≤ 30)를 알려준다.

세 번째 줄부터 r+2번째 줄 까지 길 양 끝에 존재하는 지역의 번호 a, b, 그리고 길의 길이 l (1 ≤ l ≤ 15)가 주어진다.
#
## 출력
예은이가 얻을 수 있는 최대 아이템 개수를 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 이용하면 해결 할 수 있습니다.  

우선 노드와 값과 길의 정보를 입력받습니다.  

이후 모든 노드를 대상으로 각 노드로 가는 길의 거리 값의 최소를 찾기 위하여 다익스트라 알고리즘을 적용합니다.
그럼 해당 노드에 대하여 다른 노드로 가는 최솟 값들을 구할 수 있고 해당 거리가 수색 범위면 값을 합산하여 최댓 값을 찾습니다.

이후 최댓 값을 출력해 주면 됩니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891

using namespace std;

struct edge{
    int end, val;

    edge(int e, int v): end(e), val(v){}

    bool operator<(const edge&e)const{
        return this->val < e.val;
    }
};

int farming(vector<int>&items, vector<vector<edge>>&graph, int m, int start){
    int res = 0;
    edge curr(start, 0);
    edge next(0, 0);
    vector<int> distance(items.size(), INF);
    priority_queue<edge> pq;

    pq.push(curr);
    distance[start] = 0;
    
    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = graph[curr.end][i].val + curr.val;

            if(distance[next.end] > next.val){
                distance[next.end] = next.val;
                pq.push(next);
            }
        }
    }

    for(int i = 0; i < items.size(); ++i)
        if(distance[i] <= m)
            res += items[i];

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, r, ans = 0;
    cin >> n >> m >> r;

    vector<int> items(n);
    for(int i = 0; i < n; ++i)
        cin >> items[i];

    vector<vector<edge>> graph(n);
    while(r--){
        int s, e, v;
        cin >> s >> e >> v;

        graph[s-1].push_back(edge(e-1, v));
        graph[e-1].push_back(edge(s-1, v));
    }

    for(int i = 0; i < n; ++i)
        ans = max(ans, farming(items, graph, m, i));

    cout << ans << "\n";
    return 0;
}
```