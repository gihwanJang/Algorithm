# (1644) 소수의 연속합
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1644)

## 문제
하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.

- 3 : 3 (한 가지)
- 41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
- 53 : 5+7+11+13+17 = 53 (두 가지)

하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.

자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)

## 출력
첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.

## 풀이
 우선 소수를 n까지 전부 구해야 하므로 하나 씩 찾는 것보다 에라토스테네스의 체를 이용하면 빠르게 구할 수 있습니다. 
또한 연속합을 구해야하므로 에라토스테네스의 체를 통해 구한 소수를 누적합의 형태로 저장해 사용하면 빠르게 연속합을 구할 수 있습니다.  

```cpp
void findPrime(vector<int>&primeSum, int n){
    vector<bool> prime(n+1);

    for(int i = 2; i*i <= n; ++i)
        if(!prime[i])
            for(int j = i*i; j <= n; j += i)
                prime[j] = true;

    primeSum.push_back(0);
    for(int i = 2; i <= n; ++i)
        if(!prime[i])
            primeSum.push_back(primeSum.back() + i);
}
```

누적합이 구해졌으면 이중 포인터를 이용하여 n을 기준으로 연속합의 대소를 비교하여 포인터를 옮기며 n이되는 연속합의 갯수를 찾습니다.  

```cpp
int primeSum(int n){
    int cnt = 0, l = 0, r = 0;

    vector<int> primeSum;
    findPrime(primeSum, n);

    while(l <= r && r < primeSum.size()){
		if(primeSum[r] - primeSum[l] > n)
			++l;
		else if(primeSum[r] - primeSum[l] < n)
			++r;
		else{
			++cnt;
			++r;
		}
	}

    return cnt;
}
```

최종적으로 연속합의 갯수를 출력해 줍니다.  
 
```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << primeSum(n) << "\n";
    return 0;
}
```