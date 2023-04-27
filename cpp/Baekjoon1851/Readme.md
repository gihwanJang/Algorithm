# (1851) 웜홀
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1851)
#
## 문제
때는 2020년, 백준이는 월드나라의 한 국민이다. 월드나라에는 N개의 지점이 있고 N개의 지점 사이에는 M개의 도로와 W개의 웜홀이 있다. (단 도로는 방향이 없으며 웜홀은 방향이 있다.) 웜홀은 시작 위치에서 도착 위치로 가는 하나의 경로인데, 특이하게도 도착을 하게 되면 시작을 하였을 때보다 시간이 뒤로 가게 된다. 웜홀 내에서는 시계가 거꾸로 간다고 생각하여도 좋다.

시간 여행을 매우 좋아하는 백준이는 한 가지 궁금증에 빠졌다. 한 지점에서 출발을 하여서 시간여행을 하기 시작하여 다시 출발을 하였던 위치로 돌아왔을 때, 출발을 하였을 때보다 시간이 되돌아가 있는 경우가 있는지 없는지 궁금해졌다. 여러분은 백준이를 도와 이런 일이 가능한지 불가능한지 구하는 프로그램을 작성하여라.
#
## 입력
첫 번째 줄에는 테스트케이스의 개수 TC(1 ≤ TC ≤ 5)가 주어진다. 그리고 두 번째 줄부터 TC개의 테스트케이스가 차례로 주어지는데 각 테스트케이스의 첫 번째 줄에는 지점의 수 N(1 ≤ N ≤ 500), 도로의 개수 M(1 ≤ M ≤ 2500), 웜홀의 개수 W(1 ≤ W ≤ 200)이 주어진다. 그리고 두 번째 줄부터 M+1번째 줄에 도로의 정보가 주어지는데 각 도로의 정보는 S, E, T 세 정수로 주어진다. S와 E는 연결된 지점의 번호, T는 이 도로를 통해 이동하는데 걸리는 시간을 의미한다. 그리고 M+2번째 줄부터 M+W+1번째 줄까지 웜홀의 정보가 S, E, T 세 정수로 주어지는데 S는 시작 지점, E는 도착 지점, T는 줄어드는 시간을 의미한다. T는 10,000보다 작거나 같은 자연수 또는 0이다.

두 지점을 연결하는 도로가 한 개보다 많을 수도 있다. 지점의 번호는 1부터 N까지 자연수로 중복 없이 매겨져 있다.
#
## 출력
TC개의 줄에 걸쳐서 만약에 시간이 줄어들면서 출발 위치로 돌아오는 것이 가능하면 YES, 불가능하면 NO를 출력한다.
#
## 풀이
해당 문제는 최단거리 알고리즘으로 풀 수 있는 문제입니다.  
최단 거리 알고리즘에는 다익스트라, 플로이드 워셜, 벨만포드와 같이 여러 알고리즘들이 존재하지만 해당 문제는 특정 출발노드에서 도착 노드까지의 최단거리만 구하면 되고 가중치에 음수가 존재하므로 벨만포드 알고리즘을 사용할 수 있습니다.  

우선 입력을 받는데 도로의 경우는 양방향 이동이 가능하므로 start->end, end->start 두 경우에 대하여 모두 입력으로 받아 주여야하고 웜홀의 경우 단방향 이동이므로 start->end로 이동하지만 시간이 뒤로 흘러가므로 음수로 입력을 받습니다.  

입력이 끝나면 해당 입력 그래프를 통해 벨만 포드 알고리즘을 실행해줍니다.  
과정은 아래와 같습니다.  

1. 입력 노드의 갯수만큼 거리를 저장할 리스트를 생성 및 INF로 초기화
2. 초기화가 끝났다면 모든 edge마다 n-2번 방문하며 거리 값을 갱신
    - 이때 기존의 벨만 포드방식 처럼 해당 노드가 INF인지 확인을 하면 안됩니다.  
3. 마지막으로 n-1번 째에서 갱신을 했다면 루프가 존재하는 것이므로 YES를 출력하고 갱신하지 않고 끝나면 NO를 출력  

```cpp
#include <iostream>
#include <vector>

#define INF 1234567891

using namespace std;

struct edge{
    int s, e, v;
};

bool bellman_ford(vector<edge>&graph, int nodeSize){
    vector<int> distance(nodeSize);

    for(int i = 1; i < nodeSize; ++i)
        distance[i] = INF;
    
    for(int n = 0; n < nodeSize; ++n)
        for(int m = 0; m < graph.size(); ++m)
            if(distance[graph[m].e] > distance[graph[m].s] + graph[m].v){
                distance[graph[m].e] = distance[graph[m].s] + graph[m].v;
                
                if(n == nodeSize - 1)
                    return true;
            }

    return false;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n, m, w, s, e, v;
    cin >> T;

    while(T--){
        cin >> n >> m >> w;

        vector<edge> graph;
        for(int i = 0; i < m; ++i){
            cin >> s >> e >> v;
            graph.push_back({s-1, e-1, v});
            graph.push_back({e-1, s-1, v});
        }
        for(int i = 0; i < w; ++i){
            cin >> s >> e >> v;
            graph.push_back({s-1, e-1, -v});
        }

        cout << (bellman_ford(graph, n) ? "YES" : "NO") << "\n";
    }
    return 0;
}
```