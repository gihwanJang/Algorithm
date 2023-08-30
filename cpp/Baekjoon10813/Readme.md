# (10813) 공 바꾸기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10813)
#
## 문제
도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.

도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.

공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.

둘째 줄부터 M개의 줄에 걸쳐서 공을 교환할 방법이 주어진다. 각 방법은 두 정수 i j로 이루어져 있으며, i번 바구니와 j번 바구니에 들어있는 공을 교환한다는 뜻이다. (1 ≤ i ≤ j ≤ N)

도현이는 입력으로 주어진 순서대로 공을 교환한다.
#
## 출력
1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다.
#
## 풀이
해당 문제는 배열을 이용하면 해결 할 수 있는 문제입니다.  

바구니의 수 n과 공을 바꾸는 횟수 m을 입력받습니다.  

배열을 n+1크기 만큼 선언 후 각 인덱스와 값을 일치하게 초기화해 줍니다.  

이후 바꾸는 인덱스에 대하여 해당 값을 교환을 합니다.  

교환이 끝나면 배열을 출력해 주시면 됩니다.

```cpp
#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int>&basket, int a, int b)
{
    if(a == b) return;

    int tmp = basket[a];
    basket[a] = basket[b];
    basket[b] = tmp;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, a, b;
    cin >> n >> m;

    vector<int> basket(n+1);
    for(int i = 1; i <= n; ++i)
        basket[i] = i;

    for(int i = 0; i < m; ++i)
    {
        cin >> a >> b;
        swap(basket, a, b);
    }

    for(int i = 1; i <= n; ++i)
        cout << basket[i] << " ";
    return 0;
}
```