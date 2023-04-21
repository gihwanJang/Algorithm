# (1697) 숨바꼭질
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1697)

## 문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

## 입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

## 출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

## 풀이
처음에는 DP를 통해 풀 수 있는 문제인줄 알았지만 되돌아간다는 조건 때문에 풀 수 가 없었고 해당 문제는 단순한 BFS를 이용하여 해결하였습니다.  

BFS의 깊이는 해당 값에 대하여 도달할 수 있는 가장 작은 횟수가 됩니다.  
그러므로 해당 깊이의 값을 방문했다면 다시 해당 노드를 방문할 필요가 없음으로 visited 배열을 통해 해당 노드는 다시 방문 하지 않습니다.  

위의 조건에 해당 되지 않는 다면 que에 -1, +1, x2한 값과 현제 (깊이+1)한 노드를 넣어 줍니다.  

이때 빼면서 해당 k값을 확인 해도 되지만 que에 넣기 전에 -1,+1,x2한 값이 k인지 확인 후 (깊이+1)을 반환하는 것이 더 효율적입니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int seek(int n, int k){
    if(n >= k) return n - k;

    pair<int,int> curr;
    queue<pair<int,int>> que;
    vector<bool> visited(k+2);

    que.push({n,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        visited[curr.first] = true;

        if(curr.first+1 == k || curr.first-1 == k || curr.first*2 == k)
            return curr.second+1;

        if(!visited[curr.first+1])
            que.push({curr.first+1, curr.second+1});
        if(curr.first-1 > 0 && !visited[curr.first-1])
            que.push({curr.first-1, curr.second+1});
        if(curr.first*2 < k+2 && !visited[curr.first*2])
            que.push({curr.first*2, curr.second+1});
    }

    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, k;
    cin >> n >> k;

    cout << seek(n, k) << "\n";
    return 0;
}
```