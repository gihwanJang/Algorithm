# (2490) 윷놀이
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2490)
#
## 문제
우리나라 고유의 윷놀이는 네 개의 윷짝을 던져서 배(0)와 등(1)이 나오는 숫자를 세어 도, 개, 걸, 윷, 모를 결정한다. 네 개 윷짝을 던져서 나온 각 윷짝의 배 혹은 등 정보가 주어질 때 도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 걸(배 세 개, 등 한 개), 윷(배 네 개), 모(등 네 개) 중 어떤 것인지를 결정하는 프로그램을 작성하라.
#
## 입력
첫째 줄부터 셋째 줄까지 각 줄에 각각 한 번 던진 윷짝들의 상태를 나타내는 네 개의 정수(0 또는 1)가 빈칸을 사이에 두고 주어진다.
## 출력
첫째 줄부터 셋째 줄까지 한 줄에 하나씩 결과를 도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E로 출력한다.
#
## 풀이
4개의 윷의 값을 입력 받으면 해당 값의 누적합을 구해줍니다.

해당 누적합이 4일때 'E', 3일때 'A', 2일때 'B', 1일때 'C', 0일때 'D'를 출력해 줍니다.

위의 과정을 세차례 반복합니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for(int i = 0; i < 3; ++i){
        int d, cnt = 0;

        for(int j = 0; j < 4; ++j){
            cin >> d;
            cnt += d;
        }

        if(cnt == 4)
            cout << "E" << "\n";
        else if(cnt == 3)
            cout << "A" << "\n";
        else if(cnt == 2)
            cout << "B" << "\n";
        else if(cnt == 1)
            cout << "C" << "\n";
        else
            cout << "D" << "\n";
    }
    return 0;
}
```