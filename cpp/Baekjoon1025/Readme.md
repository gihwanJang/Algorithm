# (1025) 제곱수 찾기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1025)
#
## 문제
N행 M열의 표 A가 있고, 표의 각 칸에는 숫자가 하나씩 적혀있다.

연두는 서로 다른 1개 이상의 칸을 선택하려고 하는데, 행의 번호가 선택한 순서대로 등차수열을 이루고 있어야 하고, 열의 번호도 선택한 순서대로 등차수열을 이루고 있어야 한다. 이렇게 선택한 칸에 적힌 수를 순서대로 이어붙이면 정수를 하나 만들 수 있다.

연두가 만들 수 있는 정수 중에서 가장 큰 완전 제곱수를 구해보자. 완전 제곱수란 어떤 정수를 제곱한 수이다.
#
## 입력
첫째 줄에 N, M이 주어진다. 둘째 줄부터 N개의 줄에는 표에 적힌 숫자가 1번 행부터 N번 행까지 순서대로 한 줄에 한 행씩 주어진다. 한 행에 적힌 숫자는 1번 열부터 M번 열까지 순서대로 주어지고, 공백없이 모두 붙여져 있다.
## 출력
첫째 줄에 연두가 만들 수 있는 가장 큰 완전 제곱수를 출력한다. 만약, 완전 제곱수를 만들 수 없는 경우에는 -1을 출력한다.
#
## 풀이
해당 문제는 브루스트 포스를 하면 해결할 수 있는 문제입니다.  

우선 수를 선택할 수 있는 방향은 (좌->우, 우->좌, 상->하, 하->상, 좌상->우하, 우하->좌상, 우상->좌하, 좌하->우상) 8방향이 있습니다. 

위의 8방향을 3가지 경우로 나누면 수평 수직 대각 의 방향으로 크게 나눌 수 있습니다.

- 수평 방향(좌->우, 우->좌)
    - 해당 경우는 r의 공차가 0으로 고정 시키고 c의 공차를 m 까지 증가 시키며 이동하면 됩니다.  
    - 한 라인을 탐색하며 완성한 값마다 뒤집으며 해당 수가 제곱수 인지 판별해 주어야 합니다.

- 수직 방향(상->하, 하->상)
    - 해당 경우는 c의 공차가 0으로 고정 시키고 r의 공차를 n 까지 증가 시키며 이동하면 됩니다.  
    - 한 라인을 탐색하며 완성한 값마다 뒤집으며 해당 수가 제곱수 인지 판별해 주어야 합니다.

- 대각 방향(좌상->우하, 우하->좌상, 우상->좌하, 좌하->우상)
    - (좌상->우하, 우하->좌상)
    - 해당 경우는 r, c 공차에 대하여 (1,1) ~ (n, m)까지의 경우를 모두 해 주어야합니다.  
    - 한 라인을 탐색하며 완성한 값마다 뒤집으며 해당 수가 제곱수 인지 판별해 주어야 합니다.
    - (우상->좌하, 좌하->우상)
    - 해당 경우는 r, c 공차에 대하여 (1,-1) ~ (n, -m)까지의 경우를 모두 해 주어야합니다.
    - 한 라인을 탐색하며 완성한 값마다 뒤집으며 해당 수가 제곱수 인지 판별해 주어야 합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void findSquareNumber(vector<string>&matrix, int r_s, int c_s, int&ans){
    int s_i;
    
    for(int curr_r = 0; curr_r < matrix.size(); ++curr_r){
        for(int curr_c = 0; curr_c < matrix[0].size(); ++curr_c){
            string s;
            string rev_s;
            int r = curr_r;
            int c = curr_c;

            while(r < matrix.size() && c < matrix[0].size() && c > -1){
                s += matrix[r][c];
                rev_s = s;

                s_i = stoi(s);
                if(abs(sqrt(s_i) - (int)sqrt(s_i)) < 0.000001)
                    ans = max(ans, s_i);

                reverse(rev_s.begin(), rev_s.end());
                s_i = stoi(rev_s);
                if(abs(sqrt(s_i) - (int)sqrt(s_i)) < 0.000001)
                    ans = max(ans, s_i);

                r += r_s;
                c += c_s;
            }
        }
    }
}

void initAns(vector<string>&matrix, int&ans){
    int s_i;

    ans = -1;
    for(int r = 0; r < matrix.size(); ++r)
        for(int c = 0; c < matrix[0].size(); ++c){
            s_i = matrix[r][c] - '0';

            if(abs(sqrt(s_i) - (int)sqrt(s_i)) < 0.000001)
                ans = max(ans, s_i);
        }
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans;
    cin >> n >> m;


    vector<string> matrix(n);
    for(int r = 0; r < n; ++r)
        cin >> matrix[r];

    initAns(matrix, ans);

    // 대각
    for(int r = 1; r < n; ++r){
        for(int c = 1; c < m; ++c)
            findSquareNumber(matrix, r, c, ans);
        for(int c = -1; -c < m; --c)
            findSquareNumber(matrix, r, c, ans);
    }
    // 수평
    for(int r = 1; r < n; ++r)
        findSquareNumber(matrix, r, 0, ans);
    // 수직
    for(int c = 1; c < m; ++c)
        findSquareNumber(matrix, 0, c, ans);

    cout << ans << "\n";
    return 0;
}
``` 