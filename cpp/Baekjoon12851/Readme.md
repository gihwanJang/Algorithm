# (12851) 숨바꼭질 2
[문제 바로가기](https://www.acmicpc.net/problem/12851)
## :100: Algorithm
## 문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고, 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.
## 입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
#
## 출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.
#
## 풀이
해당 문제는 BFS를 이용하면 해결 할 수 있는 문제입니다.  

먼저 수빈이와 동생의 위치를 입력 받습니다.  

이후 수빈이의 위치를 기준으로 -1, +1, *2칸을 BFS 방식으로 방문해줍니다.  
이때 방문은 중복을 제거하기 위해 visited배열을 생성하여 방문하지 않은 곳만 방문하도록 합니다.

동생이 있는 칸에 도달했다면 가장 처음에 도달한 값이 가장 빠른 시간이 됩니다.  
이후 해당 시간보다 더큰 시간이 나올 때 까지 반복합니다.  
이때 반복하며 카운트를 증가시켜줍니다.  

위의 과정이 끝났다면 가장 빠른 시간과 카운트를 출력해 주시면 됩니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void find(int n, int k, int&t, int&cnt){
    pair<int, int> curr(n, 0);
    queue<pair<int, int>> que;
    vector<bool> visited(100001);

    visited[n] = true;
    que.push(curr);
    t = 1234567891;
    cnt = 0;

    while(!que.empty()){
        curr = que.front();
        que.pop();

        visited[curr.first] = true;

        if(curr.first == k){
            if(t >= curr.second){
                t = curr.second;
                ++cnt;
            }
            else
                break;
        }

        if(curr.first-1 >= 0 && !visited[curr.first-1])
            que.push({curr.first-1, curr.second+1});

        if(curr.first < visited.size() && !visited[curr.first+1])
            que.push({curr.first+1, curr.second+1});
            
        if(curr.first*2 < visited.size() && !visited[curr.first*2])
            que.push({curr.first*2, curr.second+1});
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, time, cnt;
    cin >> n >> k;

    find(n, k, time, cnt);

    cout << time << "\n";
    cout << cnt << "\n";
    return 0;
}
```