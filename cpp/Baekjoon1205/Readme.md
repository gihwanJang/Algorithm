# (1205) 등수 구하기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1205)
#
## 문제
태수가 즐겨하는 디제이맥스 게임은 각각의 노래마다 랭킹 리스트가 있다. 이것은 매번 게임할 때 마다 얻는 점수가 비오름차순으로 저장되어 있는 것이다.

이 랭킹 리스트의 등수는 보통 위에서부터 몇 번째 있는 점수인지로 결정한다. 하지만, 같은 점수가 있을 때는 그러한 점수의 등수 중에 가장 작은 등수가 된다.

예를 들어 랭킹 리스트가 100, 90, 90, 80일 때 각각의 등수는 1, 2, 2, 4등이 된다

랭킹 리스트에 올라 갈 수 있는 점수의 개수 P가 주어진다. 그리고 리스트에 있는 점수 N개가 비오름차순으로 주어지고, 태수의 새로운 점수가 주어진다. 이때, 태수의 새로운 점수가 랭킹 리스트에서 몇 등 하는지 구하는 프로그램을 작성하시오. 만약 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력한다.

만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.
#
## 입력
첫째 줄에 N, 태수의 새로운 점수, 그리고 P가 주어진다. P는 10보다 크거나 같고, 50보다 작거나 같은 정수, N은 0보다 크거나 같고, P보다 작거나 같은 정수이다. 그리고 모든 점수는 2,000,000,000보다 작거나 같은 자연수 또는 0이다. 둘째 줄에는 현재 랭킹 리스트에 있는 점수가 비오름차순으로 주어진다. 둘째 줄은 N이 0보다 큰 경우에만 주어진다.
#
## 출력
첫째 줄에 문제의 정답을 출력한다.
#
## 풀이
해당 문제는 우선순위 큐를 이용하면 해결 할 수 있는 문제입니다.

우선순위 큐에 태수의 점수를 제외한 점수를 P개를 넘지 않도록 넣습니다.

이후 우선순위 큐에 자리가 비었다만 태수의 점수를 넣고 아니면 가장 위의 값과 비교하여 태수의 점수가 크면 넣고 아니면 -1을 출력합니다.

태수의 점수르 넣었다면 태수의 점수가 우선순위 큐의 가장 위의 값보다 크거나 같은 때 까지 우선순위 큐에서 값을 빼줍니다.

이후 (우순순위 큐의 크기 + 1)을 출력하면 됩니다.

```cpp
#include <functional>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int getRanking(priority_queue<int, vector<int>, greater<int>>&pq, int p, int score)
{
    if(pq.size() < p || pq.empty())
    {
        pq.push(score);
    }
    else
    {
        if(pq.top() < score)
        {
            pq.pop();
            pq.push(score);
        }
        else
            return -1;
    }

    while(score >= pq.top() && !pq.empty())
        pq.pop();

    return pq.size() + 1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, score, p, s;
    cin >> n >> score >> p;

    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < n; ++i)
    {
        cin >> s;

        if(pq.size() < p)
            pq.push(s);
        else
            if(pq.top() < s)
            {
                pq.pop();
                pq.push(s);
            }
    }

    cout << getRanking(pq, p, score) << "\n";
    return 0;
}
```