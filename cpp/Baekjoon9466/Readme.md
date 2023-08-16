# (9466) 텀 프로젝트
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/9466)
#
## 문제
이번 가을학기에 '문제 해결' 강의를 신청한 학생들은 텀 프로젝트를 수행해야 한다. 프로젝트 팀원 수에는 제한이 없다. 심지어 모든 학생들이 동일한 팀의 팀원인 경우와 같이 한 팀만 있을 수도 있다. 프로젝트 팀을 구성하기 위해, 모든 학생들은 프로젝트를 함께하고 싶은 학생을 선택해야 한다. (단, 단 한 명만 선택할 수 있다.) 혼자 하고 싶어하는 학생은 자기 자신을 선택하는 것도 가능하다.

학생들이(s1, s2, ..., sr)이라 할 때, r=1이고 s1이 s1을 선택하는 경우나, s1이 s2를 선택하고, s2가 s3를 선택하고,..., sr-1이 sr을 선택하고, sr이 s1을 선택하는 경우에만 한 팀이 될 수 있다.

예를 들어, 한 반에 7명의 학생이 있다고 하자. 학생들을 1번부터 7번으로 표현할 때, 선택의 결과는 다음과 같다.

| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|---|---|---|---|---|---|---|
| 3 | 1 | 3 | 7 | 3 | 4 | 6 |

위의 결과를 통해 (3)과 (4, 7, 6)이 팀을 이룰 수 있다. 1, 2, 5는 어느 팀에도 속하지 않는다.

주어진 선택의 결과를 보고 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하는 프로그램을 작성하라.

#
## 입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫 줄에는 학생의 수가 정수 n (2 ≤ n ≤ 100,000)으로 주어진다. 각 테스트 케이스의 둘째 줄에는 선택된 학생들의 번호가 주어진다. (모든 학생들은 1부터 n까지 번호가 부여된다.)
#
## 출력
각 테스트 케이스마다 한 줄에 출력하고, 각 줄에는 프로젝트 팀에 속하지 못한 학생들의 수를 나타내면 된다.
#
## 풀이
해당 문제는 DFS를 이용하면 해결 할 수 있는 문제입니다.  

우선 graph를 입력 받습니다.  

해당 그래프를 통해 앞에서 부터 DFS를 실행합니다.  
이때 방문한 곳에는 visited로 표기를 합니다.  
재귀가 한번 끝나고 재 방문 시 사이클이 발생하므로 팀이 생기게 됩니다.  
해당  팀의 인원을 전체 인원수에서 감소 시킵니다.

모든 DFS가 끝이나면 남은 인원수를 출력하면 됩니다.

```cpp
#include <iostream>
#include <vector>

using namespace std;

void DFS(vector<int>&wishes, vector<bool>&check, vector<bool>&visited, int curr, int&cnt)
{
    int next = wishes[curr];

    visited[curr] = true;

    if(!visited[next])
        DFS(wishes, check, visited, next, cnt);
    else if(!check[next])
    {
        for(int i = next; i != curr; i = wishes[i])
            --cnt;
        --cnt;
    }

    check[curr] = true;
}

int getNumberOfStudentsLeft(vector<int>&wishes, int n)
{
    int cnt = n;
    vector<bool> check(n);
    vector<bool> visited(n);

    for(int i = 0; i < n; ++i)
        if(!visited[i])
            DFS(wishes, check, visited, i, cnt);

    return cnt;
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
        int n;
        cin >> n;

        vector<int> wishes(n);
        for(int i = 0; i < n; ++i)
        {
            cin >> wishes[i];
            --wishes[i];
        }

        cout << getNumberOfStudentsLeft(wishes, n) << '\n';
    }
    return 0;
}
```