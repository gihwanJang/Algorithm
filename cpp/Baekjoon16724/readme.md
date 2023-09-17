# (16724) 피리 부는 사나이
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/16724)
#
## 문제
피리 부는 사나이 성우는 오늘도 피리를 분다.

성우가 피리를 불 때면 영과일 회원들은 자기도 모르게 성우가 정해놓은 방향대로 움직이기 시작한다. 성우가 정해놓은 방향은 총 4가지로 U, D, L, R이고 각각 위, 아래, 왼쪽, 오른쪽으로 이동하게 한다.

이를 지켜보던 재훈이는 더 이상 움직이기 힘들어하는 영과일 회원들을 지키기 위해 특정 지점에 ‘SAFE ZONE’ 이라는 최첨단 방음 시설을 만들어 회원들이 성우의 피리 소리를 듣지 못하게 하려고 한다. 하지만 예산이 넉넉하지 않은 재훈이는 성우가 설정해 놓은 방향을 분석해서 최소 개수의 ‘SAFE ZONE’을 만들려 한다. 

성우가 설정한 방향 지도가 주어졌을 때 재훈이를 도와서 영과일 회원들이 지도 어느 구역에 있더라도 성우가 피리를 불 때 ‘SAFE ZONE’에 들어갈 수 있게 하는 ‘SAFE ZONE’의 최소 개수를 출력하는 프로그램을 작성하시오.
#
## 입력
첫 번째 줄에 지도의 행의 수를 나타내는 N(1 ≤ N ≤ 1,000)과 지도의 열의 수를 나타내는 M(1 ≤ M ≤ 1,000)이 주어진다.

두 번째 줄부터 N개의 줄에 지도의 정보를 나타내는 길이가 M인 문자열이 주어진다.

지도 밖으로 나가는 방향의 입력은 주어지지 않는다.
#
## 출력
첫 번째 줄에 ‘SAFE ZONE’의 최소 개수를 출력한다.
#
## 풀이
해당 문제는 DFS를 이용하면 해결 할 수 있는 문제입니다.  

우선 해당 문제에서 궁극적으로 요구하는 것은 맵에서 몇개의 그룹으로 나뉘냐 입니다.  

그러므로 DFS를 실행하며 해당 노드에서 갈 수 있는 곳은 union-find자료구조를 이용하여 그룹화하여 최종 답을 도출 할 수 있습니다.  

우선 map의 가로(m) 세로(n) 크기를 입력 받습니다.  
해당 크기의 map을 입력 받습니다.  

맵에 대하여 DFS를 각 칸에 대하여 진행해 줍니다.  
이때 DFS각 방향으로 이동은 map밖으로 벗어나지 않기 때문에 좌표에 대한 검증은 따로 해주지 않아도 됩니다.  
또한 강 방향에 대하여 현재 위치와 다음 위치를 union하여 같은 그룹으로 묶어 줍니다.

위의 과정을 모두 끝냈따면 union table에 대하여 해당 인덱스와 같은 값을 가졌다면 카운트를 해줍니다.  

카운트 값을 출력합니다.

```cpp
#include <iostream>
#include <vector>

using namespace std;

int findNode(vector<int>&table, const int&node) {
    if(table[node] == node) return node;
    return table[node] = findNode(table, table[node]);
}

void unionNode(vector<int>&table, const int&from, const int&to) {
    int fromParent = findNode(table, from);
    int toParent = findNode(table, to);

    table[fromParent] = toParent;
}

void move(vector<pair<int,int>>&stack, vector<int>&table, int r, int c, int m, char d) {
    if (d == 'U'){
        unionNode(table, r * m + c, (r - 1) * m + c);
        stack.push_back({r - 1, c});
    }
    if (d == 'D'){
        unionNode(table, r * m + c, (r + 1) * m + c);
        stack.push_back({r + 1, c});
    }
    if (d == 'L'){
        unionNode(table, r * m + c, r * m + c - 1);
        stack.push_back({r, c - 1});
    }
    if (d == 'R'){
        unionNode(table, r * m + c, r * m + c + 1);
        stack.push_back({r, c + 1});
    }
}

int getMinimumGroup(vector<string>&map, int n, int m) {
    int groupCount = 0;
    pair<int, int> curr;
    vector<pair<int,int>> stack;
    vector<int> table(n * m);
    vector<vector<bool>> visited(n, vector<bool>(m));

    for(int i = 0; i < n*m; ++i)
        table[i] = i;

    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(!visited[r][c]) {
                stack.push_back({r, c});

                 while(!stack.empty()) {
                    curr = stack.back();
                    stack.pop_back();

                    if(!visited[r][c]){
                        visited[r][c] = true;
                        move(stack, table, r, c, m, map[r][c]);
                    }
                 }
            }

    for(int i = 0; i < n*m; ++i)
        if(table[i] == i)
            ++groupCount;

    return groupCount;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<string> map(n);
    for(int i = 0; i < n; ++i)
        cin >> map[i];

    cout << getMinimumGroup(map, n, m) << "\n";
    return 0;
}
```