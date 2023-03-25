# (1697) 도시 분할 계획
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1647)

## 문제
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그러다가 평화로운 마을에 가게 되었는데, 그곳에서는 알 수 없는 일이 벌어지고 있었다.

마을은 N개의 집과 그 집들을 연결하는 M개의 길로 이루어져 있다. 길은 어느 방향으로든지 다닐 수 있는 편리한 길이다. 그리고 각 길마다 길을 유지하는데 드는 유지비가 있다.

마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다. 마을이 너무 커서 혼자서는 관리할 수 없기 때문이다. 마을을 분할할 때는 각 분리된 마을 안에 집들이 서로 연결되도록 분할해야 한다. 각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다는 뜻이다. 마을에는 집이 하나 이상 있어야 한다.

그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다. 그리고 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다. 마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 이것을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 집의 개수 N, 길의 개수 M이 주어진다. N은 2이상 100,000이하인 정수이고, M은 1이상 1,000,000이하인 정수이다. 그 다음 줄부터 M줄에 걸쳐 길의 정보가 A B C 세 개의 정수로 주어지는데 A번 집과 B번 집을 연결하는 길의 유지비가 C (1 ≤ C ≤ 1,000)라는 뜻이다.

## 출력
첫째 줄에 없애고 남은 길 유지비의 합의 최솟값을 출력한다.

## 풀이
해당 문제는 모든 노드 문제에서는 모든 집을 이어주는 가장 값이 싼 비용을 찾는 것과 같은 문제입니다.  
즉 최소 스패닝 트리를 구하여 마지막 노드만 이어주지 않으면 2개의 집단을 최소의 비용으로 이을 수 있습니다.  

집들과 비용을 입력 받습니다.  
이때 비용을 기준으로 정렬을 해야하므로 별도의 자료구조를 만들어 쓰지 않는다면 c++에서는 자동으로 가장 앞의 인덱스로 정렬을 하므로 비용을 가장 앞의 인덱스로 입력 받습니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m; 
    cin >> n >> m;

    vector<vector<int>> roads(m, vector<int>(3));
    for(int i = 0; i < m; ++i)
        cin >> roads[i][1] >> roads[i][2] >> roads[i][0];

    cout << city_division(roads, n) << "\n";
    return 0;
}
```

입력을 받았다면 비용을 기준으로 오름차순 정렬하여 노드를 하나 씩 이어줍니다.  
이때 노드가 순환경로를 만들면 안되므로 유니온 파인드 자료구조를 이용하여 부모노드가 같지 않은 경우만 선택해 줍니다.  
하나의 그룹을 만든다면 n-1개의 노드를 선택하면 되지만 현재 문제에서는 2개의 그룹을 만들라고 하였음으로 n-2개의 노드를 선택하여 값을 계산해 줍니다.

```cpp
int find(vector<int>&parents, int h){
    if(parents[h] == h) return h;
    return parents[h] = find(parents, parents[h]);
}

void union_set(vector<int>&parents, int h1, int h2){
    int r1 = find(parents, h1);
    int r2 = find(parents, h2);
    parents[r1] = r2;
}

int city_division(vector<vector<int>>&roads, int n){
    int cost = 0, cnt = 2;

    vector<int> parents(n+1);
    for(int i = 1; i <= n; ++i)
        parents[i] = i;

    sort(roads.begin(), roads.end());

    for(int i = 0; cnt < n; ++i){
        if(find(parents, roads[i][1]) == find(parents, roads[i][2]))
            continue;

        ++cnt;
        cost += roads[i][0];
        union_set(parents, roads[i][1], roads[i][2]);
    }

    return cost;
}
```