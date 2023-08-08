# (1562) 계단 수
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1562)
#
## 문제
45656이란 수를 보자.

이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.

N이 주어질 때, 길이가 N이면서 0부터 9까지 숫자가 모두 등장하는 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. 0으로 시작하는 수는 계단수가 아니다.
#
## 입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
#
## 출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
#
## 풀이
해당 문제는 비트 마스킹과 다이나믹 프로그래밍을 이용하면 해결할 수 있는 문제입니다.

우선 해당 계단수를 찾기위한 3차원 dp테이블을 생성합니다.  
각 차원은 [계단수의 길이] [길이의 끝 숫자] [사용된 숫자]이며 이때 사용된 숫자를 비트를 이용하여 표기하게 됩니다.  
사용되는 숫자는 0~9로 10개의 숫자이며 이를 비트로 나타내면 2^10이되며 총 1024개의 경우의 수가 발생합니다.  

이후 길이가 1인 배열의 초기 값을 설정해 줍니다.  
해당 길이가 1이며 앞자리 수에 해당하는 비트의 인덱스를 1로 초기화홥니다.  

이후 점화식을 반복을 하면됩니다.  
해당 점화식의 경우 3가지로 분류가 됩니다.  
1. 끝 수가 0인 경우 1 밖에 올 수 없음으로 아래와 같은 점화식을 가집니다.
    - dp[len][0][bit | (1 << 0)] = dp[len][0][bit | (1 << 0)] + dp[len - 1][1][bit]
2. 끝 수가 9인 경우 8 밖에 올 수 없음으로 아래와 같은 점화식을 가집니다.
    - dp[len][9][bit | (1 << 9)] = dp[len][9][bit | (1 << 9)] + dp[len - 1][8][bit]
3. 나머지의 경우는 +1, -1 2가지 경우가 있음으로 2가지의 점화식을 가지게 됩니다.
    - dp[len][num][bit | (1 << num)] = dp[len][num][bit | (1 << num)] + dp[len - 1][num - 1][bit]
    - dp[len][num][bit | (1 << num)] = dp[len][num][bit | (1 << num)] + dp[len - 1][num + 1][bit]

해당 점화식을 모두 수행 했다면 길이가 n이고 1023의 비트를 가진 배열의 값들을 모두 더하여 출력해주시면 됩니다.

```cpp
#include <iostream>
#include <vector>

#define MOD 1000000000

using namespace std;

int getStairNum(int n)
{
    int res = 0;
    int last_bit = (1 << 10) - 1; 
    int len, num, bit;
    vector<vector<vector<int>>> dp(n+1, vector<vector<int>>(10, vector<int>(1 << 10)));

    for(num = 1; num <= 9; ++num)
        dp[1][num][1 << num] = 1;

    for(len = 2; len <= n; ++len)
        for(num = 0; num <= 9; ++num)
            for(bit = 0; bit <= last_bit; ++bit)
            {
                if(num == 0)
                    dp[len][0][bit | (1 << 0)] = (dp[len][0][bit | (1 << 0)] + dp[len - 1][1][bit]) % MOD;
                else if(num == 9)
                    dp[len][9][bit | (1 << 9)] = (dp[len][9][bit | (1 << 9)] + dp[len - 1][8][bit]) % MOD;
                else
                {
                    dp[len][num][bit | (1 << num)] = (dp[len][num][bit | (1 << num)] + dp[len - 1][num - 1][bit]) % MOD;
                    dp[len][num][bit | (1 << num)] = (dp[len][num][bit | (1 << num)] + dp[len - 1][num + 1][bit]) % MOD;
                }
            }

    for (num = 0; num <= 9; ++num)
        res = (res + dp[n][num][last_bit]) % MOD;

    return res;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << getStairNum(n) << "\n";
    return 0;
}
```