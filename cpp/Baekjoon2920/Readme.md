# (2920) 음계
## :100: Algorithm
## 문제
다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.

연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.

## 입력
첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.

## 출력
첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.

## 풀이
해당 문제는 정렬의 여부와 정렬된 방식을 출력하는 문제입니다.  
오름차순 정렬이면 ascending, 내림차순이면 descending 정렬이 되어 있지 않다면 mixed를 출력하면 됩니다.  

입력을 받은 값이 이전의 입력보다 항상 값이 작으면 내림차순이 되고 크면 오름 차순이 됩니다.  

조건들을 bool로 두어 검사하고 해당 조건에 맞는 값을 출력해 주면 됩니다.  

```cpp
#include <iostream>

using namespace std;

string sorted(bool a, bool d){
    if(a)
        return "ascending";
    else if(d)
        return "descending";
    else
        return "mixed";
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bool asc = true;
    bool des = true;
    int prev, curr;

    cin >> prev;
    for(int i = 1; i < 8; ++i){
        cin >> curr;

        if(prev < curr)
            des = false;
        else
            asc = false;

        prev = curr;
    }

    cout << sorted(asc, des) << "\n";
    return 0;
}

```