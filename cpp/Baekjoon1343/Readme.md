# (1343) 폴리오미노
## :100: Algorithm
## 문제
민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB

이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.

폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.

## 입력
첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.

## 출력
첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.

## 풀이
현제 위치에서 4개 단위로 'X'의 갯수를 카운트 합니다.  
그럼 (0, 2, 4, (1,3)) 4가지 경우가 발생하게 됩니다.  
1. 0인 경우는 '.'이 하나 존재하는 경우이므로 다음 위치로 옮겨 4개 단위로 카운트해 줍니다.  
2. 2인 경우는 카운트 한 곳 까지 'B'로 채워 주면 됩니다.  
3. 4인 경우는 카운트 한 곳 까지 'A'로 채워 주면 됩니다.  
4. 나머지는 채울수 있는 판이 모두 짝수 이므로  홀수인 경우는 채울 수 없음으로 -1을 반환해 줍니다.

```cpp
#include <iostream>

using namespace std;

bool polyomino(string&s){
    int i = 0;

    while(i < s.size()){
        int cnt = 0;
        while(cnt < 4 && s[i+cnt] != '.' && i+cnt < s.size()){
            ++cnt;
        }

        if(cnt == 0)    
            ++i;
        else if(cnt % 2 == 1)
            return false;
        else if(cnt == 2){
            for(int j = 0; j < cnt; ++j)
                s[i + j] = 'B';
            i += cnt;
        }
        else{
            for(int j = 0; j < cnt; ++j)
                s[i + j] = 'A';
            i += cnt;
        }
    }
    return true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << (polyomino(s) ? s : "-1") << "\n";
    return 0;
}

```