# (2096) 내려가기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2096)
#
## 문제
N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.

먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다. 그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다. 바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약 조건을 그림으로 나타내어 보면 다음과 같다.

![img1](https://www.acmicpc.net/JudgeOnline/upload/201007/down.png)

별표는 현재 위치이고, 그 아랫 줄의 파란 동그라미는 원룡이가 다음 줄로 내려갈 수 있는 위치이며, 빨간 가위표는 원룡이가 내려갈 수 없는 위치가 된다. 숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오. 점수는 원룡이가 위치한 곳의 수의 합이다.
#
## 입력
첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 숫자가 세 개씩 주어진다. 숫자는 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 중의 하나가 된다.
#
## 출력
첫째 줄에 얻을 수 있는 최대 점수와 최소 점수를 띄어서 출력한다.
#
## 풀이
해당 문제는 DP와 슬라이딩 윈도우를 이용하면 해결 할 수 있는 문제입니다.  

우선 해당 문제는 DFS나 BFS로도 충분히 해결은 할 수 있지만 해당 문제의 메모리 제한이 4MB(각 언어별 상이)있음으로 메모리 초과가 발생하게 됩니다.  

이때 기본적으로 include 하여 컴파일 후 실행하면 2020kB 즉 2.02MB를 쓰게되고 남는 1.98 MB로는 n 입력 범위의 최대인 100,000개의 줄을 감당할 수 없습니다.  
int는 보통 4byte이며 한줄에 3개 이므로 1.2MB를 사용하게되고 이외에 사용되는 메모리를 합하면 메모리 제한을 넘어서게 됩니다.  

그러므로 입력을 모두 저장할 수 없음으로 한 줄씩 처리 해야하므로 슬라이딩 윈도우 방식을 선택합니다.  

우선 초기 값으로 첫 번째 줄을 입력을 받고 두 번째 줄 부터 DP를 시작합니다.  

1. 다음 값을 입력을 받습니다.  
2. 다음에 올 값은 현제 입력 받은 값에서 다음 올 수있는 방향에서 최대 최소를 선택합니다.  
3. 이후 선택이 끝나면 다음의 값을 현재의 값으로 갱신시켜 줍니다.  

위의 과정이 끝나면 현재의 값에서 최대 최소를 찾아 출력해 주면 됩니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void getMinMax(vector<int>&board, vector<pair<int,int>>&curr, vector<pair<int,int>>&next){
    for(int c = 0; c < 3; ++c){
            next[c].first = curr[c].first + board[c];
            next[c].second = curr[c].second + board[c];

            if(c > 0){
                next[c].first = min(next[c].first, curr[c-1].first + board[c]);
                next[c].second = max(next[c].second, curr[c-1].second + board[c]);
            }

            if(c < 2){
                next[c].first = min(next[c].first, curr[c+1].first + board[c]);
                next[c].second = max(next[c].second, curr[c+1].second + board[c]);
            }
        }

    for(int c = 0; c < 3; ++c)
        curr[c] = {next[c].first, next[c].second};
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, min_sum = 1234567891, max_sum = 0;
    cin >> n;

    vector<int> board(3);
    vector<pair<int,int>> curr(3);
    vector<pair<int,int>> next(3);
    
    for(int i = 0; i < 3; ++i){
        cin >> board[i];
        curr[i] = {board[i], board[i]};
    }

    for(int r = 1; r < n; ++r){
        for(int c = 0; c < 3; ++c)
            cin >> board[c];

        getMinMax(board, curr, next);
    }

    for(int i = 0; i < 3; ++i){
        min_sum = min(min_sum, curr[i].first);
        max_sum = max(max_sum, curr[i].second);
    }
    
    cout << max_sum << " " << min_sum << "\n";
    return 0;
}

```