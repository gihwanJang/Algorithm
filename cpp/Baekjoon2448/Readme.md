# (2448) 별 찍기 - 11
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2448)
#
## 문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
#
## 입력
첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)
#
## 출력
첫째 줄부터 N번째 줄까지 별을 출력한다.
#
## 풀이
해당 문제는 재귀를 이용하면 해결 할 수 있는 문제입니다.

입력받은 n의 삼각형은 n/2의 삼각형 3개로 이루어져 있으며 n이 3일때 더이상 나눌 수 없습니다.

그러므로 n을 재귀적으로 n/2찍 쪼개며 n이 3일 경우에 만 삼각형을 그려주면 됩니다.

```cpp
#include <iostream>
#include <vector>

using namespace std;

void drawStar(vector<vector<char>>&mat, int r, int c, int n)
{
    if(n == 3)
    {
        mat[r][c] = '*';
        mat[r+1][c-1] = '*';
        mat[r+1][c+1] = '*';

        for(int col = c-2; col <= c+2; ++col)
            mat[r+2][col] = '*';

        return;
    }

    drawStar(mat, r, c, n/2);
    drawStar(mat, r + n/2, c - n/2, n/2);
    drawStar(mat, r + n/2, c + n/2, n/2);
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<char>> mat(n, vector<char>(2*n - 1));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < 2*n - 1; ++c)
            mat[r][c] = ' ';

    drawStar(mat, 0, n-1, n);

    for(int r = 0; r < n; ++r)
    {
        for(int c = 0; c < 2*n - 1; ++c)
        {
            cout << mat[r][c];
        }
        cout << "\n";
    }
    return 0;
}
```