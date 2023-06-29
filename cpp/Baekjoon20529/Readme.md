# (20529) 가장 가까운 세 사람의 심리적 거리
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/20529)
#
## 문제
여러분은 요즘 유행하는 심리검사인 MBTI에 대해 들어보았는가?

MBTI(Myers-Briggs Type Indicator)는 C.G.Jung의 심리유형론을 근거로 하여 Katharine Cook Briggs와 Isabel Briggs Myers가 보다 쉽고 일상생활에 유용하게 활용할 수 있도록 고안한 자기보고식 성격유형지표이다. (출처: 위키백과)

MBTI는 아래와 같이 네 가지 척도로 사람들의 성격을 구분한다.

- 외향(E) / 내향(I)
- 감각(S) / 직관(N)
- 사고(T) / 감정(F)
- 판단(J) / 인식(P)

각 척도마다 두 가지 분류가 존재하므로, MBTI는 총 $2^4 = 16$가지 유형이 있음을 알 수 있다. 일반적으로 MBTI의 유형들은 각 분류를 나타내는 알파벳 한 글자씩을 따 네 글자로 표시하게 된다. 모든 유형의 목록은 다음과 같다.

- ISTJ, ISFJ, INFJ, INTJ, ISTP, ISFP, INFP, INTP, ESTP, ESFP, ENFP, ENTP, ESTJ, ESFJ, ENFJ, ENTJ

MBTI 성격 유형을 이용하면 두 사람 사이의 심리적인 거리를 정의할 수 있다. 이는 두 사람의 MBTI 유형에서 서로 다른 분류에 속하는 척도의 수로 정의된다. 예를 들어, MBTI 유형이 ISTJ인 사람과 ISFJ인 사람 사이의 거리는 1이며, INTP인 사람과 ENTJ인 사람 사이의 거리는 2이다.

이 정의를 확장해서 세 사람 사이의 심리적인 거리도 정의할 수 있다. 세 사람 $A, B, C$가 있을 때 이들의 심리적인 거리는

($A$와 $B$ 사이의 심리적인 거리) + ($B$와 $C$ 사이의 심리적인 거리) + ($A$와 $C$ 사이의 심리적인 거리)

로 정의한다.

대학교에서 심리학 교수로 일하는 종서는 자신이 가르치는 학생들의 심리적인 특성을 분석하고 싶어한다.

오늘이 생일인 종서를 위해 $N$명의 학생들의 MBTI 유형이 주어질 때, 가장 가까운 세 학생 사이의 심리적인 거리를 구해보자.
#
## 입력
첫 줄에는 테스트 케이스의 수를 나타내는 정수 $T$가 주어진다.

각 테스트 케이스의 첫 줄에는 학생의 수를 나타내는 하나의 정수 $N$이 주어지며, 두 번째 줄에는 각 학생의 MBTI 성격 유형을 나타내는 문자열들이 사이에 공백을 두고 주어진다.
#
## 출력
각 테스트 케이스에 대한 답을 정수 형태로 한 줄에 하나씩 출력한다.
#
## 풀이
해당 문제는 브루스트 포스를 이용하면 해결 할 수 있는 문제입니다.

모든 mbti에 대하여 거리를 구해줍니다.  
mbti의 수는 총 16개로 16 x 16횟수의 연산을 수행하게 됩니다.

map자료구조를 이용하여 각 MBTI에 대하여 인덱스를 지정해 줍니다.  
해당 인덱스를 기반으로 MBTI를 입력 받으면 해당 인덱스의 값을 증가 시켜 해당 MBTI에 해당 하는 인원을 카운트해 줍니다.

브루스트 포스를 이용하여 만약 특정 mbti에 해당하는 인원이 있다면 해당 인원을 선택하고 인원을 감축합니다.  
위의 과정을 통해 3명이 선택되면 해당 거리의 값을 구하게되고 해당 값으로 최솟 값을 갱신합니다.    
위의 과정이 끝나면 재귀의 단계를 낮추고 인원을 다시 증가시켜줍니다.  

최종적으로 선택된 최솟 값을 출력해 줍니다.  

```cpp
#include <unordered_map>
#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

void calculateDistance(vector<vector<int>>&distance, vector<string>&mbti_label)
{
    for(int r = 0; r < 16; ++r)
        for(int c = 0; c < 16; ++c)
            for(int i = 0; i < 4; ++i)
                if(mbti_label[r][i] != mbti_label[c][i])
                    ++distance[r][c];
}

int getClosestDistance(vector<int>&mbti_count, vector<vector<int>>&distance,  vector<int>&choice)
{   
    if(choice.size() == 3)
        return distance[choice[0]][choice[1]] + distance[choice[0]][choice[2]] + distance[choice[1]][choice[2]];

    int res = 1234567891;

    for(int i = 0; i < 16; ++i)
        if(mbti_count[i])
        {
            --mbti_count[i];
            choice.push_back(i);
            res = min(res, getClosestDistance(mbti_count, distance, choice));
            choice.pop_back();
            ++mbti_count[i];
        }

    return res;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    unordered_map<string, int> MBTI_TABLE = {
        {"INFJ", 0}, {"INFP", 1},{"ISFJ", 2},{"ISFP", 3},
        {"ISTP", 4},{"ISTJ", 5},{"INTP", 6},{"INTJ", 7},
        {"ENTP", 8},{"ESTJ", 9},{"ESTP", 10},{"ENFP", 11},
        {"ESFJ", 12},{"ENTJ", 13},{"ENFJ", 14},{"ESFP", 15},
    };
    vector<string> mbti_label = {
        "INFJ", "INFP", "ISFJ", "ISFP",
        "ISTP", "ISTJ", "INTP", "INTJ",
        "ENTP", "ESTJ", "ESTP", "ENFP",
        "ESFJ", "ENTJ", "ENFJ", "ESFP"
    };
    vector<vector<int>> distance(16,vector<int>(16));
    calculateDistance(distance, mbti_label);

    while(T--)
    {
        int n, ans = 1234567891;
        cin >> n;

        string s;
        vector<int> mbti_count(16);
        for(int i = 0; i < n; ++i)
        {
            cin >> s;
            ++mbti_count[MBTI_TABLE.at(s)];
        }

        vector<int> choice;
        cout << getClosestDistance(mbti_count, distance, choice) << "\n";
    }
    return 0;
}
```