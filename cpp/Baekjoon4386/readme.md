# (4386) 별자리 만들기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/4386)
#
## 문제
도현이는 우주의 신이다. 이제 도현이는 아무렇게나 널브러져 있는 n개의 별들을 이어서 별자리를 하나 만들 것이다. 별자리의 조건은 다음과 같다.

- 별자리를 이루는 선은 서로 다른 두 별을 일직선으로 이은 형태이다.
- 모든 별들은 별자리 위의 선을 통해 서로 직/간접적으로 이어져 있어야 한다.

별들이 2차원 평면 위에 놓여 있다. 선을 하나 이을 때마다 두 별 사이의 거리만큼의 비용이 든다고 할 때, 별자리를 만드는 최소 비용을 구하시오.
#
## 입력
첫째 줄에 별의 개수 n이 주어진다. (1 ≤ n ≤ 100)

둘째 줄부터 n개의 줄에 걸쳐 각 별의 x, y좌표가 실수 형태로 주어지며, 최대 소수점 둘째자리까지 주어진다. 좌표는 1000을 넘지 않는 양의 실수이다.
#
## 출력
첫째 줄에 정답을 출력한다. 절대/상대 오차는 10-2까지 허용한다.
#
## 풀이
해당 문제는 크루스칼, 프림 알고리즘을 이용하면 해결 할 수 있는 문제입니다.  

우선 해당 문제는 크루스칼 알고리즘을 이용하여 해결 하였습니다.  

크루스칼 알고리즘에 대하여 간략하게 설명 드리면 모든 간선을 가중치 순으로 정렬후 가장 작은 값들을 선택하며 스패닝 트리를 만드는 알고리즘입니다.  
이때 스패닝 트리는 사이클이 발생하면 안되기 때문에 해당 문제를 방지하기 위해 유니온 파인드 자료구조를 이용하여 사이클을 방지합니다.  

별의 갯수(n), 과 n개의 좌표를 입력 받습니다.  

모든 좌표에 대하여 (거리, 별의 인덱스, 별의 인덱스)의 형태로 만들어 리스트를 만들어 줍니다.  

오름 차순으로 리스트를 정렬합니다.  

이후 해당 리스트의 별들이 사이클이 발생하지 않는다면 이어줍니다.  
이때 이으면서 해당 거리의 값을 누적 합산해 줍니다.

누적 합산한 값을 출력해 줍니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

struct Point{double x, y;};

struct Edge{
    double distance; 
    int from, to;

    Edge(double d, int f, int t) {
        distance = d;
        from = f;
        to = t;
    }

    bool operator<(const Edge &e) const {
		return distance < e.distance;
	}
};

double getDistance(Point a, Point b){
    double dx = b.x - a.x;
    double dy = b.y - a.y;
    return sqrt(dx * dx + dy * dy);
}

int findNode(vector<int>&union_table, const int&node) {
    if(union_table[node] == node) return node;
    return union_table[node] = findNode(union_table, union_table[node]);
}

bool unionNode(vector<int>&union_table, const int&from, const int&to) {
    int fromParent = findNode(union_table, from);
    int toParent = findNode(union_table, to);

    if(fromParent == toParent) return false;

    union_table[fromParent] = toParent;

    return true;
}

double getMinimumCost(vector<Point>&stars, const int&n) {
    double distance_sum = 0;
    vector<int> union_table(n);
    vector<Edge> edges;

    for(int i = 0; i < n; ++i)
        union_table[i] = i;

    for(int i = 0; i < n; ++i)
        for(int j = i + 1; j < n; ++j)
            edges.push_back(Edge(getDistance(stars[i], stars[j]), i, j));

    sort(edges.begin(), edges.end());

    for(int i = 0; i < edges.size(); ++i)
        if(unionNode(union_table, edges[i].from, edges[i].to))
            distance_sum += edges[i].distance;

    return distance_sum;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cout << fixed;
    cout.precision(2);

    int n;
    cin >> n;

    vector<Point> stars(n);
    for(int i = 0; i < n; ++i)
        cin >> stars[i].x >> stars[i].y;

    cout << getMinimumCost(stars, n) << "\n";
    return 0;
}
```