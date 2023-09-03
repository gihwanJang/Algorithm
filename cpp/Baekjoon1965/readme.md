# (1965) 상자넣기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1965)
#
## 문제
정육면체 모양의 상자가 일렬로 늘어서 있다. 상자마다 크기가 주어져 있는데, 앞에 있는 상자의 크기가 뒤에 있는 상자의 크기보다 작으면, 앞에 있는 상자를 뒤에 있는 상자 안에 넣을 수가 있다. 예를 들어 앞에서부터 순서대로 크기가 (1, 5, 2, 3, 7)인 5개의 상자가 있다면, 크기 1인 상자를 크기 5인 상자에 넣고, 다시 이 상자를 크기 7인 상자 안에 넣을 수 있다. 하지만 이렇게 상자를 넣을 수 있는 방법은 여러 가지가 있을 수 있다. 앞의 예에서 차례대로 크기가 1, 2, 3, 7인 상자를 선택하면 총 4개의 상자가 한 개의 상자에 들어가게 된다.

상자의 크기가 주어질 때, 한 번에 넣을 수 있는 최대의 상자 개수를 출력하는 프로그램을 작성하시오.
#
## 입력
파일의 첫 번째 줄은 상자의 개수 n (1 ≤ n ≤ 1000)을 나타낸다. 두 번째 줄에는 각 상자의 크기가 순서대로 주어진다. 상자의 크기는 1,000을 넘지 않는 자연수이다.
#
## 출력
첫째 줄에 한 줄에 넣을 수 있는 최대의 상자 개수를 출력한다.
#
## 풀이
해당 문제는 다이나믹 프로그래밍을 활용하면 해결할 수 있는 문제입니다.  

우선 상자의 갯수(n)과 상자의 크기를 입력 받습니다.  

들어갈 수 있는 상자의 갯수를 저장할 수 있는 n사이즈의 배열(dp)을 1의 값으로 초기화하여 선언합니다. 
이후 상자를 하나 선택하여 앞의 상자와 크기를 비교합니다.  
만약 앞의 상자의 크기가 작다면 현재 상자의 인덱스를 dp배열에서 찾아가 작은 상자의 (dp배열 +1) 값과 비교하여 큰 값을 저장합니다.  
즉 해당 문제에서의 점화식은 아래와 같습니다.  
if(boxs[i] > boxs[j]) (j < i) -> dp[i] = max(dp[j] + 1, dp[i])  

위의 과정을 모든 상자에 대하여 반복하였다면 dp배열의 가장 큰 값을 출력해 줍니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getMaximumCount(vector<int>&boxs, int n)
{
    int cnt = 1;
    vector<int> dp(n, 1);

    for(int i = 1; i < n; ++i)
        for(int j = 0; j < i; ++j)
            if(boxs[i] > boxs[j])
                dp[i] = max(dp[j]+1, dp[i]);

    for(int i = 1; i < n; ++i)
        cnt = max(cnt, dp[i]);

    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int>boxs(n);
    for(int i = 0; i < n; ++i)
        cin >> boxs[i];

    cout << getMaximumCount(boxs, n) << "\n";
    return 0;
}
```