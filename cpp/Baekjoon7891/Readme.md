# (7891) Can you add this?
## :100: Algorithm
## 문제
Given two integers, calculate and output their sum.

## 입력
The input contains several test cases. The first line contains and integer t (t ≤ 100) denoting the number of test cases. Then t tests follow, each of them consisiting of two space separated integers x and y (−109 ≤ x, y ≤ 109).
## 출력
For each test case output output the sum of the corresponding integers.

## 풀이
테스트 케이스를 입력 받고 해당 테스트 케이스 마다 두수의 합을 출력해 주면 됩니다.

<코드>
```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    long long a, b;
    
    cin >> T;
    while(T--){
        cin >> a >> b;

        cout << a + b << "\n";
    }
    return 0;
}
``` 