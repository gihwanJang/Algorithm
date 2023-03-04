# (17404) RGB거리 2
## :100: Algorithm
## 문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

- 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
- N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
- i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.

## 입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

## 출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

## 풀이
해당 문제의 경우 부분 최적화가 가능하므로 다이나믹 프로그래밍을 통해 해결 할 수 있습니다.  
우선 첫번째 집의 색을 고정으로 해야하기 때문에 R인 경우 B인경우 G인 경우를 각각 나누어 dp를 진행합니다.  
해당 경우가 아닐시 최댓값으로 설정해 주시면 됩니다.  
이후 R을 칠하기 위해서는 이전과 동일한 색을 못 칠하므로 B 또는 G중 작은 값을 선택해 주면됩니다.  
B, G도 위와 같은 방식으로 칠해게 되면 점화식은 아래와 같게 나옵니다.  

dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];  
dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];  
dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];  

최종 답은 dp의 가장 마즈막 값을 보면 알 수 있는데 마즈막에 칠해진 집과 처음 칠해진 집은 다른 색이어야 하므로 처음에 칠해진 색이라면 답에 반영하지 않고 나머지 두개중 작은 것을 결과로 채택합니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int rgbDistance(vector<vector<int>>&rgb){
    int res = 987654321, i;
    vector<vector<int>> dp(rgb.size(), vector<int>(3));
    
    for(int f = 0; f < 3; ++f){
        for(i = 0; i < 3; ++i){
            dp[0][i] = 987654321;
            if(f == i)
                dp[0][i] = rgb[0][i];
        }

        for(i = 1; i < rgb.size(); ++i){
            dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }

        for(i = 0; i < 3; ++i)
            if(i != f)
                res = min(res, dp[rgb.size()-1][i]);
    }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> rgb(n, vector<int>(3));
    for(int i = 0; i < n; ++i)
        cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];

    cout << rgbDistance(rgb) << "\n";
    return 0;
}

```