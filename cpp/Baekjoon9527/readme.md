# (9527) 1의 개수 세기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/9527)
#
## 문제
두 자연수 A, B가 주어졌을 때, A ≤ x ≤ B를 만족하는 모든 x에 대해 x를 이진수로 표현했을 때 1의 개수의 합을 구하는 프로그램을 작성하시오.

즉, f(x) = x를 이진수로 표현 했을 때 1의 개수라고 정의하고, 아래 식의 결과를 구하자.

 
$\sum_{x=A}^{B}{f(x)}$
#
## 입력
첫 줄에 두 자연수 A, B가 주어진다. (1 ≤ A ≤ B ≤ 1016)
#
## 출력
1의 개수를 세어 출력한다.
#
## 풀이
해당 문제는 다이나믹 프로그래밍 누적 합을 이용하면 해결 할 수 있는 문제입니다.  

우선 a~b까지 값을 증가시키며 1의 갯수를 찾는 다면 최악의 경우 10^16번을 해당 수에 대하여 1의 갯수를 찾는 연산을 해야하므로 시간초과가 나옵니다.  

그러므로 b | a 에 대하여 한번에 누적합산을 구해야 합니다.  

위의 방식 까지는 생각이 났으나 이후의 풀이는 생각이 나지 않아 [해당 블로그](https://tussle.tistory.com/1022)의 글을 참고 했습니다.

내용을 간단히 정리하자면 n까지의 1의 개수 누적 합산에 대한 식은 아래와 같습니다.  

- DP[n] = 2*DP[n-1] + 2^n

위의 식이 나오는 이유를 살펴 보겠습니다.

(n = 0)  
1  
-> 1  
(n = 1)  
<span style="color:red">1</span>0  
<span style="color:red">1</span>1  
-> 2 * (1 : n이 0일 때 값) + (2^1 : 빨간 1의 갯수) = 4  
(n = 2)  
<span style="color:red">1</span>00  
<span style="color:red">1</span>01  
<span style="color:red">1</span>10  
<span style="color:red">1</span>11  
-> 2 * (4 : n이 1일 때 값) + (2^2 : 빨간 1의 갯수) = 12
(n = 4)  
<span style="color:red">1</span>000   
<span style="color:red">1</span>001    
<span style="color:red">1</span>010  
<span style="color:red">1</span>011  
<span style="color:red">1</span>100    
<span style="color:red">1</span>101  
<span style="color:red">1</span>110  
<span style="color:red">1</span>111  
-> 2 * (12 : n이 1일 때 값) + (2^3 : 빨간 1의 갯수) = 32

위 처럼 빨간 1은 해당 n의 2^n만큼 갯수가 존재하며 뒤의 값은 이전과 동일한 경우가 2번 반복해서 나오게 됩니다.  
그러므로 해당 식이 나오게 됩니다.  

위의 방식으로 DP테이블을 미리 채워 놓습니다.  

이후 b와 a-1에 대하여 각각 아래의 방식으로 1의 갯수를 구합니다.  

입력 값의 자릿수를 구합니다.  
입력 값의 자릿수는 해당 입력값에 log를 취한뒤 log2로 나눠주면 해당 자릿수를 구할 수 있습니다.  

이후 해당 자릿수가 0이 아니라면 해당 자릿수 이전에 올 수 있는 값 즉 DP[n-1]의 값을 더한 후 현재의 값 까지의 1의 갯수를 더해 줍니다.  

마지막으로 b까지의 1의 개수에서 a-1까지의 1의 개수를 뺀 값을 출력해 줍니다.

```cpp
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void setTable(vector<long>&DP) {
    DP[0] = 1;
    for(int i = 1; i < 55; ++i)
        DP[i] = (DP[i-1] << 1) + (1L << i);
}

long getNumberOfOne(vector<long>&DP, long n) {
    long cnt = n & 1;
    int size = log(n) / log(2);

    for(int i = size; 0 < i; --i)
        if((n & (1L << i)) != 0L) {
            cnt += DP[i - 1] +(n - (1L << i) + 1);
            n -= (1L << i);
        }

    return cnt;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long a, b;
    cin >> a >> b;
    
    vector<long> DP(55);
    setTable(DP);

    cout << getNumberOfOne(DP, b) - getNumberOfOne(DP, a - 1);
    cout << "\n";
    return 0;
}
```