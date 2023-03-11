# (2143) 두 배열의 합
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2143)

## 문제
한 배열 A[1], A[2], …, A[n]에 대해서, 부 배열은 A[i], A[i+1], …, A[j-1], A[j] (단, 1 ≤ i ≤ j ≤ n)을 말한다. 이러한 부 배열의 합은 A[i]+…+A[j]를 의미한다. 각 원소가 정수인 두 배열 A[1], …, A[n]과 B[1], …, B[m]이 주어졌을 때, A의 부 배열의 합에 B의 부 배열의 합을 더해서 T가 되는 모든 부 배열 쌍의 개수를 구하는 프로그램을 작성하시오.

예를 들어 A = {1, 3, 1, 2}, B = {1, 3, 2}, T=5인 경우, 부 배열 쌍의 개수는 다음의 7가지 경우가 있다.

```
T(=5) = A[1] + B[1] + B[2]
      = A[1] + A[2] + B[1]
      = A[2] + B[3]
      = A[2] + A[3] + B[1]
      = A[3] + B[1] + B[2]
      = A[3] + A[4] + B[3]
      = A[4] + B[2] 
```

## 입력
첫째 줄에 T(-1,000,000,000 ≤ T ≤ 1,000,000,000)가 주어진다. 다음 줄에는 n(1 ≤ n ≤ 1,000)이 주어지고, 그 다음 줄에 n개의 정수로 A[1], …, A[n]이 주어진다. 다음 줄에는 m(1 ≤ m ≤ 1,000)이 주어지고, 그 다음 줄에 m개의 정수로 B[1], …, B[m]이 주어진다. 각각의 배열 원소는 절댓값이 1,000,000을 넘지 않는 정수이다.

## 출력
첫째 줄에 답을 출력한다. 가능한 경우가 한 가지도 없을 경우에는 0을 출력한다.

## 풀이
해당 문제의 경우 누적 합을 통해  $$ n^2 $$ 의 복잡도로 문제를 해결 할 수 있습니다.  

우선 아래와 같이 입력 받으며 A, B 모두 값을 누적하여 받아 줍니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n ,m;
    cin >> T >> n;

    vector<int> A(n+1);
    for(int i = 1; i <= n; ++i){
        cin >> A[i];
        A[i] += A[i - 1];
    }

    cin >> m;
    vector<int> B(m + 1);
    for(int i = 1; i <= m; ++i){
        cin >> B[i];
        B[i] += B[i - 1];
    }

    cout << subSum(A, B, T) << "\n";
    return 0;
}
```

이렇게 입력을 받게 되면 A[i] - A[j] (j < i)는 j+1 인덱스 부터 i번째 인덱스 까지의 합이 됩니다.  
위와 같은 방식으로 A배열의 모든 부분합에 대하여 카운트를 해줍니다.  
이때 T의 범위가 -1,000,000,000 ~ 1,000,000,000이므로 배열을 잡아 기록할 수 없으니 Hash Map 자료구조를 이용하여 합에 대한 값을 키로 합에 대한 갯수를 값으로 같게 만들어 줍니다.  

위의 과정이 끝나면 B의 모든 부분집합에 대하여 T와 차연산을 한 값이 맵에 있는지 확인 후 해당 키에 대한 값을 누적 합산하여 결과를 도출해 주면 됩니다. 

```cpp
long subSum(vector<int>&A, vector<int>&B, int T){
    long res = 0;
    unordered_map<int, long> map;

    for(int i  = 1; i < A.size(); ++i)
        for(int j = 0; j < i; ++j){
            if(map.count(A[i] - A[j]))
                ++map.find(A[i] - A[j])->second;
            else
                map.insert({A[i] - A[j], 1});
        }

    for(int i  = 1; i < B.size(); ++i)
        for(int j = 0; j < i; ++j)
            if(map.count(T - B[i] + B[j]))
                res += map.find(T - B[i] + B[j])->second;

    return res;
}
```

이때 모든 부분합에 대하여 값이 참이 될 경우 정수의 범위를 넘어가므로 키에 대한 값과 결과에 대한 값은 long으로 해주어야합니다.