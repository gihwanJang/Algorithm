# (2399) 거리의 합
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2399)
#
## 문제
수직선에 n개의 점이 찍혀 있다. 각각의 점의 x좌표가 주어졌을 때, n^2개의 모든 쌍에 대해서 거리를 더한 값을 구하는 프로그램을 작성하시오.

즉, 모든 i, j에 대해서 |x[i] - x[j]|의 합을 구하는 것이다.
#
## 입력
첫째 줄에 n(1 ≤ n ≤ 10,000)이 주어진다. 다음 줄에는 x[1], x[2], x[3], …, x[n]이 주어진다. 각각은 0 이상 1,000,000,000 이하의 정수이다.
#
## 출력
첫째 줄에 답을 출력한다.
#
## 풀이
배열 임의의 1개의 값에 대하여 n개의 점과의 거리를 모두 더해서 출력해 주면됩니다.  

별도로 주의 해야할 점은 출력의 범위가 정수를 초과할 수 있음으로 long자료형을 써야한다는 점이 있습니다.

```cpp
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    long ans = 0;
    cin >> n;

    vector<long> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];
    
    for(int i = 0; i < n; ++i)
        for(int j = 0; j < n; ++j)
            ans += abs(nums[i] - nums[j]);

    cout << ans << "\n";
    return 0;
}
```