# (15666) N과 M(12)
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/15666)

## 문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

- N개의 자연수 중에서 M개를 고른 수열
- 같은 수를 여러 번 골라도 된다.
- 고른 수열은 비내림차순이어야 한다.
    - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
#
## 입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
#
## 출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
#
## 풀이
해당 문제는 백 트래킹을 이용하여 해결 할 수 있습니다.  

우선 수열을 사전 순으로 증가하는 순서로 출력하기위해 정렬을 해줍니다.  

그리고 res 배열을 이용하여 백트래킹을 해주시면 됩니다.  

이때 각 자리의 수는 중복 되면 안되므로 이전의 수를 저장해 뒀다가 다음의 수와 같으면 넘어가고 중복 수열에 대하여 배재해야하기 때문에 다음 수열의 인덱스의 값은 이전 수열의 인덱스 부터 시작하여 과정을 반복합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void combin(vector<int>&arr, vector<int>&res, int m, int s){
    if(res.size() == m){
        for(int i = 0; i < m; ++i)
            cout << res[i] << " ";
        cout << "\n";

        return;
    }

    int curr = -1;

    for(int i = s; i < arr.size(); ++i){
        if(curr == arr[i])
            continue;

        curr = arr[i];

        res.push_back(arr[i]);
        combin(arr, res, m, i);
        res.pop_back();
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> res;
    vector<int> arr(n);
    for(int i = 0; i < n; ++i)
        cin >> arr[i];

    sort(arr.begin(), arr.end());

    combin(arr, res, m, 0);
    return 0;
}
```