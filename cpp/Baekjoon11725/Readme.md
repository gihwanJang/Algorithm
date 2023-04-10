# (11725) 트리의 부모 찾기 
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/11725)
#
## 문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
#
## 출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
#
## 풀이
해당 문제는 그래프 순회 문제입니다.  

해당 문제는 메모리 제한이 있기 때문에 그래프의 종류를 잘 선택하여야합니다.  
해당 문제에서는 인접행렬이 아닌 인접리스트 형식을 이용하여 구현하였습니다.  

그래프입력이 완료되면 DFS or BFS로 순회하여 부모노드를 찾아주면 됩니다.  

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void DFS(vector<vector<int>>&graph, vector<int>&parent, int curr){
    for(int i = 0; i < graph[curr].size(); ++i)
        if(!parent[graph[curr][i]]){
            parent[graph[curr][i]] = curr;
            DFS(graph, parent, graph[curr][i]);
        }                
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s, e;
    cin >> n;

    vector<int> parent(n+1);
    vector<vector<int>> graph(n+1);
    while(--n){
        cin >> s >> e;
        graph[s].push_back(e);
        graph[e].push_back(s);
    }

    parent[1] = 1;
    DFS(graph, parent, 1);
    for(int i = 2; i < parent.size(); ++i)
        cout << parent[i] << "\n";
    return 0;
}

```