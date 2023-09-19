# (1766) 문제집
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/16724)
#
## 문제
민오는 1번부터 N번까지 총 N개의 문제로 되어 있는 문제집을 풀려고 한다. 문제는 난이도 순서로 출제되어 있다. 즉 1번 문제가 가장 쉬운 문제이고 N번 문제가 가장 어려운 문제가 된다.

어떤 문제부터 풀까 고민하면서 문제를 훑어보던 민오는, 몇몇 문제들 사이에는 '먼저 푸는 것이 좋은 문제'가 있다는 것을 알게 되었다. 예를 들어 1번 문제를 풀고 나면 4번 문제가 쉽게 풀린다거나 하는 식이다. 민오는 다음의 세 가지 조건에 따라 문제를 풀 순서를 정하기로 하였다.

N개의 문제는 모두 풀어야 한다.
먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
가능하면 쉬운 문제부터 풀어야 한다.
예를 들어서 네 개의 문제가 있다고 하자. 4번 문제는 2번 문제보다 먼저 푸는 것이 좋고, 3번 문제는 1번 문제보다 먼저 푸는 것이 좋다고 하자. 만일 4-3-2-1의 순서로 문제를 풀게 되면 조건 1과 조건 2를 만족한다. 하지만 조건 3을 만족하지 않는다. 4보다 3을 충분히 먼저 풀 수 있기 때문이다. 따라서 조건 3을 만족하는 문제를 풀 순서는 3-1-4-2가 된다.

문제의 개수와 먼저 푸는 것이 좋은 문제에 대한 정보가 주어졌을 때, 주어진 조건을 만족하면서 민오가 풀 문제의 순서를 결정해 주는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 문제의 수 N(1 ≤ N ≤ 32,000)과 먼저 푸는 것이 좋은 문제에 대한 정보의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 둘째 줄부터 M개의 줄에 걸쳐 두 정수의 순서쌍 A,B가 빈칸을 사이에 두고 주어진다. 이는 A번 문제는 B번 문제보다 먼저 푸는 것이 좋다는 의미이다.

항상 문제를 모두 풀 수 있는 경우만 입력으로 주어진다.
#
## 출력
첫째 줄에 문제 번호를 나타내는 1 이상 N 이하의 정수들을 민오가 풀어야 하는 순서대로 빈칸을 사이에 두고 출력한다.
#
## 풀이
해당 문제는 우선순위 큐와 위상 정렬을 이용하면 해결 할 수 있는 문제입니다.  

우선 위상 정렬의 경우 그래프에서 순서가 있을 때 노드를 순서대로 정렬을 할 수 있습니다.  
방법을 아래와 같습니다.  
- 그래프를 만들며 해당 노드에 대하여 진입차수를 기록해 준다.
- 진입차수가 0인 것 큐에 넣어 방문한다.
- 0인 진입차수에서 방문할 수 있는 노드의 진입차수를 1 낮추고 만약 해당 노드의 진입 차수가 0이면 큐에 넣는 다.

위의 방식 대로하면 순서대로 정렬을 할 수 있지만 해당 문제에서는 큐에서 작은 순서대로 꺼내는 것을 요구하고 있으므로 우선 순위큐를 이용합니다.  

우선 노드의 갯수(n), 간선의 갯수(m)을 입력 받습니다.   
m번 반복하면 간선을 입력 받아 그래프를 만듭니다.  
이때 그래프를 통해 각 노드의 진입 차수를 기록해 줍니다.  

진입 차수각 0인 것들을 우선순위 큐에 넣습니다.  

우선순위 큐에서 노드를 빼고 해당 노드를 기록합니다.  
그래프에서 뺀 노드에서 갈 수있는 노드에 대하여 진입차수를 1 감소 시키며 감소시킨 노드의 진입 차수가 0이 되면 우선 순위 큐에 넣습니다.

기록한 노드들을 출력합니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> getSolveSeq(vector<vector<int>>&graph, vector<int>&entries) {
    int curr;
    int size = entries.size();
    vector<int> solveSeq(size);
    priority_queue<int> pq;

    for(int i = 0 ; i < size; ++i)
        if(!entries[i])
            pq.push(i * -1);

    for(int i = 0; i < size; ++i) { 
        curr = pq.top();
        curr *= -1;
        pq.pop();

        solveSeq[i] = curr+1;

        for(int j = 0; j < graph[curr].size(); ++j) {
            --entries[graph[curr][j]];
            if(!entries[graph[curr][j]]) 
                pq.push(graph[curr][j] * -1);
        }
    }

    return solveSeq;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    vector<int> entries(n);
    vector<vector<int>> graph(n);
    for(int i = 0; i < m; ++i) {
        cin >> s >> e;
        graph[s-1].push_back(e-1);
        ++entries[e-1];
    }
    
    for(int i : getSolveSeq(graph, entries))
        cout << i << " ";
    return 0;
}
```