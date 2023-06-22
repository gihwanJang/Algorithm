# (1080) 행렬
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1080)
#
## 문제
0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.

행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 → 1, 1 → 0)
#
## 입력
첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.
## 출력
첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다.
#
## 풀이
A와 B행렬을 입력받습니다.  

이때 A의 행렬의 값을 바꾸게 되는데 한 인덱스에 대하여 2번을 바꿀 일은 없으며 뒤집어 지는 것에 대하여 순서는 영향을 받지 않으므로 아래와 같이 수행 하면 됩니다.

A행렬에 대하여 행으로는 n-2 열로는 m-2까지의 인덱스에 대하여 접근하며 해당 A[r][c]의 값이 B[r][c]의 값과 다르다면 [r][c] ~ [r+2][r+2] 까지 3x3 크기를 뒤집습니다.  
이때 뒤집으며 카운트를 증가시켜줍니다.

위의 뒤집기가 끝나면 A와 B행렬에 대하여 같은 행렬인지 확인합니다.  
같다면 해당 카운트를 출력하고 아니면 -1을 출력합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

#define INF 1234567891

using namespace std;

void reverse(vector<vector<bool>>&a, int row, int col)
{
    for(int r = row; r < row+3; ++r)
        for(int c = col; c < col+3; ++c)
            a[r][c] = !a[r][c];
}

bool checkEqual(vector<vector<bool>>&a, vector<vector<bool>>&b)
{
    for(int r = 0; r < a.size(); ++r)
        for(int c = 0; c < a[0].size(); ++c)
            if(a[r][c] != b[r][c])
                return false;

    return true;
}

int changeMatrix(vector<vector<bool>>&a, vector<vector<bool>>&b)
{
    int ans = 0;

    for(int r = 0; r+2 < a.size(); ++r)
        for(int c = 0; c+2 < a[0].size(); ++c)
            if(a[r][c] != b[r][c]){
                ++ans;
                reverse(a, r, c);
            }

    if(!checkEqual(a, b))
        ans = -1;

    return ans;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string s;
    vector<vector<bool>> a(n, vector<bool>(m));
    vector<vector<bool>> b(n, vector<bool>(m));

    for(int r = 0; r < n; ++r)
    {
        cin >> s;

        for(int c = 0; c < m; ++c)
            a[r][c] = (s[c] == '1');
    }
    for(int r = 0; r < n; ++r)
    {
        cin >> s;

        for(int c = 0; c < m; ++c)
            b[r][c] = (s[c] == '1');
    }

    cout << changeMatrix(a, b) << "\n";
    return 0;
}
```