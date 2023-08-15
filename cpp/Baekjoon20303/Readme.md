# (20303) 할로윈의 양아치
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/20303)
#
## 문제
Trick or Treat!!

10월 31일 할로윈의 밤에는 거리의 여기저기서 아이들이 친구들과 모여 사탕을 받기 위해 돌아다닌다. 올해 할로윈에도 어김없이 많은 아이가 할로윈을 즐겼지만 단 한 사람, 일찍부터 잠에 빠진 스브러스는 할로윈 밤을 즐길 수가 없었다. 뒤늦게 일어나 사탕을 얻기 위해 혼자 돌아다녀 보지만 이미 사탕은 바닥나 하나도 얻을 수 없었다.

단단히 화가 난 스브러스는 거리를 돌아다니며 다른 아이들의 사탕을 빼앗기로 마음을 먹는다. 다른 아이들보다 몸집이 큰 스브러스에게 사탕을 빼앗는 건 어렵지 않다. 또한, 스브러스는 매우 공평한 사람이기 때문에 한 아이의 사탕을 뺏으면 그 아이 친구들의 사탕도 모조리 뺏어버린다. (친구의 친구는 친구다?!)

사탕을 빼앗긴 아이들은 거리에 주저앉아 울고 $K$명 이상의 아이들이 울기 시작하면 울음소리가 공명하여 온 집의 어른들이 거리로 나온다. 스브러스가 어른들에게 들키지 않고 최대로 뺏을 수 있는 사탕의 양을 구하여라.

스브러스는 혼자 모든 집을 돌아다녔기 때문에 다른 아이들이 받은 사탕의 양을 모두 알고 있다. 또한, 모든 아이는 스브러스를 피해 갈 수 없다.
#
## 입력
첫째 줄에 정수 $N$, $M$, $K$가 주어진다. $N$은 거리에 있는 아이들의 수, $M$은 아이들의 친구 관계 수, $K$는 울음소리가 공명하기 위한 최소 아이의 수이다. ($1 \leq N \leq 30\ 000$, $0 \leq M \leq 100\ 000$, $1 \leq K \leq \min\left\{N, 3\ 000\right\}$)

둘째 줄에는 아이들이 받은 사탕의 수를 나타내는 정수 $c_1, c_2, \cdots, c_N$이 주어진다. ($1 \leq c_i \leq 10\ 000$)

셋째 줄부터 $M$개 줄에 갈쳐 각각의 줄에 정수 $a$, $b$가 주어진다. 이는 $a$와 $b$가 친구임을 의미한다. 같은 친구 관계가 두 번 주어지는 경우는 없다. ($1 \leq a, b \leq N$, $a \neq b$)
#
## 출력
스브러스가 어른들에게 들키지 않고 아이들로부터 뺏을 수 있는 최대 사탕의 수를 출력한다.
#
## 풀이
해당 문제는 그래프 탐색과 다이나믹 프로그래밍을 이용하면 해결 할 수 있는 문제입니다.  

우선 캔디의 갯수와 친구관계를 입력 받습니다.  
입력받은 그래프를 탐색하며 친구를 그룹으로 묶으며 item을 만듭니다.  
이때 그룹의 아이들의 수는 weight가 되며 사탕의 수는 value가 됩니다.  

이후 해당 item들을 이용하여 냅색 알고리즘을 이용해 사탕의 최댓 값을 구합니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Item
{
    int weight, value;
};

void DFS(vector<int>&candys, vector<bool>&visited, vector<vector<int>>&relation, vector<Item>&items, int start)
{
    int curr = start;
    int candy = 0;
    int friendCount = 0;
    vector<int> stack;

    stack.push_back(start);
    while(!stack.empty())
    {
        curr = stack.back();
        stack.pop_back();

        if(!visited[curr])
        {
            visited[curr] = true;

            candy += candys[curr];
            ++friendCount;

            for(int i = 0; i < relation[curr].size(); ++i)
                if(!visited[relation[curr][i]])
                    stack.push_back(relation[curr][i]);
        }
    }
    
    items.push_back({friendCount, candy});
}

vector<Item> changeRelationToItems(vector<int>&candys, vector<vector<int>>&relation)
{
    vector<Item> items;
    vector<bool> visited(candys.size());

    for(int i = 0; i < candys.size(); ++i)
        if(!visited[i])
            DFS(candys, visited, relation, items, i);

    return items;
}

int getMaximumCandy(vector<int>&candys, vector<vector<int>>&relation, int k)
{
    vector<Item> items = changeRelationToItems(candys, relation);
    vector<vector<int>> table(items.size()+1, vector<int>(k));

    for(int r = 1; r <= items.size(); ++r)
        for(int c = 1; c < k; ++c)
        {
            if(c - items[r-1].weight >= 0)
                table[r][c] = max(table[r-1][c], table[r - 1][c - items[r-1].weight] + items[r-1].value);
            else
                table[r][c] = table[r-1][c];
        }

    return table[items.size()][k-1];
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k;
    cin >> n >> m >> k;

    vector<int> candys(n);
    for(int i = 0; i < n; ++i)
        cin >> candys[i];

    vector<vector<int>> relation(n);
    for(int i = 0; i < m; ++i)
    {
        int k1, k2;
        cin >> k1 >> k2;
        relation[k1-1].push_back(k2-1);
        relation[k2-1].push_back(k1-1);
    }

    cout << getMaximumCandy(candys, relation, k) << '\n';
    return 0;
}
```