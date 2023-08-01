# (1208) 부분수열의 합 2
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1208)
#
## 문제
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 40, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
#
## 출력
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
#
## 풀이
해당 문제는 이분 탐색을 이용하면  해결할 수 있습니다.

우선 배열을 입력 받습니다.

이후 해당 배열을 좌측과 우측으로 나누어 부분 수열을 합을 구합니다.  
우측에서는 값을 포함한 것과 포함하지 않는 부분을 나누어 모든 경우의 부분수열을 구하며 각 합산 값에 대한 갯수를 map자료구조를 통해 저장합니다.  
좌측에서도 모든 경우의 부분 수열을 구하며 각 합산 값을 구하려는 S에서 뺀 값을 key로 하여 map에서 찾아 count를 누적 합산해 줍니다.

이후 누적 합산한 count를 출력해 줍니다.

```cpp
#include <unordered_map>
#include <iostream>
#include <vector>

using namespace std;

void rightSeq(unordered_map<int,int>&map, vector<int>&val, int start, int sum)
{
    if(start == val.size())
    {
        map[sum]++;
        return;
    }

    rightSeq(map, val, start + 1, sum + val[start]);
    rightSeq(map, val, start + 1, sum);
}

void leftSeq(unordered_map<int,int>&map, vector<int>&val, int s, int start, int sum, long&count)
{
    if(start == val.size() / 2)
    {
        count += map[s - sum];
        return;
    }
    
    leftSeq(map, val, s, start + 1, sum + val[start], count);
    leftSeq(map, val, s, start + 1, sum, count);
}

long getNumOfSubSeq(vector<int>&val, int s)
{
    long count = 0;
    unordered_map<int,int> map;

    rightSeq(map, val, val.size()/2, 0);
    leftSeq(map, val, s, 0, 0, count);

    return s ? count : count - 1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s;
    cin >> n >> s;

    vector<int> val(n);
    for(int i = 0; i < n; ++i)
        cin >> val[i];

    cout << getNumOfSubSeq(val, s) << "\n";
    return 0;
}
```