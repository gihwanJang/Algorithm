# (10819) 차이를 최대로
## :100: Algorithm
## 문제
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
## 입력
첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
## 출력
첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.
## 풀이

해당 식의 최댓값을 얻기 위해서는 모든 경우의 수를 찾아봐야 하므로 백트래킹을 통해 해당 문제를 해결 하였습니다.  
아래와 같이 A배열인 해당하는 formula 배열에 입력 받은 값을 넣지 않았다면 해당 값을 값을 넣었다 빼는 방식을 통해 구현 하였습니다.  

```cpp
int formulating(vector<int>&nums, vector<int>&formula, vector<bool>&visited){
    if(formula.size() == nums.size())
        return calculate(formula);
    
    int ans = 0;

    for(int i = 0; i < nums.size(); ++i)
        if(!visited[i]){
            visited[i] = true;
            formula.push_back(nums[i]);

            ans = max(ans, formulating(nums, formula, visited));

            visited[i] = false;
            formula.pop_back();
        }

    return ans;
}
```

<전체 코드>
```cpp

#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int calculate(vector<int>&formula){
    int res = 0;

    for(int i = 1; i < formula.size(); ++i)
            res += abs(formula[i - 1] - formula[i]);

    return res;
}

int formulating(vector<int>&nums, vector<int>&formula, vector<bool>&visited){
    if(formula.size() == nums.size())
        return calculate(formula);
    
    int ans = 0;

    for(int i = 0; i < nums.size(); ++i)
        if(!visited[i]){
            visited[i] = true;
            formula.push_back(nums[i]);

            ans = max(ans, formulating(nums, formula, visited));

            visited[i] = false;
            formula.pop_back();
        }

    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> formula;
    vector<int> nums(n);
    vector<bool> visited(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    cout << formulating(nums, formula, visited) << "\n";
    return 0;
}

``` 

