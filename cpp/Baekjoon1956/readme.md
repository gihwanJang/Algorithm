# (1956) 운동
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1956)
#
## 문제
V개의 마을와 E개의 도로로 구성되어 있는 도시가 있다. 도로는 마을과 마을 사이에 놓여 있으며, 일방 통행 도로이다. 마을에는 편의상 1번부터 V번까지 번호가 매겨져 있다고 하자.

당신은 도로를 따라 운동을 하기 위한 경로를 찾으려고 한다. 운동을 한 후에는 다시 시작점으로 돌아오는 것이 좋기 때문에, 우리는 사이클을 찾기를 원한다. 단, 당신은 운동을 매우 귀찮아하므로, 사이클을 이루는 도로의 길이의 합이 최소가 되도록 찾으려고 한다.

도로의 정보가 주어졌을 때, 도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성하시오. 두 마을을 왕복하는 경우도 사이클에 포함됨에 주의한다.
#
## 입력
첫째 줄에 V와 E가 빈칸을 사이에 두고 주어진다. (2 ≤ V ≤ 400, 0 ≤ E ≤ V(V-1)) 다음 E개의 줄에는 각각 세 개의 정수 a, b, c가 주어진다. a번 마을에서 b번 마을로 가는 거리가 c인 도로가 있다는 의미이다. (a → b임에 주의) 거리는 10,000 이하의 자연수이다. (a, b) 쌍이 같은 도로가 여러 번 주어지지 않는다.
#
## 출력
첫째 줄에 최소 사이클의 도로 길이의 합을 출력한다. 운동 경로를 찾는 것이 불가능한 경우에는 -1을 출력한다.
#
## 풀이
해당 문제는 플로이드 웨샬을 이용하면 해결 할 수 있는 문제입니다.

우선 가중치 그래프를 입력 받습니다.  

이후 플로이드 워셜 알고리즘을 통하여 모든 경로로의 최단거리를 구해줍니다.  
플로이드 워셜의 점화식은 아래와 같습니다.  
graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k]);

이후 자기자신을 가리키는 값중 가장 작은 값을 찾아 출력해 주면 됩니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

#define INF 1000000000

using namespace std;

int getMinimumCycle(vector<vector<int>>&graph, int v, int e)
{
    int minimum = INF;
    
    for(int i = 0; i < v; ++i)
        for(int j = 0; j < v; ++j)
            for(int k = 0; k < v; ++k)
                graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k]);

    for(int i = 0; i < v; ++i)
        minimum = min(graph[i][i], minimum);

    return minimum == INF ? -1  : minimum;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int v, e, start, end, value;
    cin >> v >> e;

    vector<vector<int>> graph(v, vector<int>(v, INF));
    for(int i = 0; i < e; ++i)
    {
        cin >> start >> end >> value;
        graph[start-1][end-1] = value;
    }

    cout << getMinimumCycle(graph, v, e) << "\n";
    return 0;
}
```