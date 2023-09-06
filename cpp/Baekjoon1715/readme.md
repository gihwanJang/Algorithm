# (1715) 카드 정렬하기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1715)
#
## 문제
정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다. 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.

매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다. 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다. 그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.

N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.
#
## 출력
첫째 줄에 최소 비교 횟수를 출력한다.
#
## 풀이
해당 문제는 우선순위 큐를 이용하면 해결 할 수 있는 문제입니다.  

우선 카드의 수를 입력받습니다.  

이후 우선순위 큐를 선언 후 카드를 차례대로 우선순위 큐에 넣습니다.  

카드를 두개 씩 뺀후 더한 값을 누적 변수에 누적하고 우선순위 큐에 더한 값을 다시 넣습니다.  
해당 과정은 우선순위 큐의 사이즈가 1이하가 될 때 까지 반복합니다.  

이후 누적한 값을 출력합니다.  

```cpp
#include <iostream>
#include <queue>

using namespace std;

int getMinimumCmp(priority_queue<int, vector<int>, greater<int>>&pq, int n)
{
    int cnt = 0;

    for(int f, s; 1 < pq.size(); cnt += f + s)
    {
        f = pq.top();
        pq.pop();

        s = pq.top();
        pq.pop();

        pq.push(f + s);
    }

    return cnt;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int card;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < n; ++i)
    {
        cin >> card;
        pq.push(card);
    }

    cout << getMinimumCmp(pq, n) << "\n";
    return 0;
}
```