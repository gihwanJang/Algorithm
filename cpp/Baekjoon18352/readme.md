# (18352) 특정 거리의 도시 찾기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/18352)
#
## 문제
어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.

이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오. 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.

예를 들어 N=4, K=2, X=1일 때 다음과 같이 그래프가 구성되어 있다고 가정하자.

![img1](https://upload.acmicpc.net/a5e311d7-7ce4-4638-88a5-3665fb4459e5/-/preview/)

이 때 1번 도시에서 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 2인 도시는 4번 도시 뿐이다.  2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않는다.
#
## 입력
첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다. (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다. 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다. (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.
#
## 출력
X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.

이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.
#
## 풀이
해당 문제는 다익스트라 알고리즘을 활용하면 해결 할 수 있는 문제입니다.

우선 도시의 수(n), 도로의 수(m), 찾는 거리(k), 출발 도시(x)를 입력 받습니다.  

이후 m개의 도로의 정보를 입력 받아 그래프를 만들어줍니다.

해당 도로의 정보를 이용해 출발 도시에서 부터 다익스트라 알고리즘을 실행해 줍니다.  
매번 가장 짧은 간선을 선택하여 기존의 거리와 선택한 거리+1을 비교하며 가장 짧은 거리로 갱신해줍니다.  
이때 우선순위 큐를 이용하여 가장 짧은 간선을 선택하며 우선순위 큐 특성상 가장 큰 값을 젤 위에 두므로 음수를 저장하여 사용합니다.  

이후 모든 거리가 갱신이 끝났다면 k값을 가지는 도시를 출력해줍니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1000000000

using namespace std;

void dijkstra(vector<vector<int>>&road, vector<int>&distance, int n, int x)
{
    pair<int,int> curr;
    distance[x] = 0;
    priority_queue<pair<int,int>> pq;

    for(int i = 0; i < road[x].size(); ++i)
        pq.push({-1, road[x][i]});

    while(!pq.empty())
    {
        curr = pq.top();
        pq.pop();

        distance[curr.second] = min(distance[curr.second], -curr.first);

        for(int i = 0; i < road[curr.second].size(); ++i)
            if(distance[road[curr.second][i]] == INF)
                pq.push({curr.first-1, road[curr.second][i]});
    }
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bool hasAnswer = false;
    int n, m, k, x;
    cin >> n >> m >> k >> x;

    int s, e;
    vector<vector<int>> road(n);
    while(m--)
    {
        cin >> s >> e;
        road[s-1].push_back(e-1);
    }

    vector<int> distance(n, INF);
    dijkstra(road, distance, n, x-1);

    for(int i = 0; i < n; ++i)
    {
        if(distance[i] == k)
        {
            cout << i+1 << "\n";
            hasAnswer = true;
        }
    }

    if(!hasAnswer)
        cout << -1 << "\n";
    return 0;
}
```