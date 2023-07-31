# (1202) 
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1205)
#
## 문제
세계적인 도둑 상덕이는 보석점을 털기로 결심했다.

상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.

상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)

다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)

다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)

모든 숫자는 양의 정수이다.
#
## 출력
첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
#
## 풀이
해당 문제는 우선순위 큐를 이용하면 해결할 수 있는 문제입니다.

우선 보석과 가방의 정보를 입력받습니다.  
이후 보석과 가방을 각각 무게를 기준으로 오름차순 정렬해 줍니다.  

가방의 가장 작은 무게 부터 넣을 수 있는 보석을 모두 우선순위 큐에 넣습니다.  
가장 위의 값은 해당 가방에 넣을 수 있는 최고의 가격이므로 누적 합산해 줍니다.  
이외의 것들은 우선순위 큐에 넣어두고 무게가 작음으로 다음 가방에도 들어 갈 수 있습니다.   

위의 과정대로 각 가방에 대하여 넣을 수 있는 모든 보석을 넣었다면 최대의 가격을 출력하면 됩니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Gem
{
    int weight, value;
};

bool cmp(Gem a, Gem b)
{
    return a.weight < b.weight;
}

long getMaxValue(vector<Gem>&gems, vector<int>&bags)
{   
    sort(gems.begin(), gems.end(), cmp);
    sort(bags.begin(), bags.end());

    int idx = 0;
    long value = 0;
    priority_queue<int> pq;

    for(int i = 0; i < bags.size(); ++i)
    {
        while(idx < gems.size() && gems[idx].weight <= bags[i])
            pq.push(gems[idx++].value);

        if(!pq.empty())
        {
            value += pq.top();
            pq.pop();
        }
    }

    return value;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<Gem> gems(n);
    for (int i = 0; i < n; ++i)
        cin >> gems[i].weight >> gems[i].value;

    vector<int> bags(k);
    for (int i = 0; i < k; ++i)
        cin >> bags[i];

    cout << getMaxValue(gems, bags) << "\n";
    return 0;
}
```