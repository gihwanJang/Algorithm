# (1059) 좋은구간
## :100: Algorithm
## 문제
정수 집합 S가 주어졌을때, 다음 조건을 만족하는 구간 [A, B]를 좋은 구간이라고 한다.

- A와 B는 양의 정수이고, A < B를 만족한다.
- A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.

집합 S와 n이 주어졌을 때, n을 포함하는 좋은 구간의 개수를 구해보자.

## 입력
첫째 줄에 집합 S의 크기 L이 주어진다. 둘째 줄에는 집합에 포함된 정수가 주어진다. 셋째 줄에는 n이 주어진다.

## 출력
첫째 줄에 n을 포함하는 좋은 구간의 개수를 출력한다.

## 풀이
좋은 구간은 항상 주어진 집합에서 (n보다 작은 값중 가장 큰 값)과 (n보다 큰값중 가장 작은 값)사이에서 발생합니다.  
그러므로 입력 받은 집합을 정렬한 후 이진탐색을 통해 집합의 값중 n보다 작은 값을 중 가장 큰 값을 찾습니다.  
이후 가장 작은 값이 n인 경우와 집합에 n보다 큰 값이 없는 경우는 구간이 발생하지 않음으로 0을 반환하고 그렇지 않으면 해당 좋은 구간의 갯수는 다음과 같은 식을 통해 계산하여 반환해 줍니다.   

start = n보다 작은 값중 가장 큰 값;  
end = n보다 큰값중 가장 작은 값;  
return (n - start + 1) * (end - n) + (end - n -1);  

<코드>
```cpp
int binarySearch(vector<int>&set, int n){
    int lo = 0, hi = set.size(), mid;

    while(lo < hi){
        mid = (lo + hi) / 2;

        if(set[mid] == n)
            return mid;
        else if(set[mid] < n)
            lo = mid + 1;
        else
            hi = mid;
    }

    return lo-1;
}

int countingSection(vector<int>&set, int n){
    sort(set.begin(), set.end());
    int idx = binarySearch(set, n);

    if(!(set[idx] == n) && idx != set.size()-1)
        return (n - (set[idx]+1)) * (set[idx+1] - n) + (set[idx+1] - n - 1);
    return 0;
}
```