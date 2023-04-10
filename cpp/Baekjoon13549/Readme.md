# (13549) 트리의 부모 찾기 
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/13549)
#
## 문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
#
## 입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
#
## 출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
#
## 풀이
해당 문제는 BFS를 통해 해결할 수 있는 문제입니다.  

위치와 횟수값을 가지는 pair를 이용하여 BFS를 시행 합니다.  

위치와 횟수는 아래와 같이 

- {curr.firstx2, curr.seconed}
- {curr.first-1, curr.second+1}
- {curr.first+1, curr.second+1}

이 되며 한번 방문했을 때가 해당 위치에 대한 최솟값이므로 다시 해당 위치를 방문하지 않습니다.  

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int hideAndSick(int n, int k){
    pair<int,int> curr;
    vector<bool> visited(100001);
    queue<pair<int,int>> que;
    que.push({n,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.first == k)
            return curr.second;

        if(curr.first*2 < visited.size() && !visited[curr.first*2]){
            que.push({curr.first*2, curr.second});
            visited[curr.first*2] = true;
        }
        if(curr.first > 0 && !visited[curr.first-1]){
            que.push({curr.first-1, curr.second+1});
            visited[curr.first-1] = true;
        }
        if(curr.first+1 < visited.size() && !visited[curr.first+1]){
            que.push({curr.first+1, curr.second+1});
            visited[curr.first+1] = true;
        }
    }
    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    cout << hideAndSick(n, k) << "\n";
    return 0;
}

```