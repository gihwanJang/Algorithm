# (11286) 절댓값 힙
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/11286)
#
## 문제
절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

1. 배열에 정수 x (x ≠ 0)를 넣는다.
2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.  

프로그램은 처음에 비어있는 배열에서 시작하게 된다.
#
## 입력
첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.
#
## 출력
입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
#
## 풀이
해당 문제는 우선순위 큐를 사용하여 구현 하면되는 문제입니다.  
다만 우선순위를 계산하는 함수를 따로 작성해 주어야합니다.

해당 함수는 절대값이 같을 경우 대소로 판단하고 같지 않을 경우 절대값의 대소로 판단하게 합니다.  

```cpp
#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

struct compare{
    bool operator()(int a, int b){
        if(abs(a) == abs(b))
            return a > b;
        return abs(a) > abs(b);
    }
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    priority_queue<int, vector<int>, compare> que;
    cin >> n;

    while(n--){
        cin >> x;

        if(x)
            que.push(x);
        else{
            if(que.empty())
                cout << 0 << "\n";
            else{
                cout << que.top() << "\n";
                que.pop();
            }
        }
    }
    return 0;
}
```
