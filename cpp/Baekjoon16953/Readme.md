# (16953) A -> B
## :100: Algorithm
## 문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

- 2를 곱한다.
- 1을 수의 가장 오른쪽에 추가한다.   

A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

## 입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

## 출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

## 풀이
해당 문제의 경우 전수조사를 통하여 해결 하였습니다.  
종료조건으로 a 와 b 가 같다면 현제 재귀의 깊이를 리턴하고 종료합며 a 가 b보다 클경우 INF값으 리턴하고 종료합니다.  
a 가 b 보다 작은 경우 a * 2의 경우와 a * 10 + 1의 경우 두가지를 모두 탐색하며 최소값을 갱신합니다.  
아래는 해당 설명을 코드로 구현한 것 입니다.

<코드>
```cpp
int makeB(long a, long b, int depth){
    if(a == b) return depth;

    int count = INF;
    if(a < b){
        count = min(count, makeB(a * 2, b, depth + 1));
        count = min(count, makeB(a * 10 + 1, b, depth + 1));
    }

    return count;
}
``` 