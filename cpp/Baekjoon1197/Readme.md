# (1197) 최소 스패닝 트리
## :100: Algorithm
## 문제
그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.  
최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.

## 입력
첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.

그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.

## 출력
첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.

## 풀이
해당 문제는 kruskal 알고리즘을 이용하여 해결하였습니다.  
우선 간선 정보를 가지는 자료구조인 edge를 아래와 같이 작성하여 풀이 하였습니다.  
v1, v2는 연결된 노드이며 val는 가중치 입니다.
<간선>
```cpp
struct edge{
    int v1, v2, val;
};
```
이후 입력받은 간선들을 가중치를 기준으로 오름차순 정렬 합니다.  
이후 유니온 파인드 자료구조를 이용하여 해당 간선의 노드들의 파인드하여 루트가 동일하지 않다면 간선의 가중치를 합산후 간선의 노드들을 유니온해줍니다.
```cpp
int find(vector<int>&cycleTable, int x) {
    if(cycleTable[x] == x) return x;
    return find(cycleTable, cycleTable[x]);
}

int mst(vector<edge>&edges, vector<int>&cycleTable){
    sort(edges.begin(), edges.end(), cmp);

    int ans = 0;

    for(int i = 0, cnt = 2; cnt < cycleTable.size(); ++i){
        int root1 = find(cycleTable, edges[i].v1);
        int root2 = find(cycleTable, edges[i].v2);
        
        if(root1 != root2){
            ans += edges[i].val;
            // union
            cycleTable[root2] = root1;
            ++cnt;
        }
    }

    return ans;
}
```
최종적으로 합산한 값을 출력해 줍니다.
```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int v, e;
    cin >> v >> e;

    vector<edge> edges(e);
    for(int i = 0; i < e; ++i)
        cin >> edges[i].v1 >> edges[i].v2 >> edges[i].val;

    vector<int> cycleTable(v+1);
    for(int i = 1; i <= v; ++i)
        cycleTable[i] = i;

    cout << mst(edges, cycleTable) << "\n";
    return 0;
}
```
