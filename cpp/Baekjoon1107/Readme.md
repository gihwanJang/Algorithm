# (1107) 리모컨
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1107)
#
## 문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다.
#
## 입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
#
## 출력
첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
#
## 풀이
가장 짧은 루트로 채널을 켤 수 있는 방법은 3가지가 있습니다.  

1. |100 - N|
2. N보다 작거나 같으면서 가장 높은 채널 = low.f, 횟수 = low.n
    -  low.n + |low.c - N|
3. N보다 zm거나 같으면서 가장 낮은 채널 = high.f, 횟수 = high.n
    -  high.n + |high.c - N|

위의 3가지 방법입니다.  
이때 low와 high를 구하는 방법은 BFS를 이용하여 구현하였습니다.  

depth는 n이되며 값은 사용가능한 버튼을 이용하여 구해줍니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

int remote(vector<bool>&nums, int N){
    int res = abs(N-100);
    
    pair<int,int> curr;
    pair<int,int> lower = {0,999999};
    pair<int,int> higher = {1234567891,999999};
    
    vector<bool> visited(N*10+10);
    queue<pair<int,int>> que;
    que.push({0,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        for(int i = 0; i < 10; ++i)
            if(nums[i] && curr.first <= N && !visited[curr.first*10 + i]){
                que.push({curr.first*10 + i, curr.second+1});
                visited[curr.first*10 + i] = true;
            }
        
        if(curr.first <= N && curr.second)
            lower = curr;
        if(curr.first >= N && curr.second)
            higher = min(higher, curr);
    }

    res = min(res, lower.second + abs(N-lower.first));
    res = min(res, higher.second + abs(N-higher.first));
    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, k;
    cin >> N >> M;

    vector<bool> nums(10, true);
    while(M--){
        cin >> k;
        nums[k] = false;
    }

    cout << remote(nums, N) << "\n";
    return 0;
}
```