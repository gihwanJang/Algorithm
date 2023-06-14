# (13752) 히스토그램
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/13752)
#
## 문제
히스토그램은 데이터를 시각적으로 표현한 것이다. 막대로 구성되며 각 막대의 길이는 데이터 양의 크기를 나타낸다. 일부 데이터가 주어지면 히스토그램을 생성하시오.
#
## 입력
첫 번째 줄에는 테스트 케이스의 개수 n (1 ≤ n ≤ 100)이 주어진다. 다음 n 개의 줄에는 각 히스토그램의 크기 k (1 ≤ k ≤ 80)가 주어진다.
## 출력
각 테스트 케이스에 대해서 히스토그램의 크기 k와 동일한 수의 '='를 출력한다. '='사이에 공백은 존재하지 않는다.
#
## 풀이
항목의 수를 입력받습니다.  
항목의 수만큼 아래의 과정을 반복합니다.

값을 입력받은후 해당 값만큼 "="를 출력해줍니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, v;
    cin >> n;

    while(n--){
        cin >> v;

        while(v--)
            cout << "=";
            
        cout << "\n";
    }
    return 0;
}
```