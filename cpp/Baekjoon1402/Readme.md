# (1402) 아무래도이문제는A번난이도인것같다
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1402)
#
## 문제
어떤 정수 A가 있으면 그 수를 A = a1 * a2 * a3 * a4 ... * an으로 했을 때 A' = a1 + a2 + a3 ... + an이 성립하면 "A는 A'으로 변할 수 있다"라고 한다. (ai는 정수) 만약 A'이 A"으로 변할 수 있으면 "A는 A"으로 변할 수 있다"라고 한다.

이때 A와 B가 주어지면 A는 B로 변할 수 있는지 판별하시오.
#
## 입력
첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 100)이 주어진다. 테스트 케이스마다 두 정수 A, B(-231 ≤ A, B ≤ 231-1)가 주어진다.
#
## 출력
각각의 테스트 케이스마다 한 줄에 변할 수 있으면 yes, 아니면 no를 출력한다.
#
## 풀이
해당 문제에서 a1, a2, a3 ... an의 값이 다르다는 조건이 없음으로 1을 여러번 쓸 수 있습니다.  
그러므로 해당 수는 모든 수로 변환이 가능합니다.  

또한 다르다는 조건을 내포한다고 하더라도 주어진 A 값에 대하여 양수인 경우 (1큰수의 양수, 음수)로 변환이 무조건 가능하며 음수인 경우 (1작은 양수, 음수)로 변환이 가능 하므로 모든 수로 변환이 가능합니다.  

그러므로 입력을 받은 후 무조건 yes를 출력해 주시면 됩니다.
```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--)
    {
        int a, b;
        cin >> a >> b;

        cout << "yes\n" << "\n";
    }
    return 0;
}
```