# (9328) 열쇠
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/9328)
#
## 문제
상근이는 1층 빌딩에 침입해 매우 중요한 문서를 훔쳐오려고 한다. 상근이가 가지고 있는 평면도에는 문서의 위치가 모두 나타나 있다. 빌딩의 문은 모두 잠겨있기 때문에, 문을 열려면 열쇠가 필요하다. 상근이는 일부 열쇠를 이미 가지고 있고, 일부 열쇠는 빌딩의 바닥에 놓여져 있다. 상근이는 상하좌우로만 이동할 수 있다.

상근이가 훔칠 수 있는 문서의 최대 개수를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 수는 100개를 넘지 않는다.

각 테스트 케이스의 첫째 줄에는 지도의 높이와 너비 h와 w (2 ≤ h, w ≤ 100)가 주어진다. 다음 h개 줄에는 빌딩을 나타내는 w개의 문자가 주어지며, 각 문자는 다음 중 하나이다.

- '.'는 빈 공간을 나타낸다.
- '*'는 벽을 나타내며, 상근이는 벽을 통과할 수 없다.
- '$'는 상근이가 훔쳐야하는 문서이다.
- 알파벳 대문자는 문을 나타낸다.
- 알파벳 소문자는 열쇠를 나타내며, 그 문자의 대문자인 모든 문을 열 수 있다.

마지막 줄에는 상근이가 이미 가지고 있는 열쇠가 공백없이 주어진다. 만약, 열쇠를 하나도 가지고 있지 않는 경우에는 "0"이 주어진다.

상근이는 처음에는 빌딩의 밖에 있으며, 빌딩 가장자리의 벽이 아닌 곳을 통해 빌딩 안팎을 드나들 수 있다. 각각의 문에 대해서, 그 문을 열 수 있는 열쇠의 개수는 0개, 1개, 또는 그 이상이고, 각각의 열쇠에 대해서, 그 열쇠로 열 수 있는 문의 개수도 0개, 1개, 또는 그 이상이다. 열쇠는 여러 번 사용할 수 있다.
#
## 출력
각 테스트 케이스 마다, 상근이가 훔칠 수 있는 문서의 최대 개수를 출력한다.
#
## 풀이
해당 문제는 BFS, DFS를 이용하면 해결 할 수 있는 문제입니다.

입력에 대한 string으로 key의 종류를 판별 할 수 있습니다.  
하지만 string의 상태로 가지고 있다면 O(1)의 시간복잡도로 해당 key가 있는지 없는지 확인 하기 어려움으로 'a'~'z'까지 키의 여부를 저장할 수 있는 table을 26의 사이즈로 따로 만들고 해당 키가 있다면 true 아니면 false를 유지합니다.  

이후는 BFS를 하기 위하여 평면도의 가장자리를 탐색하여 들어 갈 수 있는 부분을 찾습니다.  
해당 방식은 아래와 같습니다.  

- '*'인 경우 : 무시
- 'a'~'z'인 경우 : 열쇠를 획득 하므로 key_table에 true로 표기 후 위치를 que 또는 stack에 넣음
- 'A'~'Z'인 경우 아래의 2가지로 나뉨
    - 맞는 키가 있는 경우 : 위치를 que 또는 stack에 넣음
    - 맞는 키가 없는 경우 : 해당 문의 위치를 따로 표기하기 위하여 1차원 인덱스가 'A'~'Z'인 2차원 리스트에 위치를 넣음
- '.'이거나 '$'인 경우  : 위치를 que 또는 stack에 넣음

들어가 위치가 정해지면 BFS 또는 DFS를 상하좌우에 대하여 실행하는데 상하좌우에 대하여 위의 과정을 똑같이 반복합니다.  
이때 반복하며 현제의 위치가 '$'인 경우 문서의 갯수를 증가시켜줍니다.  
위의 경우는 한번 방문한 적인는 곳에 대하여는 다시시행하면 않되기 때문에 따로 시행해 줍니다.  
1번의 BFS가 끝나면 문의 위치를 표기한 곳에 대한 키를 획득했다면 해당 문에 표기된 위치들에 대한 BFS, DFS를 다시하게 됩니다.  
만약 문에 대한 맞는 키가 없다면 문서의 갯수를 출력해 줍니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Loc{int r, c;};

void makeQue(queue<Loc>&que, vector<vector<Loc>>&door, vector<bool>&key_table, Loc loc, char&state)
{
    if(state == '*') return;

    if('a' <= state && state <= 'z')
        key_table[state - 'a'] = true;
    else if('A' <= state && state <= 'Z')
        if(!key_table[state - 'A'])
        {
            door[state - 'A'].push_back(loc);
            return;
        }
    
    que.push(loc);
}

int getDocument(vector<string>&floor_plan, vector<bool>&key_table, int h, int w)
{
    int document_cnt = 0;

    Loc curr;
    queue<Loc> que;
    vector<vector<Loc>> door(26);
    vector<vector<bool>> visited(h, vector<bool>(w));

    for(int r = 0; r < h; ++r)
    {
        makeQue(que, door, key_table, {r, 0}, floor_plan[r][0]);
        makeQue(que, door, key_table, {r, w-1}, floor_plan[r][w-1]);
    }
    for(int c = 0; c < w; ++c)
    {
        makeQue(que, door, key_table, {0, c}, floor_plan[0][c]);
        makeQue(que, door, key_table, {h-1, c}, floor_plan[h-1][c]);
    }

    while(true)
    {
        bool canStop = true;

        while(!que.empty())
        {
            curr = que.front();
            que.pop();

            if(!visited[curr.r][curr.c])
            {
                visited[curr.r][curr.c] = true;

                if(floor_plan[curr.r][curr.c] == '$') ++document_cnt;

                if(curr.r > 0 && !visited[curr.r-1][curr.c])
                    makeQue(que, door, key_table, {curr.r-1, curr.c}, floor_plan[curr.r-1][curr.c]);
                if(curr.r+1 < h && !visited[curr.r+1][curr.c])
                    makeQue(que, door, key_table, {curr.r+1, curr.c}, floor_plan[curr.r+1][curr.c]);
                if(curr.c > 0 && !visited[curr.r][curr.c-1])
                    makeQue(que, door, key_table, {curr.r, curr.c-1}, floor_plan[curr.r][curr.c-1]);
                if(curr.c+1 < w && !visited[curr.r][curr.c+1])
                    makeQue(que, door, key_table, {curr.r, curr.c+1}, floor_plan[curr.r][curr.c+1]);
            }
        }

        for(int i = 0; i < 26; ++i)
            if(key_table[i])
                while(!door[i].empty())
                {
                    que.push(door[i].back());
                    door[i].pop_back();
                    canStop = false;
                }

        if(canStop) break;
    }

    return document_cnt;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--)
    {
        int h, w;
        cin >> h >> w;

        vector<string> floor_plan(h);
        for(int r = 0; r < h; ++r)
            cin >> floor_plan[r];

        string keys;
        cin >> keys;
        vector<bool> key_table(26);
        for(int i = 0; i < keys.size(); ++i)
            if(keys[i] != '0')
                key_table[keys[i] - 'a'] = true;

        cout << getDocument(floor_plan, key_table, h, w) << "\n";
    }
    return 0;
}
```