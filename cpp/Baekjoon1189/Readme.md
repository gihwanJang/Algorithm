# (1189) 컴백홈
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1189)
#
## 문제
한수는 캠프를 마치고 집에 돌아가려 한다. 한수는 현재 왼쪽 아래점에 있고 집은 오른쪽 위에 있다. 그리고 한수는 집에 돌아가는 방법이 다양하다. 단, 한수는 똑똑하여 한번 지나친 곳을 다시 방문하지는 않는다.

        cdef  ...f  ..ef  ..gh  cdeh  cdej  ...f 
        bT..  .T.e  .Td.  .Tfe  bTfg  bTfi  .Tde 
        a...  abcd  abc.  abcd  a...  a.gh  abc. 
    거리 :  6     6     6     8     8    10    6

위 예제는 한수가 집에 돌아갈 수 있는 모든 경우를 나타낸 것이다. T로 표시된 부분은 가지 못하는 부분이다. 문제는 R x C 맵에 못가는 부분이 주어지고 거리 K가 주어지면 한수가 집까지도 도착하는 경우 중 거리가 K인 가짓수를 구하는 것이다.
#
## 입력
첫 줄에 정수 R(1 ≤ R ≤ 5), C(1 ≤ C ≤ 5), K(1 ≤ K ≤ R×C)가 공백으로 구분되어 주어진다. 두 번째부터 R+1번째 줄까지는 R×C 맵의 정보를 나타내는 '.'과 'T'로 구성된 길이가 C인 문자열이 주어진다.
#
## 출력
첫 줄에 거리가 K인 가짓수를 출력한다.
#
## 풀이
해당 문제는 DFS를 이용하면 해결 할 수 있는 문제입니다.

우선 맵을 입력받습니다.  
해당 맵의 좌하단에서 우상단 까지 DFS를 실행합니다.  
이때 왔던 길은 다시 가면 않되므로 visted를 체크해주면서 DFS를 실행합니다.  

만약 우상단에 도착했다면 거리가 k값과 같으면 카운트를 증가시키고 아니면 증가시키지 않습니다.

DFS가 끝났다면 카운트를 출력해 주시면 됩니다.

```cpp
#include <iostream>
#include <vector>

using namespace std;

struct Location
{
    int r, c;
    Location(int R, int C): r(R), c(C){}
};

bool canGo(vector<string>&road_map, vector<vector<bool>>&visited, int r, int c)
{
    if(0 > r || r >= road_map.size())
        return false;
    if(0 > c || c >= road_map[0].size())
        return false;
    if(visited[r][c])
        return false;
    if(road_map[r][c] == 'T')
        return false;
    return true;
}

int getNumberOfArrivalRoutes(vector<string>&road_map, vector<vector<bool>>&visited, int k, Location curr, int distance)
{
    if(curr.r == road_map.size()-1 && curr.c == road_map[0].size()-1)
        return distance == k;

    int count = 0;
    visited[curr.r][curr.c] = true;

    if (canGo(road_map, visited, curr.r + 1, curr.c))
        count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r + 1, curr.c), distance + 1);
    if (canGo(road_map, visited, curr.r - 1, curr.c))
       count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r - 1, curr.c), distance + 1);
    if (canGo(road_map, visited, curr.r, curr.c + 1))
        count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r, curr.c + 1), distance + 1);
    if (canGo(road_map, visited, curr.r, curr.c - 1))
        count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r, curr.c - 1), distance + 1);

    visited[curr.r][curr.c] = false;
    return count;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int R, C, K;
    cin >> R >> C >> K;

    vector<string> road_map(R);
    vector<vector<bool>> visited(R, vector<bool>(C));
    for(int i = R-1; i >= 0; --i)
        cin >> road_map[i];

    cout << getNumberOfArrivalRoutes(road_map, visited, K, Location(0,0) ,1) << "\n";
    return 0;
}
```