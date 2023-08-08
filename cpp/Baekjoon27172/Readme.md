# (27172) 수 나누기 게임
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/27172)
#
## 문제
《보드게임컵》을 준비하다 지친 은하는 보드게임컵 참가자들을 경기장에 몰아넣고 결투를 시키는 게임 《수 나누기 게임》을 만들었습니다.

《수 나누기 게임》의 규칙은 다음과 같습니다.

- 게임을 시작하기 전 각 플레이어는 $1$부터 $1\,000\,000$ 사이의 수가 적힌 서로 다른 카드를 잘 섞은 뒤 한 장씩 나눠 가집니다.
- 매 턴마다 플레이어는 다른 플레이어와 한 번씩 결투를 합니다.
- 결투는 서로의 카드를 보여주는 방식으로 진행되며, 플레이어의 카드에 적힌 수로 다른 플레이어의 카드에 적힌 수를 나눴을 때, 나머지가 $0$이면 승리합니다. 플레이어의 카드에 적힌 수가 다른 플레이어의 카드에 적힌 수로 나누어 - 떨어지면 패배합니다. 둘 다 아니라면 무승부입니다.
- 승리한 플레이어는 $1$점을 획득하고, 패배한 플레이어는 $1$점을 잃습니다. 무승부인 경우 점수의 변화가 없습니다.
- 본인을 제외한 다른 모든 플레이어와 정확히 한 번씩 결투를 하고 나면 게임이 종료됩니다.

《수 나누기 게임》의 결과를 가지고 한별이와 내기를 하던 은하는 게임이 종료되기 전에 모든 플레이어의 점수를 미리 알 수 있을지 궁금해졌습니다. 은하를 위해 각 플레이어가 가지고 있는 카드에 적힌 수가 주어졌을 때, 게임이 종료된 후의 모든 플레이어의 점수를 구해주세요.
#
## 입력
첫 번째 줄에 플레이어의 수 $N$이 주어집니다.

두 번째 줄에 첫 번째 플레이어부터 $N$번째 플레이어까지 각 플레이어가 가지고 있는 카드에 적힌 정수 $x_{1}$, $\cdots$, $x_{N}$이 공백으로 구분되어 주어집니다.
#
## 출력
첫 번째 플레이어부터 $N$번째 플레이어까지 게임이 종료됐을 때의 각 플레이어의 점수를 공백으로 구분하여 출력해주세요.
#
## 풀이
해당 문제는 정렬을 이용하면 해결할 수 있는 문제입니다.

우선 PlayerTable이라는 구조체 새로 정의해 주었습니다.  
해당 구조체는 인덱스:idx, 카드의 수:card, 플레이어 점수:score의 값을 가집니다.  

차례대로 입력을 받으면 idx와 card를 초기화해줍니다.  

이후 해당 구조체 배열을 card값을 통해 오름차순 정렬해줍니다.  

사용된 모든 카드 값을 표기하기 위하여 테이블 하나를 생성해 주고 card값에 해당하는 인덱스에 player의 정렬된 인덱스를 표기해줍니다.  
이후 앞에서 부터 최대 값까지 배수를 구하며 해당 table 배수인덱스에 값이 표기가 되있다면 player의 배수는 -1 약수는 +1을 진행해줍니다.  

이후 다시 구조체 배열을 idx기준으로 정렬한 후 차례대로 score를 출력해 줍니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct PlayerTable
{
    int idx, card, score;
};

bool cmpWithCard(PlayerTable p1, PlayerTable p2)
{
    return p1.card < p2.card;
}

bool cmpWithIdx(PlayerTable p1, PlayerTable p2)
{
    return p1.idx < p2.idx;
}


void getPlayerScore(vector<PlayerTable>&players, int n)
{
    vector<int> table(1000001);

    sort(players.begin(), players.end(), cmpWithCard);

    for(int i = 0; i < n; ++i)
        table[players[i].card] = i;

    for(int i = 0; i < n; ++i)
        for(int j = 2; j * players[i].card <= players[n - 1].card; ++j)
            if(table[j * players[i].card])
            {
                ++players[i].score;
                --players[table[j * players[i].card]].score;
            }

    sort(players.begin(), players.end(), cmpWithIdx);
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<PlayerTable> players(n);
    for(int i = 0; i < n; ++i)
    {
        players[i].idx = i;
        cin >> players[i].card;
        players[i].score = 0;
    }

    getPlayerScore(players, n);

    for(int i = 0; i < n; ++i)
        cout << players[i].score << " ";
    cout << "\n";
    return 0;
}
```